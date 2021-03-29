package service;

import model.Product;
import model.Shop;
import model.Supplier;

public class ShopService {


    public void addProduct(Shop shop, Product product) {
        if (product == null) return;
        int lastIndex = getNumberOfProducts(shop);
        shop.getProducts()[lastIndex] = product;
    }

    public void deleteProduct(Shop shop, Long id) {
        Product[] products = shop.getProducts();
        boolean gasit = false;
        Product[] newProducts = new Product[10];
        int k = 0;
        for (Product p : products) {
            if (p == null) break;
            if (id.equals(p.getId())) {
                System.out.println("Gasit si sters.");
                gasit = true;
                continue;
            }
            newProducts[k++] = p;
        }
        if (gasit == false)
            System.out.println("Nu am gasit.");
        shop.setProducts(newProducts);
    }

    public void printProductDetails(Shop shop) {
        for (Product p : shop.getProducts()) {
            if (p != null) {
                String attributeNames[] = p.getAttributeNames().split("/");
                String attributes[] = p.toString().split("/");
                System.out.println("ID: " + attributes[0]);
                for (int i = 1; i < attributes.length; i++)
                    System.out.println("\t" + attributeNames[i - 1] + ": " + attributes[i]);
            }
        }
    }

    private int getNumberOfProducts(Shop shop) {
        int nr = 0;
        for (Product p : shop.getProducts()) {
            if (p != null)
                nr++;
        }
        return nr;
    }

    public void addSupplier(Shop shop, Supplier supplier) {
        if (supplier == null) return;
        int lastIndex = getNumberOfSuppliers(shop);
        shop.getSuppliers()[lastIndex] = supplier;
    }

    public void printSupplierDetails(Shop shop) {
        for (Supplier s : shop.getSuppliers()) {
            if (s != null) {
                String attributeNames[] = s.getAttributeNames().split("/");
                String attributes[] = s.toString().split("/");
                System.out.println(attributeNames[0] + ": " + attributes[0]);
                for (int i = 1; i < attributes.length; i++)
                    System.out.println("\t" + attributeNames[i] + ": " + attributes[i]);
            }
        }
    }

    private int getNumberOfSuppliers(Shop shop) {
        int nr = 0;
        for (Supplier s : shop.getSuppliers()) {
            if (s != null)
                nr++;
        }
        return nr;
    }
}
