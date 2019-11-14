package by.gsu.ms42.pojo;

import java.util.ArrayList;
import java.util.List;

public class Branch {
    private String name;
    private List<Rate> rateList = new ArrayList<>();

    public Branch(String name, List<Rate> rateList) {
        this.name = name;
        this.rateList = rateList;
    }

    public Branch() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Rate> getRateList() {
        return rateList;
    }

    public void setRateList(List<Rate> rateList) {
        this.rateList = rateList;
    }

    @Override
    public String toString() {
        return "\n-----------------------------------------------------------------------------------------------------" +
                "\nBranch name: " + name + "\nRate list: " + rateList;
    }
}
