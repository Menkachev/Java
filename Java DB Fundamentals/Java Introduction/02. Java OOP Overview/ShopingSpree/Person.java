package ShopingSpree;

import java.util.HashMap;
import java.util.List;

public class Person {

    private String name;
    private int money;
    private List<Product> bagOfProducts;

    public Person(String name, int money) {
        this.name = name;
        this.money = money;
        this.bagOfProducts = bagOfProducts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (this.name == null){
            System.out.println("Name cannot be empty");
            return;
        }
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        if (this.money < 0){
            System.out.println("Money cannot be negative");
            return;
        }
        this.money = money;
    }

    public List<Product> getBagOfProducts() {
        return bagOfProducts;
    }

    public void setBagOfProducts(List<Product> bagOfProducts) {
        this.bagOfProducts = bagOfProducts;
    }

    public void buyProduct(Product product){
        this.bagOfProducts.add(product);

        this.setMoney(this.getMoney() - product.getCost());
    }


}
