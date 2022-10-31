/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytree;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.LinkedList;
import sun.misc.Queue;

/**
 *
 * @author Nguyen Hoang Minh
 */
public class MyBinaryTree {

    Node root;

    public boolean isEmpty() {
        return (root == null);
    }

    public void visit(Node p) {
        System.out.print(p.inf + " ");
    }

    public void insert(int x) {
        if (isEmpty()) {
            root = new Node(x);
        }
        Node p = root;
        Node par = p;
        while (p != null) {
            if (x > p.inf) {
                par = p;
                p = p.right;
            } else if (x < p.inf) {
                par = p;
                p = p.left;
            } else {
                return;
            }
        }
        if (x > par.inf) {
            par.right = new Node(x);
        } else {
            par.left = new Node(x);
        }
    }

    public void insertNode(Node x) {
        if (isEmpty()) {
            root = x;
        }
        Node p = root;
        Node par = p;
        while (p != null) {
            if (x.inf > p.inf) {
                par = p;
                p = p.right;
            } else if (x.inf < p.inf) {
                par = p;
                p = p.left;
            } else {
                return;
            }
        }
        if (x.inf > par.inf) {
            par.right = x;
        } else {
            par.left = x;
        }
    }

    public void preOrder(Node p) {
        if (p == null) {
            return;
        }
        visit(p);
        preOrder(p.left);
        preOrder(p.right);
    }

    public void inOrder(Node p) {
        if (p == null) {
            return;
        }
        inOrder(p.left);
        visit(p);
        inOrder(p.right);
    }

    public void postOrder(Node p) {
        if (p == null) {
            return;
        }
        postOrder(p.left);
        postOrder(p.right);
        visit(p);
    }

    public void breadth(Node p) throws InterruptedException {
        if (p == null) {
            return;
        }
        Queue<Node> queue = new Queue<Node>();
        Node temp;
        int check = 0;
        queue.enqueue(p);
        while (!queue.isEmpty()) {
            p = queue.dequeue();
            visit(p);
            if (p.left != null) {
                queue.enqueue(p.left);
            }
            if (p.right != null) {
                queue.enqueue(p.right);
            }
        }

    }

    public void remove(int x) {
        if (root == null) {
            return;
        }
        Node p = root;
        Node par = p;
        while (p != null && p.inf != x) {
            if (x > p.inf) {
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
            Node par_k = p;
            while (k.left != null) {
                par_k = k;
                k = k.left;

            }
            p.inf = k.inf;
            if (par_k == p) {
                p.right = k.right;
            } else {
                par_k.left = k.right;
            }
        }
    }

    public void readDataFormFile(String fname) throws FileNotFoundException, IOException {
        File f = new File(fname);
        if (!f.isFile()) {
            return;
        }
        RandomAccessFile fr = new RandomAccessFile(fname, "r");
        String s;
        while ((s = fr.readLine()) != null) {
            String[] arr = s.split("[ ]+");
            for (int i = 0; i < arr.length; i++) {
                insert(Integer.parseInt(arr[i]));
            }
        }
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

    public Node left_Rotate(Node p) {
        if (p == null || p.right == null) {
            return p;
        }
        Node newroot = p.right;
        p.right = newroot.left;
        newroot.left = p;
        return newroot;
    }

    public Node right_left_Rotate(Node p) {
        if (p == null || p.right == null) {
            return p;
        }
        p.right = right_Rotate(p);
        return left_Rotate(p);
    }

    public Node left_right_Rotate(Node p) {
        if (p == null || p.left == null) {
            return p;
        }
        p.left = left_Rotate(p.left);
        return right_Rotate(p);
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
            if (q.inf > p.inf) {
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
            p.inf = q.inf;
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
        if (p.inf== key) {
            return p;
        } else if (p.inf > key) {
            return search(p.left, key);
        } else {
            return search(p.right, key);
        }
    }
    
}
