class RamMemory extends Hardware {
    private String type;
    private int ramCapacity;
    private int frequency;


    RamMemory(String modelName, int modelYear, String modelBrand, double modelPrice,int quantity) {
        super(modelName, modelYear, modelBrand, modelPrice,quantity);
    }


    RamMemory(String modelName, int modelYear, String modelBrand, double modelPrice,int quantity, String t, int cap, int freq) {
        super(modelName, modelYear, modelBrand, modelPrice,quantity);
        if (t.equalsIgnoreCase("DDR3") || t.equalsIgnoreCase("DDR4") || t.equalsIgnoreCase("DDR5")) {
            this.type = t;
        } else {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("Invalid type of RAM");
            }
        }
        if (cap == 4 || cap == 8 || cap == 16) {
            this.ramCapacity = cap;
        } else {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("Invalid amount of RAM");
            }
        }
        if (freq == 1600 || freq == 2666 || freq == 3200) {
            this.frequency = freq;
        } else {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("Invalid RAM frequency");
            }
        }
    }

    public void setRamType(String type) {
        if (type.equalsIgnoreCase("DDR3") || type.equalsIgnoreCase("DDR4") || type.equalsIgnoreCase("DDR5")) {
            this.type = type;
        } else {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("Invalid type of RAM");
            }
        }
    }

    public void setRamCapacity(int ramCapacity) {
        if (ramCapacity == 4 || ramCapacity == 8 || ramCapacity == 16) {
            this.ramCapacity = ramCapacity;
        } else {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("Invalid amount of RAM");
            }
        }
    }

    public void setRamFrequency(int frequency) {
        if (frequency == 1600 || frequency == 2666 || frequency == 3200) {
            this.frequency = frequency;
        } else {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("Invalid RAM frequency");
            }
        }
    }

    public String getRamType() {
        return type;
    }

    public int getRamCapacity() {
        return ramCapacity;
    }

    public int getFrequency() {
        return frequency;
    }

    public String toString() {
        return super.toString() + "\nType: Ram Memory " + "Specifications :" + " " + "\nRAM Type :\t" + type + "\nGBs of RAM :\t"
                + ramCapacity + "\"" + "\nRAM frequency :\t" + frequency + "\n";
    }
}