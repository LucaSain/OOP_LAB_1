package Lab_4;


public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> bst = new BinaryTree<Integer>();
        bst.add(3);
        bst.add(2);
        bst.add(1);
        bst.inOrder();
    }
}