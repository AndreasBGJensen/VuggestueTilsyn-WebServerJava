package Controller;


import DAO.DatabaseExceptions.DatabaseRetriveContentError;
import DAO.DatabaseExceptions.DatabaseUpdateException;
import DAO.DatabaseExceptions.DatabseDeleteException;
import DAO.IDatabase;

import java.util.List;

public abstract class Controller implements IDatabase {

    @Override
    public void saveObject(Object object) {

    }

    @Override
    public void updateObject(Object object) throws DatabaseUpdateException {

    }

    @Override
    public void deleteObject(Object object) throws DatabseDeleteException {

    }

    @Override
    public Object getObject(Object object) {
        return null;
    }

    @Override
    public List<?> getAllObjecte() throws DatabaseRetriveContentError {
        return null;
    }
}
