class Solution {
  public boolean increasingTriplet(int[] nums) {
    int small = Integer.MAX_VALUE;
    int big = Integer.MAX_VALUE;
    
    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      
      if (num <= small) {
        small = num;
      }
      if (num > small && num <= big) {
        big = num;
      }
      if (num > big) {
        return true;
      }
    }
    
    return false;
  }
}