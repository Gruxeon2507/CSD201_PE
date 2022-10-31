/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.util.*;
import java.io.*;
class MyList
 {Node head,tail;
  MyList() {head=tail=null;}
  boolean isEmpty()
   {return(head==null);
   }
  void clear() {head=tail=null;}

  void fvisit(Node p, RandomAccessFile f) throws Exception
   {if(p != null) f.writeBytes(p.info + " ");
   }

  void ftraverse(RandomAccessFile f) throws Exception
   {Node p = head;
    while(p!=null)
      {fvisit(p,f); // You will use this statement to write information of the node p to the file
       p=p.next;
      }
    f.writeBytes("\r\n");
   }

  void loadData(int k)  //do not edit this function
   {String [] a = Lib.readLineToStrArray("data.txt", k);
    int [] b = Lib.readLineToIntArray("data.txt", k+1);
    int n = a.length;
    for(int i=0;i<n;i++) addLast(a[i],b[i]);
   }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
  void addLast(String xOwner, int xPrice)
   {//You should write here appropriate statements to complete this function.
        if(xOwner.charAt(0)=='B'|| xPrice >100){
            return;
        }
        else {
                Car newCar = new Car(xOwner,xPrice);
                Node p = new Node(newCar);
            if(isEmpty()){
                head=tail=p;
            }
            else{
                tail.next=p;
                tail=p;                
            }

        }

   }

  void f1() throws Exception
    {/* You do not need to edit this function. Your task is to complete the addLast  function
        above only.
     */
     clear();
     loadData(1);
     String fname = "f1.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
     ftraverse(f);
     f.close();
    }  

//==================================================================
  void f2() throws Exception
    {clear();
     loadData(4);
     String fname = "f2.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
     ftraverse(f);
     Car x = new Car("X",1);
     //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
     Node p = new Node(x);
     if(isEmpty()){
        head = tail = p;
     }
     else{
        p.next=head;
        head=p;
            
     }



    //------------------------------------------------------------------------------------
     ftraverse(f);
     f.close();
    }  

//==================================================================
  void f3() throws Exception
   {clear();
    loadData(7);
    String fname = "f3.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    ftraverse(f);
    //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

     Node p = head;
     Node pre = new Node(null);
     pre.next=head;
     while(p!=null && p.info.price!=5){
         p=p.next;
         pre=pre.next;
     }
     if(p==null) return;
     else{
         pre.next=p.next;
     }

    //------------------------------------------------------------------------------------
    ftraverse(f);
    f.close();
   }

//==================================================================
  void f4() throws Exception
   {clear();
    loadData(10);
    String fname = "f4.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    ftraverse(f);
    //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

     for(Node i=head;i!=null;i=i.next){
         for(Node j=i.next;j!=null;j=j.next){
             if(i.info.price>j.info.price){
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

 }
