/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)============================================
import java.io.*;
import java.util.*;
//-------------------------------------------------------------------------------

class Graph {

    int[][] a;
    int n;
    char v[];
    int deg[];

    Graph() {
        v = "ABCDEFGHIJKLMNOP".toCharArray();
        deg = new int[20];
        a = new int[20][20];
        n = 0;
    }

    void loadData(int k) //do not edit this function
    {
        RandomAccessFile f;
        int i, j, x;
        String s;
        StringTokenizer t;
        a = new int[20][20];
        try {
            f = new RandomAccessFile("data.txt", "r");
            for (i = 0; i < k; i++) {
                f.readLine();
            }
            s = f.readLine();
            s = s.trim();
            n = Integer.parseInt(s);
            for (i = 0; i < n; i++) {
                s = f.readLine();
                s = s.trim();
                t = new StringTokenizer(s);
                for (j = 0; j < n; j++) {
                    x = Integer.parseInt(t.nextToken().trim());
                    a[i][j] = x;
                }
            }
            f.close();
        } catch (Exception e) {
        }

    }

    void dispAdj() {
        int i, j;
        for (i = 0; i < n; i++) {
            System.out.println();
            for (j = 0; j < n; j++) {
                System.out.printf("%4d", a[i][j]);
            }
        }
    }

    void fvisit(int i, RandomAccessFile f) throws Exception {
        f.writeBytes(" " + v[i]);
    }

    void breadth(boolean[] en, int i, RandomAccessFile f) throws Exception {
        Queue q = new Queue();
        int r, j;
        q.enqueue(i);
        en[i] = true;
        while (!q.isEmpty()) {
            r = q.dequeue();
            fvisit(r, f);
            for (j = 0; j < n; j++) {
                if (!en[j] && a[r][j] > 0) {
                    q.enqueue(j);
                    en[j] = true;
                }
            }
        }
    }

    void breadth(int k, RandomAccessFile f) throws Exception {
        boolean[] en = new boolean[20];
        int i;
        for (i = 0; i < n; i++) {
            en[i] = false;
        }
        breadth(en, k, f);
        for (i = 0; i < n; i++) {
            if (!en[i]) {
                breadth(en, i, f);
            }
        }
    }

    void depth(boolean[] visited, int k, RandomAccessFile f) throws Exception {
        fvisit(k, f);
        visited[k] = true;
        for (int i = 0; i < n; i++) {
            if (!visited[i] && a[k][i] > 0) {
                depth(visited, i, f);
            }
        }
    }

    void depth(int k, RandomAccessFile f) throws Exception {
        boolean[] visited = new boolean[20];
        int i;
        for (i = 0; i < n; i++) {
            visited[i] = false;
        }
        depth(visited, k, f);
        for (i = 0; i < n; i++) {
            if (!visited[i]) {
                depth(visited, i, f);
            }
        }
    }

    void depth2(int k, RandomAccessFile f) throws Exception {
        boolean[] visited = new boolean[20];
        int i;
        for (i = 0; i < n; i++) {
            visited[i] = false;
        }
        depth2(visited, k, f);
        for (i = 0; i < n; i++) {
            if (!visited[i]) {
                depth2(visited, i, f);
            }
        }
    }

    void depth2(boolean[] visited, int k, RandomAccessFile f) throws Exception {
        
        fvisit2(k, f);
        visited[k] = true;
        for (int i = 0; i < n; i++) {
            if (!visited[i] && a[k][i] > 0) {
                depth2(visited, i, f);
            }
        }
    }

    void fvisit2(int i, RandomAccessFile f) throws Exception {
        f.writeBytes(" " + v[i]+"("+deg(i)+")");
        
    }

    int deg(int i) {
        int s, j;
        s = 0;
        for (j = 0; j < n; j++) {
            s += a[i][j];
        }
        s += a[i][i];
        return (s);
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
    void f1() throws Exception {
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        depth(1, f);
        f.writeBytes("\r\n");
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        depth2(1,f);
        //-------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }
//===========================================================================

    void f2() throws Exception {
        loadData(12);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        dijkstra(0, 4, f);

        //-------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }

    public void dijkstra(int from, int to, RandomAccessFile f) throws IOException {
        int distance[] = new int[n];
        boolean[] visited = new boolean[n];
        int[] path = new int[n];
        for (int i = 0; i < n; i++) {
            distance[i] = Integer.MAX_VALUE;
            path[i] = from;
            visited[i] = false;
        }

        System.out.println("");
        distance[from] = 0;
        int sel = from;
        visited[sel] = true;
//        path[0] = from;
        for (int t = 0; t < n; t++) {

            for (int i = 0; i < n; i++) {
                //cac dinh lien ke cua from
                if (!visited[i] && (a[sel][i] + distance[sel] < distance[i])) {
                    distance[i] = a[sel][i] + distance[sel];
                    path[i] = sel;
                }

            }
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (!visited[i] && (distance[i] < min)) {
                    sel = i;
                    min = distance[i];
                }
            }
            visited[sel] = true;
        }

        int x = to;
        java.util.Stack stack = new java.util.Stack();
        while (x != from) {
            stack.push(x);
            x = path[x];
        }
        stack.push(from);
        String dis = "";
        String ans = "";
        while (!stack.isEmpty()) {
            x = (int) stack.pop();
            ans += v[x] + " ";
            dis = dis + distance[x] + " ";
        }
        f.writeBytes(ans + "\n" + dis);

    }

//===========================================================================
/*
Algorithm for finding an Euler cycle from the vertex X using stack 
//Input: Connected graph G with all vertices having even degrees
//Output: Euler cycle
declare a stack S of characters
declare empty array E (which will contain Euler cycle)
push the vertex X to S
while(S is not empty)
 {r = top element of the stack S 
  if r is isolated then remove it from the stack and put it to E
   else
   select the first vertex Y (by alphabet order), which is adjacent
   to r, push  Y  to  S and remove the edge (r,Y) from the graph   
 }
 the last array E obtained is an Euler cycle of the graph
     */
    void f3() throws Exception {
        loadData(20);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        f.writeBytes("\r\n");
        //-------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        // You can use the statement fvisit(i,f); i = 0, 1, 2,...,n-1 to display the vertex i to file f5.txt 
        //  and statement f.writeBytes(" " + k); to write  variable k to the file f5.txt  

        eulerCycle(1, f);

        //-------------------------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }

    void eulerCycle(int from, RandomAccessFile f) throws IOException {
        Stack s = new Stack();
        s.push(from);
        ArrayList<Integer> arr = new ArrayList<>();

        while (!s.isEmpty()) {
            int sel = s.top();
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (a[sel][i] != 0) {
                    display(a);
                    s.push(i);
                    a[sel][i]--;
                    a[i][sel]--;
                    count++;
                    break;

                }

            }
            if (count == 0 && !s.isEmpty()) {
                arr.add(s.pop());
            }
        }
        for (int i = 0; i < arr.size(); i++) {
            f.writeBytes(v[arr.get(i)] + " ");
        }
        System.out.println("");
    }

    void display(int a[][]) {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
//=================================================================
