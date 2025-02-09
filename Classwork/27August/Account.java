public class Account {

    public String name;
    private int accountNo;
    private double amount;

    public void setAccountNumber(int acc) {
        accountNo = acc;
    }

    public int getAccountNumber() {
        return accountNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
