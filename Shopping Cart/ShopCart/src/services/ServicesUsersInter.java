package services;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;

import domain.domainUsers;

public interface ServicesUsersInter {
	public List<domainUsers> readCSV(String filepath) throws FileNotFoundException;
	public void saveToDb(domainUsers dUsers) throws ClassNotFoundException, SQLException;
	public void deleteFromDb(domainUsers dUsers) throws ClassNotFoundException, SQLException;
	public void updateOnDb(domainUsers dUsers, int colIdentifier, String value) throws ClassNotFoundException, SQLException;
}
