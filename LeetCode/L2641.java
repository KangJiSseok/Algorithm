import javax.swing.tree.TreeNode;
import java.util.HashMap;
import java.util.LinkedList;

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
    public TreeNode replaceValueInTree(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        root.val = 0;

        while(!q.isEmpty()){
            int size = q.size();
            int sum = 0;
            HashMap<TreeNode,Integer> map = new HashMap<>();

            for(int i=0; i< size; i++){
                TreeNode node = q.poll();

                int childSum = 0;
                if(node.left != null){
                    childSum += node.left.val;
                    q.add(node.left);
                }
                if(node.right != null){
                    childSum += node.right.val;
                    q.add(node.right);
                }

                map.put(node,childSum);
                sum += childSum;
            }

            for(TreeNode node : map.keySet()){
                int childSum = map.get(node);
                if(node.left != null){
                    node.left.val = sum - childSum;
                }
                if(node.right != null){
                    node.right.val = sum - childSum;
                }
            }
        }
        return root;
    }
}