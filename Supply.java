import java.util.*;
import java.io.*;

public class Supply {

    private ArrayList<Product> supplies;
    private String FileName;
    BufferedReader reader = null;
    String line;
    Product product = null;
    String type;
    String modelName;
    double price;
    int year = 2020;
    String manuf = "Unknown";
    int quantity = 0;

    public Supply(String FileName) {
        this.FileName = FileName;
        this.supplies = new ArrayList<Product>();
        this.createSupplies();
    }

    public void createSupplies() {
        System.out.println("\n >>>>>>> Adding Objects (Products) from " + FileName + " to Supply List ...");
        try {
            reader = new BufferedReader(new FileReader(new File(FileName)));
            line = reader.readLine();
            while (line != null){
                if (line.trim().equals("ITEM")) {
                    line = reader.readLine();
                    if (line.trim().equals("{")){
                        reader.mark(10000);
                        type = null;
                        modelName = null;
                        price = -1;
                        boolean finished = false;
                        while (!finished){
                            boolean done=false;
                            while (!done){
                                line = reader.readLine();
                                if (line.trim().startsWith("ITEM_TYPE ")){
                                    type = line.trim().substring(10).trim();
                                }
                                if (line.trim().startsWith("MODEL ")){
                                    modelName = line.trim().substring(6).trim();
                                }
                                if (line.trim().startsWith("PRICE ")){
                                    price = Double.parseDouble(line.trim().substring(6).trim());
                                }
                                if (line.trim().startsWith("MODEL_YEAR ")){
                                    year = Integer.parseInt(line.trim().substring(11).trim());
                                }
                                if (line.trim().startsWith("MANUFACTURER ")){
                                    manuf = line.trim().substring(13).trim();
                                }
                                if (line.trim().startsWith("PIECES ")){
                                    quantity = Integer.parseInt(line.trim().substring(7).trim());
                                }
                                if (line.trim().equals("}")){
                                    if (type==null || modelName==null || price == -1){
                                        System.out.println("There was an error trying to read one Product");
                                        finished = true;
                                    }else{
                                        reader.reset();
                                    }
                                    done = true;
                                }
                            }
                            if (!finished){
                                boolean searching;
                                if (type.equalsIgnoreCase("GraphicsCard")){
                                    product = new GraphicsCard(modelName, year, manuf, price, quantity);
                                    String chip = "nvidia";
                                    int mem = 8;
                                    searching = true;
                                    while (searching){
                                        if (line.trim().startsWith("CHIPSET_TYPE ")){
                                            chip = line.trim().substring(13).trim();
                                        }
                                        if (line.trim().startsWith("MEMORY ")){
                                            mem = Integer.parseInt(line.trim().substring(7).trim());
                                        }
                                        if (line.trim().equals("}")){
                                            try{
                                                ((GraphicsCard) product).setChipset(chip);
                                                ((GraphicsCard) product).setMemory(mem);
                                                supplies.add(product);
                                            }
                                            catch (Exception e){
                                                System.err.println("The chipset or the memory capacity of the Graphics Card is invalid");
                                            }
                                            searching = false;
                                            finished = true;
                                        }
                                        line = reader.readLine();
                                    }  
                                }//GraphicsCard

                                if (type.equalsIgnoreCase("HardDrive")){
                                    product = new HardDrive(modelName, year, manuf, price, quantity);
                                    String hd_type = "SSD";
                                    double size = 2.5;
                                    int capacity = 1024;
                                    searching = true;
                                    while (searching){
                                        if (line.trim().startsWith("HD_TYPE ")){
                                            hd_type = line.trim().substring(8).trim();
                                        }
                                        if (line.trim().startsWith("HD_SIZE ")){
                                            size = Double.parseDouble(line.trim().substring(8).trim());
                                        }
                                        if (line.trim().startsWith("HD_CAPACITY ")){
                                            capacity = Integer.parseInt(line.trim().substring(12).trim());
                                        }
                                        if (line.trim().equals("}")){
                                            try{
                                                ((HardDrive) product).setType(hd_type);
                                                ((HardDrive) product).setSize(size);
                                                ((HardDrive) product).setCapacity(capacity);
                                                supplies.add(product);
                                            }
                                            catch (Exception e){
                                                System.err.println("The type,size or capacity of the Hard Drive is invalid");
                                            }
                                            searching = false;
                                            finished = true;
                                        }
                                        line = reader.readLine();
                                    }  
                                }//HardDrive

                                if (type.equalsIgnoreCase("Keyboard")){
                                    product = new Keyboard(modelName, year, manuf, price, quantity);
                                    String connection = "Wired";
                                    searching = true;
                                    while (searching){
                                        if (line.trim().startsWith("CONNECTION ")){
                                            connection = line.trim().substring(11).trim();
                                        }
                                        if (line.trim().equals("}")){
                                            searching = false;
                                            finished = true;
                                            try{
                                                ((Keyboard) product).set_K_connection(connection);
                                                supplies.add(product);
                                            }
                                            catch (Exception e){
                                                System.err.println("The connection of the Keyboard is invalid");
                                            }
                                        }
                                        line = reader.readLine();
                                    } 
                                }//Keyboard

                                if (type.equalsIgnoreCase("Motherboard")){
                                    product = new Motherboard(modelName, year, manuf, price, quantity);
                                    String cpuBrand = "Intel";
                                    int storage = 64;
                                    int sataType = 6;
                                    searching = true;
                                    while (searching){
                                        if (line.trim().startsWith("CPU_BRAND ")){
                                            cpuBrand = line.trim().substring(10).trim();
                                        }
                                        if (line.trim().startsWith("STORAGE ")){
                                            storage = Integer.parseInt(line.trim().substring(8).trim());
                                        }
                                        if (line.trim().startsWith("SATA_TYPE ")){
                                            sataType = Integer.parseInt(line.trim().substring(10).trim());
                                        }
                                        if (line.trim().equals("}")){
                                            searching = false;
                                            finished = true;
                                            try{
                                                ((Motherboard) product).setCpu(cpuBrand);
                                                ((Motherboard) product).setStorage(storage);;
                                                ((Motherboard) product).setSata(sataType);
                                                supplies.add(product);
                                            }
                                            catch (Exception e){
                                                System.err.println("The CPU Socket ,Storage Capacity or SATA type of the Motherboard is invalid");
                                            }
                                        }
                                        line = reader.readLine();
                                    }
                                }//Motherboard

                                if (type.equalsIgnoreCase("Mouse")){
                                    product = new Mouse(modelName, year, manuf, price, quantity);
                                    String tech = "Laser";
                                    String connection = "Wireless";
                                    searching = true;
                                    while (searching){
                                        if (line.trim().startsWith("MOUSE_TECH ")){
                                            tech = line.trim().substring(11).trim();
                                        }
                                        if (line.trim().startsWith("MOUSE_CONNECTION ")){
                                            connection = line.trim().substring(17).trim();
                                        }
                                        if (line.trim().equals("}")){
                                            searching = false;
                                            finished = true;
                                            try{
                                                ((Mouse) product).set_M_tech(tech);
                                                ((Mouse) product).set_M_connection(connection);
                                                supplies.add(product);
                                            }
                                            catch (Exception e){
                                                System.err.println("Invalid tech or connection");
                                            }
                                        }
                                    }
                                    line = reader.readLine();
                                }//Mouse

                                if (type.equalsIgnoreCase("Printer")){
                                    product = new Printer(modelName, year, manuf, price, quantity);
                                    String tech = "Inkjet";
                                    String print_type = "Colored";
                                    searching = true;
                                    while (searching){
                                        if (line.trim().startsWith("PRINTER_TECH ")){
                                            tech = line.trim().substring(13).trim();
                                        }
                                        if (line.trim().startsWith("PRINT_TYPE ")){
                                            print_type = line.trim().substring(11).trim();
                                        }
                                        if (line.trim().equals("}")){
                                            searching = false;
                                            finished = true;
                                            try{
                                                ((Printer) product).set_P_tech(tech);
                                                ((Printer) product).set_P_type(print_type);
                                                supplies.add(product);
                                            }
                                            catch (Exception e){
                                                System.err.println("Invalid tech or type");
                                            }
                                        }
                                    }
                                    line = reader.readLine();
                                }//Printer

                                if (type.equalsIgnoreCase("Processor")){
                                    product = new Processor(modelName, year, manuf, price, quantity);
                                    double clockSpeed = 3.3;
                                    int coreCount = 6;
                                    boolean graphics = true;
                                    searching = true;
                                    while (searching){
                                        if (line.trim().startsWith("CLOCK_SPEED ")){
                                            clockSpeed = Double.parseDouble(line.trim().substring(12).trim());
                                        }
                                        if (line.trim().startsWith("RAM_CAPACITY ")){
                                            coreCount = Integer.parseInt(line.trim().substring(13).trim());
                                        }
                                        if (line.trim().startsWith("GRAPHICS ")){
                                            graphics = Boolean.parseBoolean(line.trim().substring(9).trim());
                                        }
                                        if (line.trim().equals("}")){
                                            searching = false;
                                            finished = true;
                                            try{
                                                ((Processor) product).setClockSpeed(clockSpeed);
                                                ((Processor) product).setCoreCount(coreCount);
                                                ((Processor) product).setGraphics(graphics);
                                                supplies.add(product);
                                            }
                                            catch (Exception e){
                                                System.err.println("Invalid Clock Speed,Core Count or Graphics");
                                            }
                                        }
                                        line = reader.readLine();
                                    }
                                }//Processor

                                if (type.equalsIgnoreCase("RamMemory")){
                                    product = new RamMemory(modelName, year, manuf, price, quantity);
                                    String type = "DDR5";
                                    int ramCapacity = 16;
                                    int frequency = 3200;
                                    searching = true;
                                    while (searching){
                                        if (line.trim().startsWith("RAM_TYPE ")){
                                            type = line.trim().substring(9).trim();
                                        }
                                        if (line.trim().startsWith("RAM_CAPACITY ")){
                                            ramCapacity = Integer.parseInt(line.trim().substring(13).trim());
                                        }
                                        if (line.trim().startsWith("FREQUENCY ")){
                                            frequency = Integer.parseInt(line.trim().substring(10).trim());
                                        }
                                        if (line.trim().equals("}")){
                                            searching = false;
                                            finished = true;
                                            try{
                                                ((RamMemory) product).setRamType(type);
                                                ((RamMemory) product).setRamCapacity(ramCapacity);
                                                ((RamMemory) product).setRamFrequency(frequency);
                                                supplies.add(product);
                                            }
                                            catch (Exception e){
                                                System.err.println("Invalid Type, Capacity or Frequency");
                                            }
                                        }
                                        line = reader.readLine();
                                    }
                                }//RamMemory
                                
                                if (type.equalsIgnoreCase("Screen")){
                                    product = new Screen(modelName, year, manuf, price, quantity);
                                    String Mtype =  "Monitor" ;
                                    double inches = 32;
                                    String resolution = "1920 x 1080";
                                    String port = "Display Port" ;
                                    searching = true;
                                    while (searching){
                                        if (line.trim().startsWith("SCREEN_TYPE ")){
                                            Mtype = line.trim().substring(12).trim();
                                        }
                                        if (line.trim().startsWith("INCHES ")){
                                            inches = Double.parseDouble(line.trim().substring(7).trim());
                                        }
                                        if (line.trim().startsWith("RESOLUTION ")){
                                            resolution = line.trim().substring(11).trim();
                                        }
                                        if (line.trim().startsWith("PORT_TYPE ")){
                                            port = line.trim().substring(10).trim();
                                        }
                                        if (line.trim().equals("}")){
                                            searching = false;
                                            finished = true;
                                            try{
                                                ((Screen) product).set_M_type(Mtype);
                                                ((Screen) product).set_M_inches(inches);
                                                ((Screen) product).set_M_resolution(resolution);
                                                ((Screen) product).set_M_port(port);
                                                supplies.add(product);
                                            }
                                            catch (Exception e){
                                                System.err.println("Invalid Type ,Size ,Resolution or Ports");
                                            }
                                        }
                                        line = reader.readLine();
                                    }
                                }//Screen
                            }    
                        }//finished
                        line = reader.readLine();
                    }//Product Constructor
                }//Product
                line = reader.readLine();
            }//while
            reader.close();
        }//try
        catch(IOException e){
                System.err.println("Error reading File");
        }
    }

