package com.wt.algorithm.other;

import org.checkerframework.checker.units.qual.min;

import java.util.*;

/**
 * @author wtt
 * @version 1.0
 * @description 二叉树相关的代码
 * @date 2024/1/25 16:35
 */
public class BinaryTreeCode {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        TreeNode(int x, TreeNode left, TreeNode right) {
            this.val = x;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 前序遍历-递归法
     * 中左右
     *
     * @param root
     * @return
     */
    public List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrder(root, res);
        return res;
    }

    private void preOrder(TreeNode treeNode, List<Integer> res) {
        if (null != treeNode) {
            res.add(treeNode.val);
            preOrder(treeNode.left, res);
            preOrder(treeNode.right, res);
        }
    }

    /**
     * 前序遍历-迭代法
     *
     * @param root
     * @return
     */
    public List<Integer> preOrderTraversalIteration(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (null == root) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            res.add(treeNode.val);
            if (null != treeNode.right) {
                stack.push(treeNode.right);
            }
            if (null != treeNode.left) {
                stack.push(treeNode.left);
            }
        }
        return res;
    }

    /**
     * 中序遍历-递归法
     * 左中右
     *
     * @param root
     * @return
     */
    public List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inOrder(root, res);
        return res;
    }

    private void inOrder(TreeNode node, List<Integer> res) {
        if (null != node) {
            inOrder(node.left, res);
            res.add(node.val);
            inOrder(node.right, res);
        }
    }

    /**
     * 中序遍历-迭代法
     *
     * @param root
     * @return
     */
    public List<Integer> inOrderTraversalIteration(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (null != cur || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode treeNode = stack.pop();
                res.add(treeNode.val);
                cur = treeNode.right;
            }
        }
        return res;
    }

    /**
     * 后序遍历-递归法
     * 左右中
     *
     * @param root
     * @return
     */
    public List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postOrder(root, res);
        return res;
    }

    public void postOrder(TreeNode node, List<Integer> res) {
        if (null != node) {
            postOrder(node.left, res);
            postOrder(node.right, res);
            res.add(node.val);
        }
    }

    /**
     * 后序遍历-迭代法
     *
     * @param root
     * @return
     */
    public List<Integer> postOrderTraversalIteration(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (null == root) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            res.add(treeNode.val);
            if (null != treeNode.left) {
                stack.push(treeNode.left);
            }
            if (null != treeNode.right) {
                stack.push(treeNode.right);
            }
        }
        Collections.reverse(res);
        return res;
    }

    /**
     * 二叉树的层序遍历
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (null == root) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if (null != poll.left) {
                    queue.offer(poll.left);
                }
                if (null != poll.right) {
                    queue.offer(poll.right);
                }
            }
            res.add(list);
        }
        return res;
    }

    /**
     * 二叉树的层序遍历II
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (null == root) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if (null != poll.left) {
                    queue.offer(poll.left);
                }
                if (null != poll.right) {
                    queue.offer(poll.right);
                }
            }
            res.add(list);
        }
        int i = 0, j = res.size() - 1;
        while (i < j) {
            List<Integer> temp = res.get(i);
            res.set(i, res.get(j));
            res.set(j, temp);
            i++;
            j--;
        }
        return res;
    }

    public List<List<Integer>> levelOrderBottom1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (null == root) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if (null != poll.left) {
                    queue.add(poll.left);
                }
                if (null != poll.right) {
                    queue.add(poll.right);
                }
            }
            res.add(0, list);
        }
        return res;
    }

    /**
     * 二叉树的右视图
     *
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (null == root) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (i == size - 1) {
                    res.add(poll.val);
                }
                if (null != poll.left) {
                    queue.add(poll.left);
                }
                if (null != poll.right) {
                    queue.add(poll.right);
                }
            }
        }
        return res;
    }

    /**
     * 二叉树的层平均值
     *
     * @param root
     * @return
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if (null == res) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0;
            int count = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                count++;
                if (null != node.left) {
                    queue.offer(node.left);
                }
                if (null != node.right) {
                    queue.offer(node.right);
                }
            }
            res.add(sum / count);
        }
        return res;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    /**
     * N叉树的层序遍历
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (null == root) {
            return res;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                list.add(poll.val);
                if (null != poll.children) {
                    for (Node node : poll.children) {
                        queue.add(node);
                    }
                }
            }
            res.add(list);
        }
        return res;
    }

    /**
     * 在每个树行中找到最大的值
     *
     * @param root
     * @return
     */
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (null == root) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                max = Math.max(max, poll.val);
                if (null != poll.left) {
                    queue.offer(poll.left);
                }
                if (null != poll.right) {
                    queue.offer(poll.right);
                }
            }
            res.add(max);
        }
        return res;
    }

    class NodeTree {
        public int val;
        public NodeTree left;
        public NodeTree right;
        public NodeTree next;

        public NodeTree() {
        }

        public NodeTree(int _val) {
            val = _val;
        }

        public NodeTree(int _val, NodeTree _left, NodeTree _right, NodeTree _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    /**
     * 填充每个节点的下一个右侧节点指针
     *
     * @param root
     * @return
     */
    public NodeTree connect(NodeTree root) {
        if (null == root) {
            return null;
        }
        Queue<NodeTree> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                NodeTree poll = queue.poll();
                if (i < size - 1) {
                    poll.next = queue.peek();
                }
                if (null != poll.left) {
                    queue.offer(poll.left);
                }
                if (null != poll.right) {
                    queue.offer(poll.right);
                }
            }

        }
        return root;
    }

    /**
     * 二叉树的最大深度
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        int depth = 0;
        if (null == root) {
            return depth;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (null != node.left) {
                    queue.offer(node.left);
                }
                if (null != node.right) {
                    queue.offer(node.right);
                }
            }
            depth++;
        }
        return depth;
    }

    /**
     * 二叉树的最小深度
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        int depth = 0;
        if (null == root) {
            return depth;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (null != node.left) {
                    queue.offer(node.left);
                }
                if (null != node.right) {
                    queue.offer(node.right);
                }
                if (null == node.left && null == node.right) {
                    return depth;
                }
            }
        }
        return depth;
    }

    /**
     * 反转链表-递归
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (null == root) {
            return null;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;
    }

    /**
     * 反转链表-迭代
     *
     * @param root
     * @return
     */
    public TreeNode invertTreeIterative(TreeNode root) {
        if (null == root) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            TreeNode left = node.left;
            TreeNode right = node.right;
            node.left = right;
            node.right = left;
            if (null != right) {
                stack.push(right);
            }
            if (null != left) {
                stack.push(left);
            }
        }
        return root;
    }

    /**
     * N叉树的前序遍历-迭代
     *
     * @param root
     * @return
     */
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (null == root) {
            return res;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node poll = stack.pop();
            res.add(poll.val);
            for (int i = poll.children.size() - 1; i >= 0; i--) {
                if (null != poll.children.get(i)) {
                    stack.push(poll.children.get(i));
                }
            }
        }
        return res;
    }

    /**
     * N叉树的前序遍历-递归
     *
     * @param root
     * @return
     */
    public List<Integer> preorderRecursive(Node root) {
        List<Integer> res = new ArrayList<>();
        preorderRecursive(root, res);
        return res;
    }

    private void preorderRecursive(Node node, List<Integer> res) {
        if (null != node) {
            res.add(node.val);
            for (Node child : node.children) {
                preorderRecursive(child, res);
            }
        }
    }

    /**
     * N叉树的后序遍历-迭代
     *
     * @param root
     * @return
     */
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        postorder(root, res);
        return res;
    }

    private void postorder(Node node, List<Integer> res) {
        if (null != node) {
            for (Node child : node.children) {
                postorder(child, res);
            }
            res.add(node.val);
        }
    }

    /**
     * N叉树的后序遍历-迭代
     *
     * @param root
     * @return
     */
    public List<Integer> postorderIterative(Node root) {
        List<Integer> res = new ArrayList<>();
        if (null == root) {
            return res;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node poll = stack.pop();
            res.add(poll.val);
            for (Node child : poll.children) {
                if (null != child) {
                    stack.push(child);
                }
            }
        }
        Collections.reverse(res);
        return res;
    }

    /**
     * 是否对称二叉树-递归
     *
     * @param root
     * @return
     */
    public boolean isSymmetricRecursive(TreeNode root) {
        if (null == root) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (null != left && null == right) {
            return false;
        } else if (null == left && null != right) {
            return false;
        } else if (null == left && null == right) {
            return true;
        } else if (left.val != right.val) {
            return false;
        }
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

    /**
     * 是否对称二叉树-迭代
     *
     * @param root
     * @return
     */
    public boolean isSymmetricIterative(TreeNode root) {
        if (null == root) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (null == left && null == right) {
                continue;
            }
            if (null == left || null == right || left.val != right.val) {
                return false;
            }
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }

    /**
     * 是否是相同结构的二叉树
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (null == p && null == q) {
            return true;
        } else if (null == p || null == q) {
            return false;
        }
        return p.val == q.val && isSameTree(p.left, q.left) &&
                isSameTree(p.right, q.right);
    }

    /**
     * 另一棵树的子树
     *
     * @param root
     * @param subRoot
     * @return
     */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (null == root || subRoot == null) {
            return false;
        }
        return isSameTree(root, subRoot) ||
                isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    /**
     * 二叉树的最大深度-递归
     *
     * @param root
     * @return
     */
    public int maxDepthRecursive(TreeNode root) {
        if (null == root) {
            return 0;
        }
        return 1 + Math.max(maxDepthRecursive(root.left), maxDepthRecursive(root.right));
    }

    /**
     * 二叉树的最小深度-递归
     *
     * @param root
     * @return
     */
    public int minDepthRecursive(TreeNode root) {
        if (null == root) {
            return 0;
        }
        if (null == root.left && null != root.right) {
            return 1 + minDepthRecursive(root.right);
        }
        if (null != root.left && null == root.right) {
            return 1 + minDepthRecursive(root.left);
        }
        return 1 + Math.min(minDepthRecursive(root.left), minDepthRecursive(root.right));
    }

    /**
     * 二叉树的节点个数
     *
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;

    }

    /**
     * 完全二叉树的节点个数
     *
     * @param root
     * @return
     */
    public int countNodesComplete(TreeNode root) {
        if (null == root) {
            return 0;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        int leftDepth = 0;
        int rightDepth = 0;
        while (null != left) {
            left = left.left;
            leftDepth++;
        }
        while (null != right) {
            right = right.right;
            rightDepth++;
        }
        if (leftDepth == rightDepth) {
            return (2 << leftDepth) - 1;
        }
        return 1 + countNodesComplete(root.left) + countNodesComplete(root.right);
    }

    /**
     * 平衡二叉树
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (null == root) {
            return true;
        }
        return isBalanced(root.left) && isBalanced(root.right) &&
                Math.abs(height(root.left) - height(root.right)) < 2;
    }

    private int height(TreeNode root) {
        if (null == root) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

    /**
     * 二叉树的所有路径
     *
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (null == root) {
            return res;
        }
        binaryTreePaths(root, res, "");
        return res;
    }

    private void binaryTreePaths(TreeNode node, List<String> res, String path) {
        if (null == node) {
            return;
        }
        if (null == node.right && null == node.left) {
            res.add(path + node.val);
            return;
        }
        String tmp = path + node.val + "->";
        binaryTreePaths(node.left, res, tmp);
        binaryTreePaths(node.right, res, tmp);
    }

    /**
     * 左叶子之和-递归
     *
     * @param root
     * @return
     */
    public int sumOfLeftLeavesRecursive(TreeNode root) {
        if (null == root) {
            return 0;
        }
        if (null == root.left && null == root.right) {
            return 0;
        }
        int leftValue = sumOfLeftLeavesRecursive(root.left);
        if (null != root.left && null == root.left.left && null == root.left.right) {
            leftValue = root.left.val;
        }
        int rightValue = sumOfLeftLeavesRecursive(root.right);
        return leftValue + rightValue;
    }

    /**
     * 左叶子之和-前序遍历迭代
     *
     * @param root
     * @return
     */
    public int sumOfLeftLeavesPreorder(TreeNode root) {
        if (null == root) {
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int sum = 0;
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            if (null != treeNode.left && null == treeNode.left.left && null == treeNode.left.right) {
                sum += treeNode.left.val;
            }
            if (null != treeNode.right) {
                stack.push(treeNode.right);
            }
            if (null != treeNode.left) {
                stack.push(treeNode.left);
            }
        }
        return sum;
    }

    /**
     * 左叶子之和-层序遍历迭代
     *
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if (null == root) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int sum = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (null != node.left && null == node.left.left && null == node.left.right) {
                    sum += node.left.val;
                }
                if (null != node.left) {
                    queue.offer(node.left);
                }
                if (null != node.right) {
                    queue.offer(node.right);
                }
            }
        }
        return sum;
    }

    /**
     * 最左则叶子节点的值-迭代
     *
     * @param root
     * @return
     */
    public int findBottomLeftValue(TreeNode root) {
        if (null == root) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == 0) {
                    res = node.val;
                }
                if (null != node.left) {
                    queue.offer(node.left);
                }
                if (null != node.right) {
                    queue.offer(node.right);
                }
            }
        }
        return res;
    }

    int maxDepth = 0;
    int res;

    /**
     * 最左则叶子节点的值-递归
     *
     * @param root
     * @return
     */
    public int findBottomLeftValueRecursive(TreeNode root) {
        res = root.val;
        findBottomLeftValueRecursive(root, 0);
        return res;
    }

    private void findBottomLeftValueRecursive(TreeNode node, int depth) {
        if (null == node) {
            return;
        }
        if (null == node.left && null == node.right) {
            if (maxDepth < depth) {
                maxDepth = depth;
                res = node.val;
            }
        }
        if (null != node.left) {
            depth++;
            findBottomLeftValueRecursive(node.left, depth);
            depth--;
        }
        if (null != node.right) {
            depth++;
            findBottomLeftValueRecursive(node.right, depth);
        }
    }

    boolean hasPathSum;

    /**
     * 路径总和
     *
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        orderBinary(root, root == null ? 0 : root.val, targetSum);
        return hasPathSum;
    }

    private void orderBinary(TreeNode node, int sum, int targetSum) {
        if (null == node) {
            return;
        }
        if (null == node.left && null == node.right) {
            if (sum == targetSum) {
                hasPathSum = true;
            }
            return;
        }
        if (null != node.left) {
            sum += node.left.val;
            orderBinary(node.left, sum, targetSum);
            sum -= node.left.val;
        }
        if (null != node.right) {
            sum += node.right.val;
            orderBinary(node.right, sum, targetSum);
            sum -= node.right.val;
        }
    }

    public boolean hasPathSumIteration(TreeNode root, int targetSum) {
        if (null == root) {
            return false;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        stack.push(root);
        stack2.push(root.val);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            Integer sum = stack2.pop();
            if (null == node.left && null == node.right && sum == targetSum) {
                return true;
            }
            if (null != node.right) {
                stack.push(node.right);
                stack2.push(sum + node.right.val);
            }
            if (null != node.left) {
                stack.push(node.left);
                stack2.push(sum + node.left.val);
            }
        }
        return false;
    }

    /**
     * 路径综合II-递归
     *
     * @param root
     * @param targetSum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (null == root) {
            return res;
        }
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        orderBinary(root, root.val, res, list, targetSum);
        return res;
    }

    private void orderBinary(TreeNode node, int sum, List<List<Integer>> res,
                             List<Integer> list, int targetSum) {
        if (null == node) {
            return;
        }
        if (null == node.left && null == node.right) {
            if (sum == targetSum) {
                res.add(new ArrayList<>(list));
            }
            return;
        }
        if (null != node.left) {
            list.add(node.left.val);
            orderBinary(node.left, sum + node.left.val, res, list, targetSum);
            list.remove(list.size() - 1);
        }
        if (null != node.right) {
            list.add(node.right.val);
            orderBinary(node.right, sum + node.right.val, res, list, targetSum);
            list.remove(list.size() - 1);
        }
    }

    /**
     * 根据中序遍历和后序遍历重建二叉树
     *
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (null == inorder || null == postorder ||
                inorder.length != postorder.length ||
                inorder.length == 0) {
            return null;
        }
        int rootValue = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(rootValue);
        int delimiterIndex;
        for (delimiterIndex = 0; delimiterIndex < inorder.length; delimiterIndex++) {
            if (rootValue == inorder[delimiterIndex]) {
                break;
            }
        }
        int[] leftInorder = delimiterArray(inorder, 0, delimiterIndex);
        int[] rightInorder = delimiterArray(inorder, delimiterIndex + 1, inorder.length);

        int[] leftPostorder = delimiterArray(postorder, 0, leftInorder.length);
        int[] rightPostorder = delimiterArray(postorder, leftInorder.length, postorder.length - 1);
        root.left = buildTree(leftInorder, leftPostorder);
        root.right = buildTree(rightInorder, rightPostorder);
        return root;
    }

    private int[] delimiterArray(int[] array, int start, int end) {
        int[] res = new int[end - start];
        for (int i = start; i < end; i++) {
            res[i - start] = array[i];
        }
        return res;
    }

    /**
     * 前序遍历和中序遍历构造二叉树
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTreePreIn(int[] preorder, int[] inorder) {
        if (null == preorder || null == inorder || preorder.length != inorder.length || preorder.length == 0) {
            return null;
        }
        int rootValue = preorder[0];
        TreeNode root = new TreeNode(rootValue);
        int delimiterIndex;
        for (delimiterIndex = 0; delimiterIndex < inorder.length; delimiterIndex++) {
            if (rootValue == inorder[delimiterIndex]) {
                break;
            }
        }
        int[] leftInorder = delimiterArray(inorder, 0, delimiterIndex);
        int[] rightInorder = delimiterArray(inorder, delimiterIndex + 1, inorder.length);

        int[] leftPreorder = delimiterArray(preorder, 1, leftInorder.length + 1);
        int[] rightPreorder = delimiterArray(preorder, leftInorder.length + 1, preorder.length);
        root.left = buildTreePreIn(leftPreorder, leftInorder);
        root.right = buildTreePreIn(rightPreorder, rightInorder);
        return root;
    }

    /**
     * 最大二叉树
     *
     * @param nums
     * @return
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (null == nums || nums.length == 0) {
            return null;
        }
        int maxValueIndex = 0;
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxValue) {
                maxValueIndex = i;
                maxValue = nums[maxValueIndex];
            }
        }

        TreeNode root = new TreeNode(maxValue);
        int[] left = delimiterArray(nums, 0, maxValueIndex);
        int[] right = delimiterArray(nums, maxValueIndex + 1, nums.length);
        root.left = constructMaximumBinaryTree(left);
        root.right = constructMaximumBinaryTree(right);
        return root;
    }

    /**
     * 合并两个二叉树-递归
     *
     * @param root1
     * @param root2
     * @return
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (null == root1) {
            return root2;
        }
        if (null == root2) {
            return root1;
        }
        root1.val += root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }

    /**
     * 合并两个二叉树-迭代
     *
     * @param root1
     * @param root2
     * @return
     */
    public TreeNode mergeTreesRecursive(TreeNode root1, TreeNode root2) {
        if (null == root1) {
            return root2;
        }
        if (null == root2) {
            return root1;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root1);
        stack.push(root2);
        while (!stack.isEmpty()) {
            TreeNode node2 = stack.pop();
            TreeNode node1 = stack.pop();
            node1.val += node2.val;
            if (null != node1.left && null != node2.left) {
                stack.push(node1.left);
                stack.push(node2.left);
            }
            if (null != node1.right && null != node2.right) {
                stack.push(node1.right);
                stack.push(node2.right);
            }
            if (null == node1.left && null != node2.left) {
                node1.left = node2.left;
            }
            if (null == node1.right && null != node2.right) {
                node1.right = node2.right;
            }
        }
        return root1;
    }

    /**
     * 二叉搜索树的搜索-递归
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (null == root) {
            return null;
        }
//        if (val == root.val) {
//            return root;
//        }
//        TreeNode treeNode = searchBST(root.left, val);
//        if (null != treeNode) {
//            return treeNode;
//        }
//        return searchBST(root.right, val);
        if (root.val == val) {
            return root;
        } else if (root.val < val) {
            return searchBST(root.right, val);
        } else {
            return searchBST(root.left, val);
        }
    }

    /**
     * 二叉搜索树的搜索-迭代
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBSTIterator(TreeNode root, int val) {
        while (null != root) {
            if (val == root.val) {
                return root;
            } else if (val < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return null;
    }

    /**
     * 二叉搜索树的验证-递归
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }

    /**
     * 验证二叉搜索树-迭代
     *
     * @param root
     * @return
     */
    public boolean isValidBSTIterator(TreeNode root) {
        if (null == root) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;
        while (null != cur || !stack.isEmpty()) {
            if (null != cur) {
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode treeNode = stack.pop();
                if (null != pre && treeNode.val <= pre.val) {
                    return false;
                }
                pre = treeNode;
                if (null != treeNode.right) {
                    cur = treeNode.right;
                }
            }
        }
        return true;
    }

    int result = Integer.MAX_VALUE;
    TreeNode pre = null;

    /**
     * 二叉搜索树的最小绝对差-递归
     *
     * @param root
     * @return
     */
    public int getMinimumDifference(TreeNode root) {
        getMinimumDifferenceOrder(root);
        return result;
    }

    private void getMinimumDifferenceOrder(TreeNode treeNode) {
        if (null == treeNode) {
            return;
        }
        getMinimumDifferenceOrder(treeNode.left);
        if (null != pre) {
            result = Math.min(result, treeNode.val - pre.val);
        }
        pre = treeNode;
        getMinimumDifference(treeNode.right);
    }

    /**
     * 二叉搜索树的最小绝对差-迭代
     *
     * @param root
     * @return
     */
    public int getMinimumDifferenceIterator(TreeNode root) {
        if (null == root) {
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        int result = Integer.MAX_VALUE;
        TreeNode pre = null;
        while (null != cur || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode treeNode = stack.pop();
            if (null != pre) {
                result = Math.min(result, treeNode.val - pre.val);
            }
            pre = treeNode;
            cur = treeNode.right;
        }
        return result;
    }
}
