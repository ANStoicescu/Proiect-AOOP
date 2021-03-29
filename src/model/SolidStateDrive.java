package model;

public class SolidStateDrive extends Memory {
    private String formFactor;
    private String connectionInterface;

    public SolidStateDrive(long id, String name, String brand, double price, int stock, double capacity, String formFactor, String connectionInterface) {
        super(id, name, brand, price, stock, capacity);
        this.formFactor = formFactor;
        this.connectionInterface = connectionInterface;
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
        return super.getAttributeNames() + "/" + "Form Factor" + "/" + "Connection Interface";
    }

    @Override
    public String toString() {
        return super.toString() + "/" + formFactor + "/" + connectionInterface;
    }
}
