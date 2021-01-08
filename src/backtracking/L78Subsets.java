package backtracking;

public class L78Subsets {

    /**    Subsets

     Given an integer array nums, return all possible subsets (the power set).

     The solution set must not contain duplicate subsets.

     Example 1:

     Input: nums = [1,2,3]
     Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
     Example 2:

     Input: nums = [0]
     Output: [[],[0]]

     */


    /**    Basic Ideal:
     *     {[], [1]} + [2] =>  {[], [1], [2], [1,2]}
     *     {[], [1], [2], [1,2]} + [3] => {[], [1], [2], [1,2], [3], [1,3], [2,3], [1,2,3]}
     *     recursion, backtracking
     */



    /**    Backtracking solution1:
     *     I thought the input is a sorted array...
     */

    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack( nums, track);
        res.add(new LinkedList());
        return res;
    }

    void backtrack(int[] nums, LinkedList<Integer> track) {
        // stop the traversal and add to the results array
        if (track.size() != 0 && track.getLast() == nums[nums.length-1]) {
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // skip invalid elements
            if (track.size()!=0 && track.getLast() >= nums[i])
                continue;
            // add the number to the path
            track.add(nums[i]);
            res.add(new LinkedList(track));

            backtrack(nums, track);
            // return to the previous node and update the track path
            track.removeLast();
        }
    }

    /**    Backtracking solution2: */

    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(0, nums, track);
        res.add(new LinkedList());
        return res;
    }

    void backtrack(int k, int[] nums, LinkedList<Integer> track) {
        // stop the traversal and add to the results array

        for (int i = k; i < nums.length; i++) {
            // skip invalid elements
            // if (track.size()!=0 && k >= i)
            //     continue;
            // add the number to the path
            track.add(nums[i]);
            res.add(new LinkedList(track));
            backtrack(i+1, nums, track);
            // return to the previous node and update the track path
            track.removeLast();
        }
    }

    /**    recursion solution   */

}
