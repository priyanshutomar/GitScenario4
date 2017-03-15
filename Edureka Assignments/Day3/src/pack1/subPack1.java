package pack1;

public class subPack1
{
	public void add(int x, int y)
	{
		System.out.println("Sum is "+(x+y));
	}
	public void sub(int x, int y)
	{
		System.out.println("Subtraction is "+(x-y));
	}
	public void mul(int x, int y)
	{
		System.out.println("Multiply is "+(x*y));
	}
	public void div(int x, int y)
	{
		float result = x/y;
		System.out.println("Division is "+result);
	}
	public void rev(int num)
	{
		int rev=0,u=0;
		while(num!=0)
		{
			u = num%10;
			num = num/10;
			rev = (rev*10) + u;
		}
		System.out.println("Reverse is "+rev);
	}
}