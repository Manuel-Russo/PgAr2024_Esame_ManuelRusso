package utility;

public class Copia {
    String valore;
    String seme;

    public Copia(String valore, String seme) {
        this.valore = valore;
        this.seme = seme;
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
        return "Copia: " +
                " valore = '" + valore + '\'' +
                " seme = '" + seme + '\'' + "\n\n";
    }
}
