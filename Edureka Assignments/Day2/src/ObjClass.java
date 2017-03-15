class MyClass
{
	public void Meth()
	{
		System.out.println("Inside Myclass");
	}
}

class ObjClass
{
	public static void main(String[] args)
	{
		MyClass obj1 = new MyClass();
		obj1.Meth();
	}
}
