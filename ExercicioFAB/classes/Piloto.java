package classes;
import classes.Pessoa;

public class Piloto extends Pessoa {

    private String breve;

    public Piloto(String nome, String cpf, String breve) {
        super(nome, cpf);
        this.breve = breve;
    }

    @Override
    public String toString() {
        return "Piloto [Nome: " + nome +  ", CPF: " + cpf +  ", breve: " + breve + "]";
    }

    public String getBreve() {
        return breve;
    }

    public void setBreve(String breve) {
        this.breve = breve;
    }

}