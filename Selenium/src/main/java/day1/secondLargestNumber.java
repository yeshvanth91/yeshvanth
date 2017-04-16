package day1;

public class secondLargestNumber {
	int a[]={10,7,19,8,5,18,17,9};
	int count=0;
	int length=a.length;
	int secSmall;
	public void findSecLargestNumber()
	{
		for(int i=0;i<length;i++)
		{
			count=0;
			for(int j=0;j<a.length&&j!=i;j++)
			{
				if(a[i]<a[j])
				{
					count++;
					if(count==(length-2))
					{
						secSmall=a[i];
					}
				}
			}
		}
		System.out.println("Second smallest number is is"+secSmall);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		secondLargestNumber sec=new secondLargestNumber();
		sec.findSecLargestNumber();


	}
}

