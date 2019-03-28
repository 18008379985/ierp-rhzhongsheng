package com.soa.ierp.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.soa.ierp.person.Person;
import com.soa.ierp.person.PersonRepository;
import com.soa.ierp.supplier.AmountUsed;
import com.soa.ierp.supplier.AmountUsedRepository;
import com.soa.ierp.supplier.SupplierRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.*;

@RequestMapping(value="/api/client",produces="application/json;charset=UTF-8")
@RestController
public class ClientController {
    private static final Logger logger = LoggerFactory.getLogger(ClientController.class);
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ClientHouseRepository clientHouseRepository;
    @Autowired
    private ClientFileRepository clientFileRepository;
    @Autowired
    private AmountSupplierRepository amountSupplierRepository;
    @Autowired
    private AmountUsedRepository amountUsedRepository;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private SupplierRepository supplierRepository;
    @Autowired
    ObjectMapper objectMapper;

    @RequestMapping("/find")
    public String find(@RequestBody String jsonStr)throws Exception{
        Page<Client> clients;
        Map<String,Object> map= objectMapper.readValue(jsonStr,Map.class);
        String search = map.get("search").toString();
        String useruuid = map.get("useruuid").toString();
        //分页设置
        int page = Integer.parseInt(map.get("page").toString());
        //System.out.println("page==="+page);
        int size = 10;

        List<Sort.Order> orders=new ArrayList<>();
        orders.add(new Sort.Order(Sort.Direction.ASC,"fwfhksj"));
        orders.add(new Sort.Order(Sort.Direction.DESC,"createTime"));
        orders.add(new Sort.Order(Sort.Direction.DESC,"qysj"));
        Pageable pageable = PageRequest.of(page,size,Sort.by(orders));

        //根据useruuid查出人员
        Person person = personRepository.findByUuid(useruuid);
        String role = person.getPosition();
        String name = person.getName();

        if(role.equals("总经理")||role.equals("副总经理")||role.equals("渠道专员")){
            if(search==""||search==null){
                clients = clientRepository.findAll(pageable);
            }
            else {
                clients = clientRepository.findByKhxm(pageable,search);
            }
        }
        else if(role.equals("客户经理")){
            if(search==""||search==null){
                clients = clientRepository.findByKhjl(pageable,name);
            }
            else {
                clients = clientRepository.findByKhjlAndKhxm(pageable,name,search);
            }
        }
        else if(role.equals("市场部总监")){
            if(search==""||search==null){
                clients = clientRepository.findBySczj(pageable,name);
            }
            else {
                clients = clientRepository.findBySczjAndKhxm(pageable,name,search);
            }
        }
        else {
            if(search==""||search==null){
                clients = clientRepository.findByKhjl(pageable,name);
            }
            else {
                clients = clientRepository.findByKhjlAndKhxm(pageable,name,search);
            }
        }

        return objectMapper.writeValueAsString(clients);
    }

    @RequestMapping("/find/id")
    public String findByUuid(@RequestBody String jsonObject)throws Exception{
        Map<String,Object> map= objectMapper.readValue(jsonObject,Map.class);
        String uuid = map.get("uuid").toString();
        Client client = clientRepository.findByUuid(uuid);
        return objectMapper.writeValueAsString(client);
    }

    @RequestMapping("/order/amount")
    public String findOrderAmount(@RequestBody String jsonStr)throws Exception{
        List<Client> clients;
        Map<String,Object> map= objectMapper.readValue(jsonStr,Map.class);
        String role = map.get("position").toString();
        String name = map.get("username").toString();

        if(role.equals("总经理")||role.equals("副总经理")||role.equals("渠道专员")){
            clients = clientRepository.findAll();
        }
        else if(role.equals("客户经理")){
            clients = clientRepository.findByKhjl(name);
        }
        else if(role.equals("市场部总监")){
            clients = clientRepository.findBySczj(name);
        }
        else {
                clients = clientRepository.findByKhjl(name);
            }

        OrderAmount orderAmount = sumOrderAmount(clients);
        return objectMapper.writeValueAsString(orderAmount);
    }

