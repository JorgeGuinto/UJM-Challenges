import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(1000, "123456");

        ReentrantLock bufferLock = new ReentrantLock();

        Client client1 = new Client("Client  1", bankAccount);
        Client client2 = new Client("Client  2", bankAccount);

        new Thread(new Runnable() {
            @Override
            public void run() {
                bufferLock.lock();
                client1.getBankAccount().deposit(300.00);
                client1.getBankAccount().withdraw(50.00);
                bufferLock.unlock();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                bufferLock.lock();
                client2.getBankAccount().deposit(203.75);
                client2.getBankAccount().withdraw(100.00);
                bufferLock.unlock();
            }
        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){

        } finally {
            System.out.println("Total balance = " + bankAccount.getBalance());
        }
    }
}