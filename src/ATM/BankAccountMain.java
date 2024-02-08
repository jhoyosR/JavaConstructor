package ATM;

import javax.swing.*;

public class BankAccountMain {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(24532, 50000, "Active", "Kiwi");
        bankAccount.showMenu();

    }
}
