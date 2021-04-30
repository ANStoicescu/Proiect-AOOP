package model;

public class RandomAcessMemory extends Memory {
    private int frequency;
    private String memoryType;
    private boolean rgb;

    public RandomAcessMemory(long id, String name, String brand, double price, int stock, double capacity, int frequency, String memoryType, boolean rgb) {
        super(id, name, brand, price, stock, capacity);
        this.frequency = frequency;
        this.memoryType = memoryType;
        this.rgb = rgb;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public String getMemoryType() {
        return memoryType;
    }

    public void setMemoryType(String memoryType) {
        this.memoryType = memoryType;
    }

    public boolean isrgb() {
        return rgb;
    }

    public void setrgb(boolean rgb) {
        this.rgb = rgb;
    }

    @Override
    public String getAttributeNames() {
        return super.getAttributeNames() + "/" + "Frequency" + "/" + "Memory Type" + "/" + "rgb";
    }

    @Override
    public String toString() {
        return super.toString() + "/" + frequency + "/" + memoryType + "/" + rgb;
    }
}
