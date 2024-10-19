package cl.ricardo.projectManagement.dataAccess.dao;

import cl.ricardo.projectManagement.dataAccess.User;
import java.util.List;

public interface UserDAO extends DAO<User, Integer> {
    
    @Override
    void insert(User user) throws DAOException;

    @Override
    void update(User user) throws DAOException;

    @Override
    void delete(int id) throws DAOException;

    @Override
    List<User> getAll() throws DAOException;

    @Override
    User getElement(int id) throws DAOException;
    
    User getUserByEmailOrUserName(String userInfo) throws DAOException;
    
    int getUserIdByUserName(String userName) throws DAOException;
}
