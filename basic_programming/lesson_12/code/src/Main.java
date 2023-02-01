import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
/*      Homework
        Написать программу, проверяющую является ли число четным или нечетным.
       Решить задачу двумя способами -через оператор if и через тернарный оператор.
       num%2 ==0
 */
        int num = 2;

        if (num % 2 ==0){
   //         System.out.println(num+ " is even number");
        }else{
    //        System.out.println((num+" is odd number"));
        }

   //     String evenOrOdd = (num % 2 ==0)?"even number":"odd number";

        /*SWITCH
         switch(expression){

         case constant1:
          statement sequence
          break;

         case constant2:
           statement sequence
           break;

         case constant3:
            statement sequence
            break;
            .
            .
            .
            default
             statement sequence

         }
         */
        int i =0;
        //i is zero
         i=2;
         //i is two
        i=0;
        //i is more than 3
        switch (i){
            case 0:
                System.out.println("i is zero");
                break;
            case 1:
                System.out.println("i is one");
                break;
            case 2:
                System.out.println("i is two");
                break;
            case 3:
                System.out.println("i is three");
                break;

            default:
                System.out.println("i is more than 3");

        }
        i=0;
        switch (i){
            case 0:
                System.out.println("i is zero");
            //    break;
            case 1:
                System.out.println("i is one");
            //    break;
            case 2:
                System.out.println("i is two");
            //    break;
            case 3:
                System.out.println("i is three");
            //    break;

            default:
                System.out.println("i is more than 3");

                /*
                * i is zero
                    i is one
                    i is two
                    i is three*/

        }

        char ch = 'a';
        ch = 'd';
        //another case

        switch (ch)
        {
            case 'd':
                System.out.println("Case d");
            //    break;
            case 'c':
                System.out.println("Case c");
                break;
            case 'a':
                System.out.println("Case a");
                break;

            default:
                System.out.println("another case");
        }

        /*
        1- порядок следования вариантов в switch  не обязательно должен быть 1,2,3.
        а должен отражать лишь необходимые для выполнения программы случаи (case)
        2- в качестве выражения в традиционном switch могут использоваться числа,
        символы и строки
        3- выражение в скобках внутри switch  должно в результате давать константу
         иначе switch  не будет работать
         (1+3+56)  (a+2)


        * */
        /* Java Help System
         Help on:
         1.if
         2.switch
         Choose one:
         */

        Scanner scanner = new Scanner(System.in);
        System.out.println("Help on");
        System.out.println("1.if");
        System.out.println("2.switch");
        System.out.println("Enter number: ");
        int choice = scanner.nextInt();

        switch (choice){
            case 1:
                System.out.println("The IF:");
                System.out.println("if(condition) statement;");
                System.out.println("else statement;");
                break;
            case 2:
                System.out.println("Traditional Switch:");
                System.out.println("switch(expression) {");
                System.out.println(" case constant:");
                System.out.println(" statement sequence");
                System.out.println(" break;");
                System.out.println("}");
                break;
            default:
                System.out.println("Your selection is not found");
        }

        // 1.написать простой калькулятор с четырьмя действиями, используя switch.
        // num1 и num2  +,-, /,*
        double num1,num2;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the first number: ");
        num1 = scanner.nextDouble();

        System.out.println("Enter the second number: ");
        num2 = scanner.nextDouble();

        System.out.println("Enter an operator(+,-,/,*)");
        char operator =scanner.next().charAt(0);

     //   sc.close();

        double result=0.0;

        switch (operator){

            case '+':
                result = num1 + num2;
                break;

            case '-':
                result = num1 - num2;
                break;

            case '*':
                result = num1*num2;
                break;

            case '/':
                result = num1/num2;
                break;

            default:
                System.out.println("Wrong operator");

        }
        if(operator=='+'||operator=='-'||operator=='*'||operator=='/')
        System.out.println(num1+" +operator+"+num2+" = "+result);

        //2.Написать программу, проверяющую является ли введенная с клавиатуры буква английского алфавита
        // гласной или  согласной . Написать как switch  и написать через if-else.
        // гласные: a,e,i,o,u,y:

        System.out.println("Enter a character: ");
        char ch1 = scanner.next().charAt(0);

        boolean isVowel=false;

        switch (ch1)
        {
            case 'a':
            case 'y':
            case 'i':
            case 'o':
            case 'u':
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
            case 'Y':
            case 'e': isVowel =true;

        }
        if (isVowel) {
            System.out.println(ch1 + " is a vowel");
        }
        else {
            if ((ch1 >= 'a' && ch1 <= 'z') || (ch1 >= 'A' && ch1 <= 'Z'))
                System.out.println(ch1 + " is a consonant");

            else
                System.out.println("Your symbol is not an english letter");

        }




        //3.Написать программу, находящую количество дней в месяце.
        // С клавиатуры вводятся два значения: номер месяца  и год.
        // А программа выдает количество дней в этом месяце.
        //month= 1 , year=2000 -> 31
        //month= 2 , year = 1999 -> 28
        //month= 2 , year = 2000 -> 29
        //
        System.out.println("Enter a year");
        int year = sc.nextInt();

        System.out.println("Enter month number from 1 to 12");
        int month = sc.nextInt();

        switch (month){
            case 1:
                System.out.println("January, 31 days");
                break;

            case 2:
                int numberOfDaysInFebruary;

                if((year%4==0)&&(((year%100)!=0)||((year%100==0)&&(year%400==0))))
                { numberOfDaysInFebruary =29;
                }else{numberOfDaysInFebruary=28;
                }
                System.out.println("February "+numberOfDaysInFebruary);
                break;

            case 3:
                System.out.println("March, 31 days");
                break;

            case 4:
                System.out.println("April, 30 days");
                break;

            default:
                System.out.println("you entered the wrong month number");
        }













    }
}