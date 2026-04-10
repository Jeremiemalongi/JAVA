package com.mycompany.calcul_exercice;

import java.util.Scanner;

public class CALCUL_EXERCICE {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Calculatrice calc = new Calculatrice();

        System.out.println("Choisissez l'opération :");
        System.out.println("1 - Addition");
        System.out.println("2 - Soustraction");
        System.out.println("3 - Division");
        System.out.println("4 - Multiplication");

        System.out.print("Votre choix : ");
        int choix = sc.nextInt();

        switch (choix) {
            case 1:
                calc.addition();
                break;
            case 2:
                calc.soustraction();
                break;
            case 3:
                calc.division();
                break;
            case 4:
                calc.multiplication();
                break;
            default:
                System.out.println("Choix invalide !");
        }
    }
}


