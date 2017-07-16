package ShopingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String customerLine = scanner.nextLine();
        String productLine = scanner.nextLine();

        List<Person> customers = getCustomers(customerLine);
        List<Product> products = getProducts(productLine);

        String input = scanner.nextLine();

        while (!input.equals("END")){
         String[] items = input.split(" ");
         String customerName = items[0];
         String productName = items[1];
            for (Person customer : customers) {
               if (customer.getName().equals(customerName)){
                   for (Product product : products) {
                       if (product.getName().equals(productName)){
                           if (customer.getMoney() >= product.getCost()){
                               customer.buyProduct(product);
                               System.out.println(customer.getName() + " bought " + product.getName());
                           } else {
                               System.out.println(customer.getName() + " can't afford " + product.getName());
                           }
                       }

                   }
               }
            }

            input = scanner.nextLine();
        }

        for (Person customer : customers) {
            System.out.println(customer.getName() + " - " + customer.getBagOfProducts());
        }
    }

    private static List<Product> getProducts(String productLine) {
        List<Product> products = new ArrayList<>();

        String[] productsInput = productLine.split(";");
        for (String input : productsInput) {
            String[] items = input.split("=");
            String productName = items[0];
            int productPrice = Integer.parseInt(items[1]);

            Product product = new Product(productName, productPrice);
            products.add(product);
        }
        return products;
    }

    private static List<Person> getCustomers(String customerLine) {
        List<Person> customers = new ArrayList<>();

        String[] customersInput = customerLine.split(";");
        for (String input : customersInput) {
            String[] items = input.split("=");
            String name = items[0];
            int money = Integer.parseInt(items[1]);

            Person person = new Person(name, money);
            customers.add(person);
        }
    return customers;
    }
}

