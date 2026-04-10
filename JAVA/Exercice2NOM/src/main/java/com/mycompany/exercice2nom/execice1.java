

package com.mycompany.exercice2nom;

import java.util.Scanner;

/**
 *
 * @author lenovo
 */
public class execice1 {

    public static void main(String[] args) {
        //********* Exerece 1 afficher nom souligner ************
        
        System.out.print(" MALONGI LISUMBU Jeremie \n");
        System.out.println(" ************************");
        
        Scanner scan = new Scanner (System.in);
        System.out.print(" entre le premier nombe:");

        double x1 = scan.nextDouble();
        System.out.print(" entre le deuxieme nombe:");

        double x2 = scan.nextDouble();
        System.out.println(" Entrer le choix de la signer 1 pour +, 2 pour * , 3 pour /, 4 pour - :");
        int choix = scan.nextInt();
        

        //les conditions en java
        /* 
        if (condition) {
            // bloc d'instructions a executer si la condition est vraie
        } else {
            // bloc d'instructions a executer si la condition est fausse
        }
        */
       // exemple la condition if else
         if (choix == 1) {
            double som = x1 + x2;
            System.out.println("la somme de " + x1 + "+" + x2);
            System.out.println(" la somme est: ");
            System.out.println("***************");
            System.out.println(x1 +"+" + x2 + "=" + som);
         } else if (choix == 2) {
            System.out.println(" la difference " );
            double diff = x1 - x2;
            System.out.println("***************");
            System.out.println(x1 + "-" + x2 + "=" + diff);
         } else if (choix == 3) {
            System.out.println(" la multiplication " );
            double mult = x1 * x2;
            System.out.println("*******************");
            System.out.println(x1 + "*" + x2 + "=" + mult);
         } else if (choix == 4) {
            System.out.println(" la division " );
            double div = x1 / x2;
            System.out.println("***************");
            System.out.println(x1 + "/" + x2 + "=" + div);
         } else {
            double som = x1 + x2;
            double differ = x1 - x2;
            double quonti = x1 / x2;
            double prod = x1 * x2;
            System.out.println(" signe invalide");
            System.out.println("La somme est : "+ x1 +" + "+ x2 +" = "+ som);
            System.out.println("__________________");
            System.out.println("La difference est : "+ x1 +" * "+ x2 +" = "+ prod);
            System.out.println("__________________");
            System.out.println("Le quotiant est : "+ x1 +" / "+ x2 +" = "+ quonti);
            System.out.println("__________________");
            System.out.println("Le Produit est : "+ x1 +" - "+ x2 +" = "+ differ );
            System.out.println("__________________");
         }

       

    }

}
