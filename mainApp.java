import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class mainApp {
    private Supply supplies = new Supply("products.txt");
    private OrderList orders = new OrderList("orders.txt");
    private SaleList sales = new SaleList("sales.txt");

    public mainApp() {
    }

    public static void main(String[] args) {
        Supply supplies = new Supply("products.txt");
        OrderList orders = new OrderList("orders.txt");
        SaleList sales = new SaleList("sales.txt");
        Random rand = new Random();
        int randomIndex = rand.nextInt(3);
        double randomDiscount = Math.round(rand.nextDouble() * 100.0) / 100.0;
        if (randomIndex == 1) {
            supplies.Discount("Hardware", randomDiscount);
        } else if (randomIndex == 2) {
            supplies.Discount("Peripherals", randomDiscount);
        }

        boolean exit = false;
        Scanner in = new Scanner(System.in);
        while (!exit) {
            System.out.println("\n1. Show all available products");
            System.out.println("2. Show all orders");
            System.out.println("3. Show all sales");
            System.out.println("0. Exit");
            System.out.print("> ");
            String option;
            for (option = in.nextLine(); 
                 !option.equals("0") && !option.equals("1") && !option.equals("2") && !option.equals("3"); 
                 option = in.nextLine()) {
                System.out.println("\nPlease select one of the options above!");
                System.out.print("> ");
            }

            if (option.equals("1")) {
                String searchType = "";
                String category;
                System.out.println("\n1. Hardware");
                System.out.println("2. Peripherals");
                System.out.print("> ");
                String catOption;
                for (catOption = in.nextLine(); 
                     !catOption.equals("1") && !catOption.equals("2"); 
                     catOption = in.nextLine()) {
                    System.out.println("\nPlease select one of the options above!");
                    System.out.print("> ");
                }
                if (catOption.equals("1")) {
                    category = "Hardware";
                    System.out.println("\n1. Graphics Card");
                    System.out.println("2. Hard Drives");
                    System.out.println("3. Motherboards");
                    System.out.println("4. Processors");
                    System.out.println("5. Ram Memory");
                    System.out.print("> ");
                    String subOption;
                    for (subOption = in.nextLine(); 
                         !subOption.equals("1") && !subOption.equals("2") && 
                         !subOption.equals("3") && !subOption.equals("4") && 
                         !subOption.equals("5"); 
                         subOption = in.nextLine()) {
                        System.out.println("\nPlease select one of the options above!");
                        System.out.print("> ");
                    }
                    if (subOption.equals("1")) {
                        searchType = "GraphicsCard";
                    } else if (subOption.equals("2")) {
                        searchType = "HardDrive";
                    } else if (subOption.equals("3")) {
                        searchType = "Motherboard";
                    } else if (subOption.equals("4")) {
                        searchType = "Processor";
                    } else if (subOption.equals("5")) {
                        searchType = "RamMemory";
                    }
                } else {
                    category = "Peripherals";
                    System.out.println("\n1. Keybaords");
                    System.out.println("2. Mouses");
                    System.out.println("3. Printers");
                    System.out.println("4. Screens");
                    System.out.print("> ");
                    String subOption;
                    for (subOption = in.nextLine(); 
                         !subOption.equals("1") && !subOption.equals("2") && 
                         !subOption.equals("3") && !subOption.equals("4"); 
                         subOption = in.nextLine()) {
                        System.out.println("\nPlease select one of the options above!");
                        System.out.print("> ");
                    }
                    if (subOption.equals("1")) {
                        searchType = "Keyboard";
                    } else if (subOption.equals("2")) {
                        searchType = "Mouse";
                    } else if (subOption.equals("3")) {
                        searchType = "Printer";
                    } else if (subOption.equals("4")) {
                        searchType = "Screen";
                    }
                }

                // Build a list of matching products and display them with indices
                ArrayList<Product> matchingProducts = new ArrayList<>();
                for (int i = 0; i < supplies.getProducts().size(); i++) {
                    Product p = (Product) supplies.getProducts().get(i);
                    if (p.getClass().getName().equalsIgnoreCase(searchType)) {
                        matchingProducts.add(p);
                    }
                }
                for (int i = 0; i < matchingProducts.size(); i++) {
                    System.out.println(i + ". " + matchingProducts.get(i).get_P_Name());
                }
                System.out.println("\nPlease type the number of the product you wish to see");
                System.out.print(">");
                String productChoice = in.nextLine();
                int index = Integer.parseInt(productChoice);
                String selectedProductName = matchingProducts.get(index).get_P_Name();

                boolean found = false;
                for (int i = 0; i < supplies.getProducts().size(); i++) {
                    Product prod = (Product) supplies.getProducts().get(i);
                    if (selectedProductName.equals(prod.get_P_Name())) {
                        found = true;
                        Product selectedProduct = supplies.findProduct(category, searchType, selectedProductName);
                        System.out.println(selectedProduct);
                        System.out.println("\nWould you like to purchase this product?");
                        System.out.println("1. Yes");
                        System.out.println("2. No");
                        System.out.print(">");
                        String purchaseOption;
                        for (purchaseOption = in.nextLine(); 
                             !purchaseOption.equals("1") && !purchaseOption.equals("2"); 
                             purchaseOption = in.nextLine()) {
                            System.out.println("\nPlease select one of the options above");
                            System.out.print(">");
                        }
                        if (purchaseOption.equals("1")) {
                            if (selectedProduct.get_P_quantity() != 0) {
                                String origPrice = String.format("%.2f", selectedProduct.get_P_price() + selectedProduct.get_P_price() * selectedProduct.get_P_discount());
                                double discountPercent = selectedProduct.get_P_discount() * 100.0;
                                String moneySaved = String.format("%.2f", selectedProduct.get_P_price() * selectedProduct.get_P_discount());
                                System.out.println("\nOriginal Price: " + origPrice + "\nDiscount: " + discountPercent + "%" +
                                        "\nMoney Saved: " + moneySaved + "\nFinal Price: " + String.format("%.2f", selectedProduct.get_P_price()));
                                System.out.println("\nWhat's your name?");
                                System.out.print(">");
                                String customerName = in.nextLine();
                                System.out.println("\nWhat's your phone number?");
                                System.out.print(">");
                                String phone = in.nextLine();
                                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                                String currentDate = formatter.format(LocalDateTime.now());
                                Sale saleObj = new Sale(selectedProduct, customerName, phone, currentDate, selectedProduct.get_P_price());
                                sales.getSales().add(saleObj);
                                selectedProduct.set_P_quantity(selectedProduct.get_P_quantity() - 1);
                                System.out.println("\nYour purchase was succesful !!!");
                            } else {
                                System.out.println("\nThe item you selected is out of stock!");
                                System.out.println("Would you like to order it?");
                                System.out.println("1. Yes");
                                System.out.println("2. No");
                                System.out.print(">");
                                String orderOption;
                                for (orderOption = in.nextLine(); 
                                     !orderOption.equals("1") && !orderOption.equals("2"); 
                                     orderOption = in.nextLine()) {
                                    System.out.println("\nPlease select one of the options above");
                                    System.out.print(">");
                                }
                                if (orderOption.equals("1")) {
                                    // Ordering logic:
                                    String origPrice = String.format("%.2f", selectedProduct.get_P_price() + selectedProduct.get_P_price() * selectedProduct.get_P_discount());
                                    double discountPercent = selectedProduct.get_P_discount() * 100.0;
                                    String moneySaved = String.format("%.2f", selectedProduct.get_P_price() * selectedProduct.get_P_discount());
                                    System.out.println("\nOriginal Price: " + origPrice + "\nDiscount: " + discountPercent + "%" +
                                            "\nMoney Saved: " + moneySaved + "\nFinal Price: " + String.format("%.2f", selectedProduct.get_P_price()));
                                    System.out.println("\nWhat's your name?");
                                    System.out.print(">");
                                    String customerName = in.nextLine();
                                    System.out.println("\nWhat's your phone number?");
                                    System.out.print(">");
                                    String phone = in.nextLine();
                                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                                    String currentDate = formatter.format(LocalDateTime.now());
                                    int currentDay = Integer.parseInt(currentDate.substring(0, 2));
                                    int currentMonth = Integer.parseInt(currentDate.substring(3, 5));
                                    int currentYear = Integer.parseInt(currentDate.substring(6));
                                    Sale saleObj = new Sale(selectedProduct, customerName, phone, currentDate, selectedProduct.get_P_price());
                                    
                                    boolean validArrivalDate = false;
                                    String arrivalDate = "";
                                    while (!validArrivalDate) {
                                        System.out.println("\nWhat's the expected day of arrival?");
                                        System.out.print(">");
                                        String dayInput = in.nextLine();
                                        int expectedDay = 0;
                                        while (true) {
                                            try {
                                                expectedDay = Integer.parseInt(dayInput);
                                                if (expectedDay > 0 && expectedDay <= 30) {
                                                    break;
                                                } else {
                                                    System.out.println("\nPlease type a viable answer");
                                                    System.out.print(">");
                                                    dayInput = in.nextLine();
                                                }
                                            } catch (Exception e) {
                                                System.out.println("\nPlease type a viable answer");
                                                System.out.print(">");
                                                dayInput = in.nextLine();
                                            }
                                        }

                                        System.out.println("\nWhat's the expected month of arrival?");
                                        System.out.print(">");
                                        String monthInput = in.nextLine();
                                        int expectedMonth = 0;
                                        while (true) {
                                            try {
                                                expectedMonth = Integer.parseInt(monthInput);
                                                if (expectedMonth > 0 && expectedMonth <= 12) {
                                                    break;
                                                } else {
                                                    System.out.println("\nPlease type a viable answer");
                                                    System.out.print(">");
                                                    monthInput = in.nextLine();
                                                }
                                            } catch (Exception e) {
                                                System.out.println("\nPlease type a viable answer");
                                                System.out.print(">");
                                                monthInput = in.nextLine();
                                            }
                                        }

                                        System.out.println("\nWhat's the expected year of arrival?");
                                        System.out.print(">");
                                        String yearInput = in.nextLine();
                                        int expectedYear = 0;
                                        while (true) {
                                            try {
                                                expectedYear = Integer.parseInt(yearInput);
                                                if (expectedYear >= currentYear) {
                                                    break;
                                                } else {
                                                    System.out.println("\nPlease type a viable answer");
                                                    System.out.print(">");
                                                    yearInput = in.nextLine();
                                                }
                                            } catch (Exception e) {
                                                System.out.println("\nPlease type a viable answer");
                                                System.out.print(">");
                                                yearInput = in.nextLine();
                                            }
                                        }
                                        
                                        arrivalDate = String.format("%02d-%02d-%d", expectedDay, expectedMonth, expectedYear);
                                        
                                        // Validate that the arrival date is not in the past
                                        if (expectedYear > currentYear ||
                                            (expectedYear == currentYear && expectedMonth > currentMonth) ||
                                            (expectedYear == currentYear && expectedMonth == currentMonth && expectedDay >= currentDay)) {
                                            validArrivalDate = true;
                                        } else {
                                            System.out.println("\nThe date of arrival that you submitted is wrong!");
                                            System.out.println("\nPlease try again!");
                                        }
                                    }
                                    
                                    Order orderObj = new Order(saleObj, arrivalDate);
                                    orders.getOrders().add(orderObj);
                                    System.out.println("\nYour order has been placed");
                                }
                            }
                        }
                        break;
                    }
                }
                if (!found) {
                    System.out.println("\nThis product does not exist");
                }
            } else if (option.equals("2")) {
                // Option 2: Show all orders
                if (orders.getOrders().size() == 0) {
                    System.out.println("There are no orders!");
                } else {
                    // Update each order's status before displaying orders
                    for (int i = 0; i < orders.getOrders().size(); i++) {
                        ((Order) orders.getOrders().get(i)).updateStatusIfNeeded();
                    }
                    
                    for (int i = 0; i < orders.getOrders().size(); i++) {
                        System.out.println(i + ". " + ((Order) orders.getOrders().get(i)).getSale().get_product().get_P_Name());
                        System.out.println("Order's Number :" + ((Order) orders.getOrders().get(i)).getOrder_number());
                    }
                    System.out.println("\nWould you like to see a specific order?");
                    System.out.println("1. Yes");
                    System.out.println("2. No");
                    System.out.print(">");
                    String orderDetailOption;
                    for (orderDetailOption = in.nextLine(); 
                         !orderDetailOption.equals("1") && !orderDetailOption.equals("2"); 
                         orderDetailOption = in.nextLine()) {
                        System.out.println("\nPlease select one of the options above!");
                        System.out.print(">");
                    }
                    if (orderDetailOption.equals("1")) {
                        System.out.println("\nPlease type the number of the order you would like to see in detail!");
                        System.out.print(">");
                        String orderNumberStr = in.nextLine();
                        boolean orderFound = false;
                        for (int i = 0; i < orders.getOrders().size(); i++) {
                            if (orderNumberStr.equals(Integer.toString(((Order) orders.getOrders().get(i)).getOrder_number()))) {
                                orderFound = true;
                                System.out.println("\n" + orders.getOrders().get(i));
                                System.out.println("\n\nWould you like to change the status of the order?");
                                System.out.println("1. Yes");
                                System.out.println("2. No");
                                System.out.print(">");
                                String statusOption;
                                for (statusOption = in.nextLine(); 
                                     !statusOption.equals("1") && !statusOption.equals("2"); 
                                     statusOption = in.nextLine()) {
                                    System.out.println("\nPlease select one of the options above!");
                                    System.out.print(">");
                                }
                                if (statusOption.equals("1")) {
                                    ((Order) orders.getOrders().get(i)).changeStatus();
                                    sales.getSales().add(((Order) orders.getOrders().get(i)).getSale());
                                }
                                break;
                            }
                        }
                        if (!orderFound) {
                            System.out.println("The order number you typed does not exist");
                        }
                    }
                    
                    // Ask to write orders file only if there are orders
                    System.out.println("Do you wish to write the orders on a new txt file?");
                    System.out.println("1. Yes\n2. No");
                    System.out.print(">");
                    String writeOrderOption;
                    for (writeOrderOption = in.nextLine(); 
                         !writeOrderOption.equals("1") && !writeOrderOption.equals("2"); 
                         writeOrderOption = in.nextLine()) {
                        System.out.println("Please select one of the options above");
                        System.out.print(">");
                    }
                    if (writeOrderOption.equals("1")) {
                        orders.CreateFile();
                    }
                }
            } else if (option.equals("3")) {
                // Option 3: Show all sales
                if (sales.getSales().size() == 0) {
                    System.out.println("There are no sales!");
                } else {
                    for (int i = 0; i < sales.getSales().size(); i++) {
                        System.out.println(sales.getSales().get(i));
                    }
                    // Ask to write sales file only if there are sales
                    System.out.println("Do you wish to write the sales on a new txt file?");
                    System.out.println("1. Yes\n2. No");
                    System.out.print(">");
                    String writeSalesOption;
                    for (writeSalesOption = in.nextLine(); 
                         !writeSalesOption.equals("1") && !writeSalesOption.equals("2"); 
                         writeSalesOption = in.nextLine()) {
                        System.out.println("Please select one of the options above");
                        System.out.print(">");
                    }
                    if (writeSalesOption.equals("1")) {
                        sales.CreateFile();
                    }
                }
            } else if (option.equals("0")) {
                orders.CreateFile();
                sales.CreateFile();
                supplies.CreateFile();
                exit = true;
            }
        }
    }
}
