package utility;

import java.util.ArrayList;

public class Arma extends Carta     {
    private int rangeDiTiro;
    private ArrayList<Copia> copie = new ArrayList<>();

    public Arma(String nome, boolean equipaggiabile, String desc, String valore, String seme, int rangeDiTiro) {
        super(nome, equipaggiabile, desc, valore, seme);
        this.rangeDiTiro = rangeDiTiro;
    }

    public void addCopia(Copia copia) {
        copie.add(copia);
    }

    public int getRangeDiTiro() {
        return rangeDiTiro;
    }

    public void setRangeDiTiro(int rangeDiTiro) {
        this.rangeDiTiro = rangeDiTiro;
    }

    public ArrayList<Copia> getCopie() {
        return copie;
    }

    public void setCopie(ArrayList<Copia> copie) {
        this.copie = copie;
    }

    @Override
    public String getNome() {
        return super.getNome();
    }

    @Override
    public String toString() {
        return "Arma:" +
                " rangeDiTiro = " + rangeDiTiro +
                " copie = " + copie + "\n\n";
    }
}
