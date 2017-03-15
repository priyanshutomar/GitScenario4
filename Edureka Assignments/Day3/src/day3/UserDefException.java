package day3;

class MyException extends Exception
{
   //String s1;
   MyException(String s2)
   {
	   System.out.println(s2);
       //s1=s2;
   }
   /*
   public String toString()
   {
       return (s1) ;
   }*/
}

class UserDefException
{
   public static void main(String args[])
   {
       try
       {
           throw new MyException("This is My Exception");
       }
       catch(MyException e)
       {
           System.out.println("Exception : "+e) ;
           System.out.println("****");
       }
   }
}