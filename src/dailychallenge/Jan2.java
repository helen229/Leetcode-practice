package dailychallenge;

import javax.swing.tree.TreeNode;

public class Jan2 {
    /**
     * first attempt
     * the "return cloned" isn't stored, not fully thinking through the recursion process
     **/
    public final TreeNode getTargetCopy1(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(original == null){
            return null;
        }
        if(original == target){
            return cloned;
        }
        getTargetCopy(original.left, cloned.left, target);
        getTargetCopy(original.right, cloned.right, target);
        return cloned;
    }

    TreeNode res;
    public final TreeNode getTargetCopy2(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(original == null){
            return null;
        }
        if(original == target){
            res = cloned;
        }
        getTargetCopy(original.left, cloned.left, target);
        getTargetCopy(original.right, cloned.right, target);
        return res;
    }

    /**
     * final version
     **/
    public final TreeNode getTargetCopy3(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null || original == target)
            return cloned;
        TreeNode res = getTargetCopy(original.left, cloned.left, target);
        if (res != null)
            return res;
        return getTargetCopy(original.right, cloned.right, target);
    }
}
