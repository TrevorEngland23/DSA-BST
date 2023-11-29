import java.util.LinkedList;
import java.util.Queue;

public class BST <T extends Comparable<T>> {
    // fields
    Node<T> root;

    // methods
    // search
    public Node<T> find(T valueSearchedFor){ // avg O(log n), worst O(n)
        Node<T> finger = root; // finger starts at the root

        while(finger != null){
        if(finger.value.equals(valueSearchedFor)){ // value at finger equals the value searching for return
            return finger;
        } else if(valueSearchedFor.compareTo(finger.value) < 0){ // go left
                finger = finger.left;
            } else {
                finger = finger.right;
            }
        }
        // you get here if the tree does not contain the value searched for
        return null;
    }
    
    //insert
    public Node<T> insert(T valueToAdd){ // avg O(log n), worst case O(n)
        Node<T> finger = root; // finger starts at root

        if(isEmpty()){
            return root = new Node<T>(valueToAdd);
        } else {
             finger = root;

            while(true){
                if(valueToAdd.compareTo(finger.value) <= 0){
                    // check if there is a left
                    if(finger.left!=null){
                        finger = finger.left;
                    } else {
                        // if no left, new node is linked in there
                        Node<T> newNode = new Node(valueToAdd);
                        finger.left = newNode;
                        return newNode;
                    }
                } else {
                    // check if there is a right
                    if(finger.right!=null){
                        finger = finger.right;
                    } else {
                        Node<T> newNode = new Node(valueToAdd);
                        finger.right = newNode;
                        return newNode;
                    }
                }
            }
        }
    }
    // traversal
    //inorder LNR
    public void inOrder(){ // O(n)
        inOrderHelper(root);
    }
    public void inOrderHelper(Node<T> finger){ // O(n)
        if(finger == null){
            return;
        }
        inOrderHelper(finger.left); //L - visit the entire left subtree
        System.out.print(finger.value + ", "); // N - visit the current node
        inOrderHelper(finger.right); // R - visit right subtree
    }
    //preorder NLR
        public void preOrder(){  // O(n)
        preOrderHelper(root);
    }
    public void preOrderHelper(Node<T> finger){ // O(n)
        if(finger == null){
            return;
        }
        //L - visit the entire left subtree
        System.out.print(finger.value + ", ");
        inOrderHelper(finger.left); // N - visit the current node
        inOrderHelper(finger.right); // R - visit right subtree
    }
    //postorder LRN 
        public void postOrder(){ // O(n)
        postOrderHelper(root); 
    }
    public void postOrderHelper(Node<T> finger){ // O(n)
        if(finger == null){
            return;
        }
        //L - visit the entire left subtree
        
        inOrderHelper(finger.left); // N - visit the current node
        inOrderHelper(finger.right); // R - visit right subtree
        System.out.print(finger.value + ", ");
    }
    //isEmpty
    public boolean isEmpty(){ // O(1)
        return root == null;
    }
    //min/max 
    public T max() throws Exception{ // O(log n), worst case O(n)
        Node<T> finger = root;
        if(isEmpty()){
            throw new Exception("no max found.");
        }
        while(finger.right!=null){
            finger = finger.right;
        }
        return finger.value;
    }

    // pretty method

    public int countNodes(){
       return countNodesHelper(root);
    }

    // heavy lifting method
    public int countNodesHelper(Node<T> finger){
        // ask left subtree
        // ask right subtree

        if(finger == null){
            return 0;
        }

        return countNodesHelper(finger.left) + countNodesHelper(finger.right) + 1; // add up two halves plus root
    }

    public int countLeafNodes(){
        return countLeafNodesHelper(root);
    }

    public int countLeafNodesHelper(Node <T> finger){
        if(finger == null){
            return 0;
        }
        else if(finger.left == null && finger.right==null){
            return 1;
        }
        return countLeafNodesHelper(finger.left) + countLeafNodesHelper(finger.right);
    }

    public int height(){
        return heightHelper(root);
    }

    public int heightHelper(Node<T> finger){
        // base case
        if(finger==null){
            return -1;
        }
        return Math.max(heightHelper(finger.left), heightHelper(finger.right)) +1;
    }

    public void BFS(){
        Queue<Node<T>> q = new LinkedList<Node<T>>();
        q.add(root); // enqueue

        while(!q.isEmpty()) {
        Node<T> n = q.remove();
        System.out.println(n.value);

        if(n.left!=null)
            q.add(n.left);
        if(n.right!=null)
            q.add(n.right);
        }
    }

    //ctor(s)
}
