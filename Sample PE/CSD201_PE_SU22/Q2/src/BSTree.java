/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.io.*;
import java.util.*;

public class BSTree {

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

    void visit(Node p) {
        System.out.print("p.info: ");
        if (p != null) {
            System.out.println(p.info + " ");
        }
    }

    void fvisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
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
 void postOrder(Node p, ArrayList<Node> count ) throws Exception {
          if (p==null) return;
          postOrder(p.left, count);
          postOrder(p.right, count);
          count.add(p);
    }
    void loadData(int k) { //do not edit this function
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k + 2);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            insert(a[i], b[i], c[i]);
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
    void insert(String xType, int xRate, int xWing) {
        //You should insert here statements to complete this function
          if(xType.charAt(0)=='B')return;
          else{
              if(isEmpty()){
                  root = new Node(new Bird(xType,xRate,xWing));
              }
              else{
              Node p =root;
              Node par=p;
              
              while(p!=null){
                 
                  if(xRate<p.info.rate){
                       par=p;
                      p=p.left;
                  }else{
                       par=p;
                      p=p.right;
                  }
              }
              if(xRate<par.info.rate) par.left = new Node(new Bird(xType,xRate,xWing));
              else par.right = new Node(new Bird(xType,xRate,xWing));
              }
          }
    }

//Do not edit this function. Your task is to complete insert function above only.
    void f1() throws Exception {
        clear();
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        breadth(root, f);
        f.writeBytes("\r\n");
        inOrder(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

//=====================================================1========
    void f2() throws Exception {
        clear();
        loadData(5);
        String fname = "f2.txt";
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
         breadth2(root, f);
        //------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }
    void breadth2(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        Queue q = new Queue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            if(r.info.wing>4)fvisit(r, f);
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
    }    
//=============================================================
    void f3() throws Exception {
        clear();
        loadData(9);
        String fname = "f3.txt";
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
          
        //------------------------------------------------------------------------------------
        postOrder(root, f);
        f.writeBytes("\r\n");
        f.close();
    }
    void postOrder2(Node p, RandomAccessFile f,int count) throws Exception {
        if (p == null) {
            return;
        }
        count++;
        postOrder2(p.left, f,count);
        postOrder2(p.right, f,count);
        if(p.inf)fvisit(p, f);
        if(count==4) return;
    }    
    public void remove(Node x) {
        if (root == null) {
            return;
        }
        Node p = root;
        Node par = p;
        while (p != null && p.inf != x.inf) {
            if (x > p.inf.inf) {
                par = p;
                p = p.right;
            } else {
                par = p;
                p = p.left;
            }
        }
        if (p == null) {
            return;
        }
        if (p.left == null && p.right == null) {
            if (par.left == p) {
                par.left = null;
            } else {
                par.right = null;
            }
        }
        if (p.left != null && p.right == null) {
            if (par.left == p) {
                par.left = p.left;
            } else {
                par.right = p.left;
            }
        }
        if (p.left == null && p.right != null) {
            if (par.left == p) {
                par.left = p.right;
            } else {
                par.right = p.right;
            }
        }
        if (p.left != null && p.right != null) {
//          merge tree
//            if (par.left == p) {
//                par.left = p.left;
//                insertNode(p.right);
//            } else if(par.right==p) {
//                par.right = p.left;
//                insertNode(p.right);
//            }
//            else if (par==p){
//                Node temp = p.right;
//                root=p.left;
//                insertNode(temp);
//            }
////          tim max cay con trai
//            Node k=p.left;
//            Node par_k=p;
//            while(k.right!=null){
//                par_k=k;
//                k=k.right;
//            }
//            p.inf=k.inf;
//            if(par_k==p){
//                p.left=k.left;
//            }
//            else par_k.right=k.left;
//        }
//             tim min cay con phai
               Node k = p.right;
               Node par_k=p;
               while(k.left!=null){
                   par_k=k;
                   k=k.left;
                   
               }
               p.inf=k.inf;
               if(par_k==p){
                   p.right=k.right;
               }
               else par_k.left=k.right;
        }
    }
 //=============================================================
    void f4() throws Exception {
        clear();
        loadData(13);;
        String fname = "f4.txt";
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

        //------------------------------------------------------------------------------------
        postOrder(root, f);
        f.writeBytes("\r\n");
        f.close();
    }

}
