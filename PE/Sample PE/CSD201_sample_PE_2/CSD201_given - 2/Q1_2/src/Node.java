// Do not edit this file
class Node implements  Comparable<Node>
 {Car info;
  Node next;
  Node(Car x, Node p)
   {info=x;next=p;
   }
  Node(Car x)
   {this(x,null);
   }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(info.price, o.info.price);
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 }

