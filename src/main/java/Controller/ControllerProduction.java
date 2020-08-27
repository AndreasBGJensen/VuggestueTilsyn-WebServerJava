package Controller;

import DAO.DatabaseExceptions.DatabaseUpdateException;
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

    }

    @Override
    public void updateObject(Object object) throws DatabaseUpdateException {

    }

    @Override
    public void deleteObject(Object object) {

    }

    @Override
    public Object getObject(Object object) {
        return null;
    }

    @Override
    public List<Objects> getAllObjecte() {
        return null;
    }
}
