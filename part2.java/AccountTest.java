package Account_and_Bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {
    Account account;
    @BeforeEach
    public void setUp(){
        account = new Account("ayo","fatoye","1234");
    }

    @Test
    void depositNegativeValue_balanceIsUnchanged() {
        assertThrows(InvalidAmountException.class,()-> account.deposit(-1));
        assertEquals(0,account.checkBalance());
    }

  @Test
    void depositPositiveValue_balanceIsIncreased()throws InvalidAmountException{
        account.deposit(100);
        assertEquals(100,account.checkBalance());
    }

    @Test
    void withdrawAmountGreaterThanBalance() throws InvalidAmountException, InvalidPinException {
            account.deposit(100);
            account.setPin("1234");
            assertThrows(InvalidPinException.class,()-> account.withdraw(120,"12345"));
            assertThrows(InsufficientFundsException.class,()-> account.withdraw(120,"1234"));
    }

    @Test
    void setInvalidPin_throwsAnException() {
            assertThrows(InvalidPinException.class,() ->account.setPin("12345"));
    }


    @Test
    void setValidPin_setsPin() throws InvalidPinException {
        account.setPin("1234");
        assertEquals("1234",account.getPin());
    }

    @Test
    void testThatBalanceCanBeChecked_() throws InvalidAmountException{
        assertEquals(0,account.checkBalance());
        account.deposit(100);
        assertEquals(100,account.checkBalance());
    }


    @Test
    void testThatAccountNumberIsValid()throws IllegalArgumentException{
        account.setNumber(1234567891L);
        assertEquals(1234567891L,account.getNumber());
    }
}