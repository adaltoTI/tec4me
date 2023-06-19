package classes;

public class Pessoa{

    protected String nome;
    protected String cpf;

    public Pessoa(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }
    
    public void setCpf(String cpf) throws Exception {
        if (cpf.length() != 11) {
            throw new Exception("CPF tem que ter 11 carateres.");
            
        }
        for(int i = 0; i < 11; i++) {
            if (!Character.isDigit(cpf.charAt(i))){
                throw new Exception("CPF precisa ser formado apenas por digitos.");
            }
        }
        this.cpf = cpf;
    }

}