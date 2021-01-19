package recursion;

public class L1448 {
        int res = 0;
        public int goodNodes(TreeNode root) {
            // return helper(root, -10001);
            helper(root, -10001);
            return res;
        }

//     public int helper(TreeNode root, int max) {
//         if(root == null)
//             return 0;

//         int res = 0 ;
//         if (root.val >= max){
//             res++;
//             max = root.val;
//         }

//         return res + helper(root.left, max) + helper(root.right, max);

//     }

        public void helper(TreeNode root, int max) {
            if(root == null)
                return;

            if (root.val >= max){
                res++;
                max = root.val;
            }
            helper(root.left, max);
            helper(root.right, max);
        }
}
