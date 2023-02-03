import java.util.Scanner;

public class Game {
   static Scanner scanner = new Scanner(System.in);
   static int secret = 9;

    public static void main(String[] args) {

    }

    private static int readNumberOfAttempts(){
        System.out.println("Enter number of attempts ");
       // int number=scanner.nextInt();
        return scanner.nextInt();
    }
}