package com.soa.ierp.person;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

@RequestMapping(value="/api/person",produces="application/json;charset=UTF-8")
@RestController
public class PersonController {

    private static final Logger logger = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    ObjectMapper objectMapper;

    @RequestMapping("/find")
    public String find(@RequestBody String jsonStr)throws Exception
    {
        Map<String,Object> map= objectMapper.readValue(jsonStr,Map.class);
        String search = map.get("search").toString();
        List<Person> users;
        if(search==""||search==null){
            users = personRepository.findAll();
        }else {
            users = personRepository.findByName(search);
        }
        return objectMapper.writeValueAsString(users);
    }

    @RequestMapping("/find/id")
    public String findByUuid(@RequestBody String jsonObject)throws Exception{
        Map<String,Object> map= objectMapper.readValue(jsonObject,Map.class);
        String uuid = map.get("uuid").toString();
        Person person = personRepository.findByUuid(uuid);
        return objectMapper.writeValueAsString(person);
    }

    @RequestMapping("/login")
    public String Login(@RequestBody String jsonStr) throws Exception
    {
        Map<String,Object> map= objectMapper.readValue(jsonStr,Map.class);
        String accounts = map.get("accounts").toString();
        String password = map.get("password").toString();

        Person person = personRepository.findByAccountsAndPassword(accounts,password);
        return objectMapper.writeValueAsString(person);
    }

    @RequestMapping("/save")
    public void save(@RequestBody String jsonStr) throws Exception{
        Person person = objectMapper.readValue(jsonStr, Person.class);
        personRepository.save(person);
    }
    @RequestMapping("/change/pwd")
    public void changePwd(@RequestBody String jsonStr) throws Exception{
        Map<String,Object> map= objectMapper.readValue(jsonStr,Map.class);
        String uuid = map.get("uuid").toString();
        String password = map.get("password").toString();
        Person person = personRepository.findByUuid(uuid);
        person.setPassword(password);
        personRepository.save(person);
    }
    @RequestMapping("/delete")
    public void delete(@RequestBody String jsonStr)throws Exception{
        //System.out.println("删除用户："+jsonStr);
        Person person = objectMapper.readValue(jsonStr,Person.class);
        personRepository.delete(person);
    }
}