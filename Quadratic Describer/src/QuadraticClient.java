import java.util.Scanner;

public class QuadraticClient {
	public static void main(String[] args) {
		//Call a scanner to get the user information.
		Scanner scanner = new Scanner (System.in);
		boolean loop = true;
		System.out.println("Welcome to the Quadratic Describer!");
		System.out.println("Provide values for coefficients a, b, and c");
		//If the user wants to keep going, then a while loop is used to run it until they want to stop.
		while(loop) {
			try {
				System.out.println();
				System.out.print("a: ");
				String input = scanner.nextLine();
				double a = Double.parseDouble(input);
				
				System.out.print("b: ");
				input = scanner.nextLine();
				double b = Double.parseDouble(input);
					
				System.out.print("c: ");
				input = scanner.nextLine();
				double c = Double.parseDouble(input);	
					
				//After we have all 3 values, we call the quadratic describer method from the Quadratic class.
				Quadratic.quadrDescriber(a, b, c);
				//After calling the method, it asks if you want to keep going or not.
				System.out.println("Do you want to keep going? (Type \"quit\" to end)");
				input = scanner.nextLine();
				//Checks if the first character is the letter q to quit, as charAt is 0-indexed.
				if(input.charAt(0) == 'q' || input.charAt(0) == 'Q') {
					loop = false;
				}
			} catch(Exception e) {
				//This happens if the user did not enter a number.
				System.out.println("Error: You did not enter a number! Do you want to keep going? (Type \"quit\" to end)");	
				String input = scanner.nextLine();
				if(input.charAt(0) == 'q' || input.charAt(0) == 'Q') {
					loop = false;
				}
				
			}
		}	
		scanner.close();
			
	}	
}