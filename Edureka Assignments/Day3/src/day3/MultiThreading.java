package day3;
class Table5 extends Thread
{ 
	public void run()
	{
		for(int i=1;i<=10;i++)
		{ 
			System.out.println("5 * "+i+" = "+(5*i));
		} 
	} 
} 
public class MultiThreading
{
	public static void main(String[] args)
	{
		Table5 obj = new Table5();
		obj.start();
		for(int i=2;i<=40;i++)
		{ 
			System.out.println("Even number - "+i);
			i++;
		}
	}
}