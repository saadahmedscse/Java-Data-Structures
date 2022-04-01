import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTree {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree{
        static int idx = -1;
        public static Node buildTree(int nodes[]){
            idx++;

            if (nodes[idx] == -1) return null;

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        public static void preOrder(Node root){
            if (root == null) return;

            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }

        public static void inOrder(Node root){
            if (root == null) return;

            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }

        public static void postOrder (Node root){
            if (root == null) return;

            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }

        public static void levelOrder (Node root){
            if (root == null) return;

            Queue<Node> q = new LinkedList<>();

            q.add(root);
            q.add(null);

            while(!q.isEmpty()){
                Node currentNode = q.remove();

                if (currentNode == null){
                    System.out.println();
                    if (q.isEmpty()){
                        break;
                    }
                    else {
                        q.add(null);
                    }
                }
                else {
                    System.out.print(currentNode.data + " ");
                    if (currentNode.left != null){
                        q.add(currentNode.left);
                    }
                    if (currentNode.right != null){
                        q.add(currentNode.right);
                    }
                }
            }
        }

        public static int countNodes (Node root){
            if (root == null){
                return 0;
            }

            int leftCount = countNodes(root.left);
            int rightCount = countNodes(root.right);

            return leftCount + rightCount + 1;
        }

        public static int sumOfNodes (Node root){
            if (root == null) return 0;

            int leftSum = sumOfNodes(root.left);
            int rightSum = sumOfNodes(root.right);

            return leftSum + rightSum + root.data;
        }

        public static int treeHeight (Node root){
            if (root == null) return 0;

            int leftHeight = treeHeight(root.left);
            int rightHeight = treeHeight(root.right);

            return Math.max(leftHeight, rightHeight) + 1;
        }

        //Aproach O(n^2)
        public static int maxDiameter (Node root){
            if (root == null) return 0;

            int leftDiam = maxDiameter(root.left);
            int rightDiam = maxDiameter(root.right);
            int diam = treeHeight(root.left) + treeHeight(root.right) + 1;

            return Math.max(Math.max(leftDiam, rightDiam), diam);
        }

        static class TreeInfo{
            int height;
            int diameter;

            public TreeInfo(int height, int diameter){
                this.height = height;
                this.diameter = diameter;
            }
        }

        //Aproach O(n)
        public static TreeInfo maxDiameter2(Node root){
            if (root == null) return new TreeInfo(0, 0);

            TreeInfo left = maxDiameter2(root.left);
            TreeInfo right = maxDiameter2(root.right);
            int height = Math.max(left.height, right.height) + 1;

            int leftDiam = left.diameter;
            int rightDiam = right.diameter;
            int diameter = left.height + right.height + 1;

            int largestDiameter = Math.max(Math.max(leftDiam, rightDiam), diameter);
            TreeInfo info = new TreeInfo(height, largestDiameter);

            return info;
        }
    }
    public static void main(String[] args) {
        
        int nodes[] = {9, 1, 6, -1, -1, 4, -1, -1, 7, -1, 2, -1, -1,}; // -1 Represents null nodes or the next of last nodes

        Node root = BinaryTree.buildTree(nodes);
        //BinaryTree.preOrder(root); // Time Complexity is O(n)
        //BinaryTree.inOrder(root); // Time Complexity is O(n)
        //BinaryTree.postOrder(root); // Time Complexity is O(n)
        //BinaryTree.levelOrder(root); // Time Complexity is O(n)
        //System.out.println(BinaryTree.countNodes(root)); // Time Complexity is O(n)
        //System.out.println(BinaryTree.sumOfNodes(root)); // Time Complexity is O(n)
        //System.out.println(BinaryTree.treeHeight(root)); // Time Complexity is O(n)
        //System.out.println(BinaryTree.maxDiameter(root)); // Time Complexity is O(n^2)
        System.out.println(BinaryTree.maxDiameter2(root).diameter); // Time Complexity is O(n)
    }
}