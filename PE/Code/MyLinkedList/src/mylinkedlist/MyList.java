/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylinkedlist;

/**
 *
 * @author Nguyen Hoang Minh
 */
public class MyList {

    Node head, tail;

    public MyList() {
        head = null;
        tail = null;
    }

    //return true if MyList is empty otherwise return false
    public boolean isEmpty() {
        return head == null;
    }

    //add a new node to the end of the list
    public void addLast(int x) {
        Node p = new Node(x);
        if (isEmpty()) {
            head = tail = p;
        } else {
            tail.next = p;
            tail = p;
        }
    }

    public void addFirst(int x) {
        Node p = new Node(x);
        if (isEmpty()) {
            head = tail = p;
        } else {
            p.next = head;
            head = p;
        }
    }

    public void traversal() {
        Node p = head;
        while (p != null) {
            System.out.println(p.info + " ");
            p = p.next;
        }
    }

    public int size() {

        Node p = head;
        int count = 0;
        while(p!=null){
            count++;
            p=p.next;
        }
        return count;
    }
    
    public Node get(int k){
        Node p = head;
        int i=0;
        while(p != null && i < k){
            i++;
            p=p.next;
        }
        return p;
    }
    
    public void sort(){
        int n = size();
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(get(i).info > get(j).info){
                    int temp= get(i).info;
                    get(i).info = get(j).info;
                    get(j).info = temp;
                }
            }
        }
    }
    
    public Node search(int x){
        Node p =head;
        while(p != null && p.info!=x){
            p=p.next;
        }
        return p;
    }
    
    public void sortByLocation(Node to, Node from){
        for(Node i=to;i!=from.next;i=i.next){
            for(Node j=i;j!=from.next;j=j.next){
                if(i.info>j.info){
                    int temp =i.info;
                    i.info=j.info;
                    j.info=temp;
                    
                }
            }
        }
    }
}
