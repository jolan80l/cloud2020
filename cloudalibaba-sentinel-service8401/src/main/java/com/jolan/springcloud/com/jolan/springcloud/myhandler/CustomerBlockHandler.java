package com.jolan.springcloud.com.jolan.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.jolan.springcloud.entities.CommonResult;

/**
 * @author jolan80
 * @date 2020-05-13 22:28
 */
public class CustomerBlockHandler {
    public static CommonResult handlerException(BlockException blockException){
        return new CommonResult(444, "按客户自定义, globle handlerException------1");
    }

    public static CommonResult handlerException2(BlockException blockException){
        return new CommonResult(444, "按客户自定义, globle handlerException------2");
    }
}
