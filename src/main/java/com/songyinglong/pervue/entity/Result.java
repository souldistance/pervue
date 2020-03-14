package com.songyinglong.pervue.entity;/**
 * @author SongYinglong
 * @date 2020/3/3- 2020/3/3
 */

import lombok.Data;

/**
 * @author Souldistance
 * 2020/3/3
 */
@Data
public class Result {

    private String reason;

    private Integer code;

    private Object result;

    public Result(String reason, Integer code, Object result) {
        this.reason = reason;
        this.code = code;
        this.result = result;
    }

    public Result() {
    }

    //失败的话,从捕获的之前抛出的异常中获取异常码和信息塞到这个方法中
    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setReason(msg);
        return result;
    }

    public static Result ok(Object result){
        return new Result("success",1001,result);
    }
}
