package by.gsu.ms32;


public class BusinessTrip {
    private static final int ALLOWANCE_RATE = 10000;
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
        return ALLOWANCE_RATE;
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
        return (transportExp + ALLOWANCE_RATE * numbOfDays);
    }

    public void show(){
        System.out.println("rate = " + Byn.toByn(ALLOWANCE_RATE) +
                "\naccount = " + account +
                "\ntransport expenses = " + Byn.toByn((int) transportExp) +
                "\ndays = " + numbOfDays +
                "\ntotal = " + Byn.toByn((int) getTotal()));
        System.out.println("====================================");
    }

    @Override
    public String toString() {
        return Byn.toByn(ALLOWANCE_RATE) + ";" + account + ";" + Byn.toByn((int) transportExp) + ";" + numbOfDays + ";" + Byn.toByn((int) getTotal());
    }
}
