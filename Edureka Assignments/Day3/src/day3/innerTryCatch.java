package day3;

public class innerTryCatch
{
	public static void main(String[] args)
	{
		try
		{
			System.out.println(5+5);
			try
			{
				System.out.println(5/0);
			}
			catch(Exception e)
			{
				System.out.println("inner exception block : "+e);
			}
		}
		catch(Exception e)
		{
			System.out.println("outer exception block : "+e);
		}
	}
}