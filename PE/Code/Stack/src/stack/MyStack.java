/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack;

/**
 *
 * @author Nguyen Hoang Minh
 */
public class MyStack {

    Node top = null;

    public boolean empty() {
        return (top == null);
    }

    public int peek() {
        if (empty()) {
            System.out.println("The Stack Is Empty");
            return -1;
        } else {
            return top.inf;
        }
    }

    public Node pop() {
        if (empty()) {
            System.out.println("The Stack Is Empty");
            return null;
        } else {
            Node temp = top;
            top = top.next;
            return temp;
        }
    }
    public void push(Node x){
        if(empty()){
            top = x;
        }
        else{
            x.next = top;
            top=x;
        }
    }
    public int search(Node x){
        if(empty()){
            return -1;
        }
        else{
            Node temp = top;
            int count =1;
            int check=0;
            while(temp!=null){
                if(temp==x){
                    check=1;
                    break;
                }
                count++;
                temp=temp.next;
            }
            if(check == 0) return -1;
            else return count;
        }
    }
    public void display(){
        Node p=top;
        while(p!=null){
            System.out.print(p+" ");
            p=p.next;
        }
        System.out.println("done");
    }
    public MyStack transfer(MyStack s){
        MyStack temp = new MyStack();
        while(!s.empty()){
            Node p = new Node(s.peek());
            s.pop();
            temp.push(p);
            
        }
        return temp;
    }
}
