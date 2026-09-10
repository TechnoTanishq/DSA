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

class Pair{
    int sum ;
    int count ;
    public Pair(int s , int c ){
        this.sum = s ;
        this.count = c ;

    }
}
class Solution {
    int ans = 0 ;

    public Pair find(TreeNode root){
        if(root == null){
            return new Pair(0,0);
        }

        //first finding the childs and thrn the parent 
        Pair left = find(root.left);
        Pair right = find(root.right);

        int sum = left.sum + right.sum + root.val;
        int count = left.count + right.count + 1;

        if(sum / count == root.val){
            ans++;
        }

        return new Pair(sum , count);
    }
    public int averageOfSubtree(TreeNode root) {
        find(root);
        return ans ;
    }
}