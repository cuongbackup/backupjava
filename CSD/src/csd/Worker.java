package csd;

public class Worker implements Comparable<Object> {

    int id;
    String name;

    public Worker(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Nhanvien{" + "id=" + id + ", name=" + name + '}';
    }

    @Override
    public int compareTo(Object o) {
        if (this.id < ((Worker) o).id) {
            return -1;
        }
        if (this.id == ((Worker) o).id) {
            return 0;
        }

        return 1;

    }

    class Node {

        Worker data;
        Node left, right;
        int diffHigh;

        public Node(Worker data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        @Override
        public String toString() {
            return data + " " + diffHigh;
        }

    }

    class BST {

        Node root;

        public BST(Worker[] w) {
            root = null;
            for (Worker worker : w) {
                insert(worker);
            }
        }

        void insert(Worker w) {
            root = insert(w, root);
        }

        Node insert(Worker w, Node t) {
            if (t == null) {
                return new Node(w);
            }
            if (t.data.compareTo(w) > 0) {
                t.left = insert(w, t.left);
            } else if (t.data.compareTo(w) < 0) {
                t.right = insert(w, t.right);
            } else ;
            return t;
        }

        public void decreaseTraverse() {
            subDecreaseTraverse(root);
        }

        public void subDecreaseTraverse(Node t) {
            if (t == null) {
                return;
            }
            subDecreaseTraverse(t.right);
            System.out.println(" " + t);
            subDecreaseTraverse(t.left);
        }

        Node search(int id, Node parent) {
            Node t = root;
            parent.ref = null;
            Worker temp = new Worker(id, "");
            while (t != null && t.data.compareTo(temp) != 0) {
                parent.ref = t;
                if (t.data.compareTo(temp) < 0) {
                    t = t.right;
                } else {
                    t = t.left;
                }
            }
            return t;
        }

        void delete(int id) {
            NodeRef parent = new NodeRef();
            Node t = search(id, parent);
            if (t == null) {
                return;
            }

        }
    }

    class NodeRef 
    

    (Node parent)

    public class BST {

        public static void main(String[] args) {
            BST t = new BST(new Worker(0, "a"));
            new Worker(0, "a");
            t.decreaseTraverse();
        }
    }
}
