package service;

import model.Supplier;

import java.util.Random;

public class SupplierService {
    private static Integer id = -1;

    public static Integer getId() {
        id++;
        return id;
    }

    public static void setId(Integer i) {
        id = i;
    }

    public static Supplier parseSupplier(String supplierDetails) {
        try {
            String[] attributes = supplierDetails.split("/");
            int id = getId();
            String name = attributes[0];
            String phone = attributes[1];
            String country = attributes[2];
            SQLService.addSupplier(id, name, phone, country);
            return new Supplier(id, name, phone, country);
        } catch (NumberFormatException e) {
            System.out.println("Input-ul este invalid.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Input-ul nu acopera toate specificatiile");
        }
        return null;
    }
}
