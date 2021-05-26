import java.util.HashMap;

public class ATM {

    private HashMap<Bill, Integer> billsInATM;

    public ATM() {
        this.billsInATM = new HashMap<>();
    }

    /**
     * @param billType Bill object
     * @param quantity of bills
     */
    public void addMoneyToATM(Bill billType, int quantity) {
        billsInATM.computeIfPresent(billType, (k, v) -> v + quantity);
        billsInATM.putIfAbsent(billType, quantity);
    }

    /**
     * @return String with amount of money left in the ATM
     */
    public String reportATMStatus() {
        int moneyLeft = billsInATM.entrySet().stream().mapToInt(entry -> entry.getKey().value * entry.getValue()).sum();
        return "Money in the ATM: " + moneyLeft + "$";
    }

    /**
     * @param requestedAmount int to withdraw
     * @return String whether withdrawal was successful
     */
    public String withdraw(int requestedAmount) {
        ATM_System atm_system = new ATM_System(requestedAmount, billsInATM);

        if (atm_system.isEnoughMoneyInATM() && atm_system.isEnoughBillsInATM()) {
            billsInATM = atm_system.getBillsRemaining();
        }
        return atm_system.reportResult();
    }

}