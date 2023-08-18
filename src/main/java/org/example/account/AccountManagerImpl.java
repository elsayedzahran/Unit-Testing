package org.example.account;

public class AccountManagerImpl implements AccountManager {
    private static int MAX_CREDIT = 1000;
    @Override
    public void deposit(Customer customer, int amount) {
        customer.setBalance(customer.getBalance() + amount);
    }

    @Override
    public String withdraw(Customer customer, int amount) {
        int expectedBalance = customer.getBalance() - amount;
        String msg;
        if (expectedBalance < 0) {
            expectedBalance *= -1;
            if (!customer.isCreditAllowed()) {
                msg = "insufficient account balance";
                return msg;
            } else if (expectedBalance > MAX_CREDIT && !customer.isVip()) {
                msg = "maximum credit exceeded";
                return msg;
            }
        }
        customer.setBalance(expectedBalance);
        return "success";
    }
}
