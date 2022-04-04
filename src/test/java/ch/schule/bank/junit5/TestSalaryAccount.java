/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.schule.bank.junit5;


import ch.schule.SalaryAccount;

/**
 *
 * @author Luigi Cavuoti
 */
public class TestSalaryAccount {

    public static void main(String[] args) {

        // neues SalaryAccount Objekt erstellen cl=-1000
        SalaryAccount salaryAccount = new SalaryAccount("SA-1000", -100000);

        // SalaryAccount einzahlen von 200
        salaryAccount.deposit(18450, 200000);
        // Ausgabe vom Saldo manuel!
        System.out.println("das Saldo ist :"+ salaryAccount.getBalance());

        // Auagabe vom Saldo
        salaryAccount.print();

        // Einzahlung von 1200.-
        salaryAccount.deposit(18450,    1200000);
        // neue Ausgabe
        salaryAccount.print();

        // Abheben von 16.- -> geht es?
        salaryAccount.withdraw(18450, 1600000);

        // Ausgabe von �berzogenem Konto
        salaryAccount.print();

        // Einzahlung von 100000
        salaryAccount.deposit(18450, 100000);
        // Ausgabe vom Konto
        salaryAccount.print();

        // Abheben von 16.- -> geht es?
        salaryAccount.withdraw(18450, 1600000);

        // Ausgabe von überzogenem Konto
        salaryAccount.print();

        // Abheben von 100000
        salaryAccount.withdraw(18450, 100000);
        // Ausgabe vom Konto
        salaryAccount.print();

        // Einzahlen von 2.-
        salaryAccount.deposit(18450, 200000);
        salaryAccount.print();

        // Abheben von 100000
        salaryAccount.withdraw(18450, 100000);
        // Ausgabe vom Konto
        salaryAccount.print();

        // Abheben von 100000
        salaryAccount.withdraw(18454, 100000);
        // Ausgabe vom Konto
        salaryAccount.print();
    }


}
