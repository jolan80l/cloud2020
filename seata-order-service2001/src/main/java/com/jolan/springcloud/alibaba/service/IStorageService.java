package com.jolan.springcloud.alibaba.service;

import com.jolan.springcloud.alibaba.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author jolan80
 * @date 2020-05-17 11:42
 */
@FeignClient(value = "seata-storage-service")
public interface IStorageService {

    @PostMapping(value = "/storage/decrase")
    CommonResult decrase(@RequestParam("proudctId") Long productId,  @RequestParam("count") Integer count);

}
