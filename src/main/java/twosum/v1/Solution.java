package twosum.v1;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();

        final int[][] inputs = {
                {2, 7, 11, 15},
                {3, 2, 4},
                {3, 3}
        };
        final int[] targets = {9,6,6};
        for (int i = 0; i < targets.length; i++) {
            final int[] output = sol.twoSum(inputs[i], targets[i]);
            final boolean correct = inputs[i][output[0]] + inputs[i][output[1]] == targets[i];
            System.out.printf("%b\t - \t%s | \t%s | \t%s | \t%d\n",correct, inputs[i], inputs[i], inputs[i][output[1]], targets[i]);
        }
    }

    public int[] twoSum(int[] nums, int target) {
        class Indexes {
            final int index;
            int duplicatedIndex;
            boolean isDuplicated;
            public Indexes(int indexOne) {
                this.index = indexOne;
            }
        }

        Map<Integer, Indexes> inputMap = new HashMap();
        for (int index = 0; index < nums.length; ++index) {
            final int value = nums[index];
            if (inputMap.containsKey(value)) {
                inputMap.get(value).isDuplicated = true;
                inputMap.get(value).duplicatedIndex = index;
            } else {
                inputMap.put(value, new Indexes(index));
            }
        }

        for (Map.Entry<Integer, Indexes> entry : inputMap.entrySet()) {
            Indexes value;
            if ((value = inputMap.get(target - entry.getKey())) != null) {
                return new int[]{
                        entry.getValue().index,
                        value.isDuplicated ? value.duplicatedIndex : value.index
                };
            }
        }
        return null;
    }
}