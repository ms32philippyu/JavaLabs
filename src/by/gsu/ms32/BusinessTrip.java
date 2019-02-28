package by.gsu.ms32;

public class BusinessTrip {
    private static final int allowanceRate = 10000;
    private String account;
    private double transportExp;
    private int numbOfDays;

    public BusinessTrip() {
    }

    public BusinessTrip(String account, double trasportExp, int numbOfDays) {
        this.account = account;
        this.transportExp = trasportExp;
        this.numbOfDays = numbOfDays;
    }

    public static int getAllowanceRate() {
        return allowanceRate;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public double getTrasportExp() {
        return transportExp;
    }

    public void setTrasportExp(double trasportExp) {
        this.transportExp = trasportExp;
    }

    public int getNumbOfDays() {
        return numbOfDays;
    }

    public void setNumbOfDays(int numbOfDays) {
        this.numbOfDays = numbOfDays;
    }

    public double getTotal(){
        return (transportExp + allowanceRate * numbOfDays) / 100;
    }

    public void show(){
        System.out.println("rate = " + allowanceRate +
                "\naccount = " + account +
                "\ntransport expenses = " + transportExp +
                "\ndays = " + numbOfDays +
                "\ntotal = " + getTotal());
        System.out.println("====================================");
    }

    @Override
    public String toString() {
        return allowanceRate + ";" + account + ";" + transportExp + ";" + numbOfDays + ";" + getTotal();
    }
}
