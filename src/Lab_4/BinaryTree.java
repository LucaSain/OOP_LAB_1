package Lab_4;

import org.jetbrains.annotations.NotNull;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryTree<T extends Comparable<T>> {
    private Node<T> root;

    public void add(T val) {
        root = insertRec(root, val); //will not be self-balancing
    }

    BinaryTree(){
        root = new Node<T>().makeLeaf();
    }

    private @NotNull Node<T> insertRec(Node<T> node, T val) {
        if(isLeaf(node)){
            return new Node<T>(val);
        }
        if(val.compareTo(node.val)<0){
            node.left =  insertRec(node.left,val);
        }
        else if(val.compareTo(node.val)>0){
            node.right = insertRec(node.right, val);
        }
        return node;
    }

    public void inOrder() {
        inOrderRec(root);
    }

    private void inOrderRec(Node<T> curr) {
        if(isLeaf(curr))
            return;
        inOrderRec(curr.left);
        System.out.print(curr.val+" ");
        inOrderRec(curr.right);
    }

    private boolean isLeaf(Node <T> node){
        return node.left==null && node.right==null;
    }


    private static class Node<T> {
        T val;
        Node<T> left, right;

        public Node(T val) {
            this.val = val;
            this.left = makeLeaf();
            this.right = makeLeaf();
        }

        private Node(){
            val = null;
            left = null;
            right = null;
        }

        public Node<T> makeLeaf(){
            return new Node<T>();
        }
    }
}