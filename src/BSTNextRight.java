import java.util.Arrays;

/**
 * Created by congrenhan on 6/14/17.
 */
public class BSTNextRight {
    public static void main(String[] args) {
        TreeLinkNode root = new TreeLinkNode(1);
        TreeLinkNode node2 = new TreeLinkNode(2);
        TreeLinkNode node3 = new TreeLinkNode(3);
        root.left = node2;
        root.right = node3;

        TreeLinkNode node4 = new TreeLinkNode(4);
        TreeLinkNode node5 = new TreeLinkNode(5);
        TreeLinkNode node6 = new TreeLinkNode(6);

        node2.left = node4;
        node2.right = node5;
        node3.right = node6;

        connect(root);

    }

    public static void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }

        TreeLinkNode levelStart = root;
        root.next = null;

        while (levelStart != null) {
            TreeLinkNode cur = levelStart;
            TreeLinkNode dummy = new TreeLinkNode(0);
            TreeLinkNode walk = dummy;

            while (cur != null) {
                if (cur.left != null) {
                    walk.next = cur.left;
                    walk = cur.left;
                }

                if (cur.right != null) {
                    walk.next = cur.right;
                    walk = cur.right;
                }

                cur = cur.next;
            }
            levelStart = dummy.next;
        }
    }

    public static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }
}
