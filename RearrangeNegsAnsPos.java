// Given an array of positive and negative numbers, arrange them such that all negative integers appear before 
// all the positive integers in the array without using any additional data structure like a hash table, arrays, etc. 
// The order of appearance should be maintained.
// Examples:
// Input1 :  arr[] = [12, 11, -13, -5, 6, -7, 5, -3, -6]
// Output1 : arr[] = [-13, -5, -7, -3, -6, 12, 11, 6, 5]
// Input2 :  arr[] = [-12, 11, 0, -5, 6, -7, 5, -3, -6]
// Output2 : arr[] =  [-12, -5, -7, -3, -6, 0, 11, 6, 5]

class RearrangeNegsAnsPos {

    static void printArray(int[] array, int length) {
        System.out.print("[");

        for (int i = 0; i < length; i++) {
            System.out.print(array[i]);

            if (i < (length - 1))
                System.out.print(",");
            else
                System.out.print("]\n");
        }
    }

    static void reverse(int[] array, int start, int end) {
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

    static void rearrange(int[] array, int start, int end) {

        if (start == end)
            return;

        rearrange(array, (start + 1), end);

        if (array[start] >= 0) {
            reverse(array, (start + 1), end);
            reverse(array, start, end);
        }
    }

    public static void main(String[] args) {

        int[] array = { -12, -11, -13, -5, -6, 7, 5, 3, 6 };
        int length = array.length;
        int countNegative = 0;

        for (int i = 0; i < length; i++) {
            if (array[i] < 0)
                countNegative++;
        }

        System.out.print("array: ");
        printArray(array, length);
        rearrange(array, 0, (length - 1));
        reverse(array, countNegative, (length - 1));
        System.out.print("rearranged array: ");
        printArray(array, length);
    }
}
