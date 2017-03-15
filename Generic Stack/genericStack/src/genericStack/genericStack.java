package genericStack;

import java.util.*;


public class genericStack<type>
{
   int size=10,top=-1;
   ArrayList<type> arrayList = new ArrayList<type>();
   boolean isfull()
   {
       if(top==size-1)
           return true;
       return false;
   }
   boolean isempty()
   {
       if(top==-1)
           return true;
       return false;
   }
   void push(type elem)
   {
       if(isfull())
       {
           System.out.println("Stack Overflow");
       }
       else
       {
           top++;
           arrayList.add(elem);
       }
   }
   void pop()
   {
       if(isempty())
       {
           System.out.println("Stack Underflow");
       }
       else
       {
           arrayList.remove(top);
           top--;
       }
   }

   public static void main(String[] args)
   {
       genericStack<Integer> gStackInt = new genericStack<Integer>();
       gStackInt.push(5);
       gStackInt.push(10);
       gStackInt.push(15);
       for(int i = 0; i< gStackInt.arrayList.size() ; i++)
       {
           System.out.println(gStackInt.arrayList.get(i));
       }
      
       genericStack<String> gStackStr = new genericStack<String>();
       gStackStr.push("item1");
       gStackStr.push("item2");
       gStackStr.push("item3");
       gStackStr.pop();
       for(int i = 0 ; i < gStackStr.arrayList.size() ; i++)
       {
           System.out.println(gStackStr.arrayList.get(i));
       }
   }
}
