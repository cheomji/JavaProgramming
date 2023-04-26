package real;

import abs.Calculator;

public class KnuCalc extends Calculator {

   @Override
   public int add(int a, int b) {
      return a + b;
   }

   @Override
   public int subtract(int a, int b) {
      // TODO Auto-generated method stub
      return a - b;
   }

   @Override
   public double average(int[] a) {
      double sum = 0;
      for(int element : a) sum += element;
      return sum / a.length;
   }

}
