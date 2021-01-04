package backtracking;

import java.util.LinkedList;
import java.util.List;

public class L46 {
    List<List<Integer>> res = new LinkedList<>();
    /** Given an array nums of distinct integers, return all the possible permutations. */
    List<List<Integer>> permute(int[] nums) {
        // record the decision path
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    /**
     * Path : track
     * Available Choices : elements not in
     * Ending Condition : track has n elements
     * */
    void backtrack(int[] nums, LinkedList<Integer> track) {
        // stop the traversal and add to the results array
        if (track.size() == nums.length) {
            res.add(new LinkedList(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // skip invalid elements
            if (track.contains(nums[i]))
                continue;
            // add the number to the path
            track.add(nums[i]);

            backtrack(nums, track);
            // return to the previous node and update the track path
            track.removeLast();
        }
    }
}
