import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhonebookTest {

    @Test
    void testThatPhoneBooKExist() {
        Phonebook phone = new Phonebook();
        assertNotNull(phone);
    }

    @Test
    void testThatPhonebookCanBeSearched() {
        Phonebook phone = new Phonebook();
        phone.addContact("ayo","12345");
        assertEquals("this contact is not saved at the phonebook",phone.searchContact("ay"));
    }


@Test
    void  testThatContactCanBeAdded(){
        Phonebook phone = new Phonebook();
        phone.contacts.clear();
        phone.addContact("tunde","08108823087");
        assertFalse(Phonebook.contacts.isEmpty());

    }


    @Test
    void  testThatContactCanBeSearched(){
        Phonebook phone = new Phonebook();
        phone.addContact("tunde","08108823087");
        assertEquals("tunde Number is 08108823087",phone.searchContact("tunde"));

    }


    @Test
    void testThatContactCanBeDeleted() {
        Phonebook phone = new Phonebook();
        phone.deleteContacts("tunde");
        phone.searchContact("tunde");
        assertEquals("this contact is not saved at the phonebook",phone.searchContact("ay"));


    }




}