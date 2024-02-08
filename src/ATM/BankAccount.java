package ATM;

import javax.swing.*;

public class BankAccount {
    private int accountNumber;
    private int balance;
    private String status;
    private String securityPassword;



    public BankAccount(int accountNumber, int balance, String status, String securityPassword) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.status = status;
        this.securityPassword = securityPassword;
    }

    public int balanceConsultation(){
        return this.balance;
    }

    public void cashOut(int amount){
        if (amount <= this.balance){
            this.balance -= amount;
            JOptionPane.showMessageDialog(null,"Successful withdrawal, your new balance is: " + this.balance);
        } else {
            JOptionPane.showMessageDialog(null,"Insufficient funds");
        }
    }

    public void dispatchMoney(int quantity){
        this.balance += quantity;
        JOptionPane.showMessageDialog(null,"Successful dispatch, your new balance is: " + this.balance);
    }

    public void passwordChanging(){

        String actualPassword = JOptionPane.showInputDialog("Insert the actual password");
        if (securityPassword.equals(actualPassword)) {
            String newPassword = JOptionPane.showInputDialog("Insert the new password");
            securityPassword = newPassword;
            JOptionPane.showMessageDialog(null, "Your password has been changed");
        } else {
            JOptionPane.showMessageDialog(null, "Incorrect password, you can't change it at the moment");
        }
    }

    public void showMenu(){
        int option;
        do {
            option = Integer.parseInt(JOptionPane.showInputDialog("Choose one of the following options: \n 1. Balance consultation" +
                    "\n 2. Cash out \n 3. Dispatch Money \n 4. Change Password \n 5. Leave"));
            switch (option){
                case 1:
                    JOptionPane.showMessageDialog(null,"Your balance is: " + balanceConsultation());
                    break;
                case 2:
                    int amount = Integer.parseInt(JOptionPane.showInputDialog("How much would you like to withdraw?"));
                    cashOut(amount);
                    break;
                case 3:
                    int quantity = Integer.parseInt(JOptionPane.showInputDialog("How much would you like to dispatch?"));
                    dispatchMoney(quantity);
                    break;
                case 4:
                    passwordChanging();
                case 5:
                    JOptionPane.showMessageDialog(null, "Closing software");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option. Please select a valid option.");
            }
        } while (option != 5);
    }
}
