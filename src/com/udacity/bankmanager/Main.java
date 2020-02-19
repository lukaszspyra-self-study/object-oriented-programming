package com.udacity.bankmanager;

public class Main {
    public static void main(String[] args) {
        CheckingAccount checkingAccount = new CheckingAccount();
        SavingsAccount savingsAccount = new SavingsAccount();
        CertificateOfDeposit certificateOfDeposit = new CertificateOfDeposit();

        checkingAccount.limit = 1000;
        checkingAccount.balance = 77.90;
        checkingAccount.accountNumber = "123456789";
        System.out.println(checkingAccount.balance);

        System.out.println(savingsAccount.balance);

        System.out.println(certificateOfDeposit.accountNumber);
    }
}
