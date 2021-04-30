package main;

import model.*;
import service.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop();
        ShopService shopService = new ShopService();

        try{
            CsvService.loadCvs(shop, shopService);
        }
        catch(Exception e){

        }

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
                            shopService.addProduct(shop, ProductService.parseCPU(scanner.nextLine()));
                        }
                        case "GPU" -> {
                            System.out.println("Please type the product specifications:\n" +
                                    "name/brand/price/stock/port/memory/bandwidth/RGB");
                            shopService.addProduct(shop, ProductService.parseGPU(scanner.nextLine()));
                        }
                        case "HDD" -> {
                            System.out.println("Please type the product specifications:\n" +
                                    "name/brand/price/stock/capacity/RPM/form factor/connection interface");
                            shopService.addProduct(shop, ProductService.parseHDD(scanner.nextLine()));
                        }
                        case "PSU" -> {
                            System.out.println("Please type the product specifications:\n" +
                                    "name/brand/price/stock/power/alimentation");
                            shopService.addProduct(shop, ProductService.parsePSU(scanner.nextLine()));
                        }
                        case "RAM" -> {
                            System.out.println("Please type the product specifications:\n" +
                                    "name/brand/price/stock/capacity/frequency/memory type/RGB");
                            shopService.addProduct(shop, ProductService.parseRAM(scanner.nextLine()));
                        }
                        case "SSD" -> {
                            System.out.println("Please type the product specifications:\n" +
                                    "name/brand/price/stock/capacity/form factor/connection interface");
                            shopService.addProduct(shop, ProductService.parseSSD(scanner.nextLine()));
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
                    System.out.println("Please type the supplier's:\n" + "name/phone/country");
                    shopService.addSupplier(shop, SupplierService.parseSupplier(scanner.nextLine()));
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
                case "view notifications" -> {
                    NotificationService.viewNotifications();
                }
                case "update csv" -> CsvService.updateCvs(shop, shopService);
                case "exit" -> System.exit(0);
                default -> System.out.println("This command does not exist.");
            }

        }
    }
}