    public ArrayList<Product> getProducts() {
        return this.supplies;
    }

    public void CreateFile () {
            
        System.out.println(" >>>>>>> Write data from ARRAYLIST to FILE...");
            
        FileWriter writer = null;
    
        try	{
            writer = new FileWriter(new File(FileName));
            writer.write ("ITEM_LIST\n{\n");
            for (Product product:supplies) {
                writer.write("\n ITEM"
                            +"\n {"
                            +"\n   ITEM_TYPE "+product.getClass().getName()
                            +"\n   MODEL " + product.get_P_Name()
                            +"\n   MODEL_YEAR " + product.get_P_year()
                            +"\n   MANUFACTURER " + product.get_P_brand()
                            +"\n   PRICE " + product.get_P_price()
                            +"\n   PIECES " + product.get_P_quantity());
                if (product instanceof GraphicsCard) {
                    writer.write ("\n   CHIPSET_TYPE " + ((GraphicsCard) product).getChipType()
                                 +"\n   MEMORY " + ((GraphicsCard) product).getMemory());
                }//GraphicsCard
                else if (product instanceof HardDrive) {
                    writer.write ("\n   HD_TYPE " + ((HardDrive) product).getHarddriveType()
                                 +"\n   HD_SIZE " + ((HardDrive) product).getHarddriveSize()
                                 +"\n   HD_CAPACITY " + ((HardDrive) product).getHarddriveCapacity());
                }//HardDrive
                else if (product instanceof Keyboard) {
                    writer.write("\n   CONNECTION " + ((Keyboard) product).get_K_connection());
                }//Keyboard
                else if (product instanceof Motherboard) {
                    writer.write("\n   CPU_BRAND " + ((Motherboard) product).getCpuBrand()
                                +"\n   STORAGE " + ((Motherboard) product).getStorage()
                                +"\n   SATA_TYPE " + ((Motherboard) product).getSataType());
                }//Motherboard
                else if (product instanceof Mouse) {
                    writer.write("\n   MOUSE_TECH " + ((Mouse) product).get_M_tech()
                                +"\n   MOUSE_CONNECTION " + ((Mouse) product).get_M_connection());
                }//Mouse
                else if (product instanceof Printer) {
                    writer.write("\n   PRINTER_TECH " + ((Printer) product).getPrinterteck()
                                +"\n   PRINT_TYPE " + ((Printer) product).getPrintertype());
                }//Printer
                else if (product instanceof Processor) {
                    writer.write("\n   CLOCK_SPEED " + ((Processor) product).getClockSpeed()
                                +"\n   RAM_CAPACITY " + ((Processor) product).getCoreCount()
                                +"\n   GRAPHICS " + ((Processor) product).getGraphics());
                }//Processor
                else if (product instanceof RamMemory) {
                    writer.write("\n   RAM_TYPE " + ((RamMemory) product).getRamType()
                                +"\n   RAM_CAPACITY " + ((RamMemory) product).getRamCapacity()
                                +"\n   FREQUENCY " + ((RamMemory) product).getFrequency());
                }//RamMemory
                else if (product instanceof Screen) {
                    writer.write("\n   SCREEN_TYPE " + ((Screen) product).get_M_type()
                                +"\n   INCHES " + ((Screen) product).get_M_inches()
                                +"\n   RESOLUTION " + ((Screen) product).get_M_resolution()
                                +"\n   PORT_TYPE " + ((Screen) product).get_M_port());
                }//Screen
                writer.write("\n  }");
            }
            writer.write("\n}");
            writer.close();
                    
        }//try
        catch (IOException e) {
            System.err.println("Error writing file.");
        }
    }

