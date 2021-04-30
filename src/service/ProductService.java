package service;

import model.*;

import java.util.Random;

public class ProductService {

    public static Product parseCPU(String productDetails) {
        try {
            String[] attributes = productDetails.split("/");
            String name = attributes[0];
            String brand = attributes[1];
            double price = Double.parseDouble(attributes[2]);
            int stock = Integer.parseInt(attributes[3]);
            String socket = attributes[4];
            int frequency = Integer.parseInt(attributes[5]);
            int cores = Integer.parseInt(attributes[6]);
            int threadsPerCore = Integer.parseInt(attributes[7]);
            NotificationService.sendNotification("Added CPU");
            return new CentralProcessingUnit(new Random().nextInt(100), name, brand, price, stock, socket, frequency, cores, threadsPerCore);
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
            String name = attributes[0];
            String brand = attributes[1];
            double price = Double.parseDouble(attributes[2]);
            int stock = Integer.parseInt(attributes[3]);
            String port = attributes[4];
            int memory = Integer.parseInt(attributes[5]);
            int bandWidth = Integer.parseInt(attributes[6]);
            boolean RGB = Boolean.parseBoolean(attributes[7]);
            NotificationService.sendNotification("Added GPU");
            return new GraphicalProcessingUnit(new Random().nextInt(100), name, brand, price, stock, port, memory, bandWidth, RGB);
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
            String name = attributes[0];
            String brand = attributes[1];
            double price = Double.parseDouble(attributes[2]);
            int stock = Integer.parseInt(attributes[3]);
            double capacity = Double.parseDouble(attributes[4]);
            int RPM = Integer.parseInt(attributes[5]);
            String formFactor = attributes[6];
            String connectionInterface = attributes[7];
            NotificationService.sendNotification("Added HDD");
            return new HardDiskDrive(new Random().nextInt(100), name, brand, price, stock, capacity, RPM, formFactor, connectionInterface);
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
            String name = attributes[0];
            String brand = attributes[1];
            double price = Double.parseDouble(attributes[2]);
            int stock = Integer.parseInt(attributes[3]);
            int power = Integer.parseInt(attributes[4]);
            int alimentation = Integer.parseInt(attributes[5]);
            NotificationService.sendNotification("Added PSU");
            return new PowerSupplyUnit(new Random().nextInt(100), name, brand, price, stock, power, alimentation);
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
            String name = attributes[0];
            String brand = attributes[1];
            double price = Double.parseDouble(attributes[2]);
            int stock = Integer.parseInt(attributes[3]);
            double capacity = Double.parseDouble(attributes[4]);
            int frequency = Integer.parseInt(attributes[5]);
            String memoryType = attributes[6];
            boolean RGB = Boolean.parseBoolean(attributes[7]);
            NotificationService.sendNotification("Added RAM");
            return new RandomAcessMemory(new Random().nextInt(100), name, brand, price, stock, capacity, frequency, memoryType, RGB);
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
            String name = attributes[0];
            String brand = attributes[1];
            double price = Double.parseDouble(attributes[2]);
            int stock = Integer.parseInt(attributes[3]);
            double capacity = Double.parseDouble(attributes[4]);
            String formFactor = attributes[5];
            String connectionInterface = attributes[6];
            NotificationService.sendNotification("Added SSD");
            return new SolidStateDrive(new Random().nextInt(100), name, brand, price, stock, capacity, formFactor, connectionInterface);
        } catch (NumberFormatException e) {
            System.out.println("Input-ul este invalid.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Input-ul nu acopera toate specificatiile");
        }
        return null;
    }


}
