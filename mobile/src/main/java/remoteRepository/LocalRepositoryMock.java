package remoteRepository;

import java.util.ArrayList;

import models.CardModel;
import models.DeckModel;

/**
 * Created by Ilya on 5/3/2016.
 */
public class LocalRepositoryMock extends RemoteRepositoryAbstract {

    private static final String MY_NEW_DECK = "My new deck";

    private static final String[] DECKS =  {MY_NEW_DECK};

    @Override
    public ArrayList<DeckModel> GetAllDecks() {
        ArrayList<DeckModel> decks = new ArrayList<>();

        for (int i =0 ; i< DECKS.length ; i++) {
            decks.add(createDeck(DECKS[i], i));
        }

        return decks;
    }

    private DeckModel createDeck(String name, int id){

        DeckModel deck = new DeckModel(id, name, null);
        ArrayList<CardModel> cards = new ArrayList<>();
        deck.setCards(cards);

        return deck;
    }
}
