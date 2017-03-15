package com.utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import com.beans.MainPOJO;
import com.model.ResponseSuccess;

import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;

public interface UtilsInter {
	public Connection createConnection() throws ClassNotFoundException, SQLException;
	public HttpURLConnection signOAuth (String eventUrl) throws IOException, OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException;
	public String readJSON(HttpURLConnection req) throws IOException;
	public void sendJSON(ResponseSuccess responseObject, HttpServletResponse response) throws IOException;
	public MainPOJO mapJsonToPojo(String json) throws JsonParseException, JsonMappingException, IOException;
	
}
