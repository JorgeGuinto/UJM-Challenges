import java.util.concurrent.locks.ReentrantLock;

public class Client {
    private String name;
    private BankAccount bankAccount;

    public Client(String name, BankAccount bankAccount) {
        this.name = name;
        this.bankAccount = bankAccount;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }
}
