package hw_83;

abstract class Sorter {

    protected Comparable[] elements;  // avoid changing the user's data


    /**
     construct an instance by copying the user's data
     */
    protected Sorter( Comparable[] usersData) {
        elements = new Comparable[ usersData.length];
        for( int i = 0; i < usersData.length; i++)
            elements[i] = usersData[i];
    }


    /**
     Sort elements, using the algorithm of the subclass.
     */
    public abstract void sort( );


    /**
     @return a string representation of the elements
     */
    public String toString() {
        String result = "[";
        for( Comparable e : elements)
            result += e + ",";
        return result + "]";
    }


    /**
     @return the boolean value of the statement
     "the elements are in ascending order"
     */
    public boolean isSorted() {
        for( int i = 0
             ; i < elements.length -1 // stop early, because comparing to next
                ; i++
                )
            if( elements[i].compareTo( elements[i+1]) > 0) return false;
        return true;
    }
}
