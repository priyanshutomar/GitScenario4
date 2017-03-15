package domain;

public class domainOrderDetails
{
	private int prodId, prodQty;
	
	//defining setter functions to set value in domainOrderDetails object
	public void setProdId (int prodId)
	{
		this.prodId = prodId;
	}
	public void setProdQty (int prodQty)
	{
		this.prodQty = prodQty;
	}
	
	
	//defining setter functions to get value from domainOrderDetails object
	public int getProdId ()
	{
		return prodId;
	}
	public int getProdQty ()
	{
		return prodQty;
	}
}