import java.util.Scanner;
class Fibonacci
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of values to print in series");
		int num = sc.nextInt();
		int num1=1, num2=1, num3;
		System.out.print("0 1 ");
		for(;num!=2;num--)
		{
			System.out.print(num2+" ");
			num3 = num1+num2;
			num1 = num2;
			num2 = num3;
		}
	}
}
