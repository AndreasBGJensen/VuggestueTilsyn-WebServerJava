package DAO;

import DAO.DatabaseExceptions.DatabaseRetriveContentError;
import DAO.DatabaseExceptions.DatabaseUpdateException;
import DAO.DatabaseExceptions.DatabseDeleteException;
import DTO.Institution;
import com.mongodb.WriteResult;
import dev.morphia.Datastore;
import dev.morphia.query.Query;
import dev.morphia.query.UpdateOperations;
import dev.morphia.query.UpdateResults;

import java.util.List;

public class MongoDAO implements IDatabase {
    private Datastore connection = MorphiaConnection.getInstance();


    @Override
    public void saveObject(Object object) {

        connection.save((Institution)object);
    }

    @Override
    public void updateObject(Object object) throws DatabaseUpdateException {
        Institution institution = (Institution) object;
        Query query = connection.createQuery(Institution.class).field("name").equal(institution.getName());
        UpdateOperations<Institution> operation = connection.createUpdateOperations(Institution.class)
                .set("venteliste",institution.getVenteliste())
                .set("homepage",institution.getWebpage())
                .set("periodiskTilsyn",institution.getTilsyn());
        UpdateResults result = connection.update(query,operation);

        if(!result.getUpdatedExisting()){
            throw new DatabaseUpdateException("Were unable to update database for: " + institution.getName());
        }

    }

    @Override
    public void deleteObject(Object object) throws DatabseDeleteException {
        Institution institution = (Institution) object;
        Query query = connection.createQuery(Institution.class).field("name").equal(institution.getName());
        WriteResult result = connection.delete(query);

        if(!result.wasAcknowledged()){
            throw new DatabseDeleteException("Were unable to delete the query");
        }


    }

    @Override
    public Institution getObject(Object object) {
        return null;
    }

    @Override
    public List<?> getAllObjecte() throws DatabaseRetriveContentError {

        List<Institution> returnList = connection.createQuery(Institution.class).find().toList();

        if(returnList.isEmpty()){
            throw new DatabaseRetriveContentError("Not able to fetch any data form the database");
        }


        return returnList;

    }
}
