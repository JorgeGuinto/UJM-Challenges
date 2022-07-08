import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Enter the size of the array.\r");
        //printArray(getIntegers(scanner.nextInt()));

        printArray(sortIntegers(getIntegers(scanner.nextInt())));
    }

    public static int[] getIntegers(int capacity){
        int[] array = new int[capacity];
        System.out.println("Enter " + capacity + " integer values:\r");
        for (int i =0 ; i < array.length; i++){
            array[i] = scanner.nextInt();
        }
        return array;
    }

    public static void printArray (int [] array){
        for (int i = 0; i < array.length; i++){
            System.out.println("Element " + i + " contents " + array[i]);
        }

    }

    public static int[] sortIntegers (int[] array){
        /* MI SOLUCIÓN*/
        /*int[] sortedArray = new int[array.length];

        int position = 0;
        int value = 0;
        for(int i = 0; i < array.length; i++){
            position = 0;
            value = array[i];
            boolean repeat = false;

            for (int j = 0; j < array.length; j++){
                if (value < array[j]){
                    position += 1;
                } else if (value == array[j] && repeat == false){
                    repeat = true;
                } else if (value == array[j] && repeat == true){
                    position += 1;
                }
            }
            sortedArray[position] = value;
        }
        return sortedArray;*/

        //SOLUCIÓN DE ESTE DUDE

        int[] sortedArray = new int[array.length];
        for(int i = 0; i < array.length; i++){
            sortedArray[i] = array[i];
        }
        boolean flag = true;
        int temp;

        while (flag){
            flag = false;
            for(int i = 0; i < (sortedArray.length - 1); i++){
                if (sortedArray[i] < sortedArray[i+1]){
                    temp = sortedArray[i];
                    sortedArray[i] = sortedArray[i + 1];
                    sortedArray[i + 1] = temp;
                    flag = true;
                }
            }
        }
        return sortedArray;
    }

}
