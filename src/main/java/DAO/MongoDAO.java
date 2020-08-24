package DAO;

import DTO.Institution;
import dev.morphia.Datastore;

public class MongoDAO {
    private Datastore connection = MorphiaConnection.getInstance();


    public void SaveInstitution(Institution institution){
        connection.save(institution);
    }
}
