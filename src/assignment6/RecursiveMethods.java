package assignment6;

public class RecursiveMethods {

	/**
	 * Recursively computes base ^ exponent
	 * 
	 * @param base the base - can be positive or negative
	 * @param exp  the exponent - can be positive or negative
	 * @return base ^ exponent
	 */
	public static double exponent(int base, int exp) {
		double result;
		if(exp==0){
			result = 1;
		}
		else if (exp>0){
			result = base*exponent(base,(exp-1));
		}
		else{ // making sure it works if the exponent is negative (the code should work fine if the base is negative)
			result = ((1.0/base)*exponent(base,(exp+1)));
		}
		return result;
			
	}

	/// notes to help me make exponent():
	/// let's take 2 as a base as an example
	/// 2^4 = 2*2*2*2 = 2*2^3
	/// 2^3 = 2*2*2 = 2*2^2
	/// 2^2 = 2*2 = 2*2^1
	/// 2^1 = 2*2^0 = 2*1
	/// 2^0 = 1
	/// 
	/// making sure it works with a negative exponent:
	/// 2^-4 = (1/2)*2^-3
	/// 2^-3 = (1/2)*2^-2
	/// 2^-2 = (1/2)*2^-1
	/// 2^-1 = (1/2)*2^0
	/// 2^0 = 1



	/**
	 * Recursively compute the sum of elements in an array
	 * 
	 * @param array an array of integers
	 * @return the sum of the elements in values
	 */
	public static int arraySum(int[] array) {
		int sum = 0;
		
		return sum;
			
	} // i'll do this after the studio since it refers to the studio

	/**
	 * Recursively computes string representations of dragon curves
	 * 
	 * @param n the desired degree of the dragon curve
	 * @return the nth dragon curve
	 */
	public static String dragon(int n) {
		if (n==0){
			return "F-H";
		}
		else{
			String string = dragon(n-1);
			string=string.replace("F","f");
			string=string.replace("H","h");
			string=string.replace("f","F-H");
			string=string.replace("h","F+H");
			return string;
		}
			
	}

	

	/**
	 * Finds the length of the longest path in the given 2D array from the specified
	 * start position.
	 * 
	 * @param chart 2D array of stones
	 * @param r     start position row
	 * @param c     start position column
	 * @return the length of the longest path that was found
	 */
	public static int maxPathLength(boolean[][] chart, int r, int c) {

		int length;

		if (chart[r][c]==false){
			length=0;
		}

		else{

			int up;
			if (r>0 && chart[r-1][c]){
				up = maxPathLength(chart, r-1, c) + 1;
			}
			else {
				up = 1;
			}
			int down;
			if (r<chart.length && chart[r+1][c]){
				down = maxPathLength(chart, r+1, c) + 1;
			}
			else {
				down = 1;
			}
			int left;
			if (c>0 && chart[r][c-1]){
				left = maxPathLength(chart, r, c-1) + 1;
			}
			else {
				left = 1;
			}
			int right;
			if (c<chart[0].length && chart[r][c+1]){
				right = maxPathLength(chart, r, c+1);
			}
			else {
				right = 1;
			}

			if (up>=down && up>=left && up>=right){
				length = up;
			}
			else if (down>=up && down>=left && down>=right){
				length = down;
			}
			else if (left>=up && left>=down && left>=right){
				length = left;
			}
			else {
				length = right;
			}

		}
		
		return length;
			
	}

	public static void main(String[] args){
		System.out.println(exponent(2,3));
		System.out.println(exponent(-2,3));
		System.out.println(exponent(2,-3));
		System.out.println(dragon(1));
	}
}
