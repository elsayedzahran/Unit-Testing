package org.example.store;
import org.example.account.AccountManager;
import org.example.account.Customer;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class MyStoreTest {
    AccountManager mockAccountManager = mock(AccountManager.class);
    MyStore myStore = new MyStore(mockAccountManager);
    @Test
    public void testSuccessfulPurchase() {

        Product product = new Product();
        product.setQuantity(10);
        product.setPrice(20);

        Customer customer = new Customer(1000,true,true);

        when(mockAccountManager.withdraw(customer, product.getPrice())).thenReturn("success");

        myStore.buy(product, customer);

        assertEquals(9, product.getQuantity());
    }
    @Test
    public void testSuccessfulPurchaseWithVip() {

        Product product = new Product();
        product.setQuantity(10);
        product.setPrice(20);

        Customer customer = new Customer(0,true,true);

        when(mockAccountManager.withdraw(customer, product.getPrice())).thenReturn("success");

        myStore.buy(product, customer);

        assertEquals(9, product.getQuantity());
    }
    @Test
    public void testOutOfStockPurchase() {
        Product product = new Product();
        product.setQuantity(0);
        product.setPrice(15);
        Customer customer = new Customer(1000,true,true);
        RuntimeException exception = assertThrows(RuntimeException.class, ()-> myStore.buy(product, customer));
        assertEquals("Product out of stock", exception.getMessage());
        assertEquals(customer.getBalance(), 1000);
    }

    @Test
    public void testFailedPaymentPurchase() {
        Product product = new Product();
        product.setQuantity(5);
        product.setPrice(25);

        Customer customer = new Customer(1,false,false);
        when(mockAccountManager.withdraw(customer, product.getPrice())).thenReturn("insufficient balance");
        assertThatThrownBy(() -> myStore.buy(product, customer)).isInstanceOf(RuntimeException.class)
                .hasMessage("Payment failure: insufficient balance");
        assertEquals(customer.getBalance(), 1);
    }
}
