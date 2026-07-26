class Solution {
    public int minMirrorPairDistance(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){
            // Check if current number already exists as a reversed value
            if(map.containsKey(nums[i])){
                min = Math.min(min, i - map.get(nums[i]));
            }

            // Store reverse of current number
            map.put(reverse(nums[i]), i);
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private static int reverse(int n){
        int rev = 0;
        while(n > 0){
            int dig = n % 10;
            rev = (rev * 10) + dig;
            n /= 10;
        }
        return rev;
    }
}