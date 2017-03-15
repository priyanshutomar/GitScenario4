package domain;

public class domainUsers
{
	private String userName, userAdd;
	private int userId;
	
	//defining setter functions to get values to domainUsers object
	public void setUserName (String userName)
	{
		this.userName = userName;
	}
	public void setUserAdd (String userAdd)
	{
		this.userAdd = userAdd;
	}
	public void setUserId (int userId)
	{
		this.userId = userId;
	}
	
	
	//defining getter functions to get values from domainOrders object
	public String getUserName ()
	{
		return userName;
	}
	public String getUserAdd ()
	{
		return userAdd;
	}
	public int getUserId ()
	{
		return userId;
	}
}