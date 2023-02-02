import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Циклы
        // While

        // syntax of While loop
        /*
        while(condition)
        {
        statement(s)
        }
         */

        // вывести на экран числа от 1 до 10 используя цикл while
        // 1,2,3,4,5,6,7,8,9,10

        int i = 1;

        while (i <= 10) {
            System.out.println(i);
            //   i=i+1;
            i++;
            //     i = i+2;


        }
        System.out.println("end of while loop");

       /*
1
2
3
4
5
6
7
8
9
10
end of while loop
        */
        //      System.out.println(i);

        // бесконечный цикл 1
        i = 10;
     /*   while (i>1)
        {
            System.out.println(i);
            i++;
        }*/

        // бесконечный цикл 2
        //   while(true){
        //       System.out.println("Hello");
        //   }

        i = 10;
        while (i > 1) {
            System.out.println(i);
            i--;
        }

        /*
output:
10
9
8
7
6
5
4
3
2
         */

        i = 10;
        while (i > 1) {
            System.out.print(i + " ");
            i--;
        }
        System.out.println();

        // вывести в консоль буквы строки с помощью цикла while

        //Hello
        //H - index 0
        //e -  1
        //l -  2
        //l -  3
        //o -  4

        String hello = "Hello";
        System.out.println(hello.charAt(0));
        System.out.println(hello.charAt(1));
        System.out.println(hello.charAt(2));
        System.out.println(hello.charAt(3));
        System.out.println(hello.charAt(4));

        System.out.println("Print hello letters with while loop");

        int index = 0;
        ; //5
        hello = "Evgeny";
        int length = hello.length();

        while (index < length) {
            //   while(index<=length-1)
            System.out.println(hello.charAt(index));

            index++;

        }


            // DO-WHILE
    /*
    do
    {
        statements

     }while(condition)
     */


            i = 1;
            do {
                System.out.println(i);
                i--;

            } while (i > 1);


            // Guess Number Game with Do-while loop

        Scanner scanner = new Scanner(System.in);
        int secretNumber = 5;
        int answer;

        do{
            System.out.println("Guess a number between 1 and 10");
            answer=scanner.nextInt();

            if(secretNumber == answer){
                System.out.println("Great! You win");
            }
            else {
                System.out.print("Sorry, the number is ");

                if(answer<secretNumber){
                    System.out.println("too small");
                }
                else {
                    System.out.println("too big");
                }
                System.out.println("Try again!");
            }

        }while(answer != secretNumber);

        System.out.println("Game is over");


        // используя цикл while написать программу, выводящую на экран сумму цифр от 1 до 5
        // 1+2+3+4+5 =15
        //sum=15
        // "sum of digits from 1 to 5 is " + sum

        int n = 3;
        int i1 = 1;
        int sum = 0;


        //1+2+3+4+5
        while (i1<=n){
            sum = sum + i1;// sum=0+1=1 // sum =1+2=3 // sum=3+3=6   // sum+=i1;
        //    System.out.println("i1= "+i1);
        //    System.out.println("sum="+sum);
            i1++;//2 //3

       //     sum+=i1++; в переменную sum записывается текущее значение sum и значение i1.
                        // После чего значение i1  увеличивается на 1

        }
        System.out.println("sum of digits from 1 to "+ n+ "  is "+sum);


        // используя do while loop написать программу, принимающую с клавиатуры целое число  и
        // выводящую на экран  сумму четных и сумму нечетных чисел

        //1 +3 7
        Scanner scanner1 = new Scanner(System.in);
        int number;
        int evenSum = 0;
        int oddSum = 0;
        char choice;

        do
        {
            System.out.println("Enter any number ");
            number = scanner1.nextInt();

            if (number % 2 ==0)
            {
                evenSum += number;
            }
            else
            {
               oddSum +=number;
            }

            System.out.println("Do you want to continue? enter 'y'or enter any other letter if not ");
            choice = scanner1.next().toLowerCase().charAt(0);

        }    while (choice == 'y');

        System.out.println("Sum of even numbers is "+evenSum);
        System.out.println("Sum of odd numbers is "+oddSum);





    }
}


