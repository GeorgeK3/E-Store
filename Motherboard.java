class Motherboard extends Hardware {
    private String cpuBrand;
    private int storage;
    private int sataType;

    Motherboard(String modelName, int modelYear, String modelBrand, double modelPrice,int quantity) {
        super(modelName, modelYear, modelBrand, modelPrice, quantity);
    }

    Motherboard(String modelName, int modelYear, String modelBrand, double modelPrice,int quantity, String cpu, int strg, int sata) {
        super(modelName, modelYear, modelBrand, modelPrice, quantity);
        if (cpu.equalsIgnoreCase("Intel") || cpu.equalsIgnoreCase("AMD")) {
            this.cpuBrand = cpu;
        } else {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("Invalid CPU brand");
            }
        }

        if (strg == 32 || strg == 64 || strg == 128) {
            this.storage = strg;
        } else {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("Invalid amount of storage");
            }
        }

        if (sata == 4 || sata == 6 || sata == 8) {
            this.sataType = sata;
        } else {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("Invalid SATA type");
            }
        }

    }

    public void setCpu(String cpu) {
        if (cpu.equalsIgnoreCase("Intel") || cpu.equalsIgnoreCase("AMD")) {
            this.cpuBrand = cpu;
        } else {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("Invalid CPU brand");
            }
        }
    }

    public void setStorage(int strg) {
        if (strg == 32 || strg == 64 || strg == 128) {
            this.storage = strg;
        } else {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("Invalid amount of storage");
            }
        }
    }

    public void setSata(int sata) {
        if (sata == 4 || sata == 6 || sata == 8) {
            this.sataType = sata;
        } else {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("Invalid SATA type");
            }
        }
    }

    public String getCpuBrand() {
        return cpuBrand;
    }

    public int getStorage() {
        return storage;
    }

    public int getSataType() {
        return sataType;
    }

    public String toString() {
        return super.toString() + "\nType: Motherboard " + "Specifications : "+ "\nCPU brand :\t" + cpuBrand + "\nStotage :\t"
                + storage + "\"" + "\nSata type :\t" + sataType + "\n";
    }
}