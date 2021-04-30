package service;

import model.Supplier;

import java.util.Random;

public class SupplierService {

    public static Supplier parseSupplier(String supplierDetails) {
        try {
            String[] attributes = supplierDetails.split("/");
            String name = attributes[0];
            String phone = attributes[1];
            String country = attributes[2];
            return new Supplier(new Random().nextInt(100), name, phone, country);
        } catch (NumberFormatException e) {
            System.out.println("Input-ul este invalid.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Input-ul nu acopera toate specificatiile");
        }
        return null;
    }
}
