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

    /**
     * 左叶子节点之和
     *
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        if (null == root || (null == root.left && null == root.right)) {
            return sum;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            if (null != treeNode.left && treeNode.left.left == null && treeNode.left.right == null) {
                sum += treeNode.left.val;
            }
            if (treeNode.right != null) {
                stack.push(treeNode.right);
            }
            if (treeNode.left != null) {
                stack.push(treeNode.left);
            }
        }
        return sum;
    }

    /**
     * 左叶子节点之和递归法
     *
     * @param root
     * @return
     */
    public int sumOfLeftLeavesCur(TreeNode root) {
        if (null == root) {
            return 0;
        }
        if (null == root.left && null == root.right) {
            return 0;
        }
        int leftNum = sumOfLeftLeavesCur(root.left);
        if (null != root.left && null == root.left.left && null == root.left.right) {
            leftNum += root.left.val;
        }
        int rightNum = sumOfLeftLeavesCur(root.right);
        return leftNum + rightNum;
    }

    /**
     * 做叶子节点层序法
     *
     * @param root
     * @return
     */
    public int sumOfLeftLeavesLay(TreeNode root) {
        if (null == root) {
            return 0;
        }
        if (null == root.left && null == root.right) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int sum = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode treeNode = queue.poll();
                if (null != treeNode.left && treeNode.left.left == null && treeNode.left.right == null) {
                    sum += treeNode.left.val;
                }
                if (null != treeNode.left) {
                    queue.offer(treeNode.left);
                }
                if (null != treeNode.right) {
                    queue.offer(treeNode.right);
                }
                size--;
            }
        }
        return sum;
    }

    public int findBottomLeftValue(TreeNode root) {
        if (null == root) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int result = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int index = size;
            while (size > 0) {
                TreeNode node = queue.poll();
                if (size == index) {
                    result = node.val;
                }
                if (null != node.left) {
                    queue.offer(node.left);
                }
                if (null != node.right) {
                    queue.offer(node.right);
                }
                size--;
            }
        }
        return result;
    }

    int maxDepth = -1;
    int result = 0;

    public int findBottomLeftValueRecur(TreeNode root) {
        if (null == root) {
            return 0;
        }
        transfer(root, 0);
        return result;
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (null == root) {
            return false;
        }
        return transfer(root, targetSum - root.val);
    }

    private boolean transfer(TreeNode treeNode, int count) {
        if (null == treeNode.left && null == treeNode.right) {
            return count == 0;
        }
        if (null != treeNode.left && transfer(treeNode.left, count - treeNode.left.val)) {
            return true;
        }
        if (null != treeNode.right && transfer(treeNode.right, count - treeNode.right.val)) {
            return true;
        }
        return false;
    }

    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (null == root) {
            return list;
        }
        List<Integer> nodeList = new ArrayList<>();
        transfer(root, targetSum - root.val, nodeList);
        return list;
    }

    private void transfer(TreeNode treeNode, int count, List<Integer> nodes) {
        nodes.add(treeNode.val);
        if (null == treeNode.left && null == treeNode.right) {
            if (count == 0) {
                list.add(new ArrayList<>(nodes));
            }
        }
        if (null != treeNode.left) {
            transfer(treeNode.left, count - treeNode.left.val, nodes);
            nodes.remove(nodes.size() - 1);
        }
        if (null != treeNode.right) {
            transfer(treeNode.right, count - treeNode.right.val, nodes);
            nodes.remove(nodes.size() - 1);
        }
    }

    /**
     * 从中序与后序遍历序列构造二叉树
     *
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        if (postorder.length == 1) {
            return root;
        }
        int index;
        for (index = 0; index < inorder.length; index++) {
            if (root.val == inorder[index]) {
                break;
            }
        }
        // 切割中序数组
        int[] leftInorder = splitArray(inorder, 0, index);
        int[] rightInorder = splitArray(inorder, index + 1, inorder.length);

        // 切割后序数组
        int[] leftPostorder = splitArray(postorder, 0, leftInorder.length);
        int[] rightPostorder = splitArray(postorder, leftInorder.length, postorder.length - 1);
        root.left = buildTree(leftInorder, leftPostorder);
        root.right = buildTree(rightInorder, rightPostorder);
        return root;
    }

    private static int[] splitArray(int[] array, int start, int end) {
        int[] newArray = new int[end - start];
        for (int i = start; i < end; i++) {
            newArray[i - start] = array[i];
        }
        return newArray;
    }

    public TreeNode buildTreePi(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        if (preorder.length == 1) {
            return root;
        }
        int index;
        for (index = 0; index < inorder.length; index++) {
            if (preorder[0] == inorder[index]) {
                break;
            }
        }
        //切割中序
        int[] leftInorder = splitArray(inorder, 0, index);
        int[] rightInorder = splitArray(inorder, index + 1, inorder.length);
        //切割前序
        int[] leftPreorder = splitArray(preorder, 1, leftInorder.length + 1);
        int[] rightPreorder = splitArray(preorder, leftInorder.length + 1, preorder.length);
        root.left = buildTreePi(leftPreorder, leftInorder);
        root.right = buildTreePi(rightPreorder, rightInorder);
        return root;
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        int maxIndex = 0;
        int maxResult = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxResult) {
                maxResult = nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(maxResult);
        if (nums.length == 1) {
            return root;
        }
        //切割数据
        int[] leftNums = splitArray(nums, 0, maxIndex);
        int[] rightNums = splitArray(nums, maxIndex + 1, nums.length);
        root.left = constructMaximumBinaryTree(leftNums);
        root.right = constructMaximumBinaryTree(rightNums);
        return root;
    }

    public TreeNode constructMaximumBinaryTreeOpt(int[] nums) {
        return construct(nums, 0, nums.length);
    }

    public TreeNode construct(int[] nums, int left, int right) {
        if (left >= right) {
            return null;
        }
        int maxIndex = 0;
        int maxValue = 0;
        for (int i = left; i < right; i++) {
            if (nums[i] > maxValue) {
                maxIndex = i;
                maxValue = nums[i];
            }
        }
        TreeNode root = new TreeNode(maxValue);
        if (right - left == 1) {
            return root;
        }
        root.left = construct(nums, left, maxIndex);
        root.right = construct(nums, maxIndex + 1, right);
        return root;
    }

    /**
     * 合并二叉树
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

    public TreeNode searchBST(TreeNode root, int val) {
        if (null == root) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        if (root.val > val) {
            return searchBST(root.left, val);
        }
        return searchBST(root.right, val);
    }

    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        innerTree(root, list);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > list.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    private void innerTree(TreeNode treeNode, List<Integer> list) {
        if (null == treeNode) {
            return;
        }
        innerTree(treeNode.left, list);
        list.add(treeNode.val);
        innerTree(treeNode.right, list);
    }

    long maxValue = Long.MIN_VALUE;

    public boolean isValidBST1(TreeNode root) {
        if (null == root) {
            return true;
        }
        boolean left = isValidBST1(root.left);
        if (root.val > maxValue) {
            maxValue = root.val;
        } else {
            return false;
        }
        boolean right = isValidBST1(root.right);
        return left && right;
    }

    TreeNode pre = null;

    public boolean isValidBST2(TreeNode root) {
        if (null == root) {
            return true;
        }
        boolean left = isValidBST2(root.left);
        if (null != pre && pre.val > root.val) {
            return false;
        }
        pre = root;
        boolean right = isValidBST2(root.right);
        return left && right;
    }

    public int getMinimumDifference(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        innerTree(root, list);
        int minValue = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            int abs = Math.abs(list.get(i) - list.get(i - 1));
            if (abs < minValue) {
                minValue = abs;
            }
        }
        return minValue;
    }

    int minValue = Integer.MAX_VALUE;

    public int getMinimumDifference1(TreeNode root) {
        transfer(root);
        return minValue;
    }

    private void transfer(TreeNode cur) {
        if (null == cur) {
            return;
        }
        transfer(cur.left);
        if (null != pre) {
            minValue = Math.min(minValue, cur.val - pre.val);
        }
        pre = cur;
        transfer(cur.right);
    }

    /**
     * 二叉搜索树求众数
     *
     * @param root
     * @return
     */
    int count;
    int maxCount;
    List<Integer> valList = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        transferF(root);
        int[] result = new int[valList.size()];
        for (int i = 0; i < valList.size(); i++) {
            result[i] = valList.get(i);
        }
        return result;
    }

    private void transferF(TreeNode cur) {
        if (null == cur) {
            return;
        }
        transferF(cur.left);
        if (null == pre) {
            count = 1;
        } else if (pre.val == cur.val) {
            count++;
        } else {
            count = 1;
        }
        pre = cur;
        if (count == maxCount) {
            valList.add(cur.val);
        }
        if (count > maxCount) {
            valList.clear();
            valList.add(cur.val);
            maxCount = count;
        }
        transferF(cur.right);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (null != left && null != right) {
            return root;
        } else if (null == left && null != right) {
            return right;
        } else if (null != left && null == right) {
            return left;
        } else {
            return null;
        }
    }

    public TreeNode lowestCommonAncestors(TreeNode root, TreeNode p, TreeNode q) {
        if (null == root) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        if (root.val > p.val && root.val > q.val) {
            TreeNode left = lowestCommonAncestors(root.left, p, q);
            if (null != left) {
                return left;
            }
        }
        if (root.val < p.val && root.val < q.val) {
            TreeNode right = lowestCommonAncestors(root.right, p, q);
            if (null != right) {
                return right;
            }
        }
        return root;
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (null == root) {
            root = new TreeNode(val);
        }
        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        }
        if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }

    /**
     * 二叉搜索树删除节点
     *
     * @param root
     * @param key
     * @return
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (null == root) {
            return null;
        }
        if (root.val == key) {
            if (null == root.left && null == root.right) {
                return null;
            } else if (null != root.left && null == root.right) {
                return root.left;
            } else if (null == root.left && null != root.right) {
                return root.right;
            } else {
                TreeNode cur = root.right;
                while (null != cur.left) {
                    cur = cur.left;
                }
                cur.left = root.left;
                return root.right;
            }
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    /**
     * 修剪二叉树
     *
     * @param root
     * @param low
     * @param high
     * @return
     */
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (null == root) {
            return null;
        }
        if (root.val < low) {
            return trimBST(root.right, low, high);
        }
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return traversal(nums, 0, nums.length - 1);
    }

    public TreeNode traversal(int[] nums, int left, int right) {
        if (nums.length == 0) {
            return null;
        }
        int middle = left + ((right - left) / 2);
        TreeNode node = new TreeNode(nums[middle]);
        node.left = traversal(nums, left, middle);
        node.right = traversal(nums, middle + 1, nums.length - 1);
        return node;
    }

    public TreeNode convertBST(TreeNode root) {
        traversal(root);
        return root;
    }

    int preVa = 0;

    private void traversal(TreeNode treeNode) {
        if (null == treeNode) {
            return;
        }
        traversal(treeNode.right);
        treeNode.val += preVa;
        preVa = treeNode.val;
        traversal(treeNode.left);
    }

    public static void main(String[] args) {
//        TreeNode treeNode4 = new TreeNode(4);
//        TreeNode treeNode3 = new TreeNode(3, treeNode4, null);
//        TreeNode treeNode2 = new TreeNode(2);
//        TreeNode treeNode1 = new TreeNode(1, treeNode2, treeNode3);
//        List<Integer> list = rightSideView(treeNode1);
//        list.stream().forEach(System.out::println);
        int[] array = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8};
        int[] ints = splitArray(array, 2, 8);
        Arrays.stream(ints).forEach(System.out::println);
        System.out.println(1 / 2);
    }
}
