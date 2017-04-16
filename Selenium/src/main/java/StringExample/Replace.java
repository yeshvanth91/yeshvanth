package StringExample;

public class Replace {

	public static void main(String[] args) {
		String str="Yeshvanth12345%@trt";
		String charString=str.replaceAll("[^a-zA-z]+","");
		System.out.println(charString);
		String numString=str.replaceAll("[^1-9]+","");
		System.out.println(numString);
		String specCharacter=str.replaceAll("[a-zA-Z0-9]+","");
		System.out.println(specCharacter);
	}

}
