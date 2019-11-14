package by.gsu.ms42.pojo;

import java.util.ArrayList;
import java.util.List;

public class Rate {
    private String currency;
    private List<Range> rangeList = new ArrayList<>();

    public Rate(String currency, List<Range> rangeList) {
        this.currency = currency;
        this.rangeList = rangeList;
    }

    public Rate() {
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<Range> getRangeList() {
        return rangeList;
    }

    public void setRangeList(List<Range> rangeList) {
        this.rangeList = rangeList;
    }

    @Override
    public String toString() {
        return "\n-----Rate{" +
                "currency='" + currency + '\'' +
                ", rangeList=" + rangeList +
                '}';
    }
}
