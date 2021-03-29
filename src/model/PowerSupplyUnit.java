package model;

public class PowerSupplyUnit extends Product{
    private int Power;
    private int Alimentation;

    public PowerSupplyUnit(long id, String name, String brand, double price, int stock, int power, int alimentation) {
        super(id, name, brand, price, stock);
        Power = power;
        Alimentation = alimentation;
    }

    public int getPower() {
        return Power;
    }

    public void setPower(int power) {
        Power = power;
    }

    public int getAlimentation() {
        return Alimentation;
    }

    public void setAlimentation(int alimentation) {
        Alimentation = alimentation;
    }

    @Override
    public String getAttributeNames(){
        return super.getAttributeNames() + "/" + "Power (W)" + "/" + "Alimentation";
    }

    @Override
    public String toString(){
        return super.toString() + "/"+ Power + "/" + Alimentation;
    }
}
