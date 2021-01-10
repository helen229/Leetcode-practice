package dailychallenge;

public class Jan9 {
    //Find Root of N-Ary Tree
    //
    public Node findRoot(List<Node> tree) {
        int allSum = 0;
        int allChildrenSum = 0;
        for (Node node : tree) {
            allSum += node.val;
            for (Node child : node.children) {
                allChildrenSum += child.val;
            }
        }
        for (Node node : tree) {
            if (node.val == allSum - allChildrenSum) {
                return node;
            }
        }
        return null;
    }
}
