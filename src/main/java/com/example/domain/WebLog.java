package com.example.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class WebLog {
    //开始时间
    private Long startTime;
    //消耗时间
    private Integer spendTime;
    //操作人姓名
    private String userName;
    //uri
    private String uri;
    //url
    private String url;
    //请求方法名
    private String method;
    //请求ip
    private String ip;
    //请求结果
    private Object parameter;
    //返回值
    private Object result;

    @Override
    public String toString() {
        return "WebLog{" +
                "startTime=" + startTime +
                ", spendTime=" + spendTime +
                ", userName='" + userName + '\'' +
                ", uri='" + uri + '\'' +
                ", url='" + url + '\'' +
                ", method='" + method + '\'' +
                ", ip='" + ip + '\'' +
                ", parameter=" + parameter +
                ", result=" + result +
                '}';
    }
}
