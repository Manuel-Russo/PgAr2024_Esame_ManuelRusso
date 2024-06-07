package logic;

import utility.*;
import presentation.InterfacciaUtente;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static constant.constant.*;

public class GestionePartita {
    private static int numeroGiocatori;
    static ArrayList<Giocatore> giocatori = new ArrayList<>();

    static ArrayList<Carta> mazzoDiPesca = new ArrayList<>();
    static ArrayList<Carta> mazzoScarti = new ArrayList<>();

    static ArrayList<Carta> carteConCopie = new ArrayList<>();
    static ArrayList<Carta> armiConCopie = new ArrayList<>();
    static Random random = new Random();

    public static void start()  {
        GestioneLettura.leggiXML();
        setCopieCarteArmi();

        InterfacciaUtente.stdOutput(LORE);
        numeroGiocatori = InterfacciaUtente.richestaNumeroGiocatori();

        aggiungiGiocatori();
        pescaCartePersonaggi();
        assegnaCarteCasuali();
        while (true)    {
            avvio();
           if (giocatori.size() == 1)   {
               break;
           }
        }
    }

    private static void aggiungiGiocatori()    {
        String[] nomi = InterfacciaUtente.richestaGiocatori();
        int i = 0;
        int contaFuorilegge = 0;
        int contaVice = 0;
        int contaRinnegato = 1;
        int rand;
        switch (numeroGiocatori)    {
            case 3:
                contaFuorilegge = 1;
                break;
            case 4:
                contaFuorilegge = 2;
                break;
            case 5:
                contaFuorilegge = 2;
                contaVice = 1;
                break;
            case 6:
                contaFuorilegge = 3;
                contaVice = 1;
                break;
            case 7:
                contaFuorilegge = 3;
                contaVice = 2;
                break;
        }

        do {
            if (i == 0)     {
                giocatori.addFirst(new Giocatore(nomi[i], Ruolo.SCERIFFO, 5, new ArrayList<>(), new ArrayList<>(),500,0, null));
                i++;
                attesa(400);
                stop();
            }
            else {
                rand = random.nextInt(3);
                if (rand == 0 && contaFuorilegge != 0)  {
                    InterfacciaUtente.stdOutput(nomi[i] + FUORILEGGE);
                    giocatori.addFirst(new Giocatore(nomi[i], Ruolo.FUORILEGGE, 4, new ArrayList<>(), new ArrayList<>(),500,0, null));
                    contaFuorilegge--;
                    i++;
                    attesa(400);
                    stop();
                }
                else if (rand == 1 && contaVice != 0)     {
                    InterfacciaUtente.stdOutput(nomi[i] + VICE);
                    giocatori.addFirst(new Giocatore(nomi[i], Ruolo.VICESCERIFFO, 4, new ArrayList<>(), new ArrayList<>(),500,0, null));
                    contaVice--;
                    i++;
                    attesa(400);
                    stop();
                }
                else if (rand == 2 && contaRinnegato != 0)  {
                    InterfacciaUtente.stdOutput(nomi[i] + RINNEGATO);
                    giocatori.addFirst(new Giocatore(nomi[i], Ruolo.RINNEGATO, 4, new ArrayList<>(), new ArrayList<>(),500,0, null));
                    contaRinnegato--;
                    i++;
                    attesa(400);
                    stop();
                }
            }
        } while (giocatori.size() != numeroGiocatori);
    }

    private static void pescaCartePersonaggi()  {
        Collections.shuffle(GestioneLettura.getPersonaggi());
        for (Giocatore giocatore : giocatori)   {
            giocatore.setPersonaggio(GestioneLettura.getPersonaggi().getFirst());
            InterfacciaUtente.stdOutput(giocatore.getNome() + ESTRATTO_PERSONAGGIO);
            InterfacciaUtente.stdOutput(GestioneLettura.getPersonaggi().getFirst().toString());
            giocatore.setPF(GestioneLettura.getPersonaggi().getFirst().getPf());
            GestioneLettura.getPersonaggi().removeFirst();
            stop();
        }
    }

    private static void setCopieCarteArmi()  {
        for (int i = 0; i < GestioneLettura.getCarte().size(); i++) {
            for (int j = 0; j < GestioneLettura.getCarte().get(i).getCopie().size(); j++) {
                carteConCopie.add(new Carta(GestioneLettura.getCarte().get(i).getNome(), GestioneLettura.getCarte().get(i).isEquipaggiabile(), GestioneLettura.getCarte().get(i).getDesc(), GestioneLettura.getCarte().get(i).getCopie().get(j).getSeme(), GestioneLettura.getCarte().get(i).getCopie().get(j).getValore()));
            }
        }

        for (int i = 0; i < GestioneLettura.getArmi().size(); i++) {
            for (int j = 0; j < GestioneLettura.getArmi().get(i).getCopie().size(); j++) {
                armiConCopie.add(new Arma(GestioneLettura.getArmi().get(i).getNome(), true, null, GestioneLettura.getArmi().get(i).getCopie().get(j).getValore(), GestioneLettura.getArmi().get(i).getCopie().get(j).getSeme(), GestioneLettura.getArmi().get(i).getRangeDiTiro()));
            }
        }

    }

