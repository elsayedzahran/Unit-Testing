package org.example.account;

import lombok.Data;

@Data
public class Customer {

    private String name;
    private int balance;
    private boolean creditAllowed;
    private int maxCredit = 0;
    private boolean vip;
    public Customer(){}
    public Customer(int balance, boolean creditAllowed, boolean vip) {
        this.balance = balance;
        this.creditAllowed = creditAllowed;
        this.vip = vip;
    }
}
