package Controller;

import DAO.DatabaseExceptions.DatabaseRetriveContentError;
import DAO.DatabaseExceptions.DatabaseUpdateException;
import DAO.DatabaseExceptions.DatabseDeleteException;
import DAO.IDatabase;
import DAO.MongoDAO;
import DTO.Institution;

import java.util.List;
import java.util.Objects;

public class ControllerProduction extends Controller implements IDatabase {
    private IDatabase database = null;

    public ControllerProduction(IDatabase database) {
    this.database = database;
    }

    @Override
    public void saveObject(Object object) {
        database.saveObject(object);
    }

    @Override
    public void updateObject(Object object) throws DatabaseUpdateException {
        database.updateObject(object);
    }

    @Override
    public void deleteObject(Object object) throws DatabseDeleteException {
        database.deleteObject(object);
    }

    @Override
    public Object getObject(Object object) {
        return null;
    }

    @Override
    public List<?> getAllObjecte() throws DatabaseRetriveContentError {
        return database.getAllObjecte();
    }
}
