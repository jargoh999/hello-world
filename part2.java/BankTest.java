package Account_and_Bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.security.auth.login.AccountNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {
    Bank bank;



@BeforeEach
public void setBank(){
    bank = new Bank();
}


    @Test
    void deposit() {


    }

    @Test
    void withdraw() {


    }

    @Test
    void transfer() {

    }

    @Test
    void checkBalance() {

    }

    @Test
   public void registerCustomer() throws AccountNotFoundException {
    assertEquals(bank.registerCustomer("ayomide","fatoye","1234"),bank.findAccount(14346785324L));
    assertEquals(bank.registerCustomer("dayo","akinyemi","2468"),bank.findAccount(14346785325L));
    }

    @Test
    public void removeAccount() {
        bank.registerCustomer("ayomide","fatoye","1234");
        bank.registerCustomer("dayo","akinyemi","2468");
        bank.removeAccount(14346785325L,"2468");
        assertEquals(bank.getNumberOfAccounts(),1);
    }

    @Test
   public  void findAccount() {
        assertEquals(bank.registerCustomer("ayomide","fatoye","1234"),bank.findAccount(14346785324L));
        assertThrows(Account_and_Bank.AccountNotFoundException.class, ()-> bank.findAccount(14346785325L));
    }
}