package dao;

import java.sql.Connection;
import java.sql.SQLException;

import domain.domainUsers;

public interface DaoUsersInter {
	public domainUsers getUser(int user_id) throws ClassNotFoundException, SQLException;
	public void saveToDB(domainUsers dUsers) throws ClassNotFoundException, SQLException;
	public void updateOnDB(domainUsers dUsers, String colName, String value) throws ClassNotFoundException, SQLException;
	public void deleteFromDB(domainUsers dUsers) throws ClassNotFoundException, SQLException;
	public boolean ifExists(domainUsers dUsers) throws ClassNotFoundException, SQLException;
	public Connection createConnection() throws ClassNotFoundException, SQLException;
}
