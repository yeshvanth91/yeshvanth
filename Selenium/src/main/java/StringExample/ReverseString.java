package StringExample;

public class ReverseString {

	public static void main(String[] args) {
		String str="Yeshvanth Kannan";
		String strArray[]= str.split(" ");
		for(int i=strArray.length-1;i>=0;i--)
		{
			System.out.println(strArray[i]);
		}
	}

}
