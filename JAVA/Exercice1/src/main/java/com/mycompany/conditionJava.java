import java.util.Scanner;

public class conditionJava {
    public static void main(String[] args) {

        System.out.println("MALONGI LISUMBU JEREMIE");
        System.out.println("_______________________");

        Scanner sc = new Scanner(System.in);

        System.out.print("Entrez le premier nombre : ");
        int a = sc.nextInt();

        System.out.print("Entrez le deuxième nombre : ");
        int b = sc.nextInt();

        // Déclaration des variables
        int somme = a + b;
        int differ = a - b;
        int prod = a * b;
        int quonti = 0;

        if (b != 0) {
            quonti = a / b;
        }

        System.out.println("Choisissez l'opération :");
        System.out.println("1 - Somme (+)");
        System.out.println("2 - Produit (*)");
        System.out.println("3 - Quotient (/)");
        System.out.println("4 - Difference (-)");
        System.out.println("5 - Toutes les opérations");
        System.out.print("Votre choix : ");

        int choix = sc.nextInt();

        if (choix == 1) {
            System.out.println("La somme est : " + a + " + " + b + " = " + somme);

        } else if (choix == 2) {
            System.out.println("Le produit est : " + a + " * " + b + " = " + prod);

        } else if (choix == 3) {
            if (b != 0) {
                System.out.println("Le quotient est : " + a + " / " + b + " = " + quonti);
            } else {
                System.out.println("Erreur : division par zéro impossible");
            }

        } else if (choix == 4) {
            System.out.println("Le produit est : " + a + " - " + b + " = " + differ);

        } else if (choix == 5) {
            System.out.println("La somme est : " + a + " + " + b + " = " + somme);
            System.out.println("__________________");
            System.out.println("La différence est : " + a + " * " + b + " = " + prod);
            System.out.println("__________________");

            if (b != 0) {
                System.out.println("Le quotient est : " + a + " / " + b + " = " + quonti);
            } else {
                System.out.println("Division impossible");
            }

            System.out.println("__________________");
            System.out.println("Le produit est : " + a + " - " + b + " = " + differ);
            System.out.println("__________________");

        } else {
            System.out.println("Choix invalide !");
        }
    }
}


