package com.chenly.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.chenly.model.IOTDevice;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author: haidong
 * @Date: 2019/8/21 14:37
 * @Description:
 */
@Slf4j
public class HttpClientUtils {
    /**
     * HttpClient发送json字符串post请求
     *
     * @param url
     * @param jsonstring 参数字符串
     * @return
     */
    public String HttpStringPostRequest(String url, String jsonstring, String accessToken){
        if (StringUtils.isNotEmpty(accessToken)) {
            url = url + "access_token=" + accessToken;
        }
        System.out.println("HttpStringPostRequest - result - url:" + url);
        System.out.println("HttpStringPostRequest - result - json:" + jsonstring);
        log.info("HttpStringPostRequest - result - url:" + url);
        log.info("HttpStringPostRequest - result - json:" + jsonstring);
        String returnValue = StringUtils.EMPTY;

        SSLContextBuilder sslcontext = new SSLContextBuilder();
        try {
            sslcontext.loadTrustMaterial(null, new TrustSelfSignedStrategy());
            //第一步：创建HttpClient对象
            HttpClient httpClient = HttpClients.custom().setSSLContext(sslcontext.build()).setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE)
                    .build();
            //第二步：创建httpPost对象
            HttpPost httpPost = new HttpPost(url);
            httpPost.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
            httpPost.addHeader("Accept-Encoding", "gzip, deflate");
            httpPost.addHeader("Accept-Language", "zh-CN,zh;q=0.8");
            httpPost.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.90 Safari/537.36");
            httpPost.addHeader("Content-Type", "application/json");
            httpPost.addHeader("Connection", "Keep-Alive");
            //第三步：给httpPost设置JSON格式的参数
            if (StringUtils.isNotEmpty(jsonstring)) {
                StringEntity requestEntity = new StringEntity(jsonstring, "utf-8");
                requestEntity.setContentEncoding("UTF-8");
                requestEntity.setContentType("application/json");
                httpPost.setEntity(requestEntity);
            }

            //第四步：发送HttpPost请求，获取返回值
//            CloseableHttpResponse response = httpClient.execute(httpPost);
            HttpResponse response = httpClient.execute(httpPost);
            int status = response.getStatusLine().getStatusCode();
            log.info("<=========status======>"+status);
            if (status == HttpStatus.SC_OK){
                HttpEntity responseEntity = response.getEntity();
                returnValue = EntityUtils.toString(responseEntity, "UTF-8");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //第五步：处理返回值
        return returnValue;
    }

    // 解析返回的json
    public Map<String, IOTDevice> getIOTDevice(String deviceJson) {
        System.out.println(JSON.parseObject(deviceJson).get("data"));


        return null;
    }

    /**
     * Json 转成 Map<>
     * @param jsonStr
     * @return
     */
    public static Map<String, Object> getMapForJson(String jsonStr) {
        JSONObject jsonObject;
        /*try {
            jsonObject = JSONObject.parseObject(jsonStr);
            Iterator<String> keyIter = jsonObject.keys();
            String key;
            Object value;
            Map<String, Object> valueMap = new HashMap<String, Object>();
            while (keyIter.hasNext()) {
                key = keyIter.next();
                value = jsonObject.get(key);
                valueMap.put(key, value);
            }
            return valueMap;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }*/
        return null;
    }
}
