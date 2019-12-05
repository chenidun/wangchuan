package com.chenly;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.chenly.model.Article;
import com.chenly.model.IOTDevice;
import com.chenly.model.IOTDeviceStatus;
import com.chenly.util.HttpClientUtils;
import com.chenly.util.JsonUtil;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author wangchuan
 * @date 2019/10/22.
 */
//@SpringBootTest
public class testPost {
    @Test
    public void testPostaccessToken() {
        HttpClientUtils httpClientUtils = new HttpClientUtils();
        String url = "https://10.244.18.254/api/v1/accessToken";
        Map map = new HashMap();
        map.put("api_token", "3ad2d6bc23a59333dce2a2759a2f5e69");
        String jsonString = new JSONObject(map).toJSONString();
        System.out.println(jsonString);

        String httpStringPostResponse = httpClientUtils.HttpStringPostRequest(url, jsonString, null);
        System.out.println(httpStringPostResponse);
    }

    @Test
    public void testPost() {
        HttpClientUtils httpClientUtils = new HttpClientUtils();
        String url = "https://10.244.18.254/api/v1/device/getGroup?";
        String apiToken = "7103cbe2e05115fc35d38fe92d6df367";
        Map map = new HashMap();
        List<String> list = new ArrayList<>();
        list.add("virtual-1531900108441284985");
        map.put("type_names", list);
        map.put("app_id", 3);
        String jsonString = new JSONObject(map).toJSONString();
        String httpStringPostResponse = httpClientUtils.HttpStringPostRequest(url, jsonString, apiToken);
        String data = JSON.parseObject(httpStringPostResponse).getJSONObject("data").toJSONString();
        System.out.println("data:::::" + data);
        Map<String, IOTDevice> deviceMap = JsonUtil.fromJson(data, new TypeToken<Map<String, IOTDevice>>() {
        }.getType());
        Map<String, IOTDevice> children1 = getDeviceMap(deviceMap);
        System.out.println("children::::::" + JsonUtil.toJson(children1));

    }

    private Map<String, IOTDevice> getDeviceMap(Map<String, IOTDevice> deviceMap) {
        Map<String, IOTDevice> returnMap = new HashMap<>();
        if (!deviceMap.isEmpty()) {
            deviceMap.entrySet().forEach(entry -> {
                Map<String, IOTDevice> c1 = entry.getValue().getChildren();
                if (entry.getValue().getDeviceId() != null) {
                    returnMap.putAll(entry.getValue().getChildren());
                } else {
                    // 继续循环
                    if (!c1.isEmpty()) {
                        c1.entrySet().forEach(entry1 -> {
                            Map<String, IOTDevice> c2 = entry1.getValue().getChildren();
                            if (entry1.getValue().getDeviceId() != null) {
                                returnMap.putAll(entry1.getValue().getChildren());
                            } else {
                                // 继续循环
                                if (!c2.isEmpty()) {
                                    c2.entrySet().forEach(entry2 -> {
//                                        Map<String, IOTDevice> c3 = entry1.getValue().getChildren();
                                        if (entry2.getValue().getDeviceId() != null) {
                                            returnMap.putAll(entry2.getValue().getChildren());
                                        }
                                    });
                                }
                            }
                        });
                    }
                }
            });
        }
        return returnMap;
    }

    public Map<String, IOTDevice> getChildren(Map<String, IOTDevice> children) {
        Map<String, IOTDevice> returnMap = new HashMap<>();
        for (Map.Entry<String, IOTDevice> entry : children.entrySet()) {
            if (entry.getValue().getDeviceId() == null) {
                getChildren((entry.getValue().getChildren()));
            } else {
                System.out.println("break");
                returnMap = children;
                break;
            }
        }
        return returnMap;
    }

    public Map<String, IOTDevice> getChildren1(Map<String, IOTDevice> children) {
        Map<String, IOTDevice> returnMap = children;
        for (String k : children.keySet()) {
            Map<String, IOTDevice> vchildren = children.get(k).getChildren();
            while (vchildren != null && !vchildren.isEmpty()) {
                for (String vk : vchildren.keySet()) {
                    returnMap = vchildren;
                    if (vchildren.get(vk).getDeviceId() != null) {
                        vchildren = null;
                        break;
                    } else {
                        getChildren1(returnMap);
                    }
                }
            }
        }
        return returnMap;
    }

    @Test
    public void testTrue() {
        if (true) {
            System.out.println("hhhhhhh");
        }
    }

    @Test
    public void testPostStatus() {
        HttpClientUtils httpClientUtils = new HttpClientUtils();
        String url = "https://10.244.18.254/api/v1/device/getStatus?";
        String apiToken = "92546c828f13bd540fcbb556e8a98aec";
        HashMap<String, Map> outerMap = new HashMap<>();
        Map innerMap = new HashMap();
        innerMap.put("all", true);
        outerMap.put("virtual-1531900108441284985", innerMap);
        String jsonString = JsonUtil.toJson(outerMap);
        String httpStringPostResponse = httpClientUtils.HttpStringPostRequest(url, jsonString, apiToken);
//        String data = JSON.parseObject(httpStringPostResponse).getJSONObject("virtual-1531900108441284985").getJSONObject("VT1566208717043522247").toJSONString();
        String data = JSON.parseObject(httpStringPostResponse).getJSONObject("virtual-1531900108441284985").toJSONString();
        System.out.println("data:::::" + data);
        Map<String, IOTDeviceStatus> deviceMap = JsonUtil.fromJson(data, new TypeToken<Map<String, IOTDeviceStatus>>() {
        }.getType());
        System.out.println("children::::::" + JsonUtil.toJson(deviceMap));

    }

    @Test
    public void testList() {
        List<String> ids = new ArrayList<>();
        ids.add("1");
        ids.add("3");
        ids.add("5");
        String sql = ids.stream().map(id -> new StringBuffer("JSON_CONTAINS(t_notice.building_id_list, \"")
                .append(id).append("\")").toString()).collect(Collectors.joining(" or "));
        // StringUtils.strip(id, "[]")
        System.out.println(sql);
    }

    @Test
    public void testLambda() {
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(3);
        ids.add(4);
        // lambda 表达式的写法
        List<String> list = ids.stream().map(id -> String.valueOf(id)).collect(Collectors.toList());
        // 静态方法引用格式，是lambda表达式的一个简化写法，所引用的方法其实是lambda
        // 的方法体实现
        List<String> list1 = ids.stream().map(String::valueOf).collect(Collectors.toList());
        Article article = new Article();
        article.setId(3);
        // filter 过滤数据
        long count = ids.stream().filter(article.getId()::equals).count();
        // map
        List<StringBuffer> idStrings = ids.stream().filter(id -> id > 2).map(id -> new StringBuffer(String.valueOf(id))).collect(Collectors.toList());
        idStrings.forEach(id -> System.out.println(id));
    }

}
