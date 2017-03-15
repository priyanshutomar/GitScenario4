import java.util.Scanner;
class ToWords
{
	public static void main(String[] args)
	{		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number");
		int num = sc.nextInt();
		int rev=0,u=0;
		while(num!=0)
		{
			u = num%10;
			num = num/10;
			rev = (rev*10) + u;
		}
		u=0; num=rev; 
		while(num!=0)
		{
			u = num%10;
			num = num/10;
			switch (u)
			{
			case 0:
				System.out.print("ZERO");
				break;
			case 1:
				System.out.print("ONE");
				break;
			case 2:
				System.out.print("TWO");
				break;
			case 3:
				System.out.print("THREE");
				break;
			case 4:
				System.out.print("FOUR");
				break;
			case 5:
				System.out.print("FIVE");
				break;
			case 6:
				System.out.print("SIX");
				break;
			case 7:
				System.out.print("SEVEN");
				break;
			case 8:
				System.out.print("EIGHT");
				break;
			case 9:
				System.out.print("NINE");
				break;
			default:
				System.out.print("UNKNOWN");
				break;
			}
			if(num!=0)
			{
				System.out.print(" ");
			}
		}
	}
}
