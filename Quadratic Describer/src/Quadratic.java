public class Quadratic {
	public static void quadrDescriber (double a, double b, double c) {
		System.out.println();
		System.out.println("Description of the graph");
		if(b < 0 && c < 0) {
			System.out.println("y = " + a + " x^2 " + b + " x " + c);
		} else if (b < 0) {
			System.out.println("y = " + a + " x^2 " + b + " x + " + c);
		} else if(c < 0) {
			System.out.println("y = " + a + " x^2" + " + " + b + " x " + c);
		} else {
			System.out.println("y = " + a + " x^2" + " + " + b + " x + " + c);
		}
		//when a is greater than or equal to 0, the quadratic opens up
		if (a >= 0) {
			System.out.println();
			System.out.println("Opens: Up");
		} else {
			System.out.println();
			System.out.println("Opens: Down");
		}
		//axis of symmetry
		//If the axis of symmetry equals 0, then the output would have been -0, therefore -b/2*a cannot be used, so instead b/2*a is used. 
		double axisOfSymmetry = (b /(2*a));
		//When the axis of symmetry doesn't equal zero, we can multiply b/2*a by -1. 
		//This gives us -b/2*a which is the proper form to find the axis of symmetry.
		if (axisOfSymmetry != 0) {
			axisOfSymmetry = -1 * axisOfSymmetry;
		}
		//If the axis of symmetry gives us too much decimal places, we would need to round it to 2 decimal places, so round2 method is called below. 
		System.out.println("Axis of Symmmetry: " + round2(axisOfSymmetry));
		//Vertex
		//(h, k) is the vertex form. 
		//h is the axis of symmetry
		//to find the k value, plug in h as the x value in the quadratic equation.
		double h = axisOfSymmetry;
		double k = a * (h * h) + (b * h) + c;
		//Since the vertex could give us a number that has multiple decimal places, we just need to round it to 2 decimal places.
		//So we call the round2 method below. 
		System.out.println("Vertex: (" + round2(h) + ", "  + round2(k) + ")");
		//This grabs the quadForm method and the quadForm methods can tell us the x intercepts. 
		System.out.println("x-intercept(s): " + quadForm(a, b, c));
		//the y-intercept is the value of y when x = 0, it simplifies to y = c, so the y-intercept is just c
		System.out.println("y-intercept: " + c);
		System.out.println();
	}
	public static String quadForm(double a, double b, double c) {
		
		//This should call other methods we wrote in the class libary.
		//the output depends on the discriminant so let's calculate that first
		double calculatediscriminant = discriminant(a,b,c);
		if (calculatediscriminant > 0) {
			//two real solutions
			double root1 = ((-b) + sqrt(calculatediscriminant)) / (2 * a);
			double root2 = ((-b) - sqrt(calculatediscriminant)) / (2 * a);
			
			//check to see which root is smaller
			if (max(root1, root2) == root1) {
				//root1 is greater than root2
				//we want to print the smaller value first
				return round2(root2)  + " and " + round2(root1);
			//if root1 is less than root2, root1 prints first.	
			} else {
				return round2(root1)  + " and " + round2(root2);
			}
		} else if (calculatediscriminant == 0) {
			double root = ((-b) + sqrt(calculatediscriminant)) / (2 * a);
			//convert the double to a string so we can return the right variable type
			return String.valueOf(round2(root));
		} else if (calculatediscriminant < 0) {
			return "None";
		} else {
			//the compiler doesn't realize that we already defined what would happen for all possible cases
			//it wants a return value if the 3 cases above are not true. We know that this will never happen
			//so return an empty string to make the compiler happy
			return "";
			
		}
		
	}
	public static double exponent(double base, int power) {
		//If power is less than 0
		if (power < 0) {
			throw new IllegalArgumentException("You cannot use a negative power in the exponent method.");
		}
		//If both the base and power equals 0
		if (base == 0 && power == 0) {
			throw new IllegalArgumentException("Hey! You cannot input 0 as the base and the power! Please use a power that is greater than zero and try again!");
		}
		int numTimestoMultiply = power -1;
		double answer = base;
		for (int i = 0; i < numTimestoMultiply; i++) {
			answer = answer * base; 
			}
		if (power == 0) {
			answer = 1;
		}
		return answer;
	}

//Method that determines which number is greater. This method accepts two doubles and returns a double.
	public static double max(double num1, double num2) {
		if (num1>num2) {
			return num1;
		}else {
			return num2;
		}	
	}	
//Method that returns the discriminant of the input
	public static double discriminant(double a, double b, double c) {
		double answer= (b*b)-(4*a*c);
		return answer;
	}
	//Method that rounds a double correctly to 2 decimal places. This method returns a double. 
		public static double round2(double x) {
			//This multiplies 1000
			double inputTimes1000 = x * 1000;
			//this adds five
			double addFive = inputTimes1000+5;
			//this subtracts five
			double subtractFive = inputTimes1000-5;
			//Since there are two variables, we have to see if it goes through the if statement or not. 
			//When x is less than 0, subtractFive variable is used in the if statement.
			//It goes through the if statement, and returns the answer, which is a negative answer. 
			if (x < 0){
				double divideTen = subtractFive/10;
				int number = (int)divideTen;
				double answer = (double)number/100;
				return answer;
				}
			//When x is greater than or equal to 0, the addFive variable is used. It doesn't go through the if statement, so it keeps going from here.
			//This returns a positive answer.
			double divideTen = addFive/10;
			int number = (int)divideTen;
			double answer = (double)number/100;
			return answer;
		}
		//Method that returns an approximation of the square root of the value passed, rounded to 2 decimal places. 
		//This method accepts a double and returns a double. 
		public static double sqrt(double input) {
			//If the input is negative. 
			if (input < 0) {
				throw new IllegalArgumentException("You cannot get the sqrt() of a negative number. Please input a positive number.");
			}
			double guess = 2;
			double result = 0;
			while (absValue(input - exponent(result,2)) > 0.005) {
				result = 0.5 * ((input / guess) + (guess));
				guess = result;
			}
			result = round2(result);
		
			return result;
			
		}
		//Method that returns an absolute value number with the input. This method accepts a double and returns a double.
		public static double absValue(double input) {
			if (input >= 0) {
				return input;
			} else {
				return (-1 * input);
			}
		}	
}