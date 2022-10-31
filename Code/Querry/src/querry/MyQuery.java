/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package querry;

/**
 *
 * @author Nguyen Hoang Minh
 */
public class MyQuery {
    Node head;
    Node tail;
    public boolean isEmpty(){
        return (head == null);
    }
    public void clear(){
        tail=null;
        head=null;
    }

    public void enqueue(String string){
        Node x = new Node(string);
        if(isEmpty()){
            head = x;
            tail=head;
        }
        else{      
            Node temp = head;
            int check = 0;
            if(head == null){
                head=x;
                tail=head;
            }
            else{
                tail.next=x;
                tail=x;
            }

        }
    }
    public String dequeue(){
        if(isEmpty()){
            System.out.println("The Node is Empty");
            return null;
        }
        else{
            Node temp = head;           
            head= head.next;
            return temp.inf;
        }
    }    
    public Node front(){
         if(isEmpty()){
            System.out.println("The Node is Empty");
            return null;
        }
         else{
             return head;
         }
    }
    public void display(){
        Node temp = head;
         if(isEmpty()){
            System.out.println("The Node is Empty");

        }
         else{
          while(temp != null){
        System.out.print(temp + " ");
        temp=temp.next;
        }
             System.out.println("");
         }

        
    }
}
