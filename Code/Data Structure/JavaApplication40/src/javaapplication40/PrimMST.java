/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication40;

/**
 *
 * @author Nguyen Hoang Minh
 */
public class PrimMST {
    int size;
    public PrimMST(int n){
        this.size=n;
    }
    
    int minKey(int key[],boolean check[]){ // tim min lien thuoc value
        int min=Integer.MAX_VALUE; // set gia tri max value 
        int index=-1;
        for(int i=0;i<size;i++){
            if(min>key[i]&&check[i]==false){ // kiem tra neu min > key{1} nghia la node day chua dc duyet
                index=i; // thoa man thi gan position of node
                min=key[i]; // gan vi tri 
            }
        }
        return index; // return ve vi tri node day la node nao
    }
    
    void prismMST(int graph[][]){
        int key[]=new int[size]; // luu khoang cach ngan nhat
        boolean check[] = new boolean[size]; // check  cho tung dinh neu duyet roi la true 
        int parent[]=new int[size]; // luu node parent
        for(int i=0;i<size;i++){
            key[i]=Integer.MAX_VALUE; // xet distance nhung node chua dc duyet
            check[i]=false; // chua duoc duyet
        }
        key[0]=0;
        parent[0]=-1; //root vi root ko co phu huynh
        for(int i=0;i<size;i++){ // duyet all node tim cac node chua dc duyet
            int u=minKey(key, check); // lay duoc dinh 
            check[u]=true; // duyet dinh day phai set la true da duyet
            for(int j=0;j<size;j++){ //duyet all node tim cac node lien thuoc
                if(graph[u][j] != 0&&graph[u][j]<key[j]&&check[j]==false){ // duyet dinh lien thuoc co khoang cach nho nhat ma chua dc duyet va
                    // khac khong la lien thuoc
                    // bang khong la khong lien thuoc
                    // gia tri tai dinh graph[u][j] < key[j]
                    // va cai Node day chua duoc duyet
                    key[j]=graph[u][j]; // cap nhat doan duong day thanh doan ngan nhat
                    parent[j]=u;// u den j parent cua j la u
                }
            }
        }
        //display
        for(int i=1;i<size;i++){ // khong la root 
            System.out.println(parent[i]+" to "+i+" distance: "+graph[i][parent[i]]);
        }
    }
}
