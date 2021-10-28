import java.text.DecimalFormat;
import java.util.*;
import java.io.IOException;

public class MainMenu extends Account {
    Scanner scn = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'Rs'##,##0.00");

    HashMap<Integer, Integer> data = new HashMap<>();

    public void getLogin() throws IOException {
        int x = 1;

        do {
            try {
                data.put(98761, 990589);
                data.put(98762, 990689);
                data.put(98763, 990789);
                data.put(98764, 990889);

                System.out.println("Welcome my Atm");
                System.out.println("Enter your customer number");
                setCustomerNumber(scn.nextInt());

                System.out.println("Enter your Pin Number:");
                setPinNumber(scn.nextInt());

            } catch (Exception e) {
                System.out.println("\n" + "Invalid Character(s). Only Numbers" + "\n");
                x = 2;

            }

            int cn = getCustomerNumber();
            int pn = getPinNumber();
            if (data.containsKey(cn) && data.get(cn) == pn) {
                getAccountType();

            } else
                System.out.println("\n" + "wrong customer number or Pin Number" + "\n");

        } while (x == 1);
    }

    public void getAccountType() {
        System.out.println("Select the account you want to access:");
        System.out.println("Press 1 - Current Account");
        System.out.println("Press 2 - Savings Account");
        System.out.println("Press 3 - Exit");

        int selection = scn.nextInt();

        switch (selection) {
        case 1:
            getCurrent();
            break;
        case 2:
            getSaving();
            break;
        case 3:
            System.out.println("Thanks for using this Atm");
            break;
        default:
            System.out.println("Invalid Choice");
            getAccountType();
        }
    }

    public void getCurrent() {
        System.out.println("Current Account:");
        System.out.println("Press 1 - View Balance");
        System.out.println("Press 2 - Withdrawn Funds");
        System.out.println("Press 3 - Deposit Funds");
        System.out.println("Press 4 - Exit");
        System.out.println("Choice: ");

        int selection = scn.nextInt();

        switch (selection) {
        case 1:
            System.out.println("Current Account Balance: " + moneyFormat.format(getCurrentBalance()));
            getAccountType();
            break;

        case 2:
            getCurrentWithdrawInput();
            getAccountType();
            break;

        case 3:
            getCurrentDepositInput();
            getAccountType();
            break;

        case 4:
            System.out.println("Thanks for Using Atm");
            break;

        default:
            System.out.println("Invalid Choice");
            getCurrent();
        }
    }

    public void getSaving() {
        System.out.println("Saving Account:");
        System.out.println("Press 1 - View Balance");
        System.out.println("Press 2 - Withdrawn Funds");
        System.out.println("Press 3 - Deposit Funds");
        System.out.println("Press 4 - Exit");
        System.out.println("Choice: ");

        int selection = scn.nextInt();

        switch (selection) {
        case 1:
            System.out.println("Saving Account Balance: " + moneyFormat.format(getSavingBalance()));
            getAccountType();
            break;

        case 2:
            getSavingWithdrawInput();
            getAccountType();
            break;

        case 3:
            getSavingDepositInput();
            getAccountType();
            break;

        case 4:
            System.out.println("Thanks for Using Atm");
            break;

        default:
            System.out.println("Invalid Choice");
            getSaving();
        }
    }
}
