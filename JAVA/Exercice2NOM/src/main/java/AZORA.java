import java.util.Scanner;

public class AZORA {
    public static void main(String[] args) {
        
        

        System.out.println("MALONGI LISUMBU JEREMIE");
        System.out.println("_______________________");

        Scanner sc = new Scanner(System.in);

        System.out.print("Entrez le premier nombre : ");
        int a = sc.nextInt();

        System.out.print("Entrez le deuxième nombre : ");
        int b = sc.nextInt();

        int somme = a + b;
        int differ = a - b;
        int quonti = a/b;
        int prod = a*b;

        System.out.println("La somme est : "+ a +" + "+ b +" = "+ somme);
        System.out.println("__________________");
        System.out.println("La difference est : "+ a +" - "+ b +" = "+ differ);
        System.out.println("__________________");
        System.out.println("Le quotiant est : "+ a +" / "+ b +" = "+ quonti);
        System.out.println("__________________");
        System.out.println("Le Produit est : "+ a +" * "+ b +" = "+ prod);
        System.out.println("__________________");

        // la condition en java
        


    
    }
}
