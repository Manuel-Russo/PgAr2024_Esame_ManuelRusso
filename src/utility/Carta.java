package utility;

import java.util.ArrayList;

public class Carta {
    private String nome;
    private boolean equipaggiabile;
    private String desc;
    private ArrayList<Copia> copie = new ArrayList<>();
    private String valore;
    private String seme;

    public Carta(String nome, boolean equipaggiabile, String desc, String valore, String seme) {
        this.nome = nome;
        this.equipaggiabile = equipaggiabile;
        this.desc = desc;
        this.valore = valore;
        this.seme = seme;
    }

    public void addCopia(Copia copia) {
        copie.add(copia);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isEquipaggiabile() {
        return equipaggiabile;
    }

    public void setEquipaggiabile(boolean equipaggiabile) {
        this.equipaggiabile = equipaggiabile;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public ArrayList<Copia> getCopie() {
        return copie;
    }

    public void setCopie(ArrayList<Copia> copie) {
        this.copie = copie;
    }

    public String getValore() {
        return valore;
    }

    public void setValore(String valore) {
        this.valore = valore;
    }

    public String getSeme() {
        return seme;
    }

    public void setSeme(String seme) {
        this.seme = seme;
    }

    @Override
    public String toString() {
        return "Carta:" +
                " nome='" + nome + '\'' +
                " equipaggiabile=" + equipaggiabile +
                " desc='" + desc + '\'' +
                " copie=" + copie + "\n\n";
    }
}