    private static void assegnaCarteCasuali()   {
        int conta = 0;
        mazzoDiPesca.addAll(carteConCopie);
        mazzoDiPesca.addAll(armiConCopie);
        Collections.shuffle(mazzoDiPesca);
        for (Giocatore giocatore : giocatori) {
            do {
                if (mazzoDiPesca.getFirst() instanceof Arma) {
                    giocatore.setArma((Arma) mazzoDiPesca.getFirst());
                    mazzoDiPesca.removeFirst();
                }
                else {
                    giocatore.aggiornaMazzoMano(new Carta(mazzoDiPesca.getFirst().getNome(), mazzoDiPesca.getFirst().isEquipaggiabile(), mazzoDiPesca.getFirst().getDesc(), mazzoDiPesca.getFirst().getSeme(), mazzoDiPesca.getFirst().getValore()));
                    mazzoDiPesca.removeFirst();
                }
                conta++;
            } while (conta < 3);
            isCartaEquipaggiabile(giocatore, giocatore.getMazzo());
        }
    }

    private static void isCartaEquipaggiabile(Giocatore giocatore, ArrayList<Carta> mazzoMano)     {
        for (int i = 0; i < mazzoMano.size(); i++) {
            if (mazzoMano.get(i).isEquipaggiabile())    {
                giocatore.aggiornaMazzoCampo(mazzoMano.get(i));
                mazzoMano.remove(i);
            }
        }
    }

    private static void rimescolaScarti()   {
        if (mazzoDiPesca.isEmpty())   {
            Collections.shuffle(mazzoScarti);
            mazzoDiPesca.addAll(mazzoScarti);
            mazzoScarti.clear();
        }
    }

    private static void avvio()     {
        for (int i = giocatori.size()-1; i >= 0; i--) {
            turno(giocatori.get(i));
        }
    }

    private static void turno(Giocatore giocatore)  {
        int scelta;
        for (int i = 0; i < 2; i++) {
            rimescolaScarti();
            giocatore.aggiornaMazzoMano(mazzoDiPesca.getFirst());
            isCartaEquipaggiabile(giocatore, giocatore.getMazzo());
        }
        System.out.println(giocatore.getMazzo().toString());
        scelta = InterfacciaUtente.scegliCarta(giocatore.getMazzo());
        if (scelta == 1)    {
            System.out.println(giocatore.getMazzo().getFirst().getNome());
            if (giocatore.getMazzo().getFirst().getNome().equals("BANG!"))  {
                scelta = InterfacciaUtente.scegliBersaglio(giocatore , giocatori, giocatore.getArma().getRangeDiTiro());
                System.out.println("Hai attaccato con successo");
            }
            if (giocatore.getMazzo().size() > giocatore.getPF())    {

            }
        }
    }

    public static int calcolaDistanza(Giocatore giocatoreBersaglio, Giocatore giocatoreArmato)    {
        int distanzaBer;
        int distanzaArm;
        int posBer = 0;
        int posArmn = 0;
        for (int i = 0; i < giocatori.size(); i++) {
            if (giocatori.get(i).getNome().equals(giocatoreBersaglio.getNome()))    {
                posBer = i;
            }
            if (giocatori.get(i).getNome().equals(giocatoreArmato.getNome()))   {
                posArmn = i;
            }
        }
        distanzaBer =  posBer - posArmn;
        distanzaArm = posArmn - posBer;
        return Math.min(Math.abs(distanzaBer), Math.abs(distanzaArm));
    }


    /**
     * Permette la creazione del messaggio di "premi qualsiasi tasto per continuare".
     */

    protected static void stop()    {
        InterfacciaUtente.stdOutput(STOP);
        try {
            System.in.read();
        }
        catch (IOException e) {
            System.out.println(ERRORE_INPUT);
        }
    }

    /**
     * <code>attesa</code> permette di visualizzare il delay di tempo tra un comando e l'altro
     */

    protected static void attesa(int tempo)     {
        Object lock = new Object();
        synchronized (lock)     {
            try {
                lock.wait(tempo);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int getNumeroGiocatori() {
        return numeroGiocatori;
    }
}
