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
        Product[] newProducts = new Product[products.length];
        int k = 0;
        for (Product p : products) {
            if (p == null) continue;
            if (id.equals(p.getId())) {
                System.out.println("Gasit si sters.");
                gasit = true;
                continue;
            }
            newProducts[k++] = p;
        }
        if (!gasit)
            System.out.println("Nu am gasit.");
        shop.setProducts(newProducts);
    }

    public void searchProduct(Shop shop, String line) {
        Long id;
        boolean gasit = false;
        try {
            id = Long.parseLong(line);
        }
        catch (NumberFormatException e){
            System.out.println("Input invalid.");
            return;
        }
        for(Product p : shop.getProducts()){
            if(p!=null && id.equals(p.getId())) {
                gasit = true;
                String[] attributeNames = p.getAttributeNames().split("/");
                String[] attributes = p.toString().split("/");
                System.out.println("ID: " + attributes[0]);
                for (int i = 1; i < attributes.length; i++)
                    System.out.println("\t" + attributeNames[i - 1] + ": " + attributes[i]);
                Supplier s = p.getSupplier();
                if (s != null) {
                    attributeNames = s.getAttributeNames().split("/");
                    attributes = s.toString().split("/");
                    System.out.println("\tSupplier ID: " + attributes[0]);
                    for (int i = 1; i < attributes.length; i++)
                        System.out.println("\t\t" + attributeNames[i - 1] + ": " + attributes[i]);
                } else {
                    System.out.println("\tThis product doesn't have a supplier assigned.");
                }
            }
        }
        if(!gasit) System.out.println("Nu am gasit un produs cu acest id.");
    }


    public void printProductDetails(Shop shop) {
        for (Product p : shop.getProducts()) {
            if (p != null) {
                String[] attributeNames = p.getAttributeNames().split("/");
                String[] attributes = p.toString().split("/");
                System.out.println("ID: " + attributes[0]);
                for (int i = 1; i < attributes.length; i++)
                    System.out.println("\t" + attributeNames[i - 1] + ": " + attributes[i]);
                Supplier s = p.getSupplier();
                if (s != null) {
                    attributeNames = s.getAttributeNames().split("/");
                    attributes = s.toString().split("/");
                    System.out.println("\tSupplier ID: " + attributes[0]);
                    for (int i = 1; i < attributes.length; i++)
                        System.out.println("\t\t" + attributeNames[i - 1] + ": " + attributes[i]);
                }
                else {
                    System.out.println("\tThis product doesn't have a supplier assigned.");
                }
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

    public void deleteSupplier(Shop shop, Long id) {
        Supplier[] suppliers = shop.getSuppliers();
        boolean gasit = false;
        Supplier[] newSuppliers = new Supplier[suppliers.length];
        int k = 0;
        for (Supplier s : suppliers) {
            if (s == null) continue;
            if (id.equals(s.getId())) {
                System.out.println("Gasit si sters.");
                Product[] products = shop.getProducts();
                for (Product p : products) {
                    if(p == null) continue;
                    if(p.getSupplier()==s)
                        p.setSupplier(null);
                }
                gasit = true;
                continue;
            }
            newSuppliers[k++] = s;
        }
        if (!gasit)
            System.out.println("Nu am gasit.");
        shop.setSuppliers(newSuppliers);
    }

    public void searchSupplier(Shop shop, String line) {
        Long id;
        boolean gasit = false;
        try {
            id = Long.parseLong(line);
        }
        catch (NumberFormatException e){
            System.out.println("Input invalid.");
            return;
        }
        for(Supplier s: shop.getSuppliers()){
            if(s!=null && id.equals(s.getId())){
                gasit = true;
                String[] attributeNames = s.getAttributeNames().split("/");
                String[] attributes = s.toString().split("/");
                System.out.println("ID: " + attributes[0]);
                for (int i = 1; i < attributes.length; i++)
                    System.out.println("\t" + attributeNames[i - 1] + ": " + attributes[i]);
            }
        }
        if(!gasit) System.out.println("Nu am gasit un supplier cu acest id.");
    }

    public void printSupplierDetails(Shop shop) {
        for (Supplier s : shop.getSuppliers()) {
            if (s != null) {
                String[] attributeNames = s.getAttributeNames().split("/");
                String[] attributes = s.toString().split("/");
                System.out.println("ID: " + attributes[0]);
                for (int i = 1; i < attributes.length; i++)
                    System.out.println("\t" + attributeNames[i - 1] + ": " + attributes[i]);
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

    public void addSupplierToProduct(Shop shop, String line) {
        long sid,pid;
        boolean gasitSupplier = false;
        boolean gasitProdus = false;
        try {
            String[] ids = line.split("/");
            sid = Long.parseLong(ids[0]);
            pid = Long.parseLong(ids[1]);
        }
        catch (NumberFormatException e){
            System.out.println("Input invalid");
            return;
        }
        for (Product p : shop.getProducts()) {
            if (pid == p.getId()) {
                gasitProdus = true;
                for (Supplier s : shop.getSuppliers()) {
                    if (sid == s.getId()) {
                        gasitSupplier = true;
                        p.setSupplier(s);
                        break;
                    }
                }
                if(!gasitSupplier)System.out.println("Nu am gasit supplier cu acest id.");
                break;
            }
        }
        if(!gasitProdus)System.out.println("Nu am gasit produs cu acest id.");
    }


}
