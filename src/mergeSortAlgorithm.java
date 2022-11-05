import java.util.Arrays;

public class mergeSortAlgorithm {
    public static void main(String[] args) {
        Integer[] array = {5, 4, 1, 2, 3};
        mergeSort(array);
        Arrays.asList(array).forEach(item->System.out.println(item));
    }


    private static void mergeSort(Integer[] array) {
        // the main condition is the base condtion where the loop will break
        if (array.length < 2) {
            return;
        }
        Integer middle = array.length / 2;
        Integer[] leftarray = new Integer[middle];
        Integer[] rightarray = new Integer[array.length - middle];
        // tranfer the data.
        for (Integer i = 0; i < leftarray.length; i++) {
            leftarray[i] = array[i];
        }
        for (Integer j = 0; j < rightarray.length; j++) {
            rightarray[j] = array[middle + j];
        }
        mergeSort(leftarray);
        mergeSort(rightarray);
        merge(array, leftarray, rightarray);
    }

    private static void merge(Integer[] array, Integer[] leftarray, Integer[] rightarray) {
        Integer leftarrayindex = 0;
        Integer rightarrayindex = 0;
        Integer arrayindex = 0;
        while (leftarrayindex < leftarray.length && rightarrayindex < rightarray.length) {
            if (leftarray[leftarrayindex] < rightarray[rightarrayindex]) {
                array[arrayindex++] = leftarray[leftarrayindex++];
            } else {
                array[arrayindex++] = rightarray[rightarrayindex++];
            }

        }
        // now tranfering the remaining items.
        // firstly in the left array.
        while (leftarrayindex < leftarray.length) {
            array[arrayindex++] = leftarray[leftarrayindex++];
        }
        while (rightarrayindex < rightarray.length) {
            array[arrayindex++] = rightarray[rightarrayindex++];
        }
        
    }



}

