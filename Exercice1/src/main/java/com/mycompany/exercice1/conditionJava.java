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

        System.out.println("Choisissez l'opération :");
        System.out.println("1 - Somme (+)");
        System.out.println("2 - Différence (-)");
        System.out.println("3 - Quotient (/)");
        System.out.println("4 - Produit (*)");
        System.out.print("Votre choix : ");

        int choix = sc.nextInt();

        if (choix == 1) {
            int somme = a + b;
            System.out.println("La somme est : " + a + " + " + b + " = " + somme);

        } else if (choix == 2) {
            int differ = a - b;
            System.out.println("La différence est : " + a + " - " + b + " = " + differ);

        } else if (choix == 3) {
            if (b != 0) {
                int quonti = a / b;
                System.out.println("Le quotient est : " + a + " / " + b + " = " + quonti);
            } else {
                System.out.println("Erreur : division par zéro impossible");
            }

        } else if (choix == 4) {
            int prod = a * b;
            System.out.println("Le produit est : " + a + " * " + b + " = " + prod);

        } else {
            System.out.println("La somme est : "+ a +" + "+ b +" = "+ somme);
            System.out.println("__________________");
            System.out.println("La difference est : "+ a +" - "+ b +" = "+ differ);
            System.out.println("__________________");
            System.out.println("Le quotiant est : "+ a +" / "+ b +" = "+ quonti);
            System.out.println("__________________");
            System.out.println("Le Produit est : "+ a +" * "+ b +" = "+ produit);
            System.out.println("__________________");
        }

        System.out.println("__________________");
    }
}