/** 
  Implementations of sorting an array  
 */
package hw_69;

import java.util.Arrays;

public class Sorts {

    private Comparable[] data;  // avoid changing the user's data
    public final int SORTS_METHOD_SELECTION = 0;
    public final int SORTS_METHOD_INSERTION = 1;

    // constructor
    public Sorts( Comparable[] usersData) {
        data = usersData;
    }
    
    
    /** 
      @return a string representation of the data
     */
    public String toString() {
        return Arrays.toString(data);
    }


    /** 
      @return a reference to the data
     */
     public Comparable[] get() {
         return data;
     }


    /** 
      @return the boolean value of the statement
         "the data is in ascending order"
     */
     public boolean isSorted() {
         for(int i = 1; i < data.length; i++){
             if(data[i].compareTo(data[i - 1]) < 0){
                 return false;
             }
         }
         return true;
     }


    /** 
      Sort the data, invoking the specified method.
     */
     public void sort(final int method) {
         switch(method){
             case SORTS_METHOD_SELECTION:
                 selectionSort();
                 break;
             case SORTS_METHOD_INSERTION:
                 insertionSort();
                 break;
             default:
                 //nothing here
                 break;
         }
     }


    /** 
      insertion sort
     */
    //to be fair, this would be much easier recursively
     private void insertionSort() {
         for(int i = 1; i < data.length; i++){
             System.out.println("insert value from slot " + i + ", " + data[i]);
             //print everything out
             for(int j = 0; j < data.length; j++){
                 if(j == i) System.out.print("| ");
                 System.out.print(data[j] + " ");
             }
             System.out.println("");

             //begin insertion (backwards)
             for(int j = i; j >= 0; j--){
                 if(data[j].compareTo(data[i]) < 0){
                     //insert the element at j
                     System.out.println("insert at index " + (j + 1));
                     Comparable insert = data[i];
                     for(int k = i - 1; k >= j; k--){
                         data[k + 1] = data[k];
                     }
                     data[j + 1] = insert;
                     break;
                 }
                 for(int k = 0; k < data.length; k++){
                     if(i == k) System.out.print("| ");
                     if(j == k) System.out.print("_ ");
                     System.out.print(data[k] + " ");
                 }
                 System.out.println("");
                 //special case
                 if(j == 0){
                     System.out.println("insert at index 0");
                     Comparable insert = data[i];
                     for(int k = i - 1; k >= 0; k--){
                         data[k + 1] = data[k];
                     }
                     data[0] = insert;
                 }

             }
         }
     }


    /**
      selection sort
     */
     private void selectionSort() {
         for(int i = 0; i < data.length; i++){
            int curSmallest = i;
            for(int j = i + 1; j < data.length; j++){
                if(data[curSmallest].compareTo(data[j]) > 0){
                    curSmallest = j;
                }
            }
            Comparable temp = data[curSmallest];
             data[curSmallest] = data[i];
            data[i] = temp;
         }
     }
}