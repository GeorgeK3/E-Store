class Keyboard extends Peripheral {
    private String connection;

    Keyboard(String modelName, int modelYear, String modelBrand, double modelPrice, int quantity) {
        super(modelName, modelYear, modelBrand, modelPrice,quantity );
    }

    Keyboard(String modelName, int modelYear, String modelBrand, double modelPrice, int quantity, String connection) {

        super(modelName, modelYear, modelBrand, modelPrice,quantity );

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
    public void set_K_connection(String connection) {
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
    public String get_K_connection() {
        return this.connection;
    }

    // toString
    public String toString() {
        return super.toString() + "\nType: Keyboard " + "\nSpecifications :" + "\nKeyboard's connectivity :\t"
                + connection + "\n";
    }
}// Keyboard