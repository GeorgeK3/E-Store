public class Product {
    protected int quantity;
    protected String modelName;
    protected int modelYear;
    protected String modelBrand;
    protected double modelPrice;
    protected double discount=0;

    Product(String n, int y, String b, double p,int q) {
        modelName = n;
        modelYear = y;
        modelBrand = b;
        modelPrice = p;
        quantity = q;
    }

    // Set Methods
    public void set_P_Name(String name) {
        modelName = name;
    }

    public void set_P_year(int year) {
        modelYear = year;
    }

    public void set_P_brand(String brand) {
        modelBrand = brand;
    }

    public void set_P_price(double price) {
        modelPrice = price;
    }

    public void set_P_discount(double discount){
        this.discount = discount;
    }

    public void set_P_quantity(int quantity){
        this.quantity = quantity;
    }

    // Get Methods
    public String get_P_Name() {
        return modelName;
    }

    public int get_P_year() {
        return modelYear;
    }

    public String get_P_brand() {
        return modelBrand;
    }

    public double get_P_price() {
        return modelPrice;
    }

    public int get_P_quantity(){
        return quantity;
    }

    public double get_P_discount(){
        return discount;
    }

    public String toString() {
        return "\nModel Name: " + modelName + " " + "\t\tModel Year: " + modelYear + " " +
                "\t\tModel Brand: " + modelBrand + " " + "\t\tModel Price: " + String.format("%,.2f", modelPrice) + "\nQuantity: " + quantity;
    }

}