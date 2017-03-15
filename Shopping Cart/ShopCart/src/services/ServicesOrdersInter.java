package services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import domain.domainOrderDetails;

public interface ServicesOrdersInter {
	public List<domainOrderDetails> readCSV(String filepath) throws IOException, ClassNotFoundException, SQLException;
}
