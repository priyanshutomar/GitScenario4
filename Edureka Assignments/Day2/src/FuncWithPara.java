class FuncWithPara
{
	static int Area(int length, int breadth)
	{
		return length*breadth;
	}
	public static void main(String[] args)
	{
		int len=15, br=10;
		System.out.println("Area of rectangle is "+Area(len,br));
	}
}