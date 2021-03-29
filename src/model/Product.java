package model;

public abstract class Product {
    protected long id;
    protected String name;
    protected String brand;
    protected double price;
    protected int stock;
    protected Supplier supplier;

    public Product(long id, String name, String brand, double price, int stock) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.stock = stock;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public String getAttributeNames() {
        return "Name" + "/" + "Brand" + "/" + "Price" + "/" + "Stock";
    }

    @Override
    public String toString() {
        return id + "/" + name + "/" + brand + "/" + price + "/" + stock;
    }
}
