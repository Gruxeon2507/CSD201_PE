/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package querry;

import java.io.File;

/**
 *
 * @author Nguyen Hoang Minh
 */
public class Querry {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MyQuery query = new MyQuery();
        double size=0;
        String pathname="D:\\FPT University";
        File f = new File(pathname);
        for(int i=0;i<f.listFiles().length;i++){
            query.enqueue(f.listFiles()[i].toString());
        }
       while(!query.isEmpty()){
           String child =  query.dequeue();
           f= new File(child);
           if(f.isDirectory()){
               System.out.println("Dir "+f.toString());
               for(int i=0;i<f.listFiles().length;i++){
                   query.enqueue(f.listFiles()[i].toString());
               }
           }
           else{
                         System.out.println("    "+child);
           }
       }
        System.out.println("Total size=" + size);
    }
    
}
