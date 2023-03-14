package test.utils;


import com.alibaba.fastjson.JSONObject;


import java.io.Serializable;

public class MergerEwbNoVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 合单单号
     */
    private String mergerEwbNo;

    @Override
    public String toString() {
        return "MergerEwbNoVO{" +
                "mergerEwbNo='" + mergerEwbNo + '\'' +
                ", mergerInfos=" + mergerInfos +
                ", ecId='" + ecId + '\'' +
                '}';
    }

    /**
     * 运单号集合
     * Collection<Integer>
     */
    private JSONObject mergerInfos;

    /**
     * 订单来源
     */
    private String ecId;


    public String getMergerEwbNo() {
        return mergerEwbNo;
    }

    public void setMergerEwbNo(String mergerEwbNo) {
        this.mergerEwbNo = mergerEwbNo;
    }

    public JSONObject getMergerInfos() {
        return mergerInfos;
    }

    public void setMergerInfos(JSONObject mergerInfos) {
        this.mergerInfos = mergerInfos;
    }

    public String getEcId() {
        return ecId;
    }

    public void setEcId(String ecId) {
        this.ecId = ecId;
    }
}
