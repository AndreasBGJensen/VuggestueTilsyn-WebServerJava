package DAO;

import DAO.DatabaseExceptions.DatabaseRetriveContentError;
import DAO.DatabaseExceptions.DatabaseUpdateException;
import DAO.DatabaseExceptions.DatabseDeleteException;
import DTO.Institution;

import java.util.List;
import java.util.Objects;

public interface IDatabase {

    public void saveObject(Object object);
    public void updateObject(Object object) throws DatabaseUpdateException;
    public void deleteObject(Object object) throws DatabseDeleteException;
    public Object getObject(Object object);
    public List<?> getAllObjecte() throws DatabaseRetriveContentError;


}
