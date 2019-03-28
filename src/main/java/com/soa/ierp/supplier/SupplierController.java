package com.soa.ierp.supplier;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RequestMapping(value="/api/supplier",produces="application/json;charset=UTF-8")
@RestController
public class SupplierController {
    private static final Logger logger = LoggerFactory.getLogger(SupplierController.class);
    @Autowired
    private SupplierRepository supplierRepository;
    @Autowired
    private AmountUsedRepository amountUsedRepository;
    @Autowired
    ObjectMapper objectMapper;

    @RequestMapping("/find")
    public String find(@RequestBody String jsonStr)throws Exception{

        Map<String,Object> map= objectMapper.readValue(jsonStr,Map.class);
        String search = map.get("search").toString();
        List<Supplier> suppliers;
        if(search==""||search==null){
            suppliers = supplierRepository.findAll();
        }
        else {
            suppliers = supplierRepository.findByName(search);
        }
        return objectMapper.writeValueAsString(suppliers);
    }

    @RequestMapping("/find/id")
    public String findByUuid(@RequestBody String jsonObject)throws Exception{
        Map<String,Object> map= objectMapper.readValue(jsonObject,Map.class);
        String uuid = map.get("uuid").toString();
        Supplier supplier = supplierRepository.findByUuid(uuid);
        return objectMapper.writeValueAsString(supplier);
    }

    @RequestMapping("/save")
    public void save(@RequestBody String jsonObject)throws Exception{
        Supplier supplier = objectMapper.readValue(jsonObject,Supplier.class);
        updateAmountUsed(supplier,"add");
        supplierRepository.save(supplier);
    }

    @RequestMapping("/delete")
    public void delete(@RequestBody String jsonStr) throws Exception{
        Supplier supplier = objectMapper.readValue(jsonStr,Supplier.class);
        updateAmountUsed(supplier,"remove");
        supplierRepository.delete(supplier);
    }

    @RequestMapping("/find/amount/used")
    public String findAmountUsed(@RequestBody String jsonObject)throws Exception{

        List<AmountUsed> amountUseds = amountUsedRepository.findAll();
        AmountUsed amountUsed = amountUseds.get(0);
        return objectMapper.writeValueAsString(amountUsed);
    }

    private void updateAmountUsed(Supplier supplier,String type ) throws Exception{

        List<AmountUsed> amountUseds = amountUsedRepository.findAll();
        AmountUsed amountUsed = amountUseds.get(0);
        BigDecimal bd;

        //新增时
        if(type=="add"&&supplier.getUuid()==null) {
            bd = new BigDecimal(amountUsed.getZjze() + supplier.getZjze());
            amountUsed.setZjze(bd.setScale(4,BigDecimal.ROUND_HALF_UP).doubleValue());
        }
        //更新时
        if(type=="add"&&supplier.getUuid()!=null) {
            Supplier oldSupplier = supplierRepository.findByUuid(supplier.getUuid());
            bd = new BigDecimal(amountUsed.getZjze() + supplier.getZjze() - oldSupplier.getZjze());
            amountUsed.setZjze(bd.setScale(4,BigDecimal.ROUND_HALF_UP).doubleValue());
        }
        //删除时
        if(type=="remove"){
            bd = new BigDecimal(amountUsed.getZjze() - supplier.getZjze());
            amountUsed.setZjze(bd.setScale(4,BigDecimal.ROUND_HALF_UP).doubleValue());
        }
        amountUsedRepository.save(amountUsed);
    }
}