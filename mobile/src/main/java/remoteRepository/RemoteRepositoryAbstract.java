package remoteRepository;

import java.util.ArrayList;

import models.DeckModel;

/**
 * Created by Ilya on 5/3/2016.
 */
public abstract class RemoteRepositoryAbstract {

    abstract ArrayList<DeckModel> GetAllDecks();

}
