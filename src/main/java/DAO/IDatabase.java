package DAO;

import DAO.DatabaseExceptions.DatabaseRetriveContentError;
import DAO.DatabaseExceptions.DatabaseUpdateException;
import DAO.DatabaseExceptions.DatabseDeleteException;
import DTO.Institution;

import java.util.List;
import java.util.Objects;

public interface IDatabase {

    void saveObject(Object object);
    void updateObject(Object object) throws DatabaseUpdateException;
    void deleteObject(Object object) throws DatabseDeleteException;
    Object getObject(Object object);
    List<?> getAllObjecte() throws DatabaseRetriveContentError;


}
