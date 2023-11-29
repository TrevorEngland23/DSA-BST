/**
 * TEST
 */
public class Test {

    public static void main(String[] args) throws Exception {
        BST <Integer> tree = new BST<>();
        System.out.println(tree.isEmpty());

        tree.insert(10);
        tree.insert(6);
        tree.insert(24);
        tree.insert(88);
        tree.insert(24);
        tree.insert(10);
        tree.insert(70);

        if(tree.find(24) == null){
            System.out.println("24 not in tree");
        } else {
            System.out.println("is in tree");
        }

        if(tree.find(44) == null){
            System.out.println("not in list");
        } else {
            System.out.println("is in list");
        }

        System.out.println("number of nodes: " + tree.countNodes());
        System.out.println("Number of leaf nodes: " + tree.countLeafNodes());

        // tree.inOrder();
        // System.out.println();
        // tree.preOrder();
        // System.out.println();
        // tree.postOrder();
        
    }
}