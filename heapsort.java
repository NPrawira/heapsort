import java.util.*;	
 
public class heapsort {

    public static void build(int []arr) {
        for(int i=(arr.length-1)/2; i>=0; i--) {
            heapify(arr, i, arr.length-1);
        }
    }

    public static void heapify(int[] arr, int i,int size) { 
        int left = 2*i+1, right = 2*i+2, max;
        if(left <= size && arr[left] > arr[i]) {
            max = left;
        } else {
            max = i;
        }
        if(right <= size && arr[right] > arr[max]) {
            max = right;
        }
        if(max != i) {
            exchange(arr, i, max);
            heapify(arr, max, size);
        }
    }
 
    public static void exchange(int[] arr,int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
 
    public static int[] sort(int[] arr) {
        build(arr);
        int size = arr.length-1;
        for(int i=size; i>0; i--) {
            exchange(arr, 0, i);
            size = size-1;
            heapify(arr, 0, size);
        }
        return arr;
    }
 
    public static void main(String[] args) {
        int[] arr = new int[10];
        Random random = new Random();
        for(int a=0; a<10; a++){
        	arr[a] = random.nextInt(100);	
        }
        System.out.println("Before Heap Sort: ");
        System.out.println(Arrays.toString(arr));
        arr = sort(arr);
        System.out.println("After Heap Sort: ");
        System.out.println(Arrays.toString(arr));
    }
}
