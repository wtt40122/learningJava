package com.wt.algorithm.leetCode;

import java.util.*;

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

    public static void main(String[] args) {
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(3, treeNode4, null);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode1 = new TreeNode(1, treeNode2, treeNode3);
        List<Integer> list = rightSideView(treeNode1);
        list.stream().forEach(System.out::println);
    }
}
