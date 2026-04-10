import java.util.Scanner;

/**
 *
 * @author lenovo
 */
public class execice1 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        //********* Exerece 1 afficher nom souligner ************
        
        System.out.print(" MALONGI LISUMBU JEREMIE \n");
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
            System.out.println(" la Produit " );
            double diff = x1 - x2;
            System.out.println("***************");
            System.out.println(x1 + "*" + x2 + "=" + diff);
         } else if (choix == 3) {
            System.out.println(" le Quotient " );
            double mult = x1 * x2;
            System.out.println("*******************");
            System.out.println(x1 + "/" + x2 + "=" + mult);
         } else if (choix == 4) {
            System.out.println(" la difference " );
            double div = x1 / x2;
            System.out.println("***************");
            System.out.println(x1 + "-" + x2 + "=" + div);
         } else {
            System.out.println(" signe invalide");
         }

        // condition switch
        /*
        switch (expression) {
            case valeur1:
                // bloc d'instructions a executer si l'expression est egale a valeur1
                break;
            case valeur2:
                // bloc d'instructions a executer si l'expression est egale a valeur2
                break;
            ...
            default:
                // bloc d'instructions a executer si l'expression ne correspond a aucune valeur
        }
        */
       // exemple condition switch
         int choix;
            System.out.print(" entre un nombre entre 1 et 3: ");
            choix = scan.nextInt();
            switch (choix) {
                case 1:
                    System.out.println(" vous avez choisi le nombre 1");
                    break;
                case 2:
                    System.out.println(" vous avez choisi le nombre 2");
                    break;
                case 3:
                    System.out.println(" vous avez choisi le nombre 3");
                    break;
                default:
                    System.out.println(" choix invalide");
            }

    }

}
