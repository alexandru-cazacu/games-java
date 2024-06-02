import java.util.Arrays;
import java.util.Collections;

public class Test {
	
	// ---------- 2 Monkeys ----------

	public static boolean monkeyTrouble (boolean aSmile, boolean bSmile) {
		if ((aSmile && bSmile) || (!aSmile && !bSmile)) 
			return true;
		return false;
	}

	// Same result using ternary operator
	/*public boolean monkeyTrouble (boolean aSmile, boolean bSmile) {
		return (aSmile && bSmile) || (!aSmile && !bSmile) ? true : false;
	}*/

	// ---------- Oz ----------

	public static String startOz (String str) {
		String result = "";

		if (str.length() >= 1 && str.charAt(0) == 'o')
			result += "o";
		if (str.length() >= 2 && str.charAt(1) == 'z')
			result += "z";

		return result;
	}

	// ---------- Last 2 ----------

	public static int last2 (String str) {
		int result = 0;
		String conf = str.substring(str.length() - 2, str.length());
		
		for (int i = 0; i < str.length() - 2; i++) {
			if (str.charAt(i) == conf.charAt(0) && str.charAt(i + 1) == conf.charAt(1)) {
				result++;
				// Skip the next char so a combination of xxx won't count
				// as 2, but as 1
			}
		}

		return result;
	}

	// ---------- Array front 9 ----------

	public static boolean arrayFront9 (int[] nums) {
		// If array is less than 4 use its lenght, otherwise use 4
		// Avoids index out of bounds
		int len = nums.length < 4 ? nums.length : 4;

		for (int i = 0; i < len; i++) {
			if (nums[i] == 9)
				return true;
		}

		return false;
	}

	// ---------- Color starter ----------

	public static String seeColor (String str) {
		if (str.startsWith ("red")) {
			return "red";
		}

		if (str.startsWith ("blue")) {
			return "blue";
		}

		return "";
	}

	// ---------- Without start ----------

	public static String nonStart (String a, String b) {
		// Check what happens if we use a.substring(1) on a 1 char string
		// return "" or gives an error?
		return a.substring (1) + b.substring (1);
	}

	// ---------- Reverse ----------

	public static int[] reverse3 (int[] nums) {
		/*int[] result = nums;
		Collections.reverse(Arrays.asList(result));
		return result;*/
		
		for(int i = 0; i < nums.length / 2; i++)
		{
		    int temp = nums[i];
		    nums[i] = nums[nums.length - i - 1];
		    nums[nums.length - i - 1] = temp;
		}
		
		return nums;
	}

	// ---------- Unlucky One ----------

	public static boolean unlucky1 (int[] nums) {
		// Array too short, we create a new one and add some 0
		if (nums.length < 4) {
			int[] res = new int[] {0, 0, 0, 0};
			for (int i = 0; i < nums.length; i++) {
				res[i] = nums[i];
			}
			// We use the new array filled with extra 0
			return check1and3 (res, 0) || check1and3 (res, 1) || check1and3 (res, res.length - 2) ? true : false;
		}
		
		// Array is good, normal control
		return check1and3 (nums, 0) || check1and3 (nums, 1) || check1and3 (nums, nums.length - 2) ? true : false;
	}

	// Check if the number in pos is an unlucky 1
	public static boolean check1and3 (int[] nums, int pos) {
		return nums[pos] == 1 && nums[pos + 1] == 3;
	}

	// ---------- Great 6 ----------

	// (?) why the hint on Math.abs(int)?
	// Is -6 as good as 6?

	public static boolean love6 (int a, int b) {
		return a == 6 || b == 6 || a + b == 6 || a - b == 6;
	}

	// ---------- Sum limit ----------

	public static int sumLimit (int a, int b) {
		int sum = a + b;

		if (String.valueOf(sum).length() > 1) {
			return a;
		}

		return sum;
	}

	// ---------- Lucky sum ----------

	public static int luckySum (int a, int b, int c) {
		if (a == 13)
			return 0;
		if (b == 13)
			return a;
		if (c == 13)
			return a + b;
		
		return a + b + c;
	}

	// ---------- Evenly spaced ----------

	public static boolean evenlySpaced (int a, int b, int c) {
		// Sort the numbers using an array
		int[] nums = {a, b, c};
		Arrays.sort(nums);

		return nums[0] - nums[1] == nums[1] - nums[2];
	}
}