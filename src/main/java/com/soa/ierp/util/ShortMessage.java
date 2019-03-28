package com.soa.ierp.util;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import java.util.HashMap;
import java.util.Map;

public class ShortMessage {

    public void sendMessage(){
        String host = "https://feginesms.market.alicloudapi.com";
        String path = "/codeNotice";
        String method = "GET";
        String appCode = "abc5bd3c83574f0e8f194d6e8a32e601";
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization", "APPCODE " + appCode);//APPCODE(后面是英文空格)
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("param", "123456");
        querys.put("phone", "18008379985");
        querys.put("sign", "1");
        querys.put("skin", "18");
        try {
            /**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 下载；
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             * 相关jar包（非pom）直接下载：
             * http://code.fegine.com/aliyun-jar.zip
             */
            //System.out.println("发送短信：开始!");
            HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
            System.out.println(response.toString());//如不输出json, 请打开这行代码，打印调试头部状态码。
            //状态码: 200 正常；400 URL无效；401 appCode错误； 403 次数用完； 500 API网管错误
            //获取response的body
            //System.out.println("发送短信：结束!");
            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}