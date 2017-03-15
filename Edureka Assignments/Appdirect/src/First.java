import java.util.Scanner;
class First {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 2 numbers");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		System.out.println("Largest = "+(num1>num2?num1:num2));
	}
}
