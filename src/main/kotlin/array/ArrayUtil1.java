package array;

public class ArrayUtil1 {


    public void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i] + " ");
        }
        System.out.println();
    }

    public void arrayDemo() {
        int[] myArray = new int[5];// default values // 0 1 2 3 4
        // printArray(myArray)
        myArray[0] = 5;
        myArray[1] = 1;
        myArray[2] = 8;
        myArray[3] = 2;
        myArray[4] = 10;
        printArray(myArray);
        System.out.println(myArray.length);
        System.out.println(myArray[myArray.length - 1]);
        System.out.println();

        int[] arr = {5, 1, 8, 10};
        printArray(arr);
    }


    public static void main(String[] args) {
        ArrayUtil1 arrayUtil1 = new ArrayUtil1();
        arrayUtil1.arrayDemo();
    }
}
