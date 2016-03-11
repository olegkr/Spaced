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

    ArrayList<DeckModel> decks = new ArrayList<>();

    @Override
    public ArrayList<DeckModel> GetAllDecks() {
        return decks;
    }

    public void addDeck(ArrayList<DeckModel> decks) {
        this.decks = decks;
    }

    public DeckModel createDeck(String name, int id){
        DeckModel deck = new DeckModel(id, name, null, null);
        ArrayList<CardModel> cards = new ArrayList<>();
        deck.setCards(cards);

        return deck;
    }
}
