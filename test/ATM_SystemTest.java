import org.junit.jupiter.api.*;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class ATM_SystemTest {

    ATM_System atm_system;
    private HashMap<Bill, Integer> billsInATM, moneyInATM;

    //adding money to the ATM before each test
    //two different hashMaps for different test cases
    @BeforeEach
    public void init() {
        moneyInATM = new HashMap<>();
        moneyInATM.put(Bill.THOUSAND, 2);
        moneyInATM.put(Bill.FIVE_HUNDRED, 3);
        moneyInATM.put(Bill.ONE_HUNDRED, 5);

        billsInATM = new HashMap<>();
        billsInATM.put(Bill.THOUSAND, 1);
        billsInATM.put(Bill.FIVE_HUNDRED, 1);
        billsInATM.put(Bill.ONE_HUNDRED, 1);

    }

    @Test
    @DisplayName("Test green if enough money in ATM for withdrawal")
    void isEnoughMoneyInATM() {
        atm_system = new ATM_System(1500, billsInATM);

        boolean actual = atm_system.isEnoughMoneyInATM();
        assertTrue(actual);
    }

    @Test
    @DisplayName("Test green if not enough money in ATM for withdrawal")
    void isEnoughMoneyInATMFalse() {
        atm_system = new ATM_System(25000, billsInATM);

        boolean actual = atm_system.isEnoughMoneyInATM();
        assertFalse(actual);
    }

    @Test
    @DisplayName("Test green if enough bills in ATM for withdrawal")
    void isEnoughBillsInATM() {
        atm_system = new ATM_System(1600, billsInATM);

        boolean actual = atm_system.isEnoughMoneyInATM();
        assertTrue(actual);
    }

    @Test
    @DisplayName("Test green if not enough bills in ATM for withdrawal")
    void isEnoughBillsInATMFalse() {
        atm_system = new ATM_System(1700, billsInATM);

        boolean actual = atm_system.isEnoughMoneyInATM();
        assertFalse(actual);
    }

    @Test
    @DisplayName("Test green if withdrawal succeeded")
    void reportResult() {
        atm_system = new ATM_System(600, billsInATM);
        atm_system.isEnoughBillsInATM();

        String expected = "600$ has been withdrawn!";
        String actual = atm_system.reportResult();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test green if withdrawal failed")
    void reportResultFalse() {
        atm_system = new ATM_System(1700, billsInATM);
        atm_system.isEnoughBillsInATM();

        String expected = "Not enough money in the ATM!";
        String actual = atm_system.reportResult();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test green if returns correct hashMap")
    void getBillsRemaining() {
        atm_system = new ATM_System(500, billsInATM);

        HashMap<Bill, Integer> expected = billsInATM;
        HashMap<Bill, Integer> actual = atm_system.getBillsRemaining();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test green if returns incorrect hashMap")
    void getBillsRemainingFalse() {
        atm_system = new ATM_System(500, moneyInATM);

        HashMap<Bill, Integer> expected = billsInATM;
        HashMap<Bill, Integer> actual = atm_system.getBillsRemaining();

        assertNotEquals(expected, actual);
    }

}