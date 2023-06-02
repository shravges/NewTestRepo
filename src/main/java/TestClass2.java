
public class TestClass2 {

	public static void main(String[] args) 
	{
		String data = "shilpa";
		
		
		System.out.println("Original data = " +data);
		String reversedData="";
		
		char[] myCharArray = data.toCharArray();
		
		for(int i=myCharArray.length-1;i>=0;i--)
			{
			//System.out.print(myCharArray[i]);
			reversedData = reversedData +myCharArray[i];
			}
		
		System.out.println("Reversed data =  " +reversedData);
		
		 if(data.equalsIgnoreCase(reversedData))
		 {
			 System.out.println("String palindrome");
		 }
		 else
		 {
			 System.out.println("not palindrome");
		 }
	}

}
