package com.chenly.constand;

/**
 * @author weidong
 * @date 20190530
 * @description 接口请求返回码
 */
public enum WebCodeEnum {
    REQUEST_SUCCESS(1, "请求成功"),
    REQUEST_FAIL(0, "系统内部错误,请稍后重试"),
    NO_BUILDING(100, "该商户下没有楼宇"),
    NULL_REQUESTPARAM(101, "必填参数为空"),
    NO_EXCELRECORD(104, "没有excel记录"),
    UPLOADFILE_ERROR(105, "上传文件为空"),
    APPID_ERROR(102, "appid不正确"),
    SIGN_ERROR(103, "签名错误"),
    PHONE_ERROR(105, "手机号格式错误"),
    REQUEST_TIMESERROR(104, "IP请求次数超限制"),

    MSGCODE_TIMESERROR(106, "获取短信验证码次数超限制"),
    MSGCODE_ERROR(107, "获取短信验证码失败"),
    HIVERIFYCODE_ERROR(108, "隐藏验证码错误"),
    MSGREQUEST_REPEAT(109, "短信请求太频繁"),
    MSGREQUEST_VALIDATE_ERRPR(1514, "短信验证码输入错误！"),
    MSGREQUEST_REPEAT_GET(1515, "短信验证码未获取或已过期，请重新获取！"),


    REQUEST_EXCEPTION(110, "请求异常url"),
    UID_NULL(111, "UID为空"),
    USER_NOTEXIST(112, "用户不存在"),
    MOBILE_EXIST(113, "手机号已绑定"),
    EMAIL_EXIST(114, "邮箱已绑定"),
    CHECKINVITATE_FAIL(115, "企业邀请码验证失败"),


    GID_NULL(131, "区域id不存在或不是数字"),
    GEN_NOTEXIST(132, "用户地址不存在"),
    GID_UNLAWFUL(133, "区域id不合法"),

    UAID_NULL(121, "用户地址id为空或不是数字"),
    UAID_NOTEXIST(122, "用户地址不存在"),
    ADDRESS_NOT_BELONG_USER(123, "该地址不属于该用户"),
    ADDRESS_NAME_NULL(124, "地址名称为空"),
    ADDRESS_RECEIVER_NULL(125, "收货人为空"),
    ADDRESS_MOBILE_NULL(126, "收货人手机为空"),
    ADDRESS_ADDR_NULL(126, "详细地址为空"),
    ORG_OBJ_NULL(127, "组织机构不存在"),


    PLAT_NO_PERMISSION(1411, "此用户没有平台权限"),
    EMPLOYEE_NOTEXIST(1408, "此员工不存在"),
    EMPLOYEE_IS_EXIST(1409, "此员工已存在"),

    wechat_Code(1511, "获取openId 和 sessionKey失败,请重新获取!"),
    WECHAT_MOBILE(1512,"解密手机号出错,请重新登陆"),
    wechat_JIEMI_INFO(1513,"解密微信基本信息出错,请重新登陆"),

    PASSWORD_VALIDATE(1516,"请输入6-20位密码，且包含数字和字母");




    int code;
    String message;

    WebCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
