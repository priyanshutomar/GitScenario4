import java.util.Scanner;
class OddNums
{
	public static void main(String[] args)
	{		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter values of x and y");
		int x = sc.nextInt();
		int y = sc.nextInt();
		int i;
		for ( i = (x%2==0 ? x+1 : x) ; i<=y-2 ; i++)
		{
			System.out.print(i+" ");
			i++;
		}
		System.out.print(i);
	}
}
