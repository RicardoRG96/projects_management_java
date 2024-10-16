package cl.ricardo.projectManagement.dataAccess.dao;

import java.util.List;

public interface DAO<T, K> {
    
    void insert(T item) throws DAOException;
    void update(T item) throws DAOException;
    void delete(int id) throws DAOException;
    List<T> getAll(String table) throws DAOException;
    T getElement(int id) throws DAOException;
    
}
