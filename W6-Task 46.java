class Solution {

    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }

    private int height(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int currentDiameter = leftHeight + rightHeight;

        diameter = Math.max(diameter, currentDiameter);

        // Return height of current node
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
