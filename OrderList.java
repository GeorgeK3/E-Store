import java.util.*;
import java.io.*;

public class OrderList {
    private ArrayList<Order> orders;
    private String FileName;
    BufferedReader reader = null;
    String line;
    int order_num;
    String item_type;
    String model;
    String name;
    String phone;
    String order_date;
    String delivery_date;
    double price;
    String status; // Added variable for status
    Sale sale;
    Order order;
    Supply supplies;

    public OrderList(String FileName) {
        this.supplies = new Supply("products.txt");
        this.FileName = FileName;
        this.orders = new ArrayList<Order>();
        this.createOrderList();
    }

    public void createOrderList() {
        System.out.println("\n >>>>>>> Adding Objects (Orders) from " + FileName + " to Order List ...");
        try {
            reader = new BufferedReader(new FileReader(new File(FileName)));
            
            // Skip header lines until we find an "ORDER" line.
            while ((line = reader.readLine()) != null) {
                if (line.trim().equals("ORDER")) {
                    break;
                }
            }
            
            // Process order blocks.
            while (line != null) {
                if (line.trim().equals("ORDER")) {
                    // Expect the next line to be "{"
                    line = reader.readLine();
                    if (line != null && line.trim().equals("{")) {
                        boolean error = false;
                        order_num = -1;
                        item_type = null;
                        model = null;
                        name = null;
                        phone = null;
                        order_date = null;
                        delivery_date = null;
                        price = -1;
                        status = null; // reset status

                        // Read order block lines until the closing "}" is encountered.
                        while ((line = reader.readLine()) != null && !line.trim().equals("}")) {
                            String trimmedLine = line.trim();
                            if (trimmedLine.startsWith("NUMBER ")) {
                                order_num = Integer.parseInt(trimmedLine.substring(7).trim());
                            } else if (trimmedLine.startsWith("ITEM_TYPE ")) {
                                item_type = trimmedLine.substring(10).trim();
                            } else if (trimmedLine.startsWith("MODEL ")) {
                                model = trimmedLine.substring(6).trim();
                            } else if (trimmedLine.startsWith("NAME ")) {
                                name = trimmedLine.substring(5).trim();
                            } else if (trimmedLine.startsWith("PHONE ")) {
                                phone = trimmedLine.substring(6).trim();
                            } else if (trimmedLine.startsWith("ORDER_DATE ")) {
                                order_date = trimmedLine.substring(11).trim();
                            } else if (trimmedLine.startsWith("DELIVERY_DATE ")) {
                                delivery_date = trimmedLine.substring(14).trim();
                            } else if (trimmedLine.startsWith("STATUS ")) {
                                status = trimmedLine.substring(7).trim();
                            } else if (trimmedLine.startsWith("PRICE ")) {
                                price = Double.parseDouble(trimmedLine.substring(6).trim());
                            }
                        }
                        // Now we've reached the closing "}" for this order.
                        if (order_num == -1 || item_type == null || model == null || name == null || phone == null ||
                            order_date == null || delivery_date == null || price == -1 || status == null) {
                            error = true;
                        }
                        if (!error) {
                            Product p = null;
                            for (Product product : supplies.getProducts()) {
                                if (product.get_P_Name().contains(model) && product.getClass().getName().contains(item_type)) {
                                    p = product;
                                    break;
                                }
                            }
                            if (p != null) {
                                sale = new Sale(p, name, phone, order_date, price);
                                order = new Order(sale, delivery_date);
                                order.setStatus(status); // Update order status from file
                                orders.add(order);
                            } else {
                                System.out.println("There was an error with one of the orders (product not found).");
                            }
                        } else {
                            System.out.println("There was an error with one of the orders (missing field).");
                        }
                    }
                }
                line = reader.readLine();
            }
        } catch (Exception e) {
            System.err.println("Error reading File");
            e.printStackTrace();
        }
    }

    public void CreateFile() {
        System.out.println(" >>>>>>> Write data from ARRAYLIST to FILE...");
        FileWriter writer = null;
        try {
            writer = new FileWriter(new File("orders.txt"));
            writer.write("ORDER_LIST\n{\n");
            for (Order order : orders) {
                writer.write("\n ORDER"
                        + "\n {"
                        + "\n  NUMBER " + order.getOrder_number()
                        + "\n  ITEM_TYPE " + order.getSale().get_product().getClass().getName()
                        + "\n  MODEL " + order.getSale().get_product().get_P_Name()
                        + "\n  NAME " + order.getSale().get_Name()
                        + "\n  PHONE " + order.getSale().get_Phone()
                        + "\n  ORDER_DATE " + order.getSale().get_Date()
                        + "\n  DELIVERY_DATE " + order.getdateOfArrival()
                        + "\n  STATUS " + order.getStatus()
                        + "\n  PRICE " + order.getSale().get_Price()
                        + "\n }");
            }
            writer.write("\n}");
            writer.close();
        } catch (Exception e) {
            System.err.println("Error writing file.");
        }
    }

    public ArrayList<Order> getOrders() {
        return this.orders;
    }
}
