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
    private dataChangedListener listener;

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

    public void notifyListener() {
        if(listener != null) {
            listener.notifyChange();
        }
    }

    public void registerListener(dataChangedListener dataChangedListener) {
        this.listener = dataChangedListener;

    }

    public ArrayList<DeckModel> getRemoteDecks(){
        return mRemoteDecks;
    }

    public ArrayList<DeckModel> getLocalDecks(){
        return mLocalDecks;
    }

    public interface dataChangedListener{
        void notifyChange();
    }
}
