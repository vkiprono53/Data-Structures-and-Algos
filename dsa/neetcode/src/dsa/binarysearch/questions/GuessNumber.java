package dsa.binarysearch.questions;

/**
 * LLETCODE 374. Guess Number Higher or Lower
 *
 * We are playing the Guess Game. The game is as follows:
 *
 * I pick a number from 1 to n. You have to guess which number I picked.
 *
 * Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.
 *
 * You call a pre-defined API int guess(int num), which returns three possible results:
 *
 *
 -1: Your guess is higher than the number I picked (i.e. num > pick).
 1: Your guess is lower than the number I picked (i.e. num < pick).
 0: your guess is equal to the number I picked (i.e. num == pick).

 Return the number that I picked.



 Example 1:

 Input: n = 10, pick = 6
 Output: 6

 Example 2:

 Input: n = 1, pick = 1
 Output: 1

 */
public class GuessNumber {
    public static void main(String[] args) {
        int n = 10;
        int pick = 6;
    }

    /**
     *Time Complexity - O(log n)
     * Space Complexity - O(1)
     */
    public int guessNumber(int n) {
        int low = 0;
        int high = n;
        int mid = 0;
        while(low  < high){

            mid = low + (high - low) / 2;
            int num = guess(mid);
            if(num == -1){
                high = mid;
            }
            else if(num == 1){
                low = mid + 1;
            }
            else{
                return mid;
            }
        }
        return high;
    }
    //Hardcoded guess method
    private int guess(int num){
        return num;
    }
}
