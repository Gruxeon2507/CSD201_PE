/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.io.*;

class MyList {

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

    void loadData(int k) //do not edit this function
    {
        File f = new File("data.txt");
        if (!f.isFile()) {
            System.out.println("not file");
        }
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            addHead(a[i], b[i]);
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
    void addHead(String xOwner, int xPrice) {//You should write here appropriate statements to complete this function.
        if (xOwner.charAt(xOwner.length() - 1) == 'B' || xPrice > 100) {
            return;
        } else {
            if (isEmpty()) {
                head = new Node(new Car(xOwner, xPrice));
                tail = head;
            } else {
                Node p = new Node(new Car(xOwner, xPrice));
                p.next = head;
                head = p;
            }
        }
    }

    void f1() throws Exception {/* You do not need to edit this function. Your task is to complete the addLast  function
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
        ftraverse(f);
        f.close();
    }

//==================================================================
    void f2() throws Exception {
        clear();
        loadData(4);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        Node x = new Node(new Car("X", 1));
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

        if (head.info.price > 10) {
            x.next = head;
            head = x;
        } else {
            Node p = head;
            Node par = p;
            while (p != null && p.info.price <= 10) {
                par = p;
                p = p.next;
            }
            if (p == null) {
                return;
            } else {
                par.next = x;
                x.next = p;
            }
        }

        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

//==================================================================
    void f3() throws Exception {
        clear();
        loadData(7);
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
        if(isEmpty())return;
        if (head.info.price > 10 && head.info.owner.charAt(1)=='C') {
            head=head.next;
        } else {
            Node p = head;
            Node par = p;
            while (p != null && (p.info.price <= 10 || p.info.owner.charAt(1)!='C')) {
                par = p;
                p = p.next;
            }
            if (p == null) {
                return;
            } else {
                par.next = p.next;
            }
        }
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

//==================================================================
    void f4() throws Exception {
        clear();
        loadData(10);
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
        Node  maxrate=head;
        Node p =head;
        while(p!=null){
            if(p.info.price>maxrate.info.price) maxrate = p;
            p=p.next;
            
        }
        for(Node i=head;i!=maxrate.next;i=i.next){
         for(Node j=i.next;j!=maxrate.next;j=j.next){
             if(i.info.owner.compareTo(j.info.owner)>0){
                 Car temp = i.info;
                 i.info=j.info;
                 j.info=temp;
             }
         }
     }
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }
    int getIndex(int price) {
        int indexRes = 0;
        Node p = head;
        while (p != null) {
            if (p.info.price == price);
            indexRes++;
            p = p.next;
        }
        
        return indexRes;
    }
    
    void sortFirstKElements() {
        int maxrate=-1;
        Node p =head;
        while(p!=null){
            if(p.info.price>maxrate) maxrate = p.info.price;
            p=p.next;
            
        }
        int index = getIndex(maxrate);
         for(Node i=head;i.info.price!=maxrate;i=i.next){
         for(Node j=i.next;j.info.price!=maxrate;j=j.next){
             if(i.info.price>j.info.price){
                 Car temp = i.info;
                 i.info=j.info;
                 j.info=temp;
             }
         }
     }
    }
}
