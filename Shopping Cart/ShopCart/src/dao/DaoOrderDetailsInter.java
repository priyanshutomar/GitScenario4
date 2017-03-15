package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import domain.domainOrderDetails;

public interface DaoOrderDetailsInter {
	public void saveToDB(domainOrderDetails dOrderDetails, int order_id) throws ClassNotFoundException, SQLException;
	public List<domainOrderDetails> getOrders(int order_id) throws ClassNotFoundException, SQLException;
	public int ifExists(domainOrderDetails dOrderDetails, int order_id) throws ClassNotFoundException, SQLException;
	public void updateOnDB(domainOrderDetails dOrderDetails, int order_id) throws ClassNotFoundException, SQLException;
	public Connection createConnection() throws ClassNotFoundException, SQLException;
}
