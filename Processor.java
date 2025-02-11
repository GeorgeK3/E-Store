class Processor extends Hardware {
    private double clockSpeed;
    private int coreCount;
    private boolean graphics;

    Processor(String modelName, int modelYear, String modelBrand, double modelPrice,int quantity) {
        super(modelName, modelYear, modelBrand, modelPrice, quantity);
    }


    Processor(String modelName, int modelYear, String modelBrand, double modelPrice,int quantity, double clockSpeed, int coreCount,
            boolean graphics) {
        super(modelName, modelYear, modelBrand, modelPrice, quantity);
        if (clockSpeed == 2.8 || clockSpeed == 3.3 || clockSpeed == 4.1) {
            this.clockSpeed = clockSpeed;
        } else {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("Invalid clock speed");
            }
        }
        if (coreCount == 6 || coreCount == 8 || coreCount == 16) {
            this.coreCount = coreCount;
        } else {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("Invalid core count");
            }
        }
        this.graphics = graphics;
    }

    public void setClockSpeed(double clockSpeed) {
        if (clockSpeed == 2.8 || clockSpeed == 3.3 || clockSpeed == 4.1) {
            this.clockSpeed = clockSpeed;
        } else {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("Invalid clock speed");
            }
        }
    }

    public void setCoreCount(int coreCount) {
        if (coreCount == 6 || coreCount == 8 || coreCount == 16) {
            this.coreCount = coreCount;
        } else {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("Invalid core count");
            }
        }
    }

    public void setGraphics(boolean graphics) {
        this.graphics = graphics;
    }

    public double getClockSpeed() {
        return this.clockSpeed;
    }

    public int getCoreCount() {
        return this.coreCount;
    }

    public boolean getGraphics() {
        return this.graphics;
    }

    public String toString() {
        return super.toString() + "\nType: Processor " + "Specifications : " + " " + "\nClockspeed :\t" + clockSpeed
                + "\nNumber of cores :\t" + coreCount + "\"" + "\nHas graphics :\t" + graphics + "\n";
    }
}