package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Product p = new Product("Tablet", 280.0);
        System.out.println(p.priceTag());
        Product p2 = new UsedProduct("Iphone", 400.00, LocalDate.of(2023, 7, 19));
        System.out.println(p2.priceTag());
        Product p3 = new ImportedProduct("Notebook", 260.00, 20.00);
        System.out.println(p3.priceTag());
    }
}
