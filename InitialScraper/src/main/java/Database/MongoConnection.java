package Database;
import DTO.DistrictDTO;
import DTO.Districts;
import DTO.URL_DTO;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import dev.morphia.Datastore;
import dev.morphia.Morphia;

import java.util.HashSet;


    public class MongoConnection {
        private static MongoConnection instance = new MongoConnection();
        private final Datastore handler;
        private final String CONNECTION_STRING = "mongodb+srv://test:test@cluster0.4n5ib.mongodb.net/test?retryWrites=true&w=majority";

        private MongoConnection(){
            MongoClientURI uri = new MongoClientURI(CONNECTION_STRING);
            MongoClient mongoClient = new MongoClient(uri);
            HashSet<Class> classes = new HashSet<>();
            classes.add(DistrictDTO.class);
            classes.add(Districts.class);
            Morphia m = new Morphia(classes);
            handler = m.createDatastore(mongoClient, "testDatabaseForScrapeTesting");

        }

        public static Datastore getInstance() {
            return instance.getHandler();
        }

        private Datastore getHandler() {
            return handler;
        }
    }


