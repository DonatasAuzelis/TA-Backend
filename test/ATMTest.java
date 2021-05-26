import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class ATMTest {

    //Declaring an ATM object
    ATM atm;

    //Initializing and adding money to the ATM before each test
    @BeforeEach
    public void init() {
        atm = new ATM();
        atm.addMoneyToATM(Bill.THOUSAND, 2);
        atm.addMoneyToATM(Bill.FIVE_HUNDRED, 3);
        atm.addMoneyToATM(Bill.ONE_HUNDRED, 5);
    }

    @Test
    @DisplayName("Test green if withdrawal was successful")
    void withdrawSuccessful() {
        String expected = "1500$ has been withdrawn!";
        String actual = atm.withdraw(1500);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test green if withdrawal was not successful")
    void withdrawNotSuccessful() {
        String expected = "700$ has been withdrawn!";
        String actual = atm.withdraw(25000);

        assertNotEquals(expected, actual);
    }

    @Test
    @DisplayName("Test green if expected report is correct")
    void reportATMStatus() {
        String expected1 = "Money in the ATM: 4000$";
        String actual1 = atm.reportATMStatus();

        assertEquals(expected1, actual1);

        atm.withdraw(1500);

        String expected2 = "Money in the ATM: 2500$";
        String actual2 = atm.reportATMStatus();

        assertEquals(expected2, actual2);
    }

    @Test
    @DisplayName("Test green if expected report is not correct")
    void reportATMStatusFail() {
        atm.withdraw(700);

        String expected = "Money in the ATM: 2500$";
        String actual = atm.reportATMStatus();

        assertNotEquals(expected, actual);
    }

}