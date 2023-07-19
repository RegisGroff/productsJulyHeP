package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        List<Product> list = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        int N = sc.nextInt();

        for (int i = 1; i <= N; i++){
            System.out.println("Product #" + i + " data");
            System.out.print("Common, used or imported (c/u/i)? ");
            char choice = sc.next().charAt(0);
            if (choice == 'c'){
                System.out.print("Name: ");
                sc.nextLine();
                String name = sc.nextLine();
                System.out.print("Price: ");
                double price = sc.nextDouble();
                Product p = new Product(name, price);
                list.add(p);
            }
                    else if (choice == 'u'){
                        System.out.print("Name: ");
                        sc.nextLine();
                        String name = sc.nextLine();
                        System.out.print("Price: ");
                        double price = sc.nextDouble();
                        System.out.print("Manufacture date (DD/MM/YYYY): ");
                        String date = sc.next();
                        LocalDate d08 = LocalDate.parse(date, fmt1);
                        Product p = new UsedProduct(name, price, d08);
                        list.add(p);
                    }

                                else {
                                    System.out.print("Name: ");
                                    sc.nextLine();
                                    String name = sc.nextLine();
                                    System.out.print("Price: ");
                                    double price = sc.nextDouble();
                                    System.out.print("Customs fee: ");
                                    double customsFee = sc.nextDouble();
                                    Product p = new ImportedProduct(name, price, customsFee);
                                    list.add(p);
                                }
        }
        System.out.println();
        System.out.println("PRICE TAGS: ");

        for (Product x : list){
            System.out.println(x.priceTag());
        }
        sc.close();
    }
}
