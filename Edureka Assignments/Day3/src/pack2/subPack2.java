package pack2;
import pack2.*;
import java.util.Scanner;

public class subPack2
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter two numbers");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		pack1.subPack1 obj = new pack1.subPack1();
		obj.add(num1, num2);
		obj.sub(num1, num2);
		obj.mul(num1, num2);
		obj.div(num1, num2);
		obj.rev(num1);
	}
}