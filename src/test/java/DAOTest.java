import DAO.MorphiaConnection;
import DTO.Tilsyn.AbstractTilsyn;
import DTO.*;
import dev.morphia.Datastore;
import org.junit.jupiter.api.Test;

import java.util.List;

public class DAOTest {

    @Test
    public void TEST_DatabaseConnection(){

        DataStoreForTesting stupStore = new DataStoreForTesting();
        Datastore connection = MorphiaConnection.getInstance();


        Institution institution = stupStore.createTilsyn();
        connection.save(institution);




    }
}
