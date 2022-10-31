/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytree;

import java.io.IOException;

/**
 *
 * @author Nguyen Hoang Minh
 */
public class BinaryTree {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException, IOException {
        // TODO code application logic here
        MyBinaryTree tree = new MyBinaryTree();
        String fname = "temp.txt";
        tree.readDataFormFile(fname);
//        tree.inOrder(tree.root);
//        System.out.println("");
//        tree.preOrder(tree.root);
//        System.out.println("");
//        tree.postOrder(tree.root);
        System.out.println("Tree before rotate");
        tree.breadth(tree.root);
        System.out.println("After Rotate:");
        tree.root=tree.left_right_Rotate(tree.root);
        tree.breadth(tree.root);
    }
    
}
