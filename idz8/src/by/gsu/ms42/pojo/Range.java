package by.gsu.ms42.pojo;

public class Range {
    private Long minAmount;
    private Long maxAmount;
    private Double buy;
    private Double sell;

    public Range() {
    }

    public Range(Long minAmount, Long maxAmount, Double buy, Double sell) {
        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
        this.buy = buy;
        this.sell = sell;
    }

    public Long getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(Long minAmount) {
        this.minAmount = minAmount;
    }

    public Long getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(Long maxAmount) {
        this.maxAmount = maxAmount;
    }

    public Double getBuy() {
        return buy;
    }

    public void setBuy(Double buy) {
        this.buy = buy;
    }

    public Double getSell() {
        return sell;
    }

    public void setSell(Double sell) {
        this.sell = sell;
    }

    @Override
    public String toString() {
        return "\n-------------Range{" +
                "minAmount=" + minAmount +
                ", maxAmount=" + maxAmount +
                ", buy=" + buy +
                ", sell=" + sell +
                '}';
    }
}
