package by.gsu.ms32;

import java.text.NumberFormat;

public class BusinessTrip {
    private static final int allowanceRate = 10000;
    private String account;
    private double transportExp;
    private int numbOfDays;

    public BusinessTrip() {
    }

    public BusinessTrip(String account, double transportExp, int numbOfDays) {
        this.account = account;
        this.transportExp = transportExp;
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
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(3);
        System.out.println("rate = " + allowanceRate +
                "\naccount = " + account +
                "\ntransport expenses = " + transportExp +
                "\ndays = " + numbOfDays +
                "\ntotal = " + nf.format(getTotal()));
        System.out.println("====================================");
    }

    @Override
    public String toString() {
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(3);
        return allowanceRate + ";" + account + ";" + transportExp + ";" + numbOfDays + ";" + nf.format(getTotal());
    }
}
