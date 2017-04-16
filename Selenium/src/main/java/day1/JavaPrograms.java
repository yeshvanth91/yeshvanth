package day1;

import java.util.Scanner;

public class JavaPrograms { 
	public void printIsPrime(int i)
	{
		int j;
		for(j=2;j<i;j++)
		{
			if(i%j==0)
			{
				System.out.println("The No "+i+" is  not a prime");
				break;
			}

		}
		if(i==j)
			System.out.println(i +" is prime No");
	}
	public void printIsEven(int from,int to)
	{
		System.out.println("Printing Even no's between"+ " "+from +" "+"to "+ to);
		for(int i=from+1;i<to;i++)
		{
			if(i%2==0)
			{
				System.out.println(i);
			}
		}
	}
	public void printFibonacci(int from,int to)
	{
		int fib,fib1=0,fib2=1;
		if(from==0)
		{
			System.out.println(fib1);
			System.out.println(fib2);
			from=3;
		}
		if(from==1)
		{
			fib1=1;
			System.out.println(fib1);
			from=2;
			fib1=0;
		}
		for(int i=from;i<=100;i++)
		{
			fib=fib1+fib2;
			System.out.println(fib);
			fib1=fib2;
			fib2=fib;
		}
	}
	public void checkPalindrme()
	{
		
		Scanner in=new Scanner(System.in);
		String input=in.next();
		String[] splittedInput=input.split("");
		int length=splittedInput.length;
		String[] revInput=new String[length];
		for(int i=length-1;i>=0;i--)
		{
			System.out.print(splittedInput[i]);
		}
		if(revInput.equals(splittedInput))
		{
			System.out.println("Palindrome");
		}
		else
		{
			System.out.println("Not a palindrme");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	JavaPrograms jp=new JavaPrograms();
		jp.printIsPrime(13);
		jp.printIsEven(100,200);
		System.out.println("Finished printing Even");
		jp.printFibonacci(1,100);
		jp.checkPalindrme();

	}

}
