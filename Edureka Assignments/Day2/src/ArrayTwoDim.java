import java.util.Scanner;
public class ArrayTwoDim
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of rows in an array : ");
		int rows = sc.nextInt();
		System.out.print("Enter number of columns in an array : ");
		int cols = sc.nextInt();
		int[][] arr = new int[rows][cols];
		int i,j;
		for(i=0;i<rows;i++)
		{
			for(j=0;j<cols;j++)
			{
				System.out.print("Enter the "+(j+1)+" element of "+(i+1)+" column : ");
				arr[i][j] = sc.nextInt();
			}
		}
		for(i=0;i<rows;i++)
		{
			for(j=0;j<cols;j++)
			{
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}