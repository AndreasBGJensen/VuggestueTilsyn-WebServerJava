import DAO.MorphiaConnection;
import DTO.*;
import dev.morphia.Datastore;
import org.junit.jupiter.api.Test;

public class Test_DAO {

    @Test
    public void TEST_DatabaseConnection(){

        Test_DataStore stupStore = new Test_DataStore();
        Datastore connection = MorphiaConnection.getInstance();


        Institution institution = stupStore.createTilsyn();
        connection.save(institution);


    }
}
