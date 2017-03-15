package services;

import java.io.IOException;
import java.sql.SQLException;

import domain.domainOrderDetails;

public interface ServicesOrderDetailsInter {
	public void generateInvoice(int order_id) throws ClassNotFoundException, SQLException, IOException;
	public int updateQty(domainOrderDetails dOrderDetails) throws ClassNotFoundException, SQLException;
	public void saveToDb(domainOrderDetails dOrderDetails, int order_id) throws ClassNotFoundException, SQLException;
}
