package model;

public class HardDiskDrive extends Memory {
    private int RPM;
    private String formFactor;
    private String connectionInterface;

    public HardDiskDrive(long id, String name, String brand, double price, int stock, double capacity, int RPM, String formFactor, String connectionInterface) {
        super(id, name, brand, price, stock, capacity);
        this.RPM = RPM;
        this.formFactor = formFactor;
        this.connectionInterface = connectionInterface;
    }

    public int getRPM() {
        return RPM;
    }

    public void setRPM(int RPM) {
        this.RPM = RPM;
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
        return super.getAttributeNames() + "/" + "RPM" + "/" + "Form Factor" + "/" + "Connection Interface";
    }

    @Override
    public String toString() {
        return super.toString() + "/" + RPM + "/" + formFactor + "/" + connectionInterface;
    }
}
