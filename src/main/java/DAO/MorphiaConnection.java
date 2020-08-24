package DAO;

import DTO.Institution;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import dev.morphia.Datastore;
import dev.morphia.Morphia;

import java.util.HashSet;

public class MorphiaConnection {
    private static MorphiaConnection instance = new MorphiaConnection();
    private final Datastore handler;
    private final String CONNECTION_STRING = "mongodb+srv://test:test@cluster0.4n5ib.mongodb.net/test?retryWrites=true&w=majority";

    private MorphiaConnection(){
        MongoClientURI uri = new MongoClientURI(CONNECTION_STRING);
        MongoClient mongoClient = new MongoClient(uri);
        HashSet<Class> classes = new HashSet<>();
        classes.add(Institution.class);
        Morphia m = new Morphia(classes);
        handler = m.createDatastore(mongoClient, "test");

    }

    public static Datastore getInstance() {
        return instance.getHandler();
    }

    private Datastore getHandler() {
        return handler;
    }
}
