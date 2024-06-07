package utility;

public class Personaggio {
    int pf;
    String nome;
    String desc;

    public Personaggio(int pf, String nome, String desc) {
        this.pf = pf;
        this.nome = nome;
        this.desc = desc;
    }

    public int getPf() {
        return pf;
    }

    public void setPf(int pf) {
        this.pf = pf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Personaggio:" + "\n" +
                "nome: " + nome + "\n" +
                "Punti Forza: " + pf + "\n" +
                "Descrizione del personaggio: '" + desc + "\n\n";
    }
}
