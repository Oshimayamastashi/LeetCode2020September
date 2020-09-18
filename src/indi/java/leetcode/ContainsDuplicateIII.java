package indi.java.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateIII {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

		if (t < 0) {
			return false;
		}

		Map<Long, Long> bucket = new HashMap<>();
		int w = t + 1;
		for (int i = 0; i < nums.length; i++) {
			long m = getBucketNum(nums[i], w);

			boolean isInCurBucket = bucket.containsKey(m);
			boolean isInPreBucket = bucket.containsKey(m - 1) && nums[i] - bucket.get(m - 1) <= t;
			boolean isInNextBucket = bucket.containsKey(m + 1) && bucket.get(m + 1) - nums[i] <= t;

			if (isInCurBucket || isInPreBucket || isInNextBucket) {
				return true;
			}

			bucket.put(m, (long) nums[i]);
			if (i >= k) {
				bucket.remove(getBucketNum(nums[i - k], w));
			}
		}

		return false;
	}

	private long getBucketNum(long x, long w) {
		return x < 0 ? (x + 1) / w - 1 : x / w;
	}
}
