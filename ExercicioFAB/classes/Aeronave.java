package classes;
import classes.Piloto;

public class Aeronave{

    private String modelo;
    private String numeroSerie;
    private Piloto piloto;

    public Aeronave(String modelo, String numeroSerie, Piloto piloto) {
        this.modelo = modelo;
        this.numeroSerie = numeroSerie;
        this.piloto = piloto;
    }

    @Override
    public String toString() {
        return "Aeronave [modelo=" + modelo + ", numeroSerie=" + numeroSerie + ",  Piloto=" + piloto + "]";
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }
}
