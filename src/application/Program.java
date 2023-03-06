package application;

import entities.Account;
import exceptions.BusinessException;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe os dados da conta");
        System.out.println("Numero: ");
        int number =scanner.nextInt();
        System.out.println("Titular: ");
        scanner.nextLine();
        String holder = scanner.nextLine();
        System.out.print("Saldo inicial: ");
        double balance = scanner.nextDouble();

        System.out.print("Limite de saque: ");
        double withdrawLimit = scanner.nextDouble();

        Account account = new Account(number,holder,balance,withdrawLimit); //instanciei c os dados de cima
        System.out.println();
        System.out.print("Informe uma quantia para sacar");
        double amount = scanner.nextDouble();

        try {
            account.withdraw(amount);
            System.out.printf("Novo saldo: %.2f%n", account.getBalance());
        }
        catch (BusinessException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }

}




