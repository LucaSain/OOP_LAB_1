package Lab_1;

import java.util.ArrayList;

public class Computer {
    private final int ram;
    private final int cpu;
    private final ArrayList<SoftwareProduct> softwareProducts;

    public Computer(int ram, String cpu) throws InvalidCPUException,InvalidRamException{

        if(ram%2==1){
            throw new InvalidRamException();
        }
        this.ram = ram;
        this.cpu = Computer.parseCPU(cpu);
        this.softwareProducts = new ArrayList<SoftwareProduct>();
    }

    public int getRam() {
        return ram;
    }

    public int getCpu() {
        return cpu;
    }

    public static int parseCPU(String CPU) throws InvalidCPUException{
        if(CPU.length()!=2 || CPU.charAt(0)!='i' || !Computer.isValidCPUNumber((int) CPU.charAt(1) - ((int) '0'))){
            throw new InvalidCPUException();
        }
        return (int) CPU.charAt(1) - ((int) '0');
    }

    private static boolean isValidCPUNumber(int CPU){
        return CPU%2==1 && CPU<=9 && CPU>=3;
    }

   public boolean addProduct(SoftwareProduct sp){
        if(sp.checkCompatibility(this)){
            softwareProducts.add(sp);
            return true;
        }
        System.out.println("Can't add this product because it does not meet the minimum requirements!");
        return false;
   }

}
