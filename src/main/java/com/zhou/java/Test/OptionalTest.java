package com.zhou.java.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @Description
 * @Author xiaohu
 * @Date 2020/9/22 13:46
 */
public class OptionalTest {

    public static void main(String[] args) {
        CouponCodeVO couponCode = null;
        List<CouponCodeVO> couponCodeVOList = new ArrayList<>();
        for(long i=1; i<10 ;i++){
            CouponCodeVO couponCodeVO = new CouponCodeVO();
            couponCodeVO.setId(i);
            couponCodeVOList.add(couponCodeVO);
        }
        Long couponCodeId = 5L;
        System.out.println("开始："+couponCodeVOList.get(0));

        Optional<CouponCodeVO> op = couponCodeVOList.stream().filter(c -> c.getId().equals(couponCodeId)).findFirst();
        System.out.println(op);
        System.out.println(couponCodeVOList);
        couponCode = op.orElseGet(() -> couponCodeVOList.get(0));

        System.out.println("结束："+couponCode);
        System.out.println(couponCodeVOList.get(0));
    }

}

class CouponCodeVO{
    private Long id ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CouponCodeVO{" +
                "id=" + id +
                '}';
    }
}
