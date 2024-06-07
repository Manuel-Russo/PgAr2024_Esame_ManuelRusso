package presentation;

import it.kibo.fp.lib.InputData;
import logic.GestioneLettura;
import logic.GestionePartita;
import utility.Carta;
import utility.Giocatore;

import java.util.ArrayList;

import static constant.constant.*;

public class InterfacciaUtente {
    public static int richestaNumeroGiocatori()   {
        int numeroGiocatori;
        numeroGiocatori = InputData.readInteger(INSERISCI_NUMERO_GIOCATORI);
        while (numeroGiocatori < 3 || numeroGiocatori > 7)  {
            System.out.println(NUMERO_GIOCATORI_MASSIMO);
            numeroGiocatori = InputData.readInteger(INSERISCI_NUMERO_GIOCATORI);
        }
        return numeroGiocatori;
    }

    public static String[] richestaGiocatori()   {
        String[] giocatori = new String[GestionePartita.getNumeroGiocatori()];
        for (int i = 0; i < giocatori.length; i++) {
            if (i == 0)     {
                giocatori[i] = InputData.readString(RICHESTA_SCERIFFO, false);
            }
            else    {
                giocatori[i] = InputData.readString("Giocatore " + (i+1) + ", inserisci il tuo nome:\n", false);
            }
        }
        return  giocatori;
    }

    public static void stdOutput(String stringa)   {
        System.out.println(stringa);
    }

    public static void stampaGiocatori(ArrayList<Giocatore> giocatori)  {
        System.out.println(giocatori.toString());
    }

    public static int scegliCarta(ArrayList<Carta> mazzo)  {
        int scelta;
        for (Carta carta : mazzo) {
            if (!carta.getNome().equals("Mancato!")) {
                System.out.println(carta);
            }
        }
        scelta = InputData.readInteger("Inserisci il numero della carta che vuoi usare");
        return scelta;
    }

    public static int scegliBersaglio(Giocatore giocatore, ArrayList<Giocatore> giocatori, int range)     {
        int scelta;
        for (Giocatore value : giocatori) {
            if (GestionePartita.calcolaDistanza(value, giocatore) <= range) {
                System.out.println(value);
            }
        }
        scelta = InputData.readInteger("Scegli il giocatore da attaccare");
        return scelta;
    }
}
