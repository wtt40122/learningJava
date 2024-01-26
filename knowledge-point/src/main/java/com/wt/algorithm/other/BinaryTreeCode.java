package com.wt.algorithm.other;

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
}
