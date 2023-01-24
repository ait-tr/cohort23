import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

     /*   1. a | (b&c) = (a|b)&(a|c)
        2. a & (b|c) = (a&b)|(a&c)
                3. !(a|b) = !a & !b
        4. !(a&b) = !a | !b */

        boolean a = false;
        boolean b = true;
        boolean c = false;
    /*    System.out.println((a | (b&c)) == ((a|b)&(a|c)));
        System.out.println((a & (b|c)) == ((a&b)|(a&c)));
        System.out.println(!(a|b) == (!a & !b));
        System.out.println(!(a&b) == (!a | !b));*/

     //   System.out.println("Hello world!");
      //  a||b==c

        //homework 1
        int x =10;
        int y =9;
   //     System.out.println(x==y);

        //homework2
        boolean vasyaSmile = true;
        boolean petyaSmile = true;
        boolean trouble= vasyaSmile==petyaSmile;
    //    System.out.println(trouble);

        vasyaSmile = false;
        petyaSmile = true;
        trouble=vasyaSmile==petyaSmile;
     //   System.out.println(trouble);

   //     Scanner scanner = new Scanner("qwertzertzujkl");

   //    String s = scanner.nextLine();

    //    System.out.println(s);

    //    Scanner scanner1 = new Scanner(System.in);


  //      System.out.println("Enter your name: ");
  //      String str1 = scanner1.nextLine();

    //    System.out.println("Your name is "+str1);

    //    scanner1.close();
    //    scanner.close();




        //System.out.println("Enter your name: ");
     //   String str2 = scanner2.nextLine();

     //   System.out.println("Your name is "+str2);

        Scanner scanner2 = new Scanner(System.in);

    //    System.out.println("Enter int number: ");

    //    int num =scanner2.nextInt();

    //    System.out.println("you entered "+num);

    //    System.out.println("Enter second number: ");

    //    int num2 = scanner2.nextInt();
    //    System.out.println("you entered "+num2);

   //     System.out.println("the sum of your numbers is "+(num+num2));


     //   System.out.println("Enter your full name: ");

     //   String word = scanner2.next();
    //    String word = scanner2.nextLine();

    //    System.out.println("your full name is: "+word);

   //     System.out.println("Enter number");
   //     int num = scanner2.nextInt();

   //     System.out.println("you entered number "+num);


        //   -10
        int abs = Math.abs(-10);// абсолютное значение
        System.out.println(abs);
        int x1 = 10;
        System.out.println(Math.abs(x1));

        Math.abs(45.58);

        int min = Math.min(10,20);//мин
        System.out.println(min);

        int max = Math.max(10,20);//макс
        System.out.println(max);

        double random = Math.random();//случайное число
        System.out.println(random);
        random = Math.random()*100D;
        System.out.println(random);


        double round = Math.round(random);//округление
        System.out.println("rounded random is "+round);

       double roundUP = Math.round(24.8);
       double roundDown = Math.round(24.2);
        System.out.println("roundUp is "+roundUP);
        System.out.println("roundDown is "+roundDown);

        double power = Math.pow(2,3);// степень
        System.out.println(power);

        double sqrt = Math.sqrt(9);// квадратный корень
        System.out.println("square root is "+sqrt);

        System.out.println(Math.PI);








    }
}