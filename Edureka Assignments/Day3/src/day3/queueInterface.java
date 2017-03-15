package day3;

import java.util.LinkedList;
import java.util.Queue;

interface queueInter
{
	void insert(Queue x, int y);
	void delete(Queue x);
}
public class queueInterface implements queueInter
{
	public void insert(Queue x, int y)
	{
		x.add(y);
	}
	public void delete(Queue x)
	{
		x.remove();
	}
	public static void main(String[] args)
	{
		Queue q1 = new LinkedList();
		queueInterface obj = new queueInterface();
		obj.insert(q1,15);
		obj.insert(q1,20);
		obj.insert(q1,10);
		obj.delete(q1);
		System.out.println(q1);
	}
}
