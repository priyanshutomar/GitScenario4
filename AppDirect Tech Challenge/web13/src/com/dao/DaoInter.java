package com.dao;

import java.sql.SQLException;

import com.beans.MainPOJO;

public interface DaoInter {
	public void CreateSubsription(MainPOJO pojo) throws ClassNotFoundException, SQLException;
	public void CancelSubscription(MainPOJO pojo) throws ClassNotFoundException, SQLException;
	public boolean IfExists(MainPOJO pojo) throws ClassNotFoundException, SQLException;
	public boolean getAccountIdentifier(MainPOJO pojo) throws ClassNotFoundException, SQLException;
}
