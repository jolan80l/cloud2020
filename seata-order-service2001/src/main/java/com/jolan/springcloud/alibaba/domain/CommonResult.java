package com.jolan.springcloud.alibaba.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jolan80
 * @date 2020-04-13 22:42
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;//返回码
    private String message;//返回描述
    private T data;//其他信息

    /**
     * AllArgsConstructor和NoArgsConstructor会自动增加全参构造函数和无参构造函数，这里增加一个两个参数的构造函数，方便调用
     */
    public CommonResult(Integer code, String message){
        this(code, message, null);
    }
}
