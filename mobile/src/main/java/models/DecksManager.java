package models;

import java.util.ArrayList;

import remoteRepository.LocalRepositoryMock;
import remoteRepository.RemoteRepositoryMock;

/**
 * Created by Ilya on 10/3/2016.
 */
public class DecksManager {

    private static DecksManager instance;
    private ArrayList<DeckModel> mRemoteDecks;
    private ArrayList<DeckModel> mLocalDecks;

    private DecksManager() {
        mRemoteDecks = new RemoteRepositoryMock().GetAllDecks();
        mLocalDecks = new LocalRepositoryMock().GetAllDecks();
    }

    public static DecksManager getInstance(){
        if(instance == null) {
            instance = new DecksManager();
        }
        return instance;
    }

    public ArrayList<DeckModel> getRemoteDecks(){
        return mRemoteDecks;
    }

    public ArrayList<DeckModel> getLocalDecks(){
        return mLocalDecks;
    }
}
