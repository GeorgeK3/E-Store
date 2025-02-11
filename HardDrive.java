class HardDrive extends Hardware {
    private String type;
    private double size;
    private int capacity;

    HardDrive(String modelName, int modelYear, String modelBrand, double modelPrice, int quantity) {
        super(modelName, modelYear, modelBrand, modelPrice,quantity);
    }

    HardDrive(String modelName, int modelYear, String modelBrand, double modelPrice, int quantity, String t, double s, int cap) {
        super(modelName, modelYear, modelBrand, modelPrice,quantity);
        if (t.equalsIgnoreCase("HDD") || t.equalsIgnoreCase("SSD")) {
            this.type = t;
        } else {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("Invalid type of storage");
            }
        }
        if (s == 1.8 || s == 2.5 || s == 3.5) {
            this.size = s;
        } else {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("Invalid size of harddrive");
            }
        }
        if (cap == 256 || cap == 512 || cap == 1024 || cap == 2048) {
            this.capacity = cap;
        } else {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("Invalid amount of storage");
            }
        }
    }

    public void setType(String type) {
        if (type.equalsIgnoreCase("HDD") || type.equalsIgnoreCase("SSD")) {
            this.type = type;
        } else {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("Invalid type of storage");
            }
        }
    }

    public void setSize(double size) {
        if (size == 1.8 || size == 2.5 || size == 3.5) {
            this.size = size;
        } else {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("Invalid size of harddrive");
            }
        }
    }

    public void setCapacity(int capacity) {
        if (capacity == 256 || capacity == 512 || capacity == 1024 || capacity == 2048) {
            this.capacity = capacity;
        } else {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("Invalid amount of storage");
            }
        }
    }

    public String getHarddriveType() {
        return type;
    }

    public double getHarddriveSize() {
        return size;
    }

    public int getHarddriveCapacity() {
        return capacity;
    }

    public String toString() {
        return super.toString() + "\nType: Hard Drive " +"\nSpecifications :" + "\nSSD or HDD :\t" + type + "\nSize :\t" + size
                + "\nCapacity:\t " + capacity + "\n";
    }
}