    //汇总订单金额
    private OrderAmount sumOrderAmount(List<Client> clients) throws Exception{

        //计算当前月份、年份
        Calendar cale = Calendar.getInstance();
        int now_year = cale.get(Calendar.YEAR);
        int now_month = cale.get(Calendar.MONTH);

        OrderAmount orderAmount=new OrderAmount();

        clients.forEach(client -> {
            //签约时间
            java.sql.Date qysj=client.getQysj();
            if(qysj != null){
                //获取签约年份
                Calendar c = Calendar.getInstance();
                c.setTime(qysj);
                int qysj_year = c.get(Calendar.YEAR);
                if(now_year == qysj_year){
                    //累计本年服务费
                    double fwf_bn = orderAmount.getFwf_bn();
                    fwf_bn = fwf_bn + client.getFwf();
                    BigDecimal bd_fwf_bn = new BigDecimal(fwf_bn);
                    orderAmount.setFwf_bn(bd_fwf_bn.setScale(4,BigDecimal.ROUND_HALF_UP).doubleValue());

                    //累计本年提成
                    double fwf_tc_bn = orderAmount.getFwf_tc_bn();
                    fwf_tc_bn = fwf_tc_bn + client.getTcje();
                    BigDecimal bd_fwf_tc_bn = new BigDecimal(fwf_tc_bn);
                    orderAmount.setFwf_tc_bn(bd_fwf_tc_bn.setScale(4,BigDecimal.ROUND_HALF_UP).doubleValue());

                    int qysj_month = c.get(Calendar.MONTH);
                    if(now_month==qysj_month){
                        //累计本月服务费
                        double  fwf_by=orderAmount.getFwf_by();
                        fwf_by = fwf_by + client.getFwf();
                        BigDecimal bd_fwf_by = new BigDecimal(fwf_by);
                        orderAmount.setFwf_by(bd_fwf_by.setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue());
                         //累计本月提成
                        double fwf_tc_by = orderAmount.getFwf_tc_by();
                        fwf_tc_by = fwf_tc_by + client.getTcje();
                        BigDecimal bd_fwf_tc_by = new BigDecimal(fwf_tc_by);
                        orderAmount.setFwf_tc_by(bd_fwf_tc_by.setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue());
                    }
                }
            }

            //回款时间
            java.sql.Date hksj=client.getFwfhksj();
            if(hksj!=null){
                //获取回款年份
                Calendar hksjCalendar = Calendar.getInstance();
                hksjCalendar.setTime(hksj);
                int hksj_year = hksjCalendar.get(Calendar.YEAR);

                if(now_year == hksj_year){
                    //累计本年回款
                    double fwf_yhk_bn = orderAmount.getFwf_yhk_bn();
                    fwf_yhk_bn = fwf_yhk_bn + client.getFwfhkje();
                    BigDecimal bd_fwf_yhk_bn = new BigDecimal(fwf_yhk_bn);
                    orderAmount.setFwf_yhk_bn(bd_fwf_yhk_bn.setScale(4,BigDecimal.ROUND_HALF_UP).doubleValue());

                    int hksj_month = hksjCalendar.get(Calendar.MONTH);
                    if(now_month==hksj_month){
                        //累计本月回款
                        double fwf_yhk_by = orderAmount.getFwf_yhk_by();
                        fwf_yhk_by = fwf_yhk_by + client.getFwfhkje();
                        BigDecimal bd_fwf_yhk_by = new BigDecimal(fwf_yhk_by);
                        orderAmount.setFwf_yhk_by(bd_fwf_yhk_by.setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue());
                    }
                }
            }
        });
        return orderAmount;
    }

