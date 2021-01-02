package dailychallenge;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**     Palindrome Permutation

        Given a string, determine if a permutation of the string could form a palindrome.

        Example 1:

        Input: "code"
        Output: false
        Example 2:

        Input: "aab"
        Output: true
        Example 3:

        Input: "carerac"
        Output: true
 */

public class Jan1 {
    /**
     * innitial version
     * if a character occurs even times then it can form a palindrome string while if it is odd
     * unless it's the center, otherwise it should return false.
     **/
   /* for Any easy or medium question if the answer is more than 10 lines than...
    it's definitely not the best solution*/
    public boolean canPermutePalindrome1(String s) {
        int oddNum = 0;
        HashMap<String, Integer> frequency = new HashMap<String, Integer>();
        String[] characters = s.split("");

        for (String character : characters) {
            if (frequency.containsKey(character)) {
                frequency.put(character, frequency.get(character) + 1);
            } else {
                frequency.put(character, 1);
            }
        }

        for (int num : frequency.values()) {
            if (num % 2 != 0) {
                oddNum++;
            }
        }
        if (oddNum > 1)
            return false;
        return true;
    }

    /**
     * better version
     * just use a hash set to store the character occurs odd times instead of record all the characters
     **/
    public boolean canPermutePalindrome2(String s) {
        Set<Character> set = new HashSet<Character>();
        for (int i = 0; i < s.length(); ++i) {
            if (!set.contains(s.charAt(i)))
                set.add(s.charAt(i));
            else
                set.remove(s.charAt(i));
        }
        return set.size() == 0 || set.size() == 1;
    }
}
