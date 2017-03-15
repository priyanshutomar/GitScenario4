package com.controller;

import java.io.IOException;
import java.net.HttpURLConnection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.MainPOJO;
import com.model.ResponseSuccess;
import com.services.ServicesCancelSub;
import com.utils.Utils;
import com.utils.UtilsInter;


/**
 * Servlet implementation class CancelSubscription
 */
@WebServlet("/CancelSubscription")
public class CancelSubscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelSubscription() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try{
        	response.setContentType("application/json");        	
            String eventUrl= (String) request.getParameter("eventUrl");
            
            HttpURLConnection req = new Utils().signOAuth(eventUrl);
            req.connect();            
	        
            String receivedJSON = new Utils().readJSON(req);
            MainPOJO pojo = new Utils().mapJsonToPojo(receivedJSON);
            ResponseSuccess responseObject = new ServicesCancelSub().CancelSub(pojo);
            UtilsInter utils = new Utils();
	        utils.sendJSON(responseObject,response);
        }
		catch(Exception e){
            e.printStackTrace();
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
