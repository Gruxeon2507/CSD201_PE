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

        //if (p.info.price>=3 && p.info.price<=5)
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
    void insert(String xOwner, int xPrice) {
        //You should insert here statements to complete this function
        if (xOwner.length() >= 2 && (xOwner.charAt(1) == 'B' || xPrice % 2 == 0)) {
            return;
        } else {
            Node p = root;
            Node par = p;
            if (isEmpty()) {
                root = new Node(new Car(xOwner, xPrice));
            } else {
                while (p != null) {
                    if (p.info.price == xPrice) {
                        return;
                    }
                    if (p.info.price > xPrice) {
                        par = p;
                        p = p.left;
                    } else {
                        par = p;
                        p = p.right;
                    }
                }
                if (par.info.price > xPrice) {
                    par.left = new Node(new Car(xOwner, xPrice));
                } else {
                    par.right = new Node(new Car(xOwner, xPrice));
                }
            }
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
        postOrder(root, f);
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

    void preOrder2(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }

        //if (p.info.price>=3 && p.info.price<=5)
        if (p.info.price >= 3 && p.info.price <= 50) {
            fvisit(p, f);
        }
        preOrder2(p.left, f);
        preOrder2(p.right, f);
    }

    void f3() throws Exception {
        clear();
        loadData(7);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        inOrder(root, f);
        f.writeBytes("\r\n");
//        inorder2(root);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        temp = null;

        preOrder3(root, f);

        if (temp != null) {
            System.out.println(temp.info.price);
            deleteByCopy(temp.info.price);
        }
        //------------------------------------------------------------------------------------
        inOrder(root, f);

        f.writeBytes(
                "\r\n");
        f.close();
    }
    Node temp;

    void preOrder3(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }

        //if (p.info.price>=3 && p.info.price<=5)
        if (p.info.price >= 30 && p.info.price <= 70 && p.left != null && p.right != null) {
            temp = p;
            return;
        }
        preOrder3(p.left, f);
        preOrder3(p.right, f);
    }

    public void deleteByCopy(int x) {
        Node p = search(root, x);
        if (p == null) {
            System.out.println("Key " + x + " does not exists, deletion failed");
            return;
        }
        //find f is father of p
        Node f = null, q = root;
        while (q != p) {
            f = q;
            if (q.info.price > p.info.price) {
                q = q.left;
            } else {
                q = q.right;
            }
        }
        //1.p has no child
        if (p.left == null && p.right == null) {
            if (f == null) {
                root = null;
            } else if (f.left == p) {
                f.left = null;
            } else {
                f.right = null;
            }
        } //2.p has left child only
        else if (p.left != null && p.right == null) {
            if (f == null) {
                root = p.left;
            } else if (f.left == p) {
                f.left = p.left;
            } else {
                f.right = p.left;
            }
        } //3.p has right child only
        else if (p.left == null && p.right != null) {
            if (f == null) {
                root = p.right;
            } else if (f.left == p) {
                f.left = p.right;
            } else {
                f.right = p.right;
            }
        } //4.p has both child
        else if (p.left != null && p.right != null) {
            //tim q la node lon nhat ben con trai cua p -> q la con phai nhat
            //cua con trai cua p
            q = p.left;
            f = null;
            while (q.right != null) {
                f = q;
                q = q.right;
            }
            p.info = q.info;
            //delete q
            if (f == null) {
                p.left = q.left;
            } else {
                f.right = q.left;
            }
        }
    }

    public Node search(Node p, int key) {
        if (p == null) {
            return null;
        }
        if (p.info.price == key) {
            return p;
        } else if (p.info.price > key) {
            return search(p.left, key);
        } else {
            return search(p.right, key);
        }
    }

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
        temp = null;
        inOrder2(root, f);
        if (temp != null) {
            Node p = root;
            Node par = p;
            if (temp == root) {
                root=left_Rotate(root);
            }else{
                while(p!=temp){
                    par=p;
                    if(p.info.price>temp.info.price){
                        p=p.left;
                    }else{
                        p=p.right;
                    }
                }
                if(par.info.price<p.info.price){
                    par.right=left_Rotate(p);
                }else if(par.info.price>p.info.price){
                    par.left=left_Rotate(p);
                    
                }
                else{
                    p=root;
                }
            }
        }
        //-------------------+-----------------------------------------------------------------
        preOrder(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

    void inOrder2(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        inOrder2(p.left, f);
        if (p.info.price >= 30 && p.info.price <= 70 && p.left != null) {
            temp = p;
            return;
        }
        inOrder2(p.right, f);
    }

    public Node left_Rotate(Node p) {
        if (p == null || p.right == null) {
            return p;
        }
        Node newroot = p.right;
        p.right = newroot.left;
        newroot.left = p;
        return newroot;
    }

}
