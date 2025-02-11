import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Order {
    private static int orders = 0;
    private int order_number;
    private Sale sale;
    private String fullname;
    private String phone;
    private String order_date;
    private String dateOfArrival;
    private double totalCost;
    private String status;

    public Order(Sale sale, String dateOfArrival) {
        this.order_number = orders;
        this.sale = sale;
        this.fullname = sale.get_Name();
        this.phone = sale.get_Phone();
        this.order_date = sale.get_Date();
        this.dateOfArrival = dateOfArrival;
        this.totalCost = sale.get_Price();
        this.status = "Expected";
        sale.adjust_sales();
        orders++;
    }

    // Set methods
    public void setSale(Sale sale) {
        this.sale = sale;
    }
    
    public void setOrder_number(int num) {
        this.order_number = num;
    }
    
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public void setdateOfArrival(String dateOfArrival) {
        this.dateOfArrival = dateOfArrival;
    }

    public void settotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public void changeStatus() {
        if (status.equalsIgnoreCase("Expected")) {
            status = "Arrived";
            sale.fix_sales();
            sale.set_SalesNumber();
        } else {
            System.out.println("The order has already arrived and the status cannot be changed!");
        }
    }

    // New method to automatically update status if the expected arrival date has passed or is today.
    public void updateStatusIfNeeded() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate arrivalDate = LocalDate.parse(this.dateOfArrival, formatter);
        LocalDate currentDate = LocalDate.now();
        if ((currentDate.isAfter(arrivalDate) || currentDate.isEqual(arrivalDate)) && status.equalsIgnoreCase("Expected")) {
            changeStatus();
        }
    }

    // Get methods
    public Sale getSale() {
        return sale;
    }

    public int getOrder_number() {
        return order_number;
    }

    public double getCost() {
        return totalCost;
    }

    public String getdateOfArrival() {
        return dateOfArrival;
    }

    public String getFullname() {
        return fullname;
    }

    public String getStatus() {
        return status;
    }

    public String getOrder_date() {
        return order_date;
    }

    public String getPhone() {
        return phone;
    }

    public String toString() {
        return "\nOrder with number: " + getOrder_number() +
               " \nMade by: " + getFullname() +
               " \nWith phone number: " + getPhone() +
               " \nWith total Cost: " + String.format("%.2f", getCost()) +
               " \nCreated on: " + getOrder_date() +
               " \nExpected to be delivered by: " + getdateOfArrival() +
               " \nStatus: " + getStatus();
    }
}
