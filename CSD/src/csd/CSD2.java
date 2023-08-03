package csd;

import java.util.ArrayList;

class node {

    int data;
    node left, right;

    node(int data) {
        this.data = data;
        left = right = null;
    }

    @Override
    public String toString() {
        return "" + data;
    }
}

class nodeRef {

    node itself;
}

class BST {

    node root;

    public BST() {
        root = null;
    }

    public BST(int a[]) {
        this.root = null;
        for (int x : a) {
            insert(x);
        }
    }

    void insert(int x) {
        nodeRef parent = new nodeRef();
        node pos = search(x, parent);
        if (pos != null) {
            return;
        }
        node newNode = new node(x);
        if (parent.itself == null) {
            root = newNode;
        } else if (parent.itself.data < x) {
            parent.itself.right = newNode;
        } else {
            parent.itself.left = newNode;
        }
    }

    node search(int x, nodeRef parent) {
        parent.itself = null;
        node cur = root;
        while (cur != null && cur.data != x) {
            if (cur.data < x) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }
        return cur;
    }

    ArrayList<Integer> inorder() {
        ArrayList<Integer> traversal = new ArrayList<>();
        subInOrder(root, traversal);
        return traversal;
    }

    void subInOrder(node cur, ArrayList<Integer> traversal) {
        if (cur == null) {
            return;
        }
        subInOrder(cur.left, traversal);
        traversal.add(cur.data);
        subInOrder(cur.right, traversal);
    }

    int calMaxDepth() {
        return subCalMaxDepth(root);
    }

    int subCalMaxDepth(node cur) {
        if (cur == null) {
            return 0;
        }
        return 1 + Integer.max(subCalMaxDepth(cur.left), subCalMaxDepth(cur.right));
    }
    
    node leftMost(nodeRef par) {
        if (root == null) {
            return null;
        }
        nodeRef cur =  new nodeRef();
        cur.itself = root; 
        par.itself = null;
        subLeftMost(cur, par);
        return cur.itself;
    }
    
    void subLeftMost(nodeRef cur, nodeRef par) {
        if(cur.itself.left == null) return;
        par.itself = cur.itself;
        cur.itself = cur.itself.left;
        subLeftMost(cur, par);
    }
}

public class CSD2 {

    public static void main(String[] args) {
        BST T = new BST(new int[]{9, 6, 4, 5, 8, 7, 8, 2});
        ArrayList<Integer> inOrderTraversal = T.inorder();
        System.out.println("" + inOrderTraversal);
        System.out.println("Max height = " + T.calMaxDepth());
        nodeRef parent = new nodeRef();
        node pos = T.leftMost(parent);
        if(pos == null) {
            System.out.println("The tree is empty");
        }
        else {
            System.out.println("The left next is: " + pos);
            if (parent.itself == null) {
                System.out.println("Is root");
            }
            else {
                System.out.println("With the parent is: " + parent.itself);
            }
        }
    }
}
