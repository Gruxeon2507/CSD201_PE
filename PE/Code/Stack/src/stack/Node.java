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
public class Node {
    int inf;
    Node next;

    public Node(int inf) {
        this.inf = inf;
        this.next = null;
    }
    @Override
    public String toString(){
        return inf+" ";
    }
    
}
