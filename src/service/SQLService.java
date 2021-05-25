package service;

import config.DatabaseConnection;
import model.*;

import java.sql.*;

public class SQLService {
    private static int maxid = 0;

    public static void deleteTables() {
        try {
            Connection connection = DatabaseConnection.getInstance();
            Statement statement = connection.createStatement();
            String sql = "delete from cpu";
            statement.addBatch(sql);
            sql = "delete from gpu";
            statement.addBatch(sql);
            sql = "delete from hdd";
            statement.addBatch(sql);
            sql = "delete from psu";
            statement.addBatch(sql);
            sql = "delete from ram";
            statement.addBatch(sql);
            sql = "delete from ssd";
            statement.addBatch(sql);
            sql = "delete from supplier";
            statement.addBatch(sql);
            statement.executeBatch();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void addCPU(int id, String name, String brand, double price, int stock, String socket, int frequency, int cores, int threadsPerCore) {
        String sql = "insert into cpu values (?, ?, ?, ?, ?, ?, ?, ?, ?) ";
        try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setString(3, brand);
            statement.setDouble(4, price);
            statement.setInt(5, stock);
            statement.setString(6, socket);
            statement.setInt(7, frequency);
            statement.setInt(8, cores);
            statement.setInt(9, threadsPerCore);
            statement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addGPU(int id, String name, String brand, double price, int stock, String port, int memory, int bandWidth, boolean rgb) {
        String sql = "insert into gpu values (?, ?, ?, ?, ?, ?, ?, ?, ?) ";
        try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setString(3, brand);
            statement.setDouble(4, price);
            statement.setInt(5, stock);
            statement.setString(6, port);
            statement.setInt(7, memory);
            statement.setInt(8, bandWidth);
            statement.setBoolean(9, rgb);
            statement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addHDD(int id, String name, String brand, double price, int stock, double capacity, int rpm, String formFactor, String connectionInterface) {
        String sql = "insert into hdd values (?, ?, ?, ?, ?, ?, ?, ?, ?) ";
        try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setString(3, brand);
            statement.setDouble(4, price);
            statement.setInt(5, stock);
            statement.setDouble(6, capacity);
            statement.setInt(7, rpm);
            statement.setString(8, formFactor);
            statement.setString(9, connectionInterface);
            statement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addPSU(int id, String name, String brand, double price, int stock, int power, int alimentation) {
        String sql = "insert into psu values (?, ?, ?, ?, ?, ?, ?) ";
        try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setString(3, brand);
            statement.setDouble(4, price);
            statement.setInt(5, stock);
            statement.setInt(6, power);
            statement.setInt(7, alimentation);
            statement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addRAM(int id, String name, String brand, double price, int stock, double capacity, int frequency, String memoryType, boolean rgb) {
        String sql = "insert into ram values (?, ?, ?, ?, ?, ?, ?, ?, ?) ";
        try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setString(3, brand);
            statement.setDouble(4, price);
            statement.setInt(5, stock);
            statement.setDouble(6, capacity);
            statement.setInt(7, frequency);
            statement.setString(8, memoryType);
            statement.setBoolean(9, rgb);
            statement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addSSD(int id, String name, String brand, double price, int stock, double capacity, String formFactor, String connectionInterface) {
        String sql = "insert into ssd values (?, ?, ?, ?, ?, ?, ?, ?) ";
        try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setString(3, brand);
            statement.setDouble(4, price);
            statement.setInt(5, stock);
            statement.setDouble(6, capacity);
            statement.setString(7, formFactor);
            statement.setString(8, connectionInterface);
            statement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addSupplier(int id, String name, String phone, String country) {
        String sql = "insert into supplier values (?, ?, ?, ?) ";
        try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setString(3, phone);
            statement.setString(4, country);
            statement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addSuppliertoProduct(int sid, int pid) {
        String sql = "insert into supplierproduct values (?, ?) ";
        try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
            statement.setInt(1, sid);
            statement.setInt(2, pid);
            statement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteSupplier(Long id) {
        try {
            Connection connection = DatabaseConnection.getInstance();
            Statement statement = connection.createStatement();
            String sql = "delete from supplier where id = ";
            sql = sql + id;
            statement.executeUpdate(sql);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteProduct(Long id) {
        try {
            Connection connection = DatabaseConnection.getInstance();
            Statement statement = connection.createStatement();
            String sql = "delete from cpu where id = ";
            sql = sql + id;
            statement.addBatch(sql);
            sql = "delete from gpu where id = ";
            sql = sql + id;
            statement.addBatch(sql);
            sql = "delete from hdd where id = ";
            sql = sql + id;
            statement.addBatch(sql);
            sql = "delete from psu where id = ";
            sql = sql + id;
            statement.addBatch(sql);
            sql = "delete from ram where id = ";
            sql = sql + id;
            statement.addBatch(sql);
            sql = "delete from ssd where id = ";
            sql = sql + id;
            statement.addBatch(sql);
            statement.executeBatch();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static void loadProductCPU(Shop shop, ShopService shopService) {
        String sql = "select * from cpu";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
            ResultSet result = statement.executeQuery();
            while(result.next()) {
                int id = result.getInt(1);
                if(id > maxid) maxid =id;
                String name = result.getString(2);
                String brand = result.getString(3);
                double price = result.getDouble(4);
                int stock = result.getInt(5);
                String socket = result.getString(6);
                int frequency = result.getInt(7);
                int cores = result.getInt(8);
                int threadsPerCore = result.getInt(9);
                Product product = new CentralProcessingUnit(id, name, brand, price, stock, socket, frequency, cores, threadsPerCore);
                shopService.addProduct(shop, product);
            }
            ProductService.setId(maxid);
        } catch (NumberFormatException e) {
            System.out.println("Input-ul este invalid.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Input-ul nu acopera toate specificatiile");
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static void loadProductGPU(Shop shop, ShopService shopService) {
        String sql = "select * from gpu";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
            ResultSet result = statement.executeQuery();
            while(result.next()) {
                int id = result.getInt(1);
                if(id > maxid) maxid =id;
                String name = result.getString(2);
                String brand = result.getString(3);
                double price = result.getDouble(4);
                int stock = result.getInt(5);
                String port = result.getString(6);
                int memory = result.getInt(7);
                int bandWidth = result.getInt(8);
                boolean RGB = result.getBoolean(9);
                Product product = new GraphicalProcessingUnit(id, name, brand, price, stock, port, memory, bandWidth, RGB);
                shopService.addProduct(shop, product);
            }
            ProductService.setId(maxid);
        } catch (NumberFormatException e) {
            System.out.println("Input-ul este invalid.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Input-ul nu acopera toate specificatiile");
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static void loadProductHDD(Shop shop, ShopService shopService) {
        String sql = "select * from hdd";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
            ResultSet result = statement.executeQuery();
            while(result.next()) {
                int id = result.getInt(1);
                if(id > maxid) maxid =id;
                String name = result.getString(2);
                String brand = result.getString(3);
                double price = result.getDouble(4);
                int stock = result.getInt(5);
                double capacity = result.getDouble(6);
                int RPM = result.getInt(7);
                String formFactor = result.getString(8);
                String connectionInterface = result.getString(9);
                Product product = new HardDiskDrive(id, name, brand, price, stock, capacity, RPM, formFactor, connectionInterface);
                shopService.addProduct(shop, product);
            }
            ProductService.setId(maxid);
        } catch (NumberFormatException e) {
            System.out.println("Input-ul este invalid.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Input-ul nu acopera toate specificatiile");
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static void loadProductPSU(Shop shop, ShopService shopService) {
        String sql = "select * from psu";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
            ResultSet result = statement.executeQuery();
            while(result.next()) {
                int id = result.getInt(1);
                if(id > maxid) maxid =id;
                String name = result.getString(2);
                String brand = result.getString(3);
                double price = result.getDouble(4);
                int stock = result.getInt(5);
                int power = result.getInt(6);
                int alimentation = result.getInt(7);
                Product product = new PowerSupplyUnit(id, name, brand, price, stock, power, alimentation);
                shopService.addProduct(shop, product);
            }
            ProductService.setId(maxid);
        } catch (NumberFormatException e) {
            System.out.println("Input-ul este invalid.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Input-ul nu acopera toate specificatiile");
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static void loadProductRAM(Shop shop, ShopService shopService) {
        String sql = "select * from ram";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
            ResultSet result = statement.executeQuery();
            while(result.next()) {
                int id = result.getInt(1);
                if(id > maxid) maxid =id;
                String name = result.getString(2);
                String brand = result.getString(3);
                double price = result.getDouble(4);
                int stock = result.getInt(5);
                double capacity = result.getDouble(6);
                int frequency = result.getInt(7);
                String memoryType = result.getString(8);
                boolean RGB = result.getBoolean(9);
                Product product = new RandomAcessMemory(id, name, brand, price, stock, capacity, frequency, memoryType, RGB);
                shopService.addProduct(shop, product);
            }
            ProductService.setId(maxid);
        } catch (NumberFormatException e) {
            System.out.println("Input-ul este invalid.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Input-ul nu acopera toate specificatiile");
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }
    public static void loadProductSSD(Shop shop, ShopService shopService) {
        String sql = "select * from ssd";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
            ResultSet result = statement.executeQuery();
            while(result.next()) {
                int id = result.getInt(1);
                if(id > maxid) maxid =id;
                String name = result.getString(2);
                String brand = result.getString(3);
                double price = result.getDouble(4);
                int stock = result.getInt(5);
                double capacity = result.getDouble(6);
                String formFactor = result.getString(7);
                String connectionInterface = result.getString(8);
                Product product = new SolidStateDrive(id, name, brand, price, stock, capacity, formFactor, connectionInterface);
                shopService.addProduct(shop, product);
            }
            ProductService.setId(maxid);
        } catch (NumberFormatException e) {
            System.out.println("Input-ul este invalid.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Input-ul nu acopera toate specificatiile");
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static void loadSupplier(Shop shop, ShopService shopService) {
        String sql = "select * from supplier";
        int maxid = 0;
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
            ResultSet result = statement.executeQuery();
            while(result.next()) {
                int id = result.getInt(1);
                if(id > maxid)maxid=id;
                String name = result.getString(2);
                String phone = result.getString(3);
                String country = result.getString(4);
                Supplier supplier = new Supplier(id, name, phone, country);
                shopService.addSupplier(shop, supplier);
            }
            SupplierService.setId(maxid);
        } catch (NumberFormatException e) {
            System.out.println("Input-ul este invalid.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Input-ul nu acopera toate specificatiile");
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static void loadSupplierforProduct(Shop shop, ShopService shopService) {
        String sql = "select * from supplierproduct";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
            ResultSet result = statement.executeQuery();
            while(result.next()) {
                int idSupplier = result.getInt(1);
                int idProduct = result.getInt(2);
                shopService.addSupplierToProductSQL(shop, idSupplier + "/" + idProduct);
            }
        } catch (NumberFormatException e) {
            System.out.println("Input-ul este invalid.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Input-ul nu acopera toate specificatiile");
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }

}
