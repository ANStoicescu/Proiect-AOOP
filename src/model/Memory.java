package model;

public abstract class Memory extends Product {
    private double capacity;

    public Memory(long id, String name, String brand, double price, int stock, double capacity) {
        super(id, name, brand, price, stock);
        this.capacity = capacity;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    @Override
    public String getAttributeNames() {
        return super.getAttributeNames() + "/" + "Capacity";
    }

    @Override
    public String toString() {
        return super.toString() + "/" + capacity;
    }
}
