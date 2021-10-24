package com.wt.test.queue;

import lombok.Data;

import java.util.Date;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: wtt
 * @Date: 2021/4/21 17:47
 * @Description:
 */
@Data
public class Order implements Delayed {

    private String orderNo;
    private String receiveName;
    private int cost;
    private String status;
    private Date createTime;
    private Date cancelTime;

    public Order(String orderNo, String receiveName, int cost, String status, Date createTime, Date cancelTime) {
        this.orderNo = orderNo;
        this.receiveName = receiveName;
        this.cost = cost;
        this.status = status;
        this.createTime = createTime;
        this.cancelTime = cancelTime;
    }


    @Override
    public long getDelay(TimeUnit unit) {
        long l = unit.convert(cancelTime.getTime() - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        return l;
    }

    @Override
    public int compareTo(Delayed o) {
        //这里根据取消时间来比较，如果取消时间小的，就会优先被队列提取出来
        return this.getCancelTime().compareTo(((Order) o).getCancelTime());
    }
}
