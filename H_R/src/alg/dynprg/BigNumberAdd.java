/**
 * 
 */
package alg.dynprg;



public class BigNumberAdd {

    public static void main(String[] args) {
    	String a = "77337595194528125889112";
    	String b = "278098554823";
        
//        System.out.println(addBigNumbers(a,b));
        System.out.print(multiplyBigBySingleDigit("734", 3));
        
//        System.out.print(multiply2BigNumbers("734", "734"));
    }
    
    
    
    
    
    public static String addBigNumbers(String a, String b){

    	StringBuilder output = new StringBuilder();
    	int carry = 0;
    	
    	for (int i=a.length()-1, j=b.length()-1 ; i>=0 || j>=0 ; i--,j--){
    		
    		int num1 = 0, num2 = 0;
    		if (0 <= i){
    			num1 = Integer.parseInt(String.valueOf(a.charAt(i)));
    		}
    		if (0 <= j){
    			num2 = Integer.parseInt(String.valueOf(b.charAt(j)));
    		}
    		int temp = num1 + num2 + carry;
    		
    		if (temp > 10){
    			carry = temp / 10;
    		}else{
    			carry = 0;
    		}
    		output.append(temp % 10);
    		
    	}
    	
    	if (carry != 0){
    		output.append(carry);
    	}
    	
    	return output.reverse().toString().trim();
    }
    
    
    
    public static String multiplyBigBySingleDigit(String bigNumber, int num){
    	
    	StringBuilder output = new StringBuilder();
    	int carry = 0;
    	
//    	bigNumber = "111111111111111";
//    	num = 2;
    	
    	for (int i=bigNumber.length()-1 ; i>=0 ; i--){
    		
    		int num1 = 0;
    		if (0 <= i){
    			num1 = Integer.parseInt(String.valueOf(bigNumber.charAt(i)));
    		}
    		
    		int temp = (num1 * num) + carry;
    		
    		if (temp >= 10){
    			carry = temp / 10;
    		}else{
    			carry = 0;
    		}
    		output.append(temp % 10);
    		
    	}
    	
    	if (carry != 0){
    		output.append(carry);
    	}
    	
    	return output.reverse().toString().trim();
    }
    
    
    /**
     * metho to mutiply 2 huge numbers
     * @param a
     * @param b
     * @return
     */
    public static String multiply2BigNumbers(String a, String b){

//    	StringBuilder output = new StringBuilder();
    	int max = a.length() > b.length() ? a.length() : b.length();
    	int min = a.length() > b.length() ? b.length() : a.length();
    	
    	String bigNumber = "";
    	String smallNumber = "";
    	
    	String[] outputArrays = new String[min];
    	
    	bigNumber = (a.length() == max) ? a : b;
    	
    	smallNumber = (a.equals(bigNumber)) ? b : a;
    	int p=0;
    	for (int i=min - 1 ; i>=0 ; i--){
    		
    		StringBuilder tempOutput = new StringBuilder();
    		
    		int num = Integer.parseInt(String.valueOf(smallNumber.charAt(i)));
    		
    		for (int k=0;k<min-1-i;k++){
    			tempOutput.append("0");
    		}
    		String tempProd = multiplyBigBySingleDigit(bigNumber, num);
    		
    		tempProd = tempProd.concat(tempOutput.toString());
    		
    		
    		outputArrays[p++] = tempProd;
    		
    	}
    	
    	//add all strings in the array
    	String finalOutput = "0";
    	
    	String num1 = "";
    	for (int i=0;i<=outputArrays.length-1;i++){
    		
    		num1 = outputArrays[i];
    		finalOutput = addBigNumbers(finalOutput, num1);
    		
    	}
    	return finalOutput.trim();
    }
    
    
}
