public class Sale {
    private static int sales = 0;
    private int salesNumber;
    private Product product;
    private String fullName;
    private String phonenumber;
    private String date;
    private double final_price;

    Sale() {
        sales++;
        this.salesNumber = sales;
    }// Default Constructor

    Sale(Product product, String fullName, String phonenumber, String date, double final_price) {
        sales++;
        this.salesNumber = sales;
        this.product = product;
        this.fullName = fullName;
        this.phonenumber = phonenumber;
        this.date = date;
        this.final_price = final_price;
    }// Constructor

    // Set Methods
    public void adjust_sales(){
        sales = sales-1;
    }

    public void fix_sales(){
        sales = sales+1;
    }

    public void set_product(Product product) {
        this.product = product;
    }

    public void set_Name(String fullName) {
        this.fullName = fullName;
    }

    public void set_Phone(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public void set_Date(String date) {
        this.date = date;
    }

    public void set_Price(double final_price) {
        this.final_price = final_price;
    }

    public void set_SalesNumber(){
        this.salesNumber=sales;
    }

    public void set_SalesNumber1(int num){
        this.salesNumber=num;
    }

    // Get Methods
    public int get_SalesNumber() {
        return this.salesNumber;
    }

    public Product get_product() {
        return this.product;
    }

    public String get_Name() {
        return this.fullName;
    }

    public String get_Phone() {
        return this.phonenumber;
    }

    public String get_Date() {
        return this.date;
    }

    public double get_Price() {
        return this.final_price;
    }

    // toString
    public String toString() {
        return "\nSale " + get_SalesNumber() + " has been completed. "
                + "\nDetails :"
                + "\nDate of purchase :\t" + get_Date()
                + "\nProduct :\t" + product.get_P_Name()
                + "\nFinal Price :\t" + String.format("%.2f",get_Price())
                + "\nBuyer :\t" + get_Name()
                + "\nPhone Number :\t" + get_Phone();
    }

}// Sale