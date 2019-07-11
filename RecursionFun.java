/**
 * Complete the seven methods methods in this file using recursion, no loops.
 * Also complete these three methods inside LinkedList<E>: get(int) removeAll(E)
 * duplicateAll(E)
 * 
 * Also complete one method in ObstacleCourse that uses recursive backtracking.
 * findExit(int, int)
 * 
 * Note: I believe the given unit test tests all methods. We will be using this
 * same for for correctness of code.
 * 
 * We will not be using code coverage for points.
 *
 * @author Rick Mercer and Beverly Perez
 */
public class RecursionFun {

	// Complete recursive method combinations that returns from n choose k.
	// This method is described in 17_SimpleRecursion.pptx.
	public int combinations(int n, int k) {
		if (k == 1) {
			return n;
		}
		if (k == n) {
			return 1;
		}
		return combinations(n - 1, k - 1) + combinations(n - 1, k);
	}

	// Complete recursive method intWithCommas that returns the argument as a String
	// with commas in the correct places.
	//
	// intWithCommas(999) returns "999"
	// intWithCommas(1234) returns "1,234"
	// intWithCommas(1007) returns "1,007"
	// intWithCommas(1023004567) returns "1,023,004,567"
	//
	// Precondition: n >= 0
	public String intWithCommas(int n) {
		String num = Integer.toString(n);
		int leng = num.length();
		if (leng <= 3) {
			return num;
		}
		int endLoops = leng / 3;
		int loops = 0;
		String empt = num.substring(leng - 3, leng);
		return intWithComHelp(n, num, empt, 0, leng, endLoops, loops);
	}

	private String intWithComHelp(int n, String num, String empt, int i, int leng, int endLoops, int loops) {
		if (loops == endLoops) {

			empt = num.substring(0, leng) + empt;

			return empt;
		}
		if (loops == 0) {
			empt = "," + empt;
		} else {
			empt = "," + num.substring(leng - 3, leng) + empt;
		}

		return intWithComHelp(n, num, empt, i, leng - 3, endLoops, loops + 1);
	}

	// Write recursive method reverseArray that reverses the array elements in a
	// filled array of ints. Use recursion; do not use a loop. The following
	// assertions must pass:
	//
	// int[] a = { 2, 4, 6 };
	// rf.reverseArray(a);
	// assertEquals(6, a[0]);
	// assertEquals(4, a[1]);
	// assertEquals(2, a[2]);
	//
	// Precondition: x.length > 0
	public void reverseArray(int[] x) {
		// You need a private helper that needs additional arguments.
		// like x and x.length to keep track of array the indexes
		// with no loop. Here is an example with the private helper
		// immediately below.
		reverseArray(x, 0, x.length);
	}

	private void reverseArray(int[] x, int index, int len) {
		// len = len-1;
		if (len == 1) {
			return;
		}
		if (index == len) {
			return;
		} else {
			int temp = x[index];
			x[index] = x[len - 1];
			x[len - 1] = temp;
		}
		reverseArray(x, index + 1, len - 1);

	}

	// Write recursive method arrayRange that returns the maximum
	// integer minus the minimum integer in the filled array of
	// integers, Use recursion; do not use a loop.
	// Precondition: a.length > 0
	public int arrayRange(int[] a) {
		int i = 0;
		int tempMax = a[i];
		int tempMin = a[i];
		return arrRangeHelp(a, i, tempMax, tempMin);
	}

	private int arrRangeHelp(int[] a, int i, int maxT, int minT) {

		if (a.length == 1) {
			return 0;
		}

		if (a[i] > maxT) {
			maxT = a[i];
		} else if (a[i] < minT) {
			minT = a[i];
		}

		if (i == a.length - 1) {

			return maxT - minT;
		}

		return arrRangeHelp(a, i + 1, maxT, minT);
	}

	// Return true if nums has all int elements in ascending order.
	// If not isSorted, return false.
	public boolean isSorted(int[] nums) {
		// Need to send down 0 to keep track of the index
		int i = 0;
		return isSortedhelp(nums, i);
	}

	private boolean isSortedhelp(int[] nums, int i) {
		if (nums.length == 0) {
			return true;
		}
		if (i == nums.length - 1) {
			return true;
		} else if (nums[i] <= nums[i + 1])
			return isSortedhelp(nums, i + 1);
		else {
			return false;
		}
	}

// Complete method found to return true if search is found in strs.
	// If not found, return false. Use equals, not ==.
	public boolean found(String search, String[] strs) {
		int i = 0;
		return foundhelp(search, strs, i);
	}

	private boolean foundhelp(String search, String[] strs, int i) {
		if (i == strs.length) {
			return false;
		} else if (strs[i].equals(search)) {
			return true;
		}
		return foundhelp(search, strs, i + 1);
	}
}
