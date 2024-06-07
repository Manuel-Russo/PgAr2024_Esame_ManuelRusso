package logic;

import utility.Arma;
import utility.Carta;
import utility.Copia;
import utility.Personaggio;

import javax.xml.stream.*;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static constant.constant.*;

public class GestioneLettura {
    private static final List<Personaggio> personaggi = new ArrayList<>();
    private static final List<Arma> armi = new ArrayList<>();
    private static final List<Carta> carte = new ArrayList<>();

    public static void leggiXML()   {

        try {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLStreamReader reader = factory.createXMLStreamReader(new FileInputStream(FILE_XML));

            String currentElement = "";
            Personaggio personaggio = null;
            Arma arma = null;
            Carta carta = null;
            Copia copia = null;

            while (reader.hasNext()) {
                int event = reader.next();

                switch (event) {
                    case XMLStreamConstants.START_ELEMENT:
                        currentElement = reader.getLocalName();
                        switch (currentElement) {
                            case "personaggio":
                                personaggio = new Personaggio(Integer.parseInt(reader.getAttributeValue(null, "pf")), "", "");
                                break;
                            case "arma":
                                arma = new Arma("", true, null, null, null, 0);
                                break;
                            case "carta":
                                carta = new Carta("", Boolean.parseBoolean(reader.getAttributeValue(null, "equipaggiabile")), "", "" , "");
                                break;
                            case "copia":
                                copia = new Copia("", "");
                                break;
                        }
                        break;

                    case XMLStreamConstants.CHARACTERS:
                        String data = reader.getText().trim();
                        if (!data.isEmpty()) {
                            switch (currentElement) {
                                case "nome":
                                    if (personaggio != null) personaggio.setNome(data);
                                    else if (arma != null) arma.setNome(data);
                                    else if (carta != null) carta.setNome(data);
                                    break;
                                case "descrizione":
                                    if (personaggio != null) personaggio.setDesc(data);
                                    else if (carta != null) carta.setDesc(data);
                                    break;
                                case "distanza":
                                    if (arma != null) arma.setRangeDiTiro(Integer.parseInt(data));
                                    break;
                                case "valore":
                                    if (copia != null) copia.setValore(data);
                                    break;
                                case "seme":
                                    if (copia != null) copia.setSeme(data);
                                    break;
                            }
                        }
                        break;

                    case XMLStreamConstants.END_ELEMENT:
                        switch (reader.getLocalName()) {
                            case "personaggio":
                                personaggi.add(personaggio);
                                personaggio = null;
                                break;
                            case "arma":
                                armi.add(arma);
                                arma = null;
                                break;
                            case "carta":
                                carte.add(carta);
                                carta = null;
                                break;
                            case "copia":
                                if (arma != null) arma.addCopia(copia);
                                else if (carta != null) carta.addCopia(copia);
                                copia = null;
                                break;
                        }
                        currentElement = "";
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }

    public static List<Personaggio> getPersonaggi() {
        return personaggi;
    }

    public static List<Arma> getArmi() {
        return armi;
    }

    public static List<Carta> getCarte() {
        return carte;
    }
}