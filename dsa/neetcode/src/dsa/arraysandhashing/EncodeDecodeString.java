package dsa.arraysandhashing;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/**
 * LEETCODE : 271 · Encode and Decode Strings
 *
 * Design an algorithm to encode a list of strings to a string.
 * The encoded string is then sent over the network and is decoded back to the original list of strings.
 *
 * Please implement encode and decode
 *
 * EXAMPLE 1:
 * Input: ["lint","code","love","you"]
 *
 * Output: ["lint","code","love","you"]
 *
 * Explanation:
 *
 * One possible encode method is: "lint:;code:;love:;you"
 *
 */
public class EncodeDecodeString {
    public static void main(String[] args) {

        List<String> stringList = Arrays.asList("lint","code","love","you");
        String input = encode(stringList);
        System.out.println("INPUT HERE IS:::::" + input);
        System.out.println(decode(input));

    }
    public static String encode(List<String> strs) {
        StringBuilder encode = new StringBuilder();

        for (String input : strs){
            encode.append(input.length()).append("/").append(input);
        }

        return encode.toString();
    }
    public static List<String> decode(String str) {
        List<String> myList = new ArrayList<>();
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < str.length(); i++){
            if ((Character.isDigit(str.charAt(i)) && (str.charAt(i +1) == '/'))){
                output.append(" ");
                i = i+1;
            }
            else {
                output.append(str.charAt(i));
            }
        }

        String[] out = output.toString().split(" ");
        for (int i = 1 ; i < out.length; i++){
            myList.add(out[i]);
        }

        return myList;
    }
}
