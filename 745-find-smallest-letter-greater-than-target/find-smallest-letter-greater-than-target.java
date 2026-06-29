class Solution {
   public char nextGreatestLetter(char[] letters, char target) {
       int left = 0, right = letters.length - 1;
       int resultIndex = -1;
       while (left <= right) {
           int mid = left + (right - left) / 2;
           if (letters[mid] > target) {
               resultIndex = mid; // potential answer
               right = mid - 1; // search for smaller valid index
           } else {
               left = mid + 1; // move right
           }
       }
       // Wrap-around case
       return resultIndex == -1 ? letters[0] : letters[resultIndex];
   }
}