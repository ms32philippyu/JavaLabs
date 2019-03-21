package by.gsu.ms32;

import java.util.List;

public class Client {
    private String firstName;
    private String lastName;
    private String passport;
    private List<BankAccount> bankAccounts;

    public Client() {
        this(null,null,null,null);
    }

    public Client(String firstName, String lastName, String passport, List<BankAccount> bankAccounts) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.passport = passport;
        this.bankAccounts = bankAccounts;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(List<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    @Override
    public String toString() {
        return "Client{" +
                "First name='" + firstName + '\'' +
                ", Last name='" + lastName + '\'' +
                ", Passport='" + passport + '\'' +
                ", Bank accounts=" + bankAccounts +
                '}';

    }
}
