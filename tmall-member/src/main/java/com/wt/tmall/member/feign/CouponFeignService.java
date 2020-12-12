package com.wt.tmall.member.feign;

import com.wt.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: wtt
 * @Date: 2020/12/12 13:10
 * @Description:
 */
@FeignClient("tmall-coupon")
public interface CouponFeignService {

    @RequestMapping("/coupon/coupon/member/list")
    public R memberCoupons();
}
