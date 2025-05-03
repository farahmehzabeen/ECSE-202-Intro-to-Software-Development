//** Farah Mehzabeen **//
//** McGill ID: 260910809 **//
import acm.program.ConsoleProgram;
public class baseConv extends ConsoleProgram{
	public String input;
	public int OgBase, base10, taregeted_Base;
	public char x;
	static int digitToSum(char x)
	{
	    if (x >= '0' && x <= '9')
	        return (int) x - '0';
	    else
	        return (int) x - 'A' + 10;
	}
	static int String2Integer(String input, int OgBase)
	{ 
		if (OgBase < 2 || (OgBase > 10 && OgBase != 16))
	        return -1;	
		int length = input.length();
	    int sum = 0;
	    int power = 1;
	    int i;
	    for (i = length - 1; i >= 0; i--)
	    {
	        int digit = digitToSum(input.charAt(i));
	        if (digit < 0 || digit >= OgBase)
	            return -1;
	        //** Decimal equivalent is str[len-1]*1 + str[len-1]*base + str[len-1]*(base^2) + ... **//
	        sum += digit * power;
	        power = power * OgBase;
	    }
	    return sum;
	}
	
	public String Decimal2TargetedBase(int base10, int targeted_Base)
	{
		String result = "";
	    int remainder;
	    //** Convert the entered number in targeted base by repeatedly dividing it by that base and taking the remainder. **//
	     do{
	        remainder = base10 % targeted_Base;
	        if (targeted_Base == 16) {
	            if (remainder == 10)
	                result += 'A';
	            else if (remainder == 11)
	                result += 'B';
	            else if (remainder == 12)
	                result += 'C';
	            else if (remainder == 13)
	                result += 'D';
	            else if (remainder == 14)
	                result += 'E';
	            else if (remainder == 15)
	                result += 'F';
	            else
	                result += remainder;
	        } 
	        else
	            result += remainder;
	        base10 /= targeted_Base;
	    }
	     while (base10 > 0);
	    //** Reverse the result **//
	    return new StringBuffer(result).reverse().toString();
	}
	//** The example in the document titled "ECS-202 Assignment 1.pdf" has been used as starting point **//
	//** for the code written down below from this line onwards. **//
	public void run()     
	{ 
		println("THIS IS A PROGRAM TO REPRESENT BASE CONVERSION."); 
		 while(true) 
		 {  
			 String input = readLine("Enter a number: "); 
			 if (input.equals("")) 	
				 break; 
			 int OgBase = readInt("Enter the corresponding base of the entered number: ");
			 int base10 = String2Integer(input,OgBase);
			 println("The decimal equivalent of the entered number is: "+base10);
			 int targeted_Base = readInt("Enter the targeted base for conversion: ");
			 String output = Decimal2TargetedBase(base10,targeted_Base);
			 println(input+" Base-"+OgBase+" ==> "+output+" Base-"+targeted_Base);
			 println();
		 }
		 println("Program terminated");
	}
}