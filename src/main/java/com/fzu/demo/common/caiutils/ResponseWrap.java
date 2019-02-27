package com.fzu.demo.common.caiutils;


import java.io.Serializable;


/**
 * 接口回复基础类
 *
 * @author wangny
 * @date 2017年5月23日
 */
public class ResponseWrap implements Serializable {
    /**
     * 状态码
     */
    private String errorCode;

    /**
     * 描述信息
     */
    private String errorMsg;
    /**
     * 数据域
     */
    private Object data;

    public ResponseWrap(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public ResponseWrap() {
        this.errorCode = ResponseCode.CODE_0.getCode();
        this.errorMsg = ResponseCode.CODE_0.getDesc();
    }

    public ResponseWrap(ResponseCode code) {
        this.errorCode = code.getCode();
        this.errorMsg = code.getDesc();
    }

    public ResponseWrap(ResponseCode responseCode, Object data) {
        this.errorCode = responseCode.getCode();
        this.errorMsg = responseCode.getDesc();
        this.data = data;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    /**
     * 更新code
     *
     * @param code
     */
    public void updateCode(ResponseCode code) {
        this.errorCode = code.getCode();
        this.errorMsg = code.getDesc();
    }

    public <T extends Object> T getData() {
        return (T) data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseWrap{" +
                "code=" + errorCode +
                ", desc='" + errorMsg + '\'' +
                ", data=" + data +
                '}';
    }
}
