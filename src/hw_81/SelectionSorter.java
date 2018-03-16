package hw_81;

import java.util.Arrays;

public class SelectionSorter extends Sorter {
    SelectionSorter(Comparable[] in){
        super(in);
    }
    public void sort(){
        for(int i = 0; i < data.length; i++){
            int curChamp = i;
            for(int k = i; k < data.length; k++){
                if(data[k].compareTo(data[curChamp]) < 0){
                    curChamp = k;
                }
            }
            Comparable temp = data[i];
            data[i] = data[curChamp];
            data[curChamp] = temp;
        }
    }
}
