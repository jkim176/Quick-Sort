import java.util.ArrayList;
import java.util.Scanner;

public class QuickSort{
   public static void main(String[] args){
      ArrayList<Double> myArray = new ArrayList<>();
      Scanner scan = new Scanner(System.in);
      // input
      System.out.println("Enter a number to add to your array (enter -9999 to finish): ");
      double val = 0;
      while(val != -9999){ // sentinel = -9999
         val = scan.nextDouble();
         if(val != -9999)
            myArray.add(val);
         else
            break;
      }
      // output
      System.out.println("Array before sorting: [index]val_");
      for(Double d: myArray)
         System.out.print("[" + myArray.indexOf(d) + "]" + d + " ");
      System.out.println();
      quickSort(myArray);
      System.out.println("Array after sorting: [index]val_");
      for(Double d: myArray)
         System.out.print("[" + myArray.indexOf(d) + "]" + d + " ");
   }
   public static void quickSort(ArrayList<Double> a){
      quickSort(a, 0, a.size() - 1);   // set first = 0, last = size - 1
   }
   public static void quickSort(ArrayList<Double> a, int first, int last){
      if(last > first){
         int pivotIndex = partition(a, first, last);  // save pivot
         // partition array
         quickSort(a, first, pivotIndex - 1);   // p1: a[0:pivotIndex - 1]
         quickSort(a, pivotIndex + 1, last); // p2: a[pivotIndex + 1: size - 1]
      }
   }
   public static int partition(ArrayList<Double> a, int first, int last){
      double pivot = a.get(first);  // set pivot
      int lo = first + 1;  // left pointer
      int hi = last; // right pointer
      
      while(lo < hi){   // while pointers did NOT cross
         while(lo <= hi && a.get(lo) >= pivot)  // lo, skip val < pivot
            lo++;
         while(lo <= hi && a.get(hi) < pivot)   // hi, skip val > pivot
            hi--;
         if(lo < hi){   // if pointers did NOT cross  
            // swap 
            double temp = a.get(hi);
            a.set(hi, a.get(lo) );
            a.set(lo, temp);
         }
      }
      while(hi > first && a.get(hi) <= pivot)   // pointers DID cross
         // while hi > 0 AND a[hi] > pivot, skip
         hi--;
      if(pivot < a.get(hi) ){ // if a[hi] < pivot
         // swap ....
         a.set(first, a.get(hi) );
         a.set(hi, pivot);
         return hi;  // .... and return hi, smallest val index
      }
      else{ // if smallest val is pivot
         return first;  // return first index
      }
   }
}