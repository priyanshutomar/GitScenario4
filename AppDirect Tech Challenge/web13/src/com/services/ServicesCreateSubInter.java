package com.services;

import java.sql.SQLException;

import com.beans.MainPOJO;
import com.model.ResponseSuccess;

public interface ServicesCreateSubInter {
	public  ResponseSuccess CreateSub(MainPOJO pojo) throws ClassNotFoundException, SQLException;
}
