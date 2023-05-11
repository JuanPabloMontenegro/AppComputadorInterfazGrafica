public class Computador{
    private String procesador;
    private String grafica;
    private int ram;
    
    public Computador(String procesador, String grafica, int ram) {
        this.procesador = procesador;
        this.grafica = grafica;
        this.ram = ram;
    }
    
    public String getProcesador() {
        return procesador;
    }
    
    public String getGrafica() {
        return grafica;
    }
    
    public int getRam() {
        return ram;
    }
}