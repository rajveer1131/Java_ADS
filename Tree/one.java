package Tree;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class TreeDataStructure {
    Node root = null;

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }
    TreeDataStructure(){
        root=null;
    }

    void makeTree() {
        root = new Node(5);
        root.left = new Node(7);
        root.right = new Node(8);
        root.left.right = new Node(10);
        root.right.left = new Node(6);
    }
    Node makeTree2() {
        Node subRoot = new Node(5);
        subRoot.left = new Node(7);
        subRoot.right = new Node(8);
        subRoot.left.right = new Node(10);
        subRoot.right.left = new Node(6);
        return subRoot;
    }

    private void preOrder(Node currNode) {
        if (currNode == null) {
            return;
        }
        System.out.print(currNode.data + " ");
        preOrder(currNode.left);
        preOrder(currNode.right);
    }

    void preOrder() {
        preOrder(root);
        System.out.println();
    }

    void preOrderIT() {
        Stack<Node> st=new Stack<>();
        st.push(root);
        while (!st.isEmpty()) {
            Node currNode = st.pop();

            System.out.print(currNode.data + " ");
            if (currNode.right != null) {

                st.push(currNode.right);
            }
            if (currNode.left != null) {

                st.push(currNode.left);
            }

        }
    }

    private void inOrder(Node currNode) {
        if (currNode == null) {
            return;
        }

        inOrder(currNode.left);
        System.out.print(currNode.data + " ");
        inOrder(currNode.right);
    }

    void inOder() {
        inOrder(root);
        System.out.println();
    }

    void inOrderIt(){
        Stack<Node> st=new Stack<>();
        Node currNode=root;

        System.out.println();
        while(true){
            if(currNode!=null){
                st.push(currNode);
                currNode=currNode.left;
            }
            else{
                if(st.isEmpty()){
                    break;
                }
                currNode=st.pop();
                System.out.print(currNode.data+" ");
                currNode=currNode.right;
            }
        }
    }

    private void postOrder(Node currNode) {
        if (currNode == null) {
            return;
        }

        postOrder(currNode.left);
        postOrder(currNode.right);
        System.out.print(currNode.data + " ");
    }

    void postOder() {
        postOrder(root);
        System.out.println();
    }

    void levelOrder() {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);

        while (!q.isEmpty()) {
            Node currNode = q.poll();
            if (currNode == null) {
                System.out.println();
                if (!q.isEmpty()) {
                    q.offer(null);
                }
            } else {

                System.out.print(currNode.data + " ");
                if (currNode.left != null) {
                    q.offer(currNode.left);
                }
                if (currNode.right != null) {
                    q.offer(currNode.right);
                }
            }

        }
    }


    private int countNode(Node currNode) {
        if (currNode == null) {
            return 0;
        }
        int l = countNode(currNode.left);
        int r = countNode(currNode.right);
        return l + r + 1;
    }

    int countNode() {
        System.out.print("\nNo of Nodes: ");
        return countNode(root);
    }

    private int countLeafNode(Node currNode) {
        if (currNode == null) {
            return 0;
        }
        if (currNode.left == null && currNode.right == null) {
            return 1;
        }
        int l = countLeafNode(currNode.left);
        int r = countLeafNode(currNode.right);
        return l + r;
    }

    int countLeafNode() {
        System.out.print("\nNo of Leaf Nodes: ");
        return countLeafNode(root);
    }

    private void makeTreeLevelOrder() {
        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter root");

        int x = sc.nextInt();
        root = new Node(x);
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            Node currNode = q.poll();
//            System.out.println("CurrNode is: "+currNode.data);
//            System.out.println("Enter "+currNode.data+"`s left" );
            int n = sc.nextInt();
            if (n == -1) {
                currNode.left = null;

            } else {
                currNode.left = new Node(n);
                q.offer(currNode.left);
            }

//            System.out.println("Enter "+currNode.data+"`s right" );
            n = sc.nextInt();
            if (n == -1) {
                currNode.right = null;
            } else {
                currNode.right = new Node(n);
                q.offer(currNode.right);
            }

        }

    }


    boolean isSame(Node root1,Node root2){
            if(root1 == null && root2==null){
                return true;
            }
            if(root1 == null || root2==null){
                return false;
            }
            return (root1.data==root2.data) && isSame(root1.left,root2.left) && isSame(root1.right,root2.right);


    }

    boolean isSubtree(Node root1,Node root2){
            if(root2==null  ){
                return true;
            }
            if(root1==null ){
                return false;
            }

            if(root1.data==root2.data){
                return isSame(root1,root2);
            }
            return isSubtree(root1.left,root2) || isSubtree(root1.right,root2);

    }

    void checkSubTree(){
        makeTree();
        Node root2=makeTree2();
        if(isSubtree(root,root2))
            System.out.println("It is a subtree");
        else
            System.out.println("No its not subtree");
    }

    void zigZag(){
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        boolean isLeft=true;
        while(!q.isEmpty()){
            int n=q.size();
            int []arr=new int[n];

            System.out.println();
                for(int i=0;i<n;i++){
                    Node  curr = q.poll();
                    int idx=isLeft?i:n-i-1;
                    arr[idx]=curr.data;
                    if(curr.left!=null){
                        q.offer(curr.left);
                    }
                    if(curr.right!=null){
                        q.offer(curr.right);
                    }

                }
            isLeft=!isLeft;
            for(int i=0;i<n;i++){
                System.out.print(arr[i]+" ");

            }


        }
    }

    public static void main(String[] args) {
        TreeDataStructure t1 = new TreeDataStructure();
        t1.makeTree();
        t1.zigZag();
//        t1.checkSubTree();





//        System.out.println();

    }
}
