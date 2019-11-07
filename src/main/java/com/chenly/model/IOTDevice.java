package com.chenly.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * @author wangchuan
 * @date 2019/10/25.
 */
@Data
public class IOTDevice implements Serializable {
    private Integer groupId;

    private Boolean leaf; //该空间是否为叶子节点。若该节点为设备，则为true

    private String name; //

    private String path; //

    private String deviceId; // 设备id

    private String deviceName; // 设备名称

    private String typeId; // 设备类型id

    private String typeName; // 设备名称

    private Map<String, IOTDevice> children;
}
