import java.util.Scanner;
class Reverse
{
	public static void main(String[] args)
	{		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number");
		int num = sc.nextInt();
		int rev=0,u;
		while(num!=0)
		{
			u = num%10;
			num = num/10;
			rev = (rev*10) + u;
		}
		System.out.println(rev);
	}
}