    @RequestMapping("/save")
    public String save(@RequestBody String jsonObject)throws Exception{
        Client client = objectMapper.readValue(jsonObject,Client.class);

        List<Client> oldClients = clientRepository.findBySfzh(client.getSfzh());

        //新增用户时，如果系统已经存在30天内创建的客户，不允许添加
        if(client.getUuid()==null && oldClients.size()>0){

            boolean big30 = false;

            for(Client oldClient : oldClients){
                long createday= oldClient.getCreateTime().getTime();
                Calendar calendar = Calendar.getInstance();
                long today = calendar.getTime().getTime();
                long days = (today-createday)/(1000*3600*24)+1;
                //System.out.println("today=="+today);
                //System.out.println("days=="+days);
                if(days>30){ big30=true; }
            }
            if(big30==true){
                clientRepository.save(client);
                return objectMapper.writeValueAsString(client);
            }
            else{
                return "false";
            }
        }
        else {
            //计算服务费
            BigDecimal fwf = new BigDecimal(client.getDkje() * client.getFwfl());
            client.setFwf(fwf.setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue());
            //计算提成金额
            BigDecimal tcje = new BigDecimal(client.getFwf() * client.getTcfs());
            client.setTcje(tcje.setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue());
            //计算公司毛利
            BigDecimal gsml = new BigDecimal(client.getFwf() - client.getTcje());
            client.setGsml(gsml.setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue());

            clientRepository.save(client);
            return objectMapper.writeValueAsString(client);
        }
    }

    @RequestMapping("/delete")
    public void delete(@RequestBody String jsonStr) throws Exception{
        Client client = objectMapper.readValue(jsonStr,Client.class);
        //1-删除客户房产信息；
        List<ClientHouse> houses=clientHouseRepository.findByClientUuid(client.getUuid());
        houses.forEach(clientHouse -> {
            clientHouseRepository.delete(clientHouse);
        });

        //2-删除客户图片信息；
        List<ClientFile> files=clientFileRepository.findByClientUuid(client.getUuid());
        files.forEach(clientFile ->{
            clientFileRepository.delete(clientFile);
        });

        //3-删除资方信息；
        List<AmountSupplier> amountSuppliers=amountSupplierRepository.findByClientUuid(client.getUuid());
        amountSuppliers.forEach(amountSupplier ->{
            amountSupplierRepository.delete(amountSupplier);
        });

        //4-删除客户信息；
        clientRepository.delete(client);
    }

    //=====客户文件处理方法   开始============
    @RequestMapping(value = "/file/find",method = RequestMethod.POST)
    public String findFile(@RequestBody String jsonObject)throws Exception{
        Map<String,Object> map= objectMapper.readValue(jsonObject,Map.class);
        String uuid = map.get("uuid").toString();
        List<ClientFile> files= clientFileRepository.findByClientUuid(uuid);
        return objectMapper.writeValueAsString(files);
    }

    @RequestMapping(value = "/file/delete",method = RequestMethod.POST)
    public void deleteFile(@RequestBody String jsonObject) throws Exception{
        ClientFile file = objectMapper.readValue(jsonObject,ClientFile.class);
        clientFileRepository.delete(file);
    }

    @RequestMapping(value="/file/save",method = { RequestMethod.POST})
    public String upload(MultipartFile fileValue, String clientUuid, String fileName)throws Exception {
        ClientFile file = new ClientFile();
        if (fileValue != null) {// 判断上传的文件是否为空
            //String imgName = file.getOriginalFilename();// 文件原名称
            String base64 = Base64.getEncoder().encodeToString(fileValue.getBytes());
            //System.out.println("file.base64=" + base64);
            file.setFileName(fileName);
            file.setClientUuid(clientUuid);
            file.setFileValue(base64);
            clientFileRepository.save(file);
        }
        return objectMapper.writeValueAsString(file);
    }
    //=====客户文件处理方法   结束============

