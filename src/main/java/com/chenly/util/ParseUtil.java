package com.chenly.util;

import com.alibaba.fastjson.JSONObject;
import com.chenly.model.IOTDevice;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*;

/**
 * @author wangchuan
 */
public class ParseUtil {
    private static final Logger logger = LoggerFactory.getLogger(ParseUtil.class);
    private static String charset = "UTF-8";
    private static String connector = "&";

    /**
     * 将json串解析为MAP(支持多层嵌套)
     *
     * @param msg
     * @return
     */
    public static Map<String, Object> parseJSON(String msg) {
        Map<String, Object> resultMap = new HashMap();
//        return parseJSON2Map(msg, resultMap);
        return null;
    }

    /**
     * 将json串解析为MAP(支持多层嵌套)
     *
     * @param msg
     * @return
     */
    public static Map<String, Object> parseJSONS(String msg,String name) {
        Map<String, Object> resultMap = new HashMap();
        List<Object> list= new ArrayList();
        return parseJSON2Map(msg, resultMap,name,list);
    }
    /**
     * 将复杂json解析为扁平的map格式
     * @param jsonStr json格式字符串
     * @param map 需要存入的map
     * @param jsonStr 如果遇到name名则不继续向下解析
     * @return
     */
    public static  Map<String, Object> parseJSON2Map(String jsonStr, Map<String, Object> map) {
        // 最外层解析
        JSONObject json = JSONObject.parseObject(jsonStr);
        for (String k : json.keySet()) {
//            IOTDevice iotDevice = JSONObject.parseObject(json.get(k), IOTDevice.class);
            Object v = (Object)json.get(k);
//            IOTDevice v = (IOTDevice)json.get(k);
//            JSONObject v = JSONObject.parseObject(String.valueOf(json.get(k)));
            // 如果内层还是数组的话，继续解析
//            if (v.getChildren().size() > 0) {
//                JSONObject it = JSONObject.parseObject(String.valueOf(v));
//                parseJSON2Map(String.valueOf(it), map);
//                map.put(k.toString(), v);
//            }
            if (v instanceof JSONObject) {
                JSONObject it = JSONObject.parseObject(String.valueOf(v));
                parseJSON2Map(String.valueOf(it), map);
            }else if(v instanceof List){
                List<Object> list=(List<Object>)v;
                if(null != list && list.size()>0){
                    for(Object oj:list){
                        parseJSON2Map(String.valueOf(oj), map);
                    }
                }
            } else {
                map.put(k.toString(), v);
            }
        }

        return map;
    }

    private static Map<String, Object> parseJSON2Map(String jsonStr, Map<String, Object> map,String name,List<Object> listResult) {
        // 最外层解析
        JSONObject json = JSONObject.parseObject(jsonStr);
        for (Object k : json.keySet()) {
            Object v = json.get(k);
            if(!k.equals(name)){
                // 如果内层还是数组的话，继续解析
                if (v instanceof JSONObject) {
                    JSONObject it = JSONObject.parseObject(String.valueOf(v));
                    parseJSON2Map(String.valueOf(it), map,name,listResult);
                }else if(v instanceof List){
                    List<Object> list=(List<Object>)v;
                    if(null != list && list.size()>0){
                        for(Object oj:list){
                            parseJSON2Map(String.valueOf(oj), map,name,listResult);
                        }
                    }

                } else {
                    map.put(k.toString(), v);
                }
            }else{
                listResult.add(v);
                continue;
            }
        }
        if(null != listResult && listResult.size()>0){
            map.put(name, listResult);
        }else{
            map.put(name, null);
        }

        return map;
    }
/*
    public static void main(String[] args){
        logCollect("channelHookId","9c0a118a-ed59-4c88-98d0-081a21f35c1f");
    }*/

//    private static String logCollect(String key,String value){
//        Map<String,Object> map= new HashMap();
//        map.put("query", value);
//        List<String> list=new ArrayList<String>();
//        list.add(key);
//        map.put("fields", list);
//
//        Map<String,Object> mapQueryStr= new HashMap();
//        mapQueryStr.put("query_string", map);
//
//        Map<String,Object> mapParam= new HashMap();
//        mapParam.put("query", mapQueryStr);
//        String paramer=JSONObject.toJSONString(mapParam);
//        String str="";
//        try {
//            //2018.04.18/_search
//
//            String path="http://127.0.0.1:9200/backend-"+Dttm.formatDateStr(new Date().getTime(), Dttm.FORMAT_DATE3)+"/_search";
//            str=HttpClientManager.httpPost(path, paramer, null);
//            System.out.println(str);
//        } catch (IOException e) {
//            logger.error("billRequestMessage>>http请求 失败:",e);
//        }
//        Map<String,Object> maps = (Map)JSON.parse(str);
//        Map<String,Object> mapo=Maps.newHashMap();
//        if(!maps.isEmpty()){
//            Map map1=Maps.newHashMap();
//            List list1=Lists.newArrayList();
//            Map<String,Object> resultMap=ParseUtil.parseJSON2Map(str,map1,"_source",list1);
//            Object object=resultMap.get("_source");
//            System.out.println("object:"+object);
//            mapo = (Map)JSON.parse(String.valueOf(object));
//            String csTimestamp=String.valueOf(mapo.remove("@timestamp"));
//            mapo.put("cs_timestamp", Dttm.UTCStringtODefaultString(csTimestamp));
//            mapo.remove("@version");
//        }
//        return JSONObject.toJSONString(mapo);
//    }
}
