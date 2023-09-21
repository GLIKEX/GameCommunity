package com.gc.system.vo;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private Integer code;

    private JSONObject data;

    private String status;

    public static Result Success(JSONObject data) {
        return new Result(200, data, "success");
    }

    public static Result fail(Integer code, JSONObject data, String status) {
        return new Result(code, data, status);
    }
}
