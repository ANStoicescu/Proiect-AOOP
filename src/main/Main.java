package main;

import model.*;
import service.ShopService;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop();
        ShopService shopService = new ShopService();

        while (true) {
            System.out.println("Please type a command:");
            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine();
            switch (line) {
                case "add" -> {
                    System.out.println("Please choose a product type:");
                    String productType = scanner.nextLine();
                    switch (productType) {
                        case "CPU" -> {
                            System.out.println("Please type the product specifications:\n" +
                                    "name/brand/price/stock/socket/frequency/cores/threads per core");
                            shopService.addProduct(shop, parseCPU(scanner.nextLine()));
                        }
                        case "GPU" -> {
                            System.out.println("Please type the product specifications:\n" +
                                    "name/brand/price/stock/port/memory/bandwidth/RGB");
                            shopService.addProduct(shop, parseGPU(scanner.nextLine()));
                        }
                        case "HDD" -> {
                            System.out.println("Please type the product specifications:\n" +
                                    "name/brand/price/stock/capacity/RPM/form factor/connection interface");
                            shopService.addProduct(shop, parseHDD(scanner.nextLine()));
                        }
                        case "PSU" -> {
                            System.out.println("Please type the product specifications:\n" +
                                    "name/brand/price/stock/power/alimentation");
                            shopService.addProduct(shop, parsePSU(scanner.nextLine()));
                        }
                        case "RAM" -> {
                            System.out.println("Please type the product specifications:\n" +
                                    "name/brand/price/stock/capacity/frequency/memory type/RGB");
                            shopService.addProduct(shop, parseRAM(scanner.nextLine()));
                        }
                        case "SSD" -> {
                            System.out.println("Please type the product specifications:\n" +
                                    "name/brand/price/stock/capacity/form factor/connection interface");
                            shopService.addProduct(shop, parseSSD(scanner.nextLine()));
                        }
                        default -> System.out.println("Unrecognized");
                    }
                }
                case "delete" -> {
                    System.out.println("Please type the id of the product you want to delete");
                    line = scanner.nextLine();
                    try {
                        long id = Long.parseLong(line);
                        shopService.deleteProduct(shop, id);
                    } catch (NumberFormatException e) {
                        System.out.println("Input-ul este invalid.");
                    }
                }
                case "search" -> {
                    System.out.println("Please type the id of the product you're searching for:");
                    shopService.searchProduct(shop,scanner.nextLine());
                }
                case "view" -> shopService.printProductDetails(shop);
                case "add supplier" -> {
                    System.out.println("Please type the supplier's:\n" +
                            "name/phone/country");
                    shopService.addSupplier(shop, parseSupplier(scanner.nextLine()));
                }
                case "delete supplier" -> {
                    System.out.println("Please type the id of the supplier you want to delete");
                    line = scanner.nextLine();
                    try {
                        long id = Long.parseLong(line);
                        shopService.deleteSupplier(shop, id);
                    } catch (NumberFormatException e) {
                        System.out.println("Input-ul este invalid.");
                    }
                }
                case "search supplier" -> {
                    System.out.println("Please type the id of the supplier you're searching for:");
                    shopService.searchSupplier(shop,scanner.nextLine());
                }
                case "view suppliers" -> shopService.printSupplierDetails(shop);
                case "add supplier to product" -> {
                    System.out.println("Please type the supplier's id and then the product's id:\n" +
                            "supplier's id/product's id");

                    shopService.addSupplierToProduct(shop,scanner.nextLine());
                }
                case "exit" -> System.exit(0);
                default -> System.out.println("This command does not exist.");
            }

        }
    }

    private static Product parseCPU(String productDetails) {
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
            return new CentralProcessingUnit(new Random().nextInt(100), name, brand, price, stock, socket, frequency, cores, threadsPerCore);
        } catch (NumberFormatException e) {
            System.out.println("Input-ul este invalid.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Input-ul nu acopera toate specificatiile");
        }
        return null;
    }

    private static Product parseGPU(String productDetails) {
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
            return new GraphicalProcessingUnit(new Random().nextInt(100), name, brand, price, stock, port, memory, bandWidth, RGB);
        } catch (NumberFormatException e) {
            System.out.println("Input-ul este invalid.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Input-ul nu acopera toate specificatiile");
        }
        return null;
    }

    private static Product parseHDD(String productDetails) {
        try {
            String[] attributes = productDetails.split("/");
            String name = attributes[0];
            String brand = attributes[1];
            double price = Double.parseDouble(attributes[2]);
            int stock = Integer.parseInt(attributes[3]);
            int capacity = Integer.parseInt(attributes[4]);
            int RPM = Integer.parseInt(attributes[5]);
            String formFactor = attributes[6];
            String connectionInterface = attributes[7];
            return new HardDiskDrive(new Random().nextInt(100), name, brand, price, stock, capacity, RPM, formFactor, connectionInterface);
        } catch (NumberFormatException e) {
            System.out.println("Input-ul este invalid.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Input-ul nu acopera toate specificatiile");
        }
        return null;
    }

    private static Product parsePSU(String productDetails) {
        try {
            String[] attributes = productDetails.split("/");
            String name = attributes[0];
            String brand = attributes[1];
            double price = Double.parseDouble(attributes[2]);
            int stock = Integer.parseInt(attributes[3]);
            int power = Integer.parseInt(attributes[4]);
            int alimentation = Integer.parseInt(attributes[5]);
            return new PowerSupplyUnit(new Random().nextInt(100), name, brand, price, stock, power, alimentation);
        } catch (NumberFormatException e) {
            System.out.println("Input-ul este invalid.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Input-ul nu acopera toate specificatiile");
        }
        return null;
    }

    private static Product parseRAM(String productDetails) {
        try {
            String[] attributes = productDetails.split("/");
            String name = attributes[0];
            String brand = attributes[1];
            double price = Double.parseDouble(attributes[2]);
            int stock = Integer.parseInt(attributes[3]);
            int capacity = Integer.parseInt(attributes[4]);
            int frequency = Integer.parseInt(attributes[4]);
            String memoryType = attributes[5];
            boolean RGB = Boolean.parseBoolean(attributes[6]);
            return new RandomAcessMemory(new Random().nextInt(100), name, brand, price, stock, capacity, frequency, memoryType, RGB);
        } catch (NumberFormatException e) {
            System.out.println("Input-ul este invalid.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Input-ul nu acopera toate specificatiile");
        }
        return null;
    }

    private static Product parseSSD(String productDetails) {
        try {
            String[] attributes = productDetails.split("/");
            String name = attributes[0];
            String brand = attributes[1];
            double price = Double.parseDouble(attributes[2]);
            int stock = Integer.parseInt(attributes[3]);
            int capacity = Integer.parseInt(attributes[4]);
            String formFactor = attributes[5];
            String connectionInterface = attributes[6];
            return new SolidStateDrive(new Random().nextInt(100), name, brand, price, stock, capacity, formFactor, connectionInterface);
        } catch (NumberFormatException e) {
            System.out.println("Input-ul este invalid.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Input-ul nu acopera toate specificatiile");
        }
        return null;
    }

    private static Supplier parseSupplier(String supplierDetails) {
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
