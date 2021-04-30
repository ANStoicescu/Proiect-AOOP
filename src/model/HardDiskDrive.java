package model;

public class HardDiskDrive extends Memory {
    private int rpm;
    private String formFactor;
    private String connectionInterface;

    public HardDiskDrive(long id, String name, String brand, double price, int stock, double capacity, int rpm, String formFactor, String connectionInterface) {
        super(id, name, brand, price, stock, capacity);
        this.rpm = rpm;
        this.formFactor = formFactor;
        this.connectionInterface = connectionInterface;
    }

    public int getrpm() {
        return rpm;
    }

    public void setrpm(int rpm) {
        this.rpm = rpm;
    }

    public String getFormFactor() {
        return formFactor;
    }

    public void setFormFactor(String formFactor) {
        this.formFactor = formFactor;
    }

    public String getConnectionInterface() {
        return connectionInterface;
    }

    public void setConnectionInterface(String connectionInterface) {
        this.connectionInterface = connectionInterface;
    }

    @Override
    public String getAttributeNames() {
        return super.getAttributeNames() + "/" + "Rpm" + "/" + "Form Factor" + "/" + "Connection Interface";
    }

    @Override
    public String toString() {
        return super.toString() + "/" + rpm + "/" + formFactor + "/" + connectionInterface;
    }
}
