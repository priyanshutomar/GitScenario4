import java.util.Scanner;

class FuncWithReturnTypes
{
	static int Sum(int x, int y)
	{
		return x+y;
	}
	static float div(float x, float y)
	{
		return x/y;
	}
	static boolean bool(int x)
	{
		return x%2==0;
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter two numbers to sum : ");
		int x = sc.nextInt();
		int y = sc.nextInt();
		System.out.println("Sum is : "+Sum(x,y));
		System.out.print("Enter two numbers to divide : ");
		float a = sc.nextInt();
		float b = sc.nextInt();
		System.out.print("Division is : "+div(a,b));
		System.out.print("Enter a number : ");
		int num = sc.nextInt();
		if(bool(num))
		{
			System.out.println(num+" is even");
		}
		else
		{
			System.out.println(num+" is odd");
		}
	}
}