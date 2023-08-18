package org.example;

import org.example.account.AccountManager;
import org.example.account.AccountManagerImpl;
import org.example.account.Customer;
import org.example.store.MyStore;
import org.example.store.Product;

public class Main {
    public static void main(String[] args) {

        Product product = new Product();
        product.setQuantity(5);
        product.setPrice(25);

        Customer customer = new Customer(1,false,false);
        AccountManager accountManager = new AccountManagerImpl();
        MyStore store = new MyStore(accountManager);
        store.buy(product, customer);
    }
}