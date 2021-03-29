package model;

public class CentralProcessingUnit extends Product {
    private String socket;
    private int frequency;
    private int cores;
    private int threadsPerCore;

    public CentralProcessingUnit(long id, String name, String brand, double price, int stock, String socket, int frequency, int cores, int threadsPerCore) {
        super(id, name, brand, price, stock);
        this.socket = socket;
        this.frequency = frequency;
        this.cores = cores;
        this.threadsPerCore = threadsPerCore;
    }

    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public int getCores() {
        return cores;
    }

    public void setCores(int cores) {
        this.cores = cores;
    }

    public int getThreadsPerCore() {
        return threadsPerCore;
    }

    public void setThreadsPerCore(int threadsPerCore) {
        this.threadsPerCore = threadsPerCore;
    }

    @Override
    public String getAttributeNames() {
        return super.getAttributeNames() + "/" + "Socket" + "/" + "Frequency" + "/" + "Cores" + "/" + "Threads";
    }

    @Override
    public String toString() {
        return super.toString() + "/" + socket + "/" + frequency + "/" + cores + "/" + threadsPerCore * cores;
    }
}
