package test.Test;


import java.io.Serializable;

public class ConstructCreateJobDto implements Serializable {
    private Double discountTransAmount;
    private Double transAmount;

    public Double getDiscountTransAmount() {
        return discountTransAmount;
    }

    public void setDiscountTransAmount(Double discountTransAmount) {
        this.discountTransAmount = discountTransAmount;
    }

    public Double getTransAmount() {
        return transAmount;
    }

    public void setTransAmount(Double transAmount) {
        this.transAmount = transAmount;
    }
}
