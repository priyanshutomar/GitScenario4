package com.services;

import java.sql.SQLException;

import com.beans.MainPOJO;
import com.dao.*;
import com.model.ResponseSuccess;

public class ServicesCreateSub implements ServicesCreateSubInter {
	public  ResponseSuccess CreateSub(MainPOJO pojo) throws ClassNotFoundException, SQLException
	{
		ResponseSuccess responseObject;
		DaoInter Dao = new Dao();
		if(!Dao.IfExists(pojo))
		{
			Dao.CreateSubsription(pojo);
			responseObject = new ResponseSuccess(true,pojo.getCreator().getFirstName()+":"+pojo.getCreator().getUuid());
			return responseObject;
		}
		else
		{
			System.out.println("User already has the product");
			responseObject = new ResponseSuccess(false,"");
			return responseObject;
		}
	}
}
