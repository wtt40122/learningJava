package com.wt.tmall.coupon;

import com.wt.tmall.coupon.entity.CouponEntity;
import com.wt.tmall.coupon.service.CouponService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TmallCouponApplicationTests {

	@Autowired
	private CouponService couponService;

	@Test
	public void contextLoads() {
		CouponEntity couponEntity = new CouponEntity();
		couponEntity.setAmount(new BigDecimal(1));
		couponEntity.setCouponType(1);
		couponEntity.setCouponName("测试优惠券");
		couponService.save(couponEntity);

	}

}
