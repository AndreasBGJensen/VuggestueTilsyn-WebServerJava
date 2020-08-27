import DAO.DatabaseExceptions.DatabaseRetriveContentError;
import DAO.DatabaseExceptions.DatabaseUpdateException;
import DAO.DatabaseExceptions.DatabseDeleteException;
import DAO.MongoDAO;
import DAO.MorphiaConnection;
import DTO.*;
import dev.morphia.Datastore;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Test_DAO {
MongoDAO databaseDAO = new MongoDAO();

    @Test
    public void TEST_DatabaseConnection(){
        Datastore connection = MorphiaConnection.getInstance();
        assert(connection.getDatabase().getName()!=null);


    }

    @Test
    public void TEST_DatabaseSave(){
        Test_DataStore stupStore = new Test_DataStore();
        Datastore connection = MorphiaConnection.getInstance();
        Institution institution = stupStore.createTilsyn();
        databaseDAO.saveObject(institution);

        Institution returnInstitution = connection.createQuery(Institution.class).field("name").equal(institution.getName()).first();

        assertEquals(institution.getName(),returnInstitution.getName());
        assertEquals(institution.getVenteliste(),returnInstitution.getVenteliste());
        assertEquals(institution.getWebpage(),returnInstitution.getWebpage());
        assertEquals(institution.getTilsyn().getForældresamarbejde().getAnbefaling(),returnInstitution.getTilsyn().getForældresamarbejde().getAnbefaling());
    }

    @Test
    public void TEST_DatabaseDelete() throws DatabseDeleteException {
        Test_DataStore stupStore = new Test_DataStore();
        Datastore connection = MorphiaConnection.getInstance();
        Institution institution = stupStore.createTilsyn();
        databaseDAO.deleteObject(institution);

        Institution returnInstitution = connection.createQuery(Institution.class).field("name").equal(institution.getName()).first();

        assertEquals(null,returnInstitution);
    }

    @Test
    public void TEST_DatabaseUpdate() throws DatabaseUpdateException {
        Test_DataStore stupStore = new Test_DataStore();
        Datastore connection = MorphiaConnection.getInstance();
        Institution institution = stupStore.createTilsyn();
        connection.save(institution);

        //Testing that "venteliste" field will be updated
        Institution newUpdatedInstitution = institution;
        newUpdatedInstitution.setVenteliste(999);
        //Testing that indsats will be updated
        newUpdatedInstitution.getTilsyn().getKravOmReflektion().setIndsats("Changed according to test");
        databaseDAO.updateObject(newUpdatedInstitution);

        Institution returnInstitution = connection.createQuery(Institution.class).field("name").equal(institution.getName()).first();

        assertEquals(999,returnInstitution.getVenteliste());
        assertEquals(newUpdatedInstitution.getVenteliste(),returnInstitution.getVenteliste());
        assertEquals("Changed according to test",returnInstitution.getTilsyn().getKravOmReflektion().getIndsats());

    }


    @Test
    public void TEST_GetAllObjectsFromDatabase() throws DatabaseRetriveContentError {
        //Deleting all records in the database
        Datastore connection = MorphiaConnection.getInstance();
        connection.delete(connection.createQuery(Institution.class));

        Test_DataStore stupStore = new Test_DataStore();

        List<Institution> listOfInstitutionToSave = stupStore.getListOfInstitutions(20);

        for (int i = 0; i<listOfInstitutionToSave.size();i++){
            connection.save(listOfInstitutionToSave.get(i));
        }

        assertEquals(listOfInstitutionToSave.size(),databaseDAO.getAllObjecte().size());

    }

}
