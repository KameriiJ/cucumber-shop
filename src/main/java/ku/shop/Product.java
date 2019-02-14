package ku.shop;

public class Product {
    private double price;
    private String name;
    private int initQuantity;
    private int remain;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.initQuantity = quantity;
        this.remain = quantity;
    }

    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public int getInitQuantity() {return initQuantity;}
    public int getRemain() {return remain;}

    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(double price) {
        if (price < 0)
            throw new IllegalArgumentException("Price must be not be negative zero");
        this.price = price;
    }

    public void updateQuantity(int boughtQaunt){
        if(this.remain - boughtQaunt >= 0){
            this.remain -= boughtQaunt;
        }
        else System.out.printf("%s is not enough. %s remains %d left.", name, name, this.remain);
    }
}
