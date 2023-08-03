package csd;

class node {

    int data;
    node next;

    public node(int data) {
        this.data = data;
        this.next = null;
    }

    @Override
    public String toString() {
        return data + "";
    }

}

class Llist {

    public node head;
    public node tail;

    public Llist() {
        node a, b, c, d, e;
        a = new node(5);
        b = new node(2);
        c = new node(7);
        d = new node(9);
        e = new node(8);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        head = a;
        tail = e;
    }

    void display() {
        for (node t = head; t != null; t = t.next) {
            System.out.println(" " + t);
        }
    }

    void insert(node n, node pred) {
        if (head == null) {
            n.next = pred.next;
            pred.next = n;
        } else {
            n.next = head;
            head = n;
        }
        if (pred == tail) {
            tail = n;
        }
    }

    void insertHead(int n) {
        insert(new node(n), null);
    }

    void insertTail(int n) {
        insert(new node(n), tail);
    }

    void delete(node pred) {
        node xoa;
        if (pred != null) {
            xoa = pred.next;
            pred.next = xoa.next;
        } else {
            xoa = head;
            head = xoa.next;
        }
        if (xoa == tail) {
            tail = pred;
        }
    }

    void deleteHead() {
        delete(null);
    }

    void deleteTail() {
        delete(tail);
    }

    public static void main(String[] args) {
        Llist l = new Llist();
        l.insertHead(6);
        l.deleteHead();
        l.display();
    }
}
