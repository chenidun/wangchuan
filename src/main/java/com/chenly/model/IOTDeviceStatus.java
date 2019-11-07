package com.chenly.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author wangchuan
 * @date 2019/10/28.
 */
@Data
public class IOTDeviceStatus implements Serializable {
    private Integer app_id; // 3
    private String app_name; // 设备所属空间，7F会议室
    private Integer group_id; // 4
    private String group_name; // 智慧办公
    private String hardVer; // 看着像电压，  "1.0.0"
    private String lastTime; //
    private String name; // 设备名称：705左
    private String onlineTime; // 最近上线时间
    private Integer root_group_id; // 3
    private String root_group_name; // "7F会议室"
    private String softVer; // "1.0.0"
    private String states; // 虚拟设备的开关状态  "online"
    private Boolean success;
    private String dataJson; // 设备data 属性，jsonMap
    private String deviceId;
}
