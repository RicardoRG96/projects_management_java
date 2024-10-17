package cl.ricardo.projectManagement.dataAccess.dao;

import cl.ricardo.projectManagement.dataAccess.User;
import java.util.List;

public interface UserDAO extends DAO<User, Integer> {
    
    @Override
    public void insert(User user) throws DAOException;

    @Override
    public void update(User user) throws DAOException;

    @Override
    public void delete(int id) throws DAOException;

    @Override
    public List<User> getAll() throws DAOException;

    @Override
    public User getElement(int id) throws DAOException;
}
