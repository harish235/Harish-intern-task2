import java.io.*;
import java.util.Scanner;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("/Users/harish/IdeaProjects/TaskTwo/Products.csv"));
        Products[] p = new Products[3];
        int i = 0;
        while (sc.hasNext())  //returns a boolean value
        {
            String curr_line = sc.next();
            String[] entities = curr_line.split(",");

            p[i] = new Products(Integer.parseInt(entities[0]), entities[1], Integer.parseInt(entities[2]), Integer.parseInt(entities[3]));
            i++;
        }
        sc.close();

        List<Products> wholesaleProducts = new ArrayList<>();
        //List<Products> wholesalers = new ArrayList<>();
        Wholesaler[] w = new Wholesaler[2];

        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.println("\n\t\tWelcome to Task - 2");
            System.out.println("\n\tSelect 1 for Product details");
            System.out.println("\n\tSelect 2 for Wholesaler details");
            System.out.println("\n\tSelect 3 for Retailer details");
            System.out.println("\n\tSelect 4 for updating wholesaler stock");
            System.out.println("\n\tSelect 5 for updating retailer stock");
            System.out.println("\n\tSelect 6 for EXIT");

            int op = s.nextInt();
            switch (op) {
                case 1:
                    for (i = 0; i < 3; i++) {
                        p[i].display();
                    }
                    break;
                case 2:
                    System.out.println("\nWholesaler dummy");
                    break;
                case 3:
                    System.out.println("\nRetailer dummy");
                    break;
                case 4:

                    int product_choice, wholesaler_choice, qty;
                    System.out.println("\nEnter the Wholesaler id");
                    wholesaler_choice = s.nextInt();
                    System.out.println("\nEnter the product id to purchase: ");
                    product_choice = s.nextInt();
                    for(i = 0; i<3; i++){
                        if(p[i].getId() == product_choice){
                            System.out.println("\nEnter the quantity:");
                            qty = s.nextInt();
                            p[i].reduce_stock(qty);


                            Products temp = new Products(product_choice, p[i].getName(), qty, p[i].getPrice());
                            System.out.println(temp);
                            wholesaleProducts.add(temp);

                            w[product_choice - 1] = new Wholesaler(wholesaler_choice, "dummy", wholesaleProducts);
//
                        }
                    }
                    break;

                case 5:
                    List availableProducts;
                    Products productTemp = new Products();
                    System.out.println("\nEnter Wholesaler id:");
                    wholesaler_choice = s.nextInt();
                    System.out.println("\nEnter Product choice");
                    product_choice = s.nextInt();
                    availableProducts = w[wholesaler_choice-1].getProduct_details();
                    System.out.println("\nsize:"+availableProducts.size());
                    for(int j=0; j < availableProducts.size(); j++){
                        System.out.println(availableProducts.get(j).get());
                        System.out.println(availableProducts.get(j).getClass());
                    }
                    System.out.println(availableProducts.getClass());
                    break;

                case 6:
                    System.exit(0);
            }
        }
    }
}