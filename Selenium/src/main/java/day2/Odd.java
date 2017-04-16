package day2;

public class Odd {
	public void isOdd(int a)
	{
		if(a%2==0)
		{
			System.out.println("Even");
		}
		else
			System.out.println("Odd");
	}

	public static void main(String[] args) {

		Odd od=new Odd();
		od.isOdd(38);
	}

}
