package com.services;

import java.sql.SQLException;

import com.beans.MainPOJO;
import com.model.ResponseSuccess;

public interface ServicesCancelSubInter {
	public  ResponseSuccess CancelSub(MainPOJO pojo) throws ClassNotFoundException, SQLException;
}
