package com.services;

import java.sql.SQLException;

import com.beans.MainPOJO;
import com.dao.Dao;
import com.dao.DaoInter;
import com.model.ResponseSuccess;

public class ServicesCancelSub implements ServicesCancelSubInter {
	public  ResponseSuccess CancelSub(MainPOJO pojo) throws ClassNotFoundException, SQLException
	{
		ResponseSuccess responseObject;
		DaoInter Dao = new Dao();
		if(Dao.IfExists(pojo))
		{
			
			if(Dao.getAccountIdentifier(pojo))
			{
				Dao.CancelSubscription(pojo);
				responseObject = new ResponseSuccess(true,pojo.getCreator().getFirstName()+":"+pojo.getCreator().getUuid());
				return responseObject;
			}
			responseObject = new ResponseSuccess(false,"");	
			return responseObject;
		}
		else
		{
			System.out.println("User already unsubscribed the product");
			responseObject = new ResponseSuccess(false,"");
			return responseObject;
		}
	}
}
