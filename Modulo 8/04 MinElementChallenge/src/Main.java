import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner (System.in);

    public static void main(String[] args) {

        System.out.println("Enter count:");
        int count = scanner.nextInt();
        scanner.nextLine();

        int[] myArray = readIntegers(count);
        System.out.println("min = " + findMin(myArray));

        /*-------------- PARA EL EJERCICIO
        int count = readInteger();
        int[] array = readElements(count);
        int min = findMin(array);
        System.out.println(min);*/

    }

    private static int[] readIntegers (int count){
        int[] myArray = new int[count];

        for (int i = 0; i < myArray.length; i++){
            System.out.println("Enter a number:");
            myArray[i] = scanner.nextInt();
            scanner.nextLine();
        }

        return myArray;
    }

    private static int findMin(int[] myArray){

        int min = myArray[0];

        for (int i = 1; i < myArray.length; i++){
            if (myArray[i] < min){
                min = myArray[i];
            }
        }
        return min;
    }

    /*-----------------------PARA EL EJERCICIO DEL CHALLENGE-----------------------------
    private static int readInteger (){
        Scanner scanner = new Scanner (System.in);
        int count = scanner.nextInt();
        scanner.nextLine();
        return count;
    }

    private static int[] readElements (int count){
        Scanner scanner = new Scanner (System.in);
        int[] myArray = new int[count];

        for (int i = 0; i < myArray.length; i++){
            //System.out.println("Enter a number:");
            myArray[i] = scanner.nextInt();
            scanner.nextLine();
        }

        return myArray;
    }

    private static int findMin(int[] myArray){

        int min = myArray[0];

        for (int i = 1; i < myArray.length; i++){
            if (myArray[i] < min){
                min = myArray[i];
            }
        }
        return min;
    }*/

}
