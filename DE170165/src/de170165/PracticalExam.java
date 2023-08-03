//------------------------------------------------------------------------
package de170165; // Replace the name of your project!

import java.util.Arrays;

class nodeQueue {

    nodeBST data;
    nodeQueue next;

    nodeQueue(nodeBST refNodeBT) {
        data = refNodeBT;
        next = null;
    }
}

class Queue {

    nodeQueue front, rear;

    Queue() {
        front = rear = null;
    }

    boolean empty() {
        return (front == null);
    }

    void enqueue(nodeBST refNodeBT) {
        nodeQueue t = new nodeQueue(refNodeBT);
        t.next = null;
        if (empty()) {
            front = t;
        } else {
            rear.next = t;
        }
        rear = t;
    }

    nodeBST dequeue() {
        nodeBST refNodeBT = front.data;
        front = front.next;
        return refNodeBT;
    }
}

class nodeBST {

    double key;
    nodeBST leftChild, rightChild;

    nodeBST(double x) {
        key = x;
        leftChild = rightChild = null;
    }

    @Override
    public String toString() {
        return key + "";
    }
}

class BSTree {

    nodeBST root;
// ___BEGIN YOUR CODE HERE__________________________________________
// Question (I)
// I.1: Declare array A of doubles, the variable num_node
// .................................................................
// .................................................................
    double A[];
    int num_code;
// __________________________________________________END THE CODE___

    BSTree() {
        root = null;
// ___BEGIN YOUR CODE HERE______________________________________
// I.2: Initialize num_node with zero and set A by null.
// .............................................................// .............................................................
        A = null;
        num_code = 0;
// ______________________________________________END THE CODE___
    }

    private nodeBST findParent(double x) {
        nodeBST par = null, t = root;
        while (t != null && t.key != x) {
            par = t;
            if (t.key == x) {
                break;
            }
            if (t.key < x) {
                t = t.rightChild;
            } else {
                t = t.leftChild;
            }
        }
        return par;
    }

    private nodeBST getChild(nodeBST par, double x) {
        if (par != null) {
            if (par.key < x) {
                return par.rightChild;
            } else {
                return par.leftChild;
            }
        }
        return root;
    }

    void insert(double x) {
        nodeBST par = findParent(x);
        nodeBST child = getChild(par, x);
        if (child != null) {
            return;
        }
        nodeBST newNode = new nodeBST(x);
        if (root == null) {
            root = newNode;
        } else if (par.key < x) {
            par.rightChild = newNode;
        } else {
            par.leftChild = newNode;
        }
// ___BEGIN YOUR CODE HERE______________________________________
// I.3: Increase the value of num_node by 1.
// .............................................................
// .............................................................
        num_code++;
// ______________________________________________END THE CODE___
    }

    boolean isEmpty() {
        return root == null;
    }

    void breadthFirstTraverse() {
// ___BEGIN YOUR CODE HERE_____________________________________
// Question (II)
// To traversal by breadth first using the class Queue.
// ............................................................
// ............................................................
// _____________________________________________END THE CODE___

        if (isEmpty()) {
            return;
        }
        Queue q = new Queue();
        q.enqueue(root);
        nodeBST p;
        while (!q.empty()) {
            p = q.dequeue();
            System.out.println(p.key + " ");
            if (p.leftChild != null) {
                q.enqueue(p.leftChild);
            }
            if (p.rightChild != null) {
                q.enqueue(p.rightChild);
            }
        }
    }

    double sumKeys() {
        return sumKeys(root);
    }

    private double sumKeys(nodeBST t) {
        double sum=0;
        
        // ___BEGIN YOUR CODE HERE____________________________________
        // Question (II)
        // Compute the sum of all keys using a recursion
        if(t== null) return 0;
        sum= t.key+sumKeys(t.leftChild) + sumKeys(t.rightChild);
        // ____________________________________________END THE CODE___
        
        return sum;
    }
// ____________________________________________END THE CODE___return sum;

    void rootLeftRight() {
        rootLeftRight(root);
    }

    private void rootLeftRight(nodeBST t) {
        if (t == null) {
            return;
        }
        System.out.print(" " + t.key);
        rootLeftRight(t.leftChild);
        rootLeftRight(t.rightChild);
    }

    void rootLeftRightToArray() {
// ___BEGIN YOUR CODE HERE____________________________________
// Question (IV)
// Traverse the tree by pre-order traversal into the array A,
// and sort A in decrease order.
// Hint: see function leftRightRoot.
// IV.1: We allocate A with num_node integers, set index by 0.
// IV.2: Call rootLeftRightToArray by root
// ...........................................................
// ...........................................................
        double[] A = new double[num_code];
        rootLeftRightToArray(root);
// ____________________________________________END THE CODE___
    }

    private void rootLeftRightToArray(nodeBST t) {
// ___BEGIN YOUR CODE HERE____________________________________
// IV.2: + If t is null, we should return
// + Save t's data to A at position c, increase c by 1
// + Call recursives to traverse two sub branches of t.
// ...........................................................
// ...........................................................
// ____________________________________________END THE CODE___

        if (t == null) {
            return;
        }
        int c = 0;
        A[c] = t.key;
        c++;
        rootLeftRightToArray(t.leftChild);
        rootLeftRightToArray(t.rightChild);
    }

    void decSortByInsertion() {
// ___BEGIN YOUR CODE HERE____________________________________
// Question (V).......
// V.1. Sort array A in decreasing order (using insertion sort)
// V.2. Display A to screen
// ...........................................................
// ...........................................................
// ____________________________________________END THE CODE___
    }

}

public class PracticalExam // Replace the name of your project!
{

    public static void main(String[] args) {
        BSTree MyBST = new BSTree();
        MyBST.insert(50);
        MyBST.insert(30);
        MyBST.insert(40);
        MyBST.insert(20);
        MyBST.insert(10);
        MyBST.insert(70);
        MyBST.insert(90);
        MyBST.insert(80);
        MyBST.insert(60);

// ___BEGIN YOUR CODE HERE____________________________________
// ...a) Call function breadthFirstTraverse() ................
// ...b) Call function sumKeys() and show the sum.............
// ...c) Call function rootLeftRightToArray().................
// ...d) Call decSortByInsertion()............................//
        MyBST.breadthFirstTraverse();
        System.out.println("" + MyBST.sumKeys());
//____________________________________________END THE CODE___
    }
}
//------------------------------------------------------------------------
