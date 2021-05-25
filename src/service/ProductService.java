package service;

import model.*;

import java.util.Random;

public class ProductService {
    private static Integer id = -1;

    public static Integer getId() {
        id++;
        return id;
    }

    public static void setId(Integer i) {
        id = i;
    }

    public static Product parseCPU(String productDetails) {
        try {
            String[] attributes = productDetails.split("/");
            int id = getId();
            String name = attributes[0];
            String brand = attributes[1];
            double price = Double.parseDouble(attributes[2]);
            int stock = Integer.parseInt(attributes[3]);
            String socket = attributes[4];
            int frequency = Integer.parseInt(attributes[5]);
            int cores = Integer.parseInt(attributes[6]);
            int threadsPerCore = Integer.parseInt(attributes[7]);
            NotificationService.sendNotification("Added CPU");
            SQLService.addCPU(id, name, brand, price, stock, socket, frequency, cores, threadsPerCore);
            return new CentralProcessingUnit(id, name, brand, price, stock, socket, frequency, cores, threadsPerCore);
        } catch (NumberFormatException e) {
            System.out.println("Input-ul este invalid.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Input-ul nu acopera toate specificatiile");
        }
        return null;
    }

    public static Product parseGPU(String productDetails) {
        try {
            String[] attributes = productDetails.split("/");
            int id = getId();
            String name = attributes[0];
            String brand = attributes[1];
            double price = Double.parseDouble(attributes[2]);
            int stock = Integer.parseInt(attributes[3]);
            String port = attributes[4];
            int memory = Integer.parseInt(attributes[5]);
            int bandWidth = Integer.parseInt(attributes[6]);
            boolean RGB = Boolean.parseBoolean(attributes[7]);
            SQLService.addGPU(id, name, brand, price, stock, port, memory, bandWidth, RGB);
            NotificationService.sendNotification("Added GPU");
            return new GraphicalProcessingUnit(id, name, brand, price, stock, port, memory, bandWidth, RGB);
        } catch (NumberFormatException e) {
            System.out.println("Input-ul este invalid.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Input-ul nu acopera toate specificatiile");
        }
        return null;
    }

    public static Product parseHDD(String productDetails) {
        try {
            String[] attributes = productDetails.split("/");
            int id = getId();
            String name = attributes[0];
            String brand = attributes[1];
            double price = Double.parseDouble(attributes[2]);
            int stock = Integer.parseInt(attributes[3]);
            double capacity = Double.parseDouble(attributes[4]);
            int RPM = Integer.parseInt(attributes[5]);
            String formFactor = attributes[6];
            String connectionInterface = attributes[7];
            SQLService.addHDD(id, name, brand, price, stock, capacity, RPM, formFactor, connectionInterface);
            NotificationService.sendNotification("Added HDD");
            return new HardDiskDrive(id, name, brand, price, stock, capacity, RPM, formFactor, connectionInterface);
        } catch (NumberFormatException e) {
            System.out.println("Input-ul este invalid.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Input-ul nu acopera toate specificatiile");
        }
        return null;
    }

    public static Product parsePSU(String productDetails) {
        try {
            String[] attributes = productDetails.split("/");
            int id = getId();
            String name = attributes[0];
            String brand = attributes[1];
            double price = Double.parseDouble(attributes[2]);
            int stock = Integer.parseInt(attributes[3]);
            int power = Integer.parseInt(attributes[4]);
            int alimentation = Integer.parseInt(attributes[5]);
            SQLService.addPSU(id, name, brand, price, stock, power, alimentation);
            NotificationService.sendNotification("Added PSU");
            return new PowerSupplyUnit(id, name, brand, price, stock, power, alimentation);
        } catch (NumberFormatException e) {
            System.out.println("Input-ul este invalid.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Input-ul nu acopera toate specificatiile");
        }
        return null;
    }

    public static Product parseRAM(String productDetails) {
        try {
            String[] attributes = productDetails.split("/");
            int id = getId();
            String name = attributes[0];
            String brand = attributes[1];
            double price = Double.parseDouble(attributes[2]);
            int stock = Integer.parseInt(attributes[3]);
            double capacity = Double.parseDouble(attributes[4]);
            int frequency = Integer.parseInt(attributes[5]);
            String memoryType = attributes[6];
            boolean RGB = Boolean.parseBoolean(attributes[7]);
            SQLService.addRAM(id, name, brand, price, stock, capacity, frequency, memoryType, RGB);
            NotificationService.sendNotification("Added RAM");
            return new RandomAcessMemory(id, name, brand, price, stock, capacity, frequency, memoryType, RGB);
        } catch (NumberFormatException e) {
            System.out.println("Input-ul este invalid.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Input-ul nu acopera toate specificatiile");
        }
        return null;
    }

    public static Product parseSSD(String productDetails) {
        try {
            String[] attributes = productDetails.split("/");
            int id = getId();
            String name = attributes[0];
            String brand = attributes[1];
            double price = Double.parseDouble(attributes[2]);
            int stock = Integer.parseInt(attributes[3]);
            double capacity = Double.parseDouble(attributes[4]);
            String formFactor = attributes[5];
            String connectionInterface = attributes[6];
            SQLService.addSSD(id, name, brand, price, stock, capacity, formFactor, connectionInterface);
            NotificationService.sendNotification("Added SSD");
            return new SolidStateDrive(id, name, brand, price, stock, capacity, formFactor, connectionInterface);
        } catch (NumberFormatException e) {
            System.out.println("Input-ul este invalid.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Input-ul nu acopera toate specificatiile");
        }
        return null;
    }


}
