package indi.java.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Medium, Runtime: 123 ms(29.77%) Memory Usage: 70.9 MB(12.14%)
 */
public class MaximumXOROfTwoNumbersInArray {

	/**
	 * Greedy Trying Like this:
	 * 
	 * <pre>
	 *      Y        Y
	 * 100 ---> 110 ---> 111 ...
	 *      |        |
	 *      |        --> 101 ...
	 *      |        N	
	 *      |        Y
	 *      --> 010 ---> 011 ...  
	 *      N        |
	 *               --> 001 ...
	 *               N
	 * </pre>
	 * 
	 * @param nums
	 * @return
	 */
	public int findMaximumXOR(int[] nums) {
		int mask = 0;
		int max = 0;

		for (int i = 30; i >= 0; i--) {
			mask = mask | 1 << i;

			Set<Integer> hs = new HashSet<>();
			for (int num : nums) {
				// ¾B¸n«ái®æ
				hs.add(num & mask);
			}

			int num = 1 << i;
			for (int s : hs) {
				// if a ^ x = b then a ^ b = x.
				if (hs.contains(s ^ (max | num))) {
					max |= num;
					break;
				}
			}
		}

		return max;
	}

}
