public class Main {
    public static void main(String[] args) {

        //adding specified amount of bills to the atm
        ATM atm = new ATM();
        atm.addMoneyToATM(Bill.THOUSAND, 2);
        atm.addMoneyToATM(Bill.FIVE_HUNDRED, 3);
        atm.addMoneyToATM(Bill.ONE_HUNDRED, 5);

        //checking the current ATM balance
        System.out.println(atm.reportATMStatus());

        //demo transactions
        System.out.println("------");
        System.out.println(atm.withdraw(1500));
        System.out.println(atm.withdraw(700));
        System.out.println(atm.withdraw(400));
        System.out.println(atm.withdraw(1100));
        System.out.println(atm.withdraw(1000));
        System.out.println(atm.withdraw(700));
        System.out.println(atm.withdraw(300));
        System.out.println("------");

        //checking the current ATM balance
        System.out.println(atm.reportATMStatus());
    }
}