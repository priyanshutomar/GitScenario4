package domain;

public class domainProducts
{
	private String prodName;
	private int prodId, prodQty, prodUP;
	
	//defining setter functions to set values to domainProducts object
	public void setProdName (String prodName)
	{
		this.prodName = prodName;
	}
	public void setProdQty (int prodQty)
	{
		this.prodQty = prodQty;
	}
	public void setProdId (int prodId)
	{
		this.prodId = prodId;
	}
	public void setProdUp (int prodUP)
	{
		this.prodUP = prodUP;
	}
	
	//defining getter functions to get values from domainProducts object
	public String getProdName ()
	{
		return prodName;
	}
	public int getProdQty ()
	{
		return prodQty;
	}
	public int getProdId ()
	{
		return prodId;
	}
	public int getProdUp ()
	{
		return prodUP;
	}
}
