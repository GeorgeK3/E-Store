class Mouse extends Peripheral {
    private String tech;
    private String connection;


    Mouse(String modelName, int modelYear, String modelBrand, double modelPrice,int quantity) {
        super(modelName, modelYear, modelBrand, modelPrice, quantity);
    }


    Mouse(String modelName, int modelYear, String modelBrand, double modelPrice,int quantity, String tech, String connection) {
        super(modelName, modelYear, modelBrand, modelPrice, quantity);

        if (tech.equalsIgnoreCase("Laser")) {
            this.tech = "Laser";
        } else if (tech.equalsIgnoreCase("Optical")) {
            this.tech = "Optical";
        } else {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("These technology is not supported");
            }
        } // Technology

        if (connection.equalsIgnoreCase("Wired")) {
            this.connection = "Wired";
        } else if (connection.equalsIgnoreCase("Wireless")) {
            this.connection = "Wireless";
        } else {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("Wrong connection type");
            }
        } // Connection

    }// Constructor

    // Set Methods
    public void set_M_tech(String tech) {
        if (tech.equalsIgnoreCase("Laser")) {
            this.tech = "Laser";
        } else if (tech.equalsIgnoreCase("Optical")) {
            this.tech = "Optical";
        } else {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("These technology is not supported");
            }
        }
    }

    public void set_M_connection(String connection) {
        if (connection.equalsIgnoreCase("Wired")) {
            this.connection = "Wired";
        } else if (connection.equalsIgnoreCase("Wireless")) {
            this.connection = "Wireless";
        } else {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("Wrong connection type");
            }
        }
    }

    // Get Methods
    public String get_M_tech() {
        return this.tech;
    }

    public String get_M_connection() {
        return this.connection;
    }

    // toString
    public String toString() {
        return super.toString() + "\nType: Mouse " + "\nSpecifications :" + "\nTechnology :\t" + tech
                + "\nConnectivity :\t" + connection + "\n";
    }
}// Mouse