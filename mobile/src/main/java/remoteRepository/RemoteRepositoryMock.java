package remoteRepository;

import java.util.ArrayList;

import models.CardModel;
import models.DeckModel;

/**
 * Created by Ilya on 5/3/2016.
 */
public class RemoteRepositoryMock extends RemoteRepositoryAbstract {

    private static final String SPANISH_FOR_BEGINNERS = "Spanish for beginners";
    private static final String SPANISH_FOR_ADVANCED = "Spanish for advanced";
    private static final String ISRAEL_IMPORTANT_DATES = "Israel important dates";
    private static final String EUROPE_CAPITAL_CITIES = "Europe least known capitals";
    private static final String TBD1 = "TBD1";
    private static final String TBD2 = "TBD2";
    private static final String TBD3 = "TBD3";
    private static final String TBD4 = "TBD4";
    private static final String TBD5 = "TBD5";
    private static final String TBD6 = "TBD6";
    private static final String TBD7 = "TBD7";
    private static final String TBD8 = "TBD8";

    private static final String[] DECKS =
            {SPANISH_FOR_BEGINNERS, SPANISH_FOR_ADVANCED,
                    ISRAEL_IMPORTANT_DATES, EUROPE_CAPITAL_CITIES,
                    TBD1, TBD2, TBD3, TBD4, TBD5, TBD6, TBD7, TBD8};

    @Override
    public ArrayList<DeckModel> GetAllDecks() {
        ArrayList<DeckModel> decks = new ArrayList<>();

        for (int i =0 ; i< DECKS.length ; i++) {
            decks.add(createDeck(DECKS[i], i));
        }

        return decks;
    }

    private DeckModel createDeck(String name, int id){

        DeckModel deck = new DeckModel(id, name, false);
        ArrayList<CardModel> cards = new ArrayList<>();
        deck.setCards(cards);

        int i = 0;

        switch (name) {
            case SPANISH_FOR_BEGINNERS:
                cards.add(new CardModel(i++, "Good morning", "Buenos días"));
                cards.add(new CardModel(i++, "Good afternoon", "Buenas tardes"));
                cards.add(new CardModel(i++, "Good evening", "Buenas noches"));
                cards.add(new CardModel(i++, "Hello, my name is John", "Hola, me llamo Juan"));
                cards.add(new CardModel(i++, "What is your name?", "¿Cómo se llama usted?"));
                cards.add(new CardModel(i++, "How are you?", "¿Cómo está usted?"));
                cards.add(new CardModel(i++, "I am fine", "Estoy bien."));
                cards.add(new CardModel(i++, "Nice to meet you", "Mucho gusto"));
                cards.add(new CardModel(i++, "Goodbye", "Adiós"));
                cards.add(new CardModel(i++, "See you later", "Hasta luego"));
                cards.add(new CardModel(i++, "Please", "Por favor"));
                cards.add(new CardModel(i++, "Thank you", "Gracías"));
                cards.add(new CardModel(i++, "I'm sorry", "Lo siento"));
                cards.add(new CardModel(i++, "Bless you", "Salud"));
                break;

            case SPANISH_FOR_ADVANCED:
                cards.add(new CardModel(i++, "Similar", "Semejante"));
                cards.add(new CardModel(i++, "Available", "Dispuesto"));
                cards.add(new CardModel(i++, "Strike", "Huelga"));
                cards.add(new CardModel(i++, "Rate", "Tasa"));
                cards.add(new CardModel(i++, "Character", "Personaje"));
                cards.add(new CardModel(i++, "Cast", "Elenco"));
                cards.add(new CardModel(i++, "Bottom", "Fondo"));
                cards.add(new CardModel(i++, "Barely", "Apenas"));
                cards.add(new CardModel(i++, "I hope so", "Ojalá"));
                cards.add(new CardModel(i++, "Purpose", "Propósito"));
                break;

            case ISRAEL_IMPORTANT_DATES:
                cards.add(new CardModel(i++, "Theodor Herzl had formed a Zionist Movement", "1 Jan 1880"));
                cards.add(new CardModel(i++, "TLV Android Academy meetup foundation date", "15 March 2014"));
                cards.add(new CardModel(i++, "The British took control of Palestine", "11 Nov 1918"));
                cards.add(new CardModel(i++, "Israel's supervision is given to the United Nations", "14 Feb 1947"));
                cards.add(new CardModel(i++, "Opening of the First Zionist Congress at Basel, Switzerland", "August 29, 1897"));
                cards.add(new CardModel(i++, "Declaration of the State of Israel", "May 14, 1948"));
                cards.add(new CardModel(i++, "Israel’s first national elections", "January 25, 1949"));
                cards.add(new CardModel(i++, "A start of the Six Day War", "June 5, 1967"));
                cards.add(new CardModel(i++, "Assassination of Prime Minister Yitzhak Rabin", "November 4, 1995"));
                cards.add(new CardModel(i++, "Camp David Summit", "July 11, 2000"));

                break;

            case EUROPE_CAPITAL_CITIES:
                cards.add(new CardModel(i++, "Macedonia", "Skopje"));
                cards.add(new CardModel(i++, "Malta", "Valletta"));
                cards.add(new CardModel(i++, "Montenegro", "Podgorica"));
                cards.add(new CardModel(i++, "Slovenia", "Ljubljana"));
                cards.add(new CardModel(i++, "Iceland", "Reykjavik"));
                cards.add(new CardModel(i++, "Kosovo", "Pristina"));
                cards.add(new CardModel(i++, "San Marino", "San Marino"));
                cards.add(new CardModel(i++, "Cyprus", "Nicosia"));
                cards.add(new CardModel(i++, "Moldova", "Chisinau"));
                cards.add(new CardModel(i++, "Albania", "Tirana"));
                cards.add(new CardModel(i++, "Liechtenstein", "Vaduz"));
                cards.add(new CardModel(i++, "Monaco", "Monaco"));
                cards.add(new CardModel(i++, "Andorra", "Andorra la Vella"));
                cards.add(new CardModel(i++, "Slovakia", "Bratislava"));
                cards.add(new CardModel(i++, "Kazakhstan", "Astana"));
                break;
        }

        return deck;


    }
}