    //=====客户房产处理方法   开始============
    @RequestMapping("/house/find")
    public String findHouse(@RequestBody String jsonObject)throws Exception{
        Map<String,Object> map= objectMapper.readValue(jsonObject,Map.class);
        String uuid = map.get("uuid").toString();
        //根据客户UUID查询出房产信息
        List<ClientHouse> clientHouses= clientHouseRepository.findByClientUuid(uuid);
        return objectMapper.writeValueAsString(clientHouses);
    }

    @RequestMapping("/house/save")
    public String saveHouse(@RequestBody String jsonObject)throws Exception{
        ClientHouse house = objectMapper.readValue(jsonObject,ClientHouse.class);
        return objectMapper.writeValueAsString(clientHouseRepository.save(house));
    }

    @RequestMapping("/house/delete")
    public void deleteHouse(@RequestBody String jsonObject) throws Exception{
        ClientHouse house = objectMapper.readValue(jsonObject,ClientHouse.class);
        clientHouseRepository.delete(house);
    }
    //=====客户房产处理方法   结束============

    //=====资方处理方法   开始============
    @RequestMapping("/amountSupplier/find")
    public String findAmountSupplier(@RequestBody String jsonObject)throws Exception{
        Map<String,Object> map= objectMapper.readValue(jsonObject,Map.class);
        String uuid = map.get("uuid").toString();
        //根据客户UUID查询出资方信息
        List<AmountSupplier> amountSuppliers= amountSupplierRepository.findByClientUuid(uuid);
        return objectMapper.writeValueAsString(amountSuppliers);
    }

    @RequestMapping("/amountSupplier/save")
    public String saveAmountSupplier(@RequestBody String jsonObject)throws Exception{
        AmountSupplier amountSupplier = objectMapper.readValue(jsonObject,AmountSupplier.class);

        //更新资方资金使用情况
        updateAmountUsed(amountSupplier,"add");

        if(amountSupplier.getCdjsrq()!=null && amountSupplier.getCdksrq()!=null){
            //计算使用天数
            long jsrq = amountSupplier.getCdjsrq().getTime();
            long ksrq = amountSupplier.getCdksrq().getTime();
            //System.out.println(ksrq);
            long days = (jsrq-ksrq)/(1000*3600*24)+1;
            amountSupplier.setSyts(days);
            //计算冲贷毛利
            double cdml = amountSupplier.getCdje() * days * amountSupplier.getCdll();
            BigDecimal bd1 = new BigDecimal(cdml);
            amountSupplier.setCdml(bd1.setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue());
        }

        return objectMapper.writeValueAsString(amountSupplierRepository.save(amountSupplier));
    }

    private void updateAmountUsed(AmountSupplier amountSupplier, String type ) throws Exception{
        //冲贷金额
        double cdje = amountSupplier.getCdje();
        //回款金额
        double hkje = amountSupplier.getHkje();

        List<AmountUsed> amountUseds= amountUsedRepository.findAll();
        AmountUsed amountUsed = amountUseds.get(0);
            if(type=="add") {
                BigDecimal yyje = new BigDecimal(amountUsed.getYyje() + cdje - hkje);
                amountUsed.setYyje(yyje.setScale(4,BigDecimal.ROUND_HALF_UP).doubleValue());
                amountUsedRepository.save(amountUsed);
            }
            if(type=="remove"){
                BigDecimal yyje = new BigDecimal(amountUsed.getYyje() - cdje + hkje);
                amountUsed.setYyje(yyje.setScale(4,BigDecimal.ROUND_HALF_UP).doubleValue());
                amountUsedRepository.save(amountUsed);
            }
    }

    @RequestMapping("/amountSupplier/delete")
    public void deleteAmountSupplier(@RequestBody String jsonObject) throws Exception{
        AmountSupplier amountSupplier = objectMapper.readValue(jsonObject,AmountSupplier.class);
        //更新资方资金使用情况
        updateAmountUsed(amountSupplier,"remove");
        //
        amountSupplierRepository.delete(amountSupplier);
    }
    //=====资方处理方法   结束============

}