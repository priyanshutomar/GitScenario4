import java.util.Scanner;
class LargestOfThree
{
	public static void main(String[] args)
	{		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 3 numbers");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int num3 = sc.nextInt();
		System.out.println("Largest = "+( num1>num2 ? (num1>num3?num1:num3) : (num2>num3?num2:num3) ));
	}
}
