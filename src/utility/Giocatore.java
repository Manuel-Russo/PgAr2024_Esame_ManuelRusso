package utility;

import java.util.ArrayList;
import java.util.Arrays;

public class Giocatore  {
    String nome;
    Ruolo ruolo;
    int PF;
    ArrayList<Carta> mazzo = new ArrayList<>();
    ArrayList<Carta> campoEquipaggiabili = new ArrayList<>();
    Arma arma;
    int sbeuri;
    int partiteGiocate;
    Personaggio personaggio;

    public Giocatore(String nome, Ruolo ruolo, int PF, ArrayList<Carta> mazzo, ArrayList<Carta> campoEquipaggiabili, int sbeuri, int partiteGiocate, Personaggio personaggio) {
        this.nome = nome;
        this.ruolo = ruolo;
        this.PF = PF;
        this.mazzo = mazzo;
        this.campoEquipaggiabili = campoEquipaggiabili;
        this.arma = new Arma("colt. 45", true, null, null, null, 1);
        this.sbeuri = sbeuri;
        this.partiteGiocate = partiteGiocate;
        this.personaggio = personaggio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Ruolo getRuolo() {
        return ruolo;
    }

    public void setRuolo(Ruolo ruolo) {
        this.ruolo = ruolo;
    }

    public int getPF() {
        return PF;
    }

    public void setPF(int PF) {
        this.PF = PF;
    }

    public Arma getArma() {
        return arma;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }

    public int getSbeuri() {
        return sbeuri;
    }

    public void setSbeuri(int sbeuri) {
        this.sbeuri = sbeuri;
    }

    public int getPartiteGiocate() {
        return partiteGiocate;
    }

    public void setPartiteGiocate(int partiteGiocate) {
        this.partiteGiocate = partiteGiocate;
    }

    public Personaggio getPersonaggio() {
        return personaggio;
    }

    public void setPersonaggio(Personaggio personaggio) {
        this.personaggio = personaggio;
    }

    public void aggiornaMazzoMano(Carta cartaDaAggiungere)     {
        mazzo.add(cartaDaAggiungere);
    }

    public void aggiornaMazzoCampo(Carta cartaDaAggiungere)     {
        campoEquipaggiabili.add(cartaDaAggiungere);
    }

    public ArrayList<Carta> getMazzo() {
        return mazzo;
    }

    public ArrayList<Carta> getCampoEquipaggiabili() {
        return campoEquipaggiabili;
    }

    @Override
    public String toString() {
        return "Giocatore:" +
                " nome = '" + nome + '\'' +
                " ruolo = " + ruolo +
                " PF = " + PF +
                " mazzo = " + mazzo.toString() +
                " arma = " + arma +
                " sbeuri = " + sbeuri +
                " partiteGiocate = " + partiteGiocate + "\n\n";
    }
}
