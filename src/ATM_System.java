import java.util.HashMap;

public class ATM_System {
    private final int requestedAmount;
    private final HashMap<Bill, Integer> billsInATM;
    private boolean isWithdrawalSuccessful = false;

    public ATM_System(int requestedAmount, HashMap<Bill, Integer> billsInATM) {
        this.requestedAmount = requestedAmount;
        this.billsInATM = new HashMap<>(billsInATM);
    }

    /**
     * @return hashMap of bills in the ATM
     */
    public HashMap<Bill, Integer> getBillsRemaining() {
        return billsInATM;
    }

    /**
     * @return true if enough money in the ATM for withdrawal
     */
    public boolean isEnoughMoneyInATM() {
        int moneyLeft = billsInATM.entrySet().stream().mapToInt(entry -> entry.getKey().value * entry.getValue()).sum();
        return moneyLeft >= requestedAmount;
    }

    /**
     * @return true if enough bills in the ATM for withdrawal
     */
    public boolean isEnoughBillsInATM() {
        int leftToWithdraw = requestedAmount;

        for (Bill bill : Bill.values()) {

            if (billsInATM.containsKey(bill) && (leftToWithdraw != 0)) {
                int billCountNeeded = leftToWithdraw / bill.value;

                if (billCountNeeded > 0) {
                    for (int i = 0; i < billCountNeeded && i < billsInATM.get(bill); i++) {
                        leftToWithdraw -= bill.value;
                    }

                    if (billsInATM.get(bill) - billCountNeeded == 0) {
                        billsInATM.remove(bill);
                    } else {
                        billsInATM.compute(bill, (k, v) -> v - billCountNeeded);
                    }
                }
            }
        }
        return isWithdrawalSuccessful = leftToWithdraw == 0;
    }

    public String reportResult() {
        return isWithdrawalSuccessful ? requestedAmount + "$ has been withdrawn!" : "Not enough money in the ATM!";
    }
}