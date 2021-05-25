package service;

import model.Product;
import model.Shop;
import model.Supplier;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class CsvService {

    private static final String DIRECTORY_PATH = "resources/data";
    private static final String FILE_PATH = DIRECTORY_PATH + "/data.csv";
    public static void updateCvs(Shop shop, ShopService shopService){
        if(!Files.exists(Paths.get(DIRECTORY_PATH))) {
            try {
                Files.createDirectories(Paths.get(DIRECTORY_PATH));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        if(!Files.exists(Paths.get(FILE_PATH))) {
            try {
                Files.createFile(Paths.get(FILE_PATH));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        try {
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(FILE_PATH),
                    StandardOpenOption.APPEND);

            for (Supplier s : shop.getSuppliers()) {
                if (s != null) {
                    String attributes = s.toString();
                    attributes = attributes.replaceAll("/",",");

                    writer.write(s.getClass().getSimpleName() + "," + attributes + "\n");
                }
            }

            for (Product p : shop.getProducts()) {
                if (p != null) {
                    String attributes = p.toString();
                    attributes = attributes.replaceAll("/",",");

                    Supplier s = p.getSupplier();
                    if (s != null) {
                        attributes = Long.toString(s.getId()) + "," + attributes;
                    } else attributes = "-1," + attributes;

                    writer.write(p.getClass().getSimpleName() + "," + attributes + "\n");
                }
            }

            writer.flush();
            NotificationService.sendNotification("CVS file updated");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void loadCvs(Shop shop, ShopService shopService){
        try {
            SQLService.deleteTables();
            BufferedReader reader = Files.newBufferedReader(Paths.get(FILE_PATH));
            String objectDetails = "";
            while((objectDetails = reader.readLine()) != null) {
                objectDetails = objectDetails.replaceAll(",","/");
                String objectType = objectDetails.substring(0, objectDetails.indexOf('/'));
                objectDetails = objectDetails.substring(objectDetails.indexOf('/') + 1);
                objectType = objectType.replaceAll("[a-z]", "");

                int supplierId = -1;
                if(!objectType.equals("S")){
                    supplierId = Integer.parseInt(objectDetails.substring(0, objectDetails.indexOf('/')));
                    objectDetails = objectDetails.substring(objectDetails.indexOf('/') + 1);
                }
                int objectId = Integer.parseInt(objectDetails.substring(0, objectDetails.indexOf('/')));
                objectDetails = objectDetails.substring(objectDetails.indexOf('/') + 1);

                switch (objectType) {
                    case "CPU" -> {
                        shopService.addProduct(shop, ProductService.parseCPU(objectDetails), objectId);
                        handlesupplier(shop,shopService,supplierId,objectId);
                    }
                    case "GPU" -> {
                        shopService.addProduct(shop, ProductService.parseGPU(objectDetails), objectId);
                        handlesupplier(shop,shopService,supplierId,objectId);
                    }
                    case "HDD" -> {
                        shopService.addProduct(shop, ProductService.parseHDD(objectDetails), objectId);
                        handlesupplier(shop,shopService,supplierId,objectId);
                    }
                    case "PSU" -> {
                        shopService.addProduct(shop, ProductService.parsePSU(objectDetails), objectId);
                        handlesupplier(shop,shopService,supplierId,objectId);
                    }
                    case "RAM" -> {
                        shopService.addProduct(shop, ProductService.parseRAM(objectDetails), objectId);
                        handlesupplier(shop,shopService,supplierId,objectId);
                    }
                    case "SSD" -> {
                        shopService.addProduct(shop, ProductService.parseSSD(objectDetails), objectId);
                        handlesupplier(shop,shopService,supplierId,objectId);
                    }
                    case "S" -> {
                        shopService.addSupplier(shop, SupplierService.parseSupplier(objectDetails), objectId);
                    }
                    default -> System.out.println("Unrecognized");
                }
            }
        } catch (NoSuchFileException e) {
            System.out.println("The file with the name " + FILE_PATH + " doesn't exist.");
        } catch (IOException e) {
            System.out.println(e.getClass() + " " + e.getMessage());
        }
    }

    private static void handlesupplier(Shop shop, ShopService shopService,int supplierId, int objectId) {
        if(supplierId != -1) {
            String aux = supplierId + "/" + objectId;
            shopService.addSupplierToProduct(shop, aux);
        }
    }
}
