class Printer extends Peripheral {
    private String tech;
    private String print_type;


    Printer(String modelName, int modelYear, String modelBrand, double modelPrice, int quantity) {

        super(modelName, modelYear, modelBrand, modelPrice, quantity);
    }

    
    Printer(String modelName, int modelYear, String modelBrand, double modelPrice, int quantity, String tech, String print_type) {

        super(modelName, modelYear, modelBrand, modelPrice, quantity);

        if (tech.equalsIgnoreCase("Laser")) {
            this.tech = "Laser";
        } else if (tech.equalsIgnoreCase("Inkjet")) {
            this.tech = "Inkjet";
        } else {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("These technology is not supported");
            }
        } // Technology

        if (print_type.equalsIgnoreCase("Colored")) {
            this.print_type = "Colored";
        } else if (print_type.equalsIgnoreCase("Black And White") || print_type.equalsIgnoreCase("Monochrome")) {
            this.print_type = "Black And White / Monochrome";
        } else {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("These printing technology is not supported");
            }
        } // Printing Type

    }// Constructor

    // Set Methods
    public void set_P_tech(String tech) {
        if (tech.equalsIgnoreCase("Laser")) {
            this.tech = "Laser";
        } else if (tech.equalsIgnoreCase("Inkjet")) {
            this.tech = "Inkjet";
        } else {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("These technology is not supported");
            }
        }
    }

    public void set_P_type(String print_type) {
        if (print_type.equalsIgnoreCase("Colored")) {
            this.print_type = "Colored";
        } else if (print_type.equalsIgnoreCase("Black And White") || print_type.equalsIgnoreCase("Monochrome")) {
            this.print_type = "Black And White / Monochrome";
        } else {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("These printing technology is not supported");
            }
        }
    }

    // Get Methods
    public String getPrinterteck() {
        return this.tech;
    }

    public String getPrintertype() {
        return this.print_type;
    }

    // toString
    public String toString() {
        return super.toString() + "\nType: Printer " + "\nDetails :" + "\nPrinting Technology :\t" + tech + "\nPrinting Type :\t"
                + print_type + "\n";
    }
}// Printer