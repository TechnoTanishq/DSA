/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int rob(TreeNode root) {
        int[] choices = find(root);
        return Math.max(choices[0] , choices[1]);
    }

    public int[] find(TreeNode root){
          if(root == null){
            return new int[2];
          }

          //take the current 
        int[] left = find(root.left);
        int[] right = find(root.right);

        //rob the current nodes val 
        //left[1] and right[1] shows the val if we skip 
        int rob = root.val + left[1] + right[1];

        int skip = Math.max(left[0], left[1])
                 + Math.max(right[0], right[1]);

        return new int[]{rob, skip};
    }
}