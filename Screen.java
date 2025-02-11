class Screen extends Peripheral {
    private String type;
    private double inches;
    private String resolution;
    private String port;


    public Screen(String modelName, int modelYear, String modelBrand, double modelPrice,int quantity) {

        super(modelName, modelYear, modelBrand, modelPrice, quantity);
    }


    public Screen(String modelName, int modelYear, String modelBrand, double modelPrice,int quantity, String type, double inches,
            String resolution, String port) {

        super(modelName, modelYear, modelBrand, modelPrice, quantity);

        if (type.equalsIgnoreCase("Monitor")) {
            this.type = "Monitor";
        } else if (type.equalsIgnoreCase("Portable Monitor")) {
            this.type = "Portable Monitor";
        } else if (type.equalsIgnoreCase("TV Monitor")) {
            this.type = "TV Monitor";
        } else {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("These type of Screen does not exist");
            }
        } // Type

        this.inches = inches;
        this.resolution = resolution;

        if (port.equalsIgnoreCase("Display Port")) {
            this.port = "Display Port";
        } else if (port.equalsIgnoreCase("HDMI")) {
            this.port = "HDMI";
        } else if (port.equalsIgnoreCase("USB-C")) {
            this.port = "USB-C";
        } else {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("This port is not supported");
            }
        } // Port

    }// Constructor

    // Set Methods
    public void set_M_type(String type) {
        if (type.equalsIgnoreCase("Monitor")) {
            this.type = "Monitor";
        } else if (type.equalsIgnoreCase("Portable Monitor")) {
            this.type = "Portable Monitor";
        } else if (type.equalsIgnoreCase("TV Monitor")) {
            this.type = "TV Monitor";
        } else {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("These type of Screen does not exist");
            }
        }
    }

    public void set_M_inches(double inches) {
        this.inches = inches;
    }

    public void set_M_resolution(String resolution) {
        this.resolution = resolution;
    }

    public void set_M_port(String port) {
        if (type.equalsIgnoreCase("Monitor")) {
            this.type = "Monitor";
        } else if (type.equalsIgnoreCase("Portable Monitor")) {
            this.type = "Portable Monitor";
        } else if (type.equalsIgnoreCase("TV Monitor")) {
            this.type = "TV Monitor";
        } else {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("These type of Screen does not exist");
            }
        }
    }

    // Get Methods
    public String get_M_type() {
        return this.type;
    }

    public double get_M_inches() {
        return this.inches;
    }

    public String get_M_resolution() {
        return this.resolution;
    }

    public String get_M_port() {
        return this.port;
    }

    // toString
    public String toString() {
        return super.toString() + "\nType: Screen " + "\nSpecifications :" + "\nType :\t" + type
                + "\nDimensions :\t" + inches + "\"" + "\nResolution :\t" + resolution + " pixels" + "\nPorts :\t"
                + port + "\n";
    }

}// Screen