    public Product findProduct(String category, String type, String name) {
        for (Product product : this.supplies) {
            if (category.equals("Hardware") && product instanceof Hardware) {
                if (product.getClass().getName().equals(type) && product.get_P_Name().equals(name)) {
                    return product;
                }
            } else {
                if (product.getClass().getName().equals(type) && product.get_P_Name().equals(name)) {
                    return product;
                }
            }
        }

        return null;
    }

    public Product searchProducts(String category, String type) {
        for (Product product : this.supplies) {
            if (category.equals("Hardware") && product instanceof Hardware) {
                if (product.getClass().getName().equals(type)) {
                    System.out.println(product);
                }
            } else {
                if (product.getClass().getName().equals(type)) {
                    System.out.println(product);
                }
            }
        }

        return null;
    }

    public Product searchCategory(String category) {
        for (Product product : this.supplies) {
            if (category.equals("Hardware") && product instanceof Hardware) {
                System.out.println(product);
            } else {
                System.out.println(product);
            }
        }

        return null;
    }

    public void Discount(String category, double discount) {
        for (Product product : this.supplies) {
            if (category.equals("Hardware") && product instanceof Hardware) {
                product.set_P_discount(discount);
                product.set_P_price(product.get_P_price() - product.get_P_price() * product.get_P_discount());
            } else {
                product.set_P_discount(discount);
                product.set_P_price(product.get_P_price() - product.get_P_price() * product.get_P_discount());
            }
        }
    }

}
