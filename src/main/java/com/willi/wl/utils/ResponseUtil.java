package com.willi.wl.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: William
 * @Description: 自定义返回数据格式 json
 * @Date: 2018/9/27 10:36
 **/
public class ResponseUtil {

    private final int code;
    private final String message;
    private final Map<String, Object> data = new HashMap<String, Object>();

    public ResponseUtil(int code, String message ) {
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public ResponseUtil putReponseData(String key, Object value) {
        data.put(key, value);
        return this;
    }

    public static ResponseUtil ok() {
        return new ResponseUtil(200, "Ok");
    }

    public static ResponseUtil notFound() {
        return new ResponseUtil(404, "Not Found");
    }

    public static ResponseUtil badRequest() {
        return new ResponseUtil(400, "Bad Request");
    }

    public static ResponseUtil forbidden() {
        return new ResponseUtil(403, "Forbidden");
    }

    public static ResponseUtil unauthorized() {
        return new ResponseUtil(401, "unauthorized");
    }

    public static ResponseUtil serverInternalError() { return new ResponseUtil(500, "Server Internal Error"); }

    public static ResponseUtil customerError() {
        return new ResponseUtil(1001, "customer Error");
    }
}
