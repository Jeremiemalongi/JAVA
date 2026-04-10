/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calcul_exercice;

import java.util.Scanner;

public class Calculatrice {

    Scanner sc = new Scanner(System.in);

    public void addition() {
        System.out.print("Entrez le premier nombre : ");
        double a = sc.nextDouble();

        System.out.print("Entrez le deuxième nombre : ");
        double b = sc.nextDouble();

        System.out.println("Résultat = " + (a + b));
    }

    public void soustraction() {
        System.out.print("Entrez le premier nombre : ");
        double a = sc.nextDouble();

        System.out.print("Entrez le deuxième nombre : ");
        double b = sc.nextDouble();

        System.out.println("Résultat = " + (a - b));
    }

    public void division() {
        System.out.print("Entrez le premier nombre : ");
        double a = sc.nextDouble();

        System.out.print("Entrez le deuxième nombre : ");
        double b = sc.nextDouble();

        if (b == 0) {
            System.out.println("Erreur : division par zéro !");
        } else {
            System.out.println("Résultat = " + (a / b));
        }
    }

    public void multiplication() {
        System.out.print("Entrez le premier nombre : ");
        double a = sc.nextDouble();

        System.out.print("Entrez le deuxième nombre : ");
        double b = sc.nextDouble();

        System.out.println("Résultat = " + (a * b));
    }
}
