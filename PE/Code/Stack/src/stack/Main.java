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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        MyStack stack2 = new MyStack();
        stack.push(new Node(0));
        stack.push(new Node(5));
//        stack.push(new Node(10));
//        stack.push(new Node(15));
//        stack.push(new Node(20));
//        stack.push(new Node(25));
//        stack.push(new Node(30));
        stack.display();
        
//        stack2=stack.transfer(stack);
//        stack.display();
////        System.out.println(stack2.pop());
//        stack2.display();
    }
    
}
