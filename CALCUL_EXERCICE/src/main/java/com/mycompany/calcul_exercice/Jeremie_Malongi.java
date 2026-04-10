
package com.mycompany.calcul_exercice;

/**
 *
 * @author jerem
 */
import java.util.Scanner;
public class Jeremie_Malongi {
  
    Scanner clavier=new Scanner(System.in);
    
    void addition(){
    System.out.print("Saisissez un nombre");int x=clavier.nextInt();
    System.out.print("Saisissez un autre");int y=clavier.nextInt();
    System.out.print("La somm est :"+(x+y));
    }
    void soustraction(){
    System.out.print("Saisissez un nombre");int x=clavier.nextInt();
    System.out.print("Saisissez un autre");int y=clavier.nextInt();
    System.out.print("La somm est :"+(x-y));
    }
 void multiplication(){
    System.out.print("Saisissez un nombre");int x=clavier.nextInt();
    System.out.print("Saisissez un autre");int y=clavier.nextInt();
    System.out.print("La somm est :"+(x*y));
    }  
 void division(){
    System.out.print("Saisissez un nombre");int x=clavier.nextInt();
    System.out.print("Saisissez un autre");int y=clavier.nextInt();
    System.out.print("La somm est :"+(x+y));
    }
 void souligner(){
 System.out.print("\n_________________");
 }
 void reste() {
    System.out.print("Saisissez un nombre : ");
    int x = clavier.nextInt();

    System.out.print("Saisissez un autre nombre : ");
    int y = clavier.nextInt();

    if (y != 0) {
        System.out.print("Le reste est : " + (x % y));
    } else {
        System.out.print("Erreur : division par zéro impossible");
    }
}

}
 




