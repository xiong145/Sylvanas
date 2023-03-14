package test.utils;

import java.io.Serializable;

public class MergerInfosDto implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 运单号
     */
    private String ewbNo;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getEwbNo() {
        return ewbNo;
    }

    public void setEwbNo(String ewbNo) {
        this.ewbNo = ewbNo;
    }
}
