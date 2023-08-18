package org.example.account;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccountManagerTest {
    private AccountManagerImpl accountManager = new AccountManagerImpl();

    @Test
    void testCustomerWithSuffientBalance(){
        Customer customerWithSuffientBalance = new Customer(1000,true,true);
        String result = accountManager.withdraw(customerWithSuffientBalance,800);
        assertEquals("success", result);
    }
    @Test
    void testCustomerWithOutCreditAllowed(){
        Customer customerWithOutCreditAllowed = new Customer(800,false,true);
        String result = accountManager.withdraw(customerWithOutCreditAllowed,900);
        assertEquals("insufficient account balance", result);
    }
    @Test
    void testCustomerWithExpectedBalanceMoreTHanCreditAndNotVip(){
        Customer customerWithExpectedBalanceMoreThanCreditAndNotVip = new Customer(100,true,false);
        String result = accountManager.withdraw(customerWithExpectedBalanceMoreThanCreditAndNotVip,1900);
        assertEquals("maximum credit exceeded", result);
    }
    @Test
    void testCustomerWithExpectedBalanceMoreTHanCreditAndVip(){
        Customer customerWithExpectedBalanceMoreThanCreditAndVip = new Customer(100,true,true);
        String result = accountManager.withdraw(customerWithExpectedBalanceMoreThanCreditAndVip,1900);
        assertEquals("success", result);
    }
    @Test
    void testCustomerWithExpectedBalanceLessTHanCreditAndNotVip(){
        Customer customerWithExpectedBalanceLessThanCreditAndNotVip = new Customer(1000,true,false);
        String result = accountManager.withdraw(customerWithExpectedBalanceLessThanCreditAndNotVip,1900);
        assertEquals("success", result);
    }
    @Test
    void testCustomerWithExpectedBalanceLessTHanCreditAndVip(){
        Customer customerWithExpectedBalanceLessThanCreditAndVip = new Customer(1000,true,true);
        String result = accountManager.withdraw(customerWithExpectedBalanceLessThanCreditAndVip,1900);
        assertEquals("success", result);
    }

}
