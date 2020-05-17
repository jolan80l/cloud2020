package com.jolan.springcloud.alibaba.service;

import com.jolan.springcloud.alibaba.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author jolan80
 * @date 2020-05-17 11:41
 */
@FeignClient(value = "seata-account-service")
public interface IAccountService {
    @PostMapping(value = "/account/decrase")
    CommonResult decrase(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}
