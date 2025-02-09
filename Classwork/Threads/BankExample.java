class BankAccount{
    private int balance = 1000;

    public synchronized void withdraw(int amount, String name) {
        System.out.println(name + " is trying to withdraw Rs. " + amount);

        if (balance >= amount) {
            System.out.println(name + " withdrew Rs. " + amount);
            balance -= amount;
        } else {
            System.out.println(name + " tried to withdraw more than available balance.");
        }
    }
}

class WithdrawTask implements Runnable{
    private BankAccount account;
    private int amount;
    private String name;

    public WithdrawTask(BankAccount account, int amount, String name) {
        this.account = account;
        this.amount = amount;
        this.name = name;
    }

    @Override
    public void run() {
        account.withdraw(amount, name);
    }
}

public class BankExample {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        WithdrawTask withdraw1 = new WithdrawTask(account, 890, "Person1");

        WithdrawTask withdraw2 = new WithdrawTask(account, 140, "Person2");

        Thread person1 = new Thread(withdraw1);
        Thread person2 = new Thread(withdraw2);

        person2.start();
        
        try{
            //wait for person2 to finish before starting person1
            person2.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        person1.start();
    }
}
