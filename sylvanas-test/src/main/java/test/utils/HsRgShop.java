package test.utils;



import java.io.Serializable;



public class HsRgShop implements Serializable {
    private static final long serialVersionUID = 1L;

    private String hsRgShopId;

    private String ecId;

    private String ewbNo;

    private String orderNo;

    private String mergerEwbNo;

    public String getHsRgShopId() {
        return hsRgShopId;
    }

    public void setHsRgShopId(String hsRgShopId) {
        this.hsRgShopId = hsRgShopId;
    }

    public String getEcId() {
        return ecId;
    }

    public void setEcId(String ecId) {
        this.ecId = ecId;
    }

    public String getEwbNo() {
        return ewbNo;
    }

    public void setEwbNo(String ewbNo) {
        this.ewbNo = ewbNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getMergerEwbNo() {
        return mergerEwbNo;
    }

    public void setMergerEwbNo(String mergerEwbNo) {
        this.mergerEwbNo = mergerEwbNo;
    }

    @Override
    public String toString() {
        return "HsRgShop{" +
                "hsRgShopId='" + hsRgShopId + '\'' +
                ", ecId='" + ecId + '\'' +
                ", ewbNo='" + ewbNo + '\'' +
                ", orderNo='" + orderNo + '\'' +
                ", mergerEwbNo='" + mergerEwbNo + '\'' +
                '}';
    }
}
