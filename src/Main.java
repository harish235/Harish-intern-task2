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


        //List<Products> wholesalers = new ArrayList<>();
        List<Products> wholesaleProductsOne = new ArrayList<>();
        List<Products> wholesaleProductsTwo = new ArrayList<>();
        Wholesaler[] w = new Wholesaler[2];

        Retailer[] r = new Retailer[2];

        Scanner s = new Scanner(System.in);
        while (true) {

            System.out.println("\n\t\tWelcome to Task - 2");
            System.out.println("\n\tSelect 1 for Product details");
            System.out.println("\n\tSelect 2 for Wholesaler details");
            System.out.println("\n\tSelect 3 for Retailer details");
            System.out.println("\n\tSelect 4 for updating wholesaler stock");
            System.out.println("\n\tSelect 5 for Display wholesale stock");
            System.out.println("\n\tSelect 6 for updating retailer stock");
            System.out.println("\n\tSelect 7 for Display retailer stock");
            System.out.println("\n\tSelect 8 for EXIT");

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
                    List productsAvailable;

                    //Products temp = new Products();
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
                            System.out.println(temp.getClass());
                            if(wholesaler_choice == 1){
                                wholesaleProductsOne.add(temp);
                                w[0] = new Wholesaler(wholesaler_choice, "dummy", wholesaleProductsOne);
//
                            }
                            else if(wholesaler_choice == 2){
                                wholesaleProductsTwo.add(temp);
                                w[1] = new Wholesaler(wholesaler_choice, "dummy", wholesaleProductsTwo);
                            }

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
                    availableProducts = w[wholesaler_choice-1].getProduct_details(); //[p1, p2]
                    System.out.println("\nsize:"+availableProducts.size());

                    for(int j=0; j< availableProducts.size();j++){
                        productTemp = (Products)availableProducts.get(j);
                        if(productTemp.getId()==product_choice){
                            System.out.println("\nid : "+productTemp.getId());
                            System.out.println("\nname : "+productTemp.getName());
                            System.out.println("\nstock : "+productTemp.getStock());
                            System.out.println("\nprice : "+productTemp.getPrice());
                        }
                    }
                    break;
                case 6:
                    List wholesaleProducts;

                    //Products temp = new Products();
                    int wholesaler_ch, retailer_choice, stock_qty, product_ch;
                    System.out.println("\nEnter the Retailler id");
                    retailer_choice = s.nextInt();
                    System.out.println("\nEnter the wholesaler id");
                    wholesaler_ch = s.nextInt();
                    if(wholesaler_ch == 1){
                        wholesaleProducts = w[0].getProduct_details();
                        for(int j=0; j< wholesaleProducts.size();j++){
                            productTemp = (Products)wholesaleProducts.get(j);

                            System.out.println("\nid : "+productTemp.getId());
                            System.out.println("\nname : "+productTemp.getName());
                            System.out.println("\nstock : "+productTemp.getStock());
                            System.out.println("\nprice : "+productTemp.getPrice());

                        }
                        System.out.println("\nEnter the product id");
                        product_ch = s.nextInt();
                        System.out.println("\nEnter the stock");
                        stock_qty = s.nextInt();
                        for(int j=0; j < wholesaleProducts.size(); j++){
                            productTemp = (Products)wholesaleProducts.get(j);
                            if(productTemp.getId() == product_ch){
                                productTemp.setStock(productTemp.getStock() - stock_qty);
                            }
                        }

                    }
                    else if(wholesaler_ch == 2){
                        wholesaleProducts = w[1].getProduct_details();
                        for(int j=0; j< wholesaleProducts.size();j++){
                            productTemp = (Products)wholesaleProducts.get(j);

                            System.out.println("\nid : "+productTemp.getId());
                            System.out.println("\nname : "+productTemp.getName());
                            System.out.println("\nstock : "+productTemp.getStock());
                            System.out.println("\nprice : "+productTemp.getPrice());
                        }
                        System.out.println("\nEnter the product id");
                        product_ch = s.nextInt();
                        System.out.println("\nEnter the stock");
                        stock_qty = s.nextInt();
                        for(int j=0; j < wholesaleProducts.size(); j++){
                            productTemp = (Products)wholesaleProducts.get(j);
                            if(productTemp.getId() == product_ch){
                                productTemp.setStock(productTemp.getStock() - stock_qty);
                            }
                        }
                    }
                    break;
                case 7:
                    break;
                case 8:
                    System.exit(0);
            }
        }
    }
}