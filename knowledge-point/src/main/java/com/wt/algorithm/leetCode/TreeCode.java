package com.wt.algorithm.leetCode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/11/29 0:51
 */
public class TreeCode {
    /**
     * 前序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        treeTraversalBefore(root, list);
        return list;
    }

    private void treeTraversalBefore(TreeNode treeNode, List<Integer> list) {
        if (null != treeNode) {
            list.add(treeNode.val);
            treeTraversalBefore(treeNode.left, list);
            treeTraversalBefore(treeNode.right, list);
        }
    }

    private void treeTraversalBeforeIterator(TreeNode treeNode, List<Integer> list) {
        if (null == treeNode) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(treeNode);
        while (!stack.isEmpty()) {
            TreeNode treeNodeEle = stack.pop();
            list.add(treeNodeEle.val);
            if (null != treeNodeEle.right) {
                stack.push(treeNodeEle.right);
            }
            if (null != treeNodeEle.left) {
                stack.push(treeNodeEle.left);
            }
        }
    }

    /**
     * 后续遍历
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        treeTraversalAfter(root, list);
        return list;
    }

    private void treeTraversalAfter(TreeNode treeNode, List<Integer> list) {
        if (null != treeNode) {
            treeTraversalAfter(treeNode.left, list);
            treeTraversalAfter(treeNode.right, list);
            list.add(treeNode.val);
        }
    }

    /**
     * 栈实现
     *
     * @param treeNode
     * @param list
     */
    private void treeTraversalAfterIterator(TreeNode treeNode, List<Integer> list) {
        if (null != treeNode) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(treeNode);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                list.add(node.val);
                if (null != node.left) {
                    stack.push(node.left);
                }
                if (null != node.right) {
                    stack.push(node.right);
                }
            }
            reverseList(list);
        }
    }

    private void reverseList(List<Integer> list) {
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            Integer rightVale = list.get(right);
            list.set(right, list.get(left));
            list.set(left, rightVale);
            left++;
            right--;
        }
    }

    /**
     * 中序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        treeTraversalMiddle(root, list);
        return list;
    }

    private void treeTraversalMiddle(TreeNode treeNode, List<Integer> list) {
        if (null != treeNode) {
            treeTraversalMiddle(treeNode.left, list);
            list.add(treeNode.val);
            treeTraversalMiddle(treeNode.right, list);
        }
    }

    /**
     * 中序遍历迭代法
     *
     * @param treeNode
     * @param list
     */
    private void treeTraversalMiddleIterator(TreeNode treeNode, List<Integer> list) {
        if (null != treeNode) {
            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur = treeNode;
            while (cur != null || !stack.isEmpty()) {
                if (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                } else {
                    TreeNode pop = stack.pop();
                    list.add(pop.val);
                    cur = pop.right;
                }
            }
        }
    }

    /**
     * 层序遍历
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (null == root) {
            return list;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> sizeList = new ArrayList<>();
            while (size > 0) {
                TreeNode treeNode = queue.poll();
                sizeList.add(treeNode.val);
                if (null != treeNode.left) {
                    queue.offer(treeNode.left);
                }
                if (null != treeNode.right) {
                    queue.offer(treeNode.right);
                }
                size--;
            }
            list.add(sizeList);
        }
        return list;
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        if (null == root) {
            return list;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> sizeList = new ArrayList<>();
            while (size > 0) {
                TreeNode treeNode = queue.poll();
                sizeList.add(treeNode.val);
                if (null != treeNode.left) {
                    queue.offer(treeNode.left);
                }
                if (null != treeNode.right) {
                    queue.offer(treeNode.right);
                }
                size--;
            }
            list.add(sizeList);
        }
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            List<Integer> rightValue = list.get(right);
            list.set(right, list.get(left));
            list.set(left, rightValue);
            left++;
            right--;
        }
        return list;
    }

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (null == root) {
            return list;
        }
        Queue<TreeNode> treeNodes = new ArrayDeque<>();
        treeNodes.offer(root);
        while (!treeNodes.isEmpty()) {
            int size = treeNodes.size();
            while (size > 0) {
                TreeNode treeNode = treeNodes.poll();
                if (null != treeNode.left) {
                    treeNodes.offer(treeNode.left);
                }
                if (null != treeNode.right) {
                    treeNodes.offer(treeNode.right);
                }
                if (size == 1) {
                    list.add(treeNode.val);
                }
                size--;
            }
        }
        return list;
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        if (null == root) {
            return list;
        }
        Queue<TreeNode> treeNodes = new ArrayDeque<>();
        treeNodes.offer(root);
        while (!treeNodes.isEmpty()) {
            int size = treeNodes.size();
            double sum = 0;
            int count = size;
            while (size > 0) {
                TreeNode treeNode = treeNodes.poll();
                sum += treeNode.val;
                if (null != treeNode.left) {
                    treeNodes.offer(treeNode.left);
                }
                if (null != treeNode.right) {
                    treeNodes.offer(treeNode.right);
                }
                size--;
            }
            list.add(sum / count);
        }
        return list;
    }

    public List<List<Integer>> levelOrder(Node1 root) {
        List<List<Integer>> list = new ArrayList<>();
        if (null == root) {
            return list;
        }
        Queue<Node1> nodes = new ArrayDeque<>();
        nodes.offer(root);
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            List<Integer> layerList = new ArrayList<>();
            while (size > 0) {
                Node1 poll = nodes.poll();
                layerList.add(poll.val);
                if (null != poll.children) {
                    for (Node1 child : poll.children) {
                        nodes.offer(child);
                    }
                }
                size--;
            }
            list.add(layerList);
        }
        return list;
    }

    class Node1 {
        public int val;
        public List<Node1> children;

        public Node1() {
        }

        public Node1(int _val) {
            val = _val;
        }

        public Node1(int _val, List<Node1> _children) {
            val = _val;
            children = _children;
        }
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if (null == root) {
            return root;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node next = null;
            while (size > 0) {
                Node node = queue.poll();
                node.next = next;
                if (null != node.right) {
                    queue.offer(node.right);
                }
                if (null != node.left) {
                    queue.offer(node.left);
                }
                size--;
                next = node;
            }
        }
        return root;
    }

    public int maxDepth(TreeNode root) {
        int deep = 0;
        if (null == root) {
            return deep;
        }
        Queue<TreeNode> treeNodes = new ArrayDeque<>();
        treeNodes.offer(root);
        while (!treeNodes.isEmpty()) {
            int size = treeNodes.size();
            while (size > 0) {
                TreeNode treeNode = treeNodes.poll();
                if (null == treeNode.left && null == treeNode.right) {
                    return deep;
                }
                if (null != treeNode.left) {
                    treeNodes.offer(treeNode.left);
                }
                if (null != treeNode.right) {
                    treeNodes.offer(treeNode.right);
                }
                size--;
            }
            deep++;
        }
        return deep;
    }

    public TreeNode invertTree(TreeNode root) {
        invertTreeBefore(root);
        return root;
    }

    private void invertTreeBefore(TreeNode treeNode) {
        if (null != treeNode) {
            TreeNode node = treeNode.left;
            treeNode.left = treeNode.right;
            treeNode.right = node;
            invertTreeBefore(treeNode.left);
            invertTreeBefore(treeNode.right);
        }
    }

    private void invertTreeBeforeIterator(TreeNode treeNode) {
        if (null != treeNode) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(treeNode);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                TreeNode leftNode = node.left;
                node.left = node.right;
                node.right = leftNode;
                if (null != node.left) {
                    stack.push(node.left);
                }
                if (null != node.right) {
                    stack.push(node.right);
                }
            }
        }
    }

    private void invertTreeBeforeIteratorBFS(TreeNode treeNode) {
        if (null != treeNode) {
            Queue<TreeNode> treeNodes = new ArrayDeque<>();
            treeNodes.offer(treeNode);
            while (!treeNodes.isEmpty()) {
                int size = treeNodes.size();
                while (size-- > 0) {
                    TreeNode node = treeNodes.poll();
                    TreeNode leftNode = node.left;
                    node.left = node.right;
                    node.right = leftNode;
                    if (null != node.left) {
                        treeNodes.offer(node.left);
                    }
                    if (null != node.right) {
                        treeNodes.offer(node.right);
                    }
                }
            }
        }
    }

    /**
     * 判断二叉树是否是对称的
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (null == root) {
            return true;
        }
        return compare(root.left, root.right);
    }

    private boolean compare(TreeNode left, TreeNode right) {
        if (left != null && null == right) {
            return false;
        } else if (left == null && null != right) {
            return false;
        } else if (null == left && null == right) {
            return true;
        } else if (left.val != right.val) {
            return false;
        }
        boolean leftBool = compare(left.left, right.right);
        boolean rightBool = compare(left.right, right.left);
        return leftBool && rightBool;
    }

    public boolean isSymmetricIteratorQueue(TreeNode root) {
        if (null == root) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) {
            TreeNode leftNode = queue.poll();
            TreeNode rightNode = queue.poll();
            if (null == leftNode && null == rightNode) {
                continue;
            }
            if (null == leftNode || null == rightNode || leftNode.val != rightNode.val) {
                return false;
            }
            queue.add(leftNode.left);
            queue.offer(rightNode.right);
            queue.offer(leftNode.right);
            queue.offer(rightNode.left);
        }
        return true;
    }

    public boolean isSymmetricIteratorStack(TreeNode root) {
        if (null == root) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        while (!stack.isEmpty()) {
            TreeNode rightNode = stack.pop();
            TreeNode leftNode = stack.pop();
            if (null == rightNode && null == leftNode) {
                continue;
            }
            if (null == rightNode || null == leftNode || rightNode.val != leftNode.val) {
                return false;
            }
            stack.push(rightNode.right);
            stack.push(leftNode.left);
            stack.push(rightNode.left);
            stack.push(leftNode.right);
        }
        return true;
    }

    /**
     * 是否相同的树
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (null == p && null == q) {
            return true;
        }
        if (null == p || null == q) {
            return false;
        }
        Stack<TreeNode> queueP = new Stack<>();
        Stack<TreeNode> queueQ = new Stack<>();

        queueP.add(p);

        queueQ.add(q);

        while (!queueP.isEmpty() && !queueQ.isEmpty()) {
            TreeNode nodeP = queueP.pop();

            TreeNode nodeQ = queueQ.pop();

            if (nodeP == null && nodeQ == null) {
                continue;
            }
            if (nodeQ == null || nodeP == null || nodeP.val != nodeQ.val) {
                return false;
            }

            queueP.add(nodeP.left);
            queueP.add(nodeP.right);

            queueQ.add(nodeQ.left);
            queueQ.add(nodeQ.right);
        }
        return true;
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (null == root) {
            return false;
        }
        if (null == subRoot) {
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot) ||
                compareTwoTree(root, subRoot);
    }

    /**
     * 判断2棵树是否相等
     *
     * @param s
     * @param t
     * @return
     */
    private boolean compareTwoTree(TreeNode s, TreeNode t) {
        if (null == s && null == t) {
            return true;
        }
        if (null == s || null == t) {
            return false;
        }
        if (s.val != t.val) {
            return false;
        }
        return compareTwoTree(s.left, t.left) && compareTwoTree(s.right, t.right);
    }

    /**
     * 最大深度递归遍历
     *
     * @param root
     * @return
     */
    public int maxDepthRecur(TreeNode root) {
        if (null == root) {
            return 0;
        }
        return Math.max(maxDepthRecur(root.left), maxDepthRecur(root.right)) + 1;
    }

    public int minDepthRecur(TreeNode root) {
        if (null == root) {
            return 0;
        }
        if (null == root.left && null != root.right) {
            return 1 + minDepthRecur(root.right);
        }
        if (null != root.left && null == root.right) {
            return 1 + minDepthRecur(root.left);
        }
        return Math.min(minDepthRecur(root.left), minDepthRecur(root.right)) + 1;
    }

    public int countNodes(TreeNode root) {
        if (null == root) {
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    public int countNodesIterator(TreeNode root) {
        int count = 0;
        if (null == root) {
            return count;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (null != node.left) {
                queue.offer(node.left);
            }
            if (null != node.right) {
                queue.offer(node.right);
            }
            count++;
        }
        return count;
    }

    /**
     * 利用满2叉树的特点计算
     *
     * @param root
     * @return
     */
    public int countNodesFull(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;
        int leftCount = 0;
        int rightCount = 0;
        while (null != leftNode) {
            leftNode = leftNode.left;
            leftCount++;
        }
        while (null != rightNode) {
            rightNode = rightNode.right;
            rightCount++;
        }
        if (leftCount == rightCount) {
            return (2 << leftCount) - 1;
        }
        return countNodesFull(root.left) + countNodesFull(root.right) + 1;
    }

    /**
     * 判断是否是平衡二叉树
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (null == root) {
            return true;
        }
        return getHeight(root) != -1;
    }

    private int getHeight(TreeNode treeNode) {
        if (null == treeNode) {
            return 0;
        }
        int leftHeight = getHeight(treeNode.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = getHeight(treeNode.right);
        if (rightHeight == -1) {
            return -1;
        }
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return 1 + Math.max(leftHeight, rightHeight);
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
        transfer(root, new ArrayList<>(), res);
        return res;
    }

    private void transfer(TreeNode treeNode, List<Integer> nodeVales, List<String> result) {
        nodeVales.add(treeNode.val);
        if (null == treeNode.left && null == treeNode.right) {
            result.add(nodeVales.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining("->")));
            return;
        }
        if (null != treeNode.left) {
            transfer(treeNode.left, nodeVales, result);
            nodeVales.remove(nodeVales.size() - 1);
        }
        if (null != treeNode.right) {
            transfer(treeNode.right, nodeVales, result);
            nodeVales.remove(nodeVales.size() - 1);
        }
    }

    public List<String> binaryTreePathsIterator(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (null == root) {
            return res;
        }
        Stack<Object> stack = new Stack<>();
        stack.push(root);
        stack.add(root.val + "");
        while (!stack.isEmpty()) {

            String path = (String) stack.pop();
            TreeNode treeNode = (TreeNode) stack.pop();

            if (null == treeNode.left && null == treeNode.right) {
                res.add(path);
            }
            if (null != treeNode.right) {
                stack.push(treeNode.right);
                stack.push(path + "->" + treeNode.right.val);
            }
            if (null != treeNode.left) {
                stack.push(treeNode.left);
                stack.push(path + "->" + treeNode.left.val);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(3, treeNode4, null);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode1 = new TreeNode(1, treeNode2, treeNode3);
        List<Integer> list = rightSideView(treeNode1);
        list.stream().forEach(System.out::println);
    }
}
