class Car implements Comparable<Car>
 {String owner;
  int price;
  Car(String xOwner, int xPrice)
   {owner=xOwner;price=xPrice;
   }
  public String toString()
   {return("(" +owner+","+ price + ")");
   }

    @Override
    public int compareTo(Car o) {
       return Integer.compare(price, o.price);
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 }
