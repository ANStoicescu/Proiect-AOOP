package model;

public class Shop {
    private Product[] products = new Product[10];
    private Supplier[] suppliers = new Supplier[10];

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }

    public Supplier[] getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(Supplier[] suppliers) {
        this.suppliers = suppliers;
    }
}
