package model;

public class RandomAcessMemory extends Memory {
    private int frequecy;
    private String memoryType;
    private boolean RGB;

    public RandomAcessMemory(long id, String name, String brand, double price, int stock, double capacity, int frequecy, String memoryType, boolean RGB) {
        super(id, name, brand, price, stock, capacity);
        this.frequecy = frequecy;
        this.memoryType = memoryType;
        this.RGB = RGB;
    }

    public int getFrequecy() {
        return frequecy;
    }

    public void setFrequecy(int frequecy) {
        this.frequecy = frequecy;
    }

    public String getMemoryType() {
        return memoryType;
    }

    public void setMemoryType(String memoryType) {
        this.memoryType = memoryType;
    }

    public boolean isRGB() {
        return RGB;
    }

    public void setRGB(boolean RGB) {
        this.RGB = RGB;
    }

    @Override
    public String getAttributeNames() {
        return super.getAttributeNames() + "/" + "Frequency" + "/" + "Memory Type" + "/" + "RGB";
    }

    @Override
    public String toString() {
        return super.toString() + "/" + frequecy + "/" + memoryType + "/" + RGB;
    }
}
