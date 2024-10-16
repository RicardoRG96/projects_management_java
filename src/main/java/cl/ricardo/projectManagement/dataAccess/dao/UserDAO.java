package cl.ricardo.projectManagement.dataAccess.dao;

import cl.ricardo.projectManagement.dataAccess.User;
import java.util.List;

public interface UserDAO extends DAO<User, Integer> {
    
    @Override
    public void insert(User item) throws DAOException;

    @Override
    public void update(User item) throws DAOException;

    @Override
    public void delete(int id) throws DAOException;

    @Override
    public List<User> getAll(String table) throws DAOException;

    @Override
    public User getElement(int id) throws DAOException;
}
