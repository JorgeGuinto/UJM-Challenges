import java.util.Arrays;

public class ReverseArray {

    public static void main(String[] args) {

        int[] array = new int[]{1,2,3,4,5};
        reverse(array);
    }

    private static void reverse(int[] array){
        System.out.println("Array = " + Arrays.toString(array));

        for (int i = 0; i < (array.length/2); i++){
            int storage = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = storage;
        }

        System.out.println("Reversed array = " + Arrays.toString(array));
    }

}
