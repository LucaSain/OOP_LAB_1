package Lab_1;

public class SoftwareProduct {
    private String name;
    private String platform;
    private int minRam;
    private int minCPU;

    public SoftwareProduct(String name, String platform, int minRam, String minCPU) throws InvalidCPUException {
        this.name = name;
        this.platform = platform;
        this.minRam = minRam;
        this.minCPU = Computer.parseCPU(minCPU);
    }

    public boolean checkCompatibility(Computer c){
        return c.getRam()>=minRam && c.getCpu()>=minCPU;
    }
}
