package constant;

import it.kibo.fp.lib.AnsiColors;

public class constant {
    public final static String CNV = AnsiColors.RED + "Il comando inserito non è valido" + AnsiColors.RESET;
    public final static String STOP = AnsiColors.BLUE + "Premi un tasto per continuare" + AnsiColors.RESET;
    public final static String GAME_OVER = """
                      ######      ###    ##     ## ########     #######  ##     ## ######## ######## \s
                     ##    ##    ## ##   ###   ### ##          ##     ## ##     ## ##       ##     ##\s
                     ##         ##   ##  #### #### ##          ##     ## ##     ## ##       ##     ##\s
                     ##   #### ##     ## ## ### ## ######      ##     ## ##     ## ######   ######## \s
                     ##    ##  ######### ##     ## ##          ##     ##  ##   ##  ##       ##   ##  \s
                     ##    ##  ##     ## ##     ## ##          ##     ##   ## ##   ##       ##    ## \s
                      ######   ##     ## ##     ## ########     #######     ###    ######## ##     ##\s
            """;


    public static final String LORE = "";

    public static final String INSERISCI_NUMERO_GIOCATORI = """
            Inserisci il numero di giocatori con cui vuoi giocare:
            """;
    public static final String NUMERO_GIOCATORI_MASSIMO = """
            Il numero di giocatori deve essere compreso tra 3 e 7.
            """;

    public static final String RICHESTA_SCERIFFO = """
            Giocatore 1, tu sarai lo sceiffo della città!
            inserisci il tuo nome:
            """;

    public static final String ESTRATTO_PERSONAGGIO = """
             in questa partita prederai le vesti di:
            """;
    public static final String FUORILEGGE = """
             in questa partita tu sarai il fuorilegge.
            Non comunicare a nessuno il tuo ruolo!
            """;
    public static final String VICE = """
             in questa partita tu sarai il vicesceriffo.
            Non comunicare a nessuno il tuo ruolo!
            """;
    public static final String RINNEGATO = """
             in questa partita tu sarai il rinnegato.
            Non comunicare a nessuno il tuo ruolo!
            """;

    public final static String ERRORE_READER = "Errore rilevato nell'inizializzazione del reader.";
    public final static String ERRORE_SCRITTURA = "Errore rilevato durante la scrittura";
    public final static String ERRORE_WRITER = "Errore rilevato nell'inizializzazione del writer";
    public final static String ERRORE_INPUT = "Errore rilevato nell'input";

    public final static String FILE_XML = "src/source_file/listaCarte.xml";
}
