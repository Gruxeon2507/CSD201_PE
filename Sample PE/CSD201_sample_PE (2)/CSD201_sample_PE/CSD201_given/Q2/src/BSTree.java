/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.io.*;
import java.util.*;

class BSTree {

    Node root;

    BSTree() {
        root = null;
    }

    boolean isEmpty() {
        return (root == null);
    }

    void clear() {
        root = null;
    }

    void fvisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }

    void preOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        fvisit(p, f);
        preOrder(p.left, f);
        preOrder(p.right, f);
    }

    void inOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        inOrder(p.left, f);
        fvisit(p, f);
        inOrder(p.right, f);
    }

    void postOrder(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        postOrder(p.left, f);
        postOrder(p.right, f);
        fvisit(p, f);
    }

    Node postOrder1(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return null;
        }


        if (p.info.price < 7 && p.left != null) {
            return p;
        } else {
            if(p.info.price >= 7) return postOrder1(p.left, f);
            else return postOrder1(p.right, f);
        }
    }

    void breadth(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        Queue q = new Queue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            fvisit(r, f);
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
    }

    void loadData(int k) //do not edit this function
    {
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            insert(a[i], b[i]);
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
    void insert(String xOwner, int xPrice) {//You should insert here statements to complete this function
        if (xOwner.charAt(0) == 'B' || xPrice > 100) {
            return;
        }
        Node x = new Node(new Car(xOwner, xPrice));
        if (isEmpty()) {
            root = x;
        }
        Node p = root;
        Node par = p;
        while (p != null) {
            if (x.info.price > p.info.price) {
                par = p;
                p = p.right;
            } else if (x.info.price < p.info.price) {
                par = p;
                p = p.left;
            } else {
                return;
            }
        }
        if (x.info.price > par.info.price) {
            par.right = x;
        } else {
            par.left = x;
        }

    }

    void f1() throws Exception {/* You do not need to edit this function. Your task is to complete insert  function
        above only.
         */
        clear();
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        preOrder(root, f);
        f.writeBytes("\r\n");
        inOrder(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

//=============================================================
    void f2() throws Exception {
        clear();
        loadData(4);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        preOrder(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        preOrder2(root, f);
        //------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }

// f.writeBytes(" k = " + k + "\r\n");
//=============================================================
    void f3() throws Exception {
        clear();
        loadData(7);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        breadth(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        Node p = root;
        Node par = p;
        while (p != null && p.info.price > 8) {
            par = p;
            p = p.left;

        }
        while (p.right == null || p.left == null) {
            if (p.left != null) {
                p = p.left;
            } else {
                p = p.right;
            }
            if (p == null) {
                return;
            }
        }
        if (p.left != null && p.right != null) {
            Node k = p.left;
            Node par_k = p;
            while (k.right != null) {
                par_k = k;
                k = k.right;
            }
            p.info = k.info;
            if (par_k == p) {
                p.left = k.left;
            } else {
                par_k.right = k.left;
            }
        }

        //------------------------------------------------------------------------------------
        breadth(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

//=============================================================
    void f4() throws Exception {
        clear();
        loadData(10);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        breadth(root, f);
        f.writeBytes("\r\n");
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
//        Node p = root;
//        Node par = p;
//        while (p != null && p.info.price >= 7) {
//            par = p;
//            p = p.left;
//
//        }
//        while (p.left == null) {
//            par=p;
//            p = p.right;
//            if (p == null) {               
//                break;
//            }
//        }
//        System.out.println(par.info.price);
//        if(p==root){
//            root = right_Rotate(p);
//        }
//        else if (p.left != null) {
//            if(p.info.price>par.info.price) par.right= right_Rotate(p);
//            else par.left = right_Rotate(p);
//        }else{
//            p=root;
//        }

        Node p = postOrder1(root, f);
        if(p==null) return;
        Node par = root;
        Node p1=root;
        while(p1!=null&&p1.info.price!=p.info.price){
            if(p1.info.price<p.info.price){
                par=p1;
                p1=p1.right;
            }
            else{
                par=p1;
                p1=p.left;
            }
        }
        if (p == root) {
            root = right_Rotate(p);
        } else if (p.left != null) {
            if (p.info.price > par.info.price) {
                par.right = right_Rotate(p);
            } else {
                par.left = right_Rotate(p);
            }
        } else {
            p = root;
        }
        //------------------------------------------------------------------------------------
        breadth(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

    void preOrder2(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        if (p.info.price >= 3 && p.info.price <= 5) {
            fvisit(p, f);
        }
        preOrder2(p.left, f);
        preOrder2(p.right, f);
    }

    public Node right_Rotate(Node p) {
        if (p == null || p.left == null) {
            return p;
        }
        Node newroot = p.left;
        p.left = newroot.right;
        newroot.right = p;
        return newroot;
    }
}
