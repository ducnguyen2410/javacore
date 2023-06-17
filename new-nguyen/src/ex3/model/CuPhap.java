package ex3.model;

public class CuPhap {
    public String cuPhap;
    public String noiDung;
    public CuPhap(String cuPhap, String noiDung)
    {
        this.cuPhap = cuPhap;
        this.noiDung = noiDung;
    }

    public void printCuPhap(CuPhap newCuPhap)
    {
        System.out.println("Cu phap: " + newCuPhap.cuPhap);
        System.out.println("Noi dung: " + newCuPhap.noiDung);
        System.out.println();
    }
}
