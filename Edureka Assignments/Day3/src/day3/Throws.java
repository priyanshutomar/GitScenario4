package day3;

import java.io.IOException;

public class Throws 
{
   public static void main(String[] args) throws Exception
   {
	   try
	   {
		   System.out.println("Welcome! ");
		   System.out.println(10/0);
	   }
	   catch(Exception e)
	   {
		   System.out.println("Exception raised");
	   }
	   
   }
}