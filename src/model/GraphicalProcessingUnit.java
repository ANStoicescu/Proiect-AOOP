package model;

public class GraphicalProcessingUnit extends Product{
    private String port;
    private int memory;
    private int bandWidth;
    private boolean RGB;
    public GraphicalProcessingUnit(long id, String name, String brand, double price, int stock, String port, int memory, int bandWidth, boolean RGB) {
        super(id, name, brand, price, stock);
        this.port = port;
        this.memory = memory;
        this.bandWidth = bandWidth;
        this.RGB = RGB;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public int getBandWidth() {
        return bandWidth;
    }

    public void setBandWidth(int bandWidth) {
        this.bandWidth = bandWidth;
    }

    public boolean isRGB() {
        return RGB;
    }

    public void setRGB(boolean RGB) {
        this.RGB = RGB;
    }

    @Override
    public String getAttributeNames(){
        return super.getAttributeNames() + "/" + "Port" + "/" + "Memory" + "/" + "BandWidth" + "/" + "RGB";
    }

    @Override
    public String toString(){
        return super.toString() + "/"+ port + "/" + memory + "/" + bandWidth + "/" + RGB;
    }
}
