package com.soa.houzheng.person.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.soa.houzheng.person.entity.User;
import com.soa.houzheng.person.repository.UserRepo;
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
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepo personRepository;
    @Autowired
    ObjectMapper objectMapper;

    @RequestMapping("/find")
    public String find(@RequestBody String jsonStr)throws Exception
    {
        Map<String,Object> map= objectMapper.readValue(jsonStr,Map.class);
        String search = map.get("search").toString();
        List<User> users;
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
        User person = personRepository.findByUuid(uuid);
        return objectMapper.writeValueAsString(person);
    }

    @RequestMapping("/login")
    public String Login(@RequestBody String jsonStr) throws Exception
    {
        Map<String,Object> map= objectMapper.readValue(jsonStr,Map.class);
        String accounts = map.get("accounts").toString();
        String password = map.get("password").toString();

        User person = personRepository.findByAccountsAndPassword(accounts,password);
        return objectMapper.writeValueAsString(person);
    }

    @RequestMapping("/save")
    public void save(@RequestBody String jsonStr) throws Exception{
        User person = objectMapper.readValue(jsonStr, User.class);
        personRepository.save(person);
    }
    @RequestMapping("/change/pwd")
    public void changePwd(@RequestBody String jsonStr) throws Exception{
        Map<String,Object> map= objectMapper.readValue(jsonStr,Map.class);
        String uuid = map.get("uuid").toString();
        String password = map.get("password").toString();
        User person = personRepository.findByUuid(uuid);
        person.setPassword(password);
        personRepository.save(person);
    }
    @RequestMapping("/delete")
    public void delete(@RequestBody String jsonStr)throws Exception{
        //System.out.println("删除用户："+jsonStr);
        User person = objectMapper.readValue(jsonStr,User.class);
        personRepository.delete(person);
    }
}