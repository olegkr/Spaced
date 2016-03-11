package remoteRepository;

import android.graphics.Bitmap;

import java.util.ArrayList;

import models.CardModel;
import models.DeckModel;

/**
 * Created by Ilya on 5/3/2016.
 */
public class RemoteRepositoryMock extends RemoteRepositoryAbstract {

    private static final String SPANISH_FOR_BEGINNERS = "Spanish for Beginners";
    private static final String SPANISH_FOR_ADVANCED = "Spanish for Advanced";
    private static final String ISRAEL_IMPORTANT_DATES = "Israel Important Dates";
    private static final String EUROPE_CAPITAL_CITIES = "Europe Least Known Capitals";
    private static final String PSYCHOMETRIC_TEST = "psychometric test";
    private static final String SOLAR_SYSTEM = "Solar System";
    private static final String CLASSIC_COMPOSERS = "Classic composers";
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
                    PSYCHOMETRIC_TEST, SOLAR_SYSTEM, CLASSIC_COMPOSERS, TBD4, TBD5, TBD6, TBD7, TBD8};

    @Override
    public ArrayList<DeckModel> GetAllDecks() {
        ArrayList<DeckModel> decks = new ArrayList<>();

        for (int i =0 ; i< DECKS.length ; i++) {
            decks.add(createDeck(DECKS[i], i));
        }

        return decks;
    }

    Bitmap _bitmap;
    private DeckModel createDeck(String name, int id){

        ArrayList<CardModel> cards = new ArrayList<>();

        int i = 0;
        String imageUrl = "http://eagle.phys.utk.edu/guidry/android/figs/androidLogos/free-large-android256.jpg";

        switch (name) {
            case SPANISH_FOR_BEGINNERS:
                imageUrl = "http://www.ceelechile.org/images/Spain%20Flag.png";
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
                imageUrl = "http://www.ceelechile.org/images/Spain%20Flag.png";
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
                imageUrl = "https://myimeiunlock.com/wp-content/uploads/2012/10/Israel-iPhone-IMEI-Factory-Unlock.png";
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
                imageUrl = "https://professionalxen.com/minecraft/img/slide/servers/euicon.gif";
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

            case PSYCHOMETRIC_TEST:
                imageUrl = "https://cdn4.iconfinder.com/data/icons/ballicons-2-new-generation-of-flat-icons/100/brain-128.png";
                break;

            case SOLAR_SYSTEM:
                imageUrl = "http://icons.iconarchive.com/icons/dan-wiersma/solar-system/256/Saturn-icon.png";
                break;

            case CLASSIC_COMPOSERS:
                    imageUrl = "http://www.fluteworld.com/products/midifiles/play_music-icon.gif";
                break;



        }

        DeckModel deck = new DeckModel(id, name, _bitmap, imageUrl);
        deck.setCards(cards);

        return deck;


    }
}
