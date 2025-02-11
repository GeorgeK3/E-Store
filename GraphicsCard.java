class GraphicsCard extends Hardware {
    private String chipset;
    private int memory;

    GraphicsCard(String modelName, int modelYear, String modelBrand, double modelPrice, int quantity) {
        super(modelName, modelYear, modelBrand, modelPrice, quantity);
    }
    GraphicsCard(String modelName, int modelYear, String modelBrand, double modelPrice, int quantity, String chip, int mem) {
        super(modelName, modelYear, modelBrand, modelPrice, quantity);
        if (chip.equalsIgnoreCase("nVidia") || chip.equalsIgnoreCase("AMD")) {
            this.chipset = chip;
        } else {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("Invalid chipset type");
            }
        }

        if (mem == 6 || mem == 8 || mem == 16) {
            this.memory = mem;
        } else {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("Invalid amount of memory");
            }
        }
    }

    public void setChipset(String chip) {
        if (chip.equalsIgnoreCase("nVidia") || chip.equalsIgnoreCase("AMD")) {
            this.chipset = chip;
        } else {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("Invalid chipset type.");
            }
        }
    }

    public void setMemory(int mem) {
        if (mem == 6 || mem == 8 || mem == 16) {
            this.memory = mem;
        } else {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("Invalid amount of memory");
            }
        }
    }

    public String getChipType() {
        return chipset;
    }

    public int getMemory() {
        return memory;
    }

    public String toString() {
        return super.toString() + "\nType: Graphics Card  " + "\nSpecifications :" + "\nType of chipset :\t" + chipset
                + "\nGBs of video memory :\t" + memory + "\n";
    }
}