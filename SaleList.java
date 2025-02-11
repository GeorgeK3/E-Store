import java.util.*;
import java.io.*;

public class SaleList {
    private ArrayList<Sale> sales;
    private String FileName;
    BufferedReader reader = null;
    String line;
    int sale_num;
    String item_type;
    String model;
    String name;
    String phone;
    String sale_date;
    Sale sale;
    Supply supplies;

    public SaleList(String FileName) {
        this.supplies = new Supply("products.txt");
        this.FileName = FileName;
        this.sales = new ArrayList<Sale>();
        this.createSaleList();
    }

    public void createSaleList() {
        System.out.println("\n >>>>>>> Adding Objects (Sales) from " + FileName + " to Sale List ...");
        try {
            reader = new BufferedReader(new FileReader(new File(FileName)));
            line = reader.readLine();
            while (line != null) {
                if (line.trim().equals("SALE")) {
                    line = reader.readLine();
                    if (line.trim().equals("{")) {
                        boolean searching = true;
                        boolean error = false;
                        sale_num = -1;
                        item_type = null;
                        model = null;
                        name = null;
                        phone = null;
                        sale_date = null;
                        while (searching) {
                            if (line.trim().startsWith("NUMBER ")) {
                                sale_num = Integer.parseInt(line.trim().substring(7).trim());
                            }
                            if (line.trim().startsWith("ITEM_TYPE ")) {
                                item_type = line.trim().substring(10).trim();
                            }
                            if (line.trim().startsWith("MODEL ")) {
                                model = line.trim().substring(6).trim();
                            }
                            if (line.trim().startsWith("NAME ")) {
                                name = line.trim().substring(5).trim();
                            }
                            if (line.trim().startsWith("PHONE ")) {
                                phone = line.trim().substring(6).trim();
                            }
                            if (line.trim().startsWith("SALE_DATE ")) {
                                sale_date = line.trim().substring(10).trim();
                            }
                            if (line.trim().equals("}")) {
                                searching = false;
                                if (sale_num == -1 || item_type == null || model == null || name == null || phone == null || sale_date == null) {
                                    error = true;
                                }
                            }
                            line = reader.readLine();
                        }
                        if (!error) {
                            Product p=null;
                            for (Product product : supplies.getProducts()){
                                if (product.get_P_Name().contains(model) && product.getClass().getName().contains(item_type)){
                                    p = product;
                                }
                            }
                            if (p!=null){
                            sale = new Sale(p, name, phone, sale_date, p.get_P_price());
                            sale.set_SalesNumber1(sale_num);
                            sales.add(sale);
                            } else {
                            System.out.println("There was an error with one of the sales");
                            }
                        }

                    }

                }
                line = reader.readLine();
            } // while
        } // try
        catch (Exception e) {
            System.err.println("Error reading File");
        }

    }

    public void CreateFile() {

        System.out.println(" >>>>>>> Write data from ARRAYLIST to FILE...");

        FileWriter writer = null;

        try {
            writer = new FileWriter(new File("sales.txt"));
            writer.write("SALE_LIST\n{\n");
            for (Sale x : sales) {
                writer.write("\n SALE"
                        + "\n {"
                        + "\n  NUMBER " + x.get_SalesNumber()
                        + "\n  ITEM_TYPE " + x.get_product().getClass().getName()
                        + "\n  MODEL " + x.get_product().get_P_Name()
                        + "\n  NAME " + x.get_Name()
                        + "\n  PHONE " + x.get_Phone()
                        + "\n  SALE_DATE " + x.get_Date()
                        + "\n }");
            }
            writer.write("\n}");
            writer.close();
        } catch (Exception e) {
            System.err.println("Error writing file.");
        }
    }

    public ArrayList<Sale> getSales(){
        return this.sales;
    }
}