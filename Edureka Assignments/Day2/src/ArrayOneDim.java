import java.util.Scanner;
public class ArrayOneDim
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of elements in an array : ");
		int num = sc.nextInt();
		int[] arr = new int[num];
		int i;
		for(i=0;i<num;i++)
		{
			System.out.print("Enter the "+(i+1)+" element : ");
			arr[i] = sc.nextInt();
		}
		for(int element : arr)
		{
			System.out.print(element+" ");
		}
	}
}