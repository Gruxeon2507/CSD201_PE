/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.util.*;
import java.io.*;

public class MyList {

    Node head, tail;

    MyList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    void fvisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }

    void ftraverse(RandomAccessFile f) throws Exception {
        Node p = head;
        while (p != null) {
            fvisit(p, f); // You will use this statement to write information of the node p to the file
            p = p.next;
        }
        f.writeBytes("\r\n");
    }

    void loadData(int k) { //do not edit this function
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k + 2);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            addLast(a[i], b[i], c[i]);
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
/* 
   Khong su dung tieng Viet co dau de viet ghi chu.
   Neu dung khi chay truc tiep se bao loi va nhan 0 diem
     */
    void addLast(String xType, int xRate, int xWing) {
        //You should write here appropriate statements to complete this function.        
         if(xType.charAt(0)=='B') return;
         else{
             if(isEmpty()){
                 head=new Node(new Bird(xType,xRate,xWing));
                 tail = head;
             }
             else{
                 Node  p = new Node(new Bird(xType,xRate,xWing));
                 tail.next = p;
                 tail = p; 
             }
         }
    }

    //You do not need to edit this function. Your task is to complete the addLast function above only.
    void f1() throws Exception {
        clear();
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        f.close();
    }

//==================================================================
    void f2() throws Exception {
        clear();
        loadData(5);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        Bird x, y;
        x = new Bird("X", 1, 2);
        y = new Bird("Y", 3, 4);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        addPosition(4, new Node(x));
        addPosition(6, new Node(y));
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }
    
    void addPosition(int pos, Node x) {
        int count=1;
        
        Node p = head;
        Node par=p;
        while(p!=null&&count!=pos){
            par=p;
            p=p.next;
            count++;
        }
        par.next=x;
        x.next=p;
    }
    
 

//==================================================================
    void f3() throws Exception {
        clear();
        loadData(9);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        int count=0;
        
        Node p = head;
        Node par=p;
        while(p!=null){
            par=p;
            p=p.next;
            if(p.info.rate<6){
                count++;
            }
            if(count==2) break;
        }
        p.info.wing=99;       
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

//==================================================================
    void f4() throws Exception {
        clear();
        loadData(13);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
         sortFirstKElements(0);
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }
   
    int getIndex(int rate) {
        int indexRes = 0;
        Node p = head;
        while (p != null) {
            if (p.info.rate == rate) break;
            indexRes++;
            p = p.next;
        }
        
        return indexRes;
    }
    
    void sortFirstKElements(int k) {
        int maxrate=-1;
        Node p =head;
        while(p!=null){
            if(p.info.rate>maxrate) maxrate = p.info.rate;
            p=p.next;
            
        }
        int index = getIndex(maxrate);
         for(Node i=head;i.info.rate!=maxrate;i=i.next){
         for(Node j=i.next;j.info.rate!=maxrate;j=j.next){
             if(i.info.rate>j.info.rate){
                 Bird temp = i.info;
                 i.info=j.info;
                 j.info=temp;
             }
         }
     }
    }
}
