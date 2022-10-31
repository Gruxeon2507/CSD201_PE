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
public class Node {
    String inf;
    Node next;

    public Node(String inf) {
        this.inf = inf;
        this.next = null;
    }
    @Override
    public String toString(){
        return inf+" ";
    }
    


}
