package day3;
import java.util.Scanner;

public class Throw
{
	public static boolean function(int x)
	{
		return x%2==0;
	}
	public static void main(String[] args)
	{
		try
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter an odd number");
			int num = sc.nextInt();
			if(function(num))
			{
				throw new Exception(num+" is even");  
			}
			System.out.println("program ended");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}