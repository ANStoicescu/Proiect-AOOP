package model;

public class PowerSupplyUnit extends Product{
    private int power;
    private int alimentation;

    public PowerSupplyUnit(long id, String name, String brand, double price, int stock, int power, int alimentation) {
        super(id, name, brand, price, stock);
        this.power = power;
        this.alimentation = alimentation;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getAlimentation() {
        return alimentation;
    }

    public void setAlimentation(int alimentation) {
        this.alimentation = alimentation;
    }

    @Override
    public String getAttributeNames() {
        return super.getAttributeNames() + "/" + "Power" + "/" + "Alimentation";
    }

    @Override
    public String toString() {
        return super.toString() + "/" + power + "/" + alimentation;
    }
}
