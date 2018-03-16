package hw_81;

import java.util.Arrays;

public abstract class Sorter {
    protected Comparable[] data;

    Sorter(Comparable[] in){
        data = in;
    }
    public String toString(){
        return Arrays.toString(data);
    }
    public boolean isSorted(){
        for(int i = 1; i < data.length; i++){
            if(data[i].compareTo(data[i-1]) < 0) {
                return false;
            }
        }
        return true;
    }

    public abstract void sort();
}
