public class Main {
    public static void main(String[] args) {
/*
Даны два целых числа.
Написать программу, выводящую на экран или их сумму
или если эти числа равны, то двойную сумму.
 */
     //   int a = 2;
        int a = 3;
        int b = 3;
    //    a = 3;

        int sum = a + b;//6

        if(a==b){
            sum = sum*2;   //12
        }
        System.out.println("sum of a+b = "+sum);
        //output: sum of a+b = 12



        if(a==b) {
            System.out.println((a+b)*2);

        }
        else System.out.println(a+b);

        if(a==b) System.out.println((a+b)*2);
        if (a!=b) System.out.println(a+b);

        char ch1 = 'k';
        char ch2 = 'k';
    //    if(ch1==ch2)

        /* IF  Условный Оператор
        1-if statement
        2- if-else statement
        3- nested if
        4- if-else-if

        example of nested if
        **/
       // int num = 20;
       // int num = 5;
        int num = 61;

        if(num <50){
            System.out.println("number is less than 50");

            if(num>10){
                System.out.println("number is greater than 10");
            } else {
                System.out.println("number is less than 10");
            }
            /*output:
            number is less than 50
            number is greater than 10

            output2: number is less than 50
                        number is less than 10

            output3:  number is greater than 50


             */

        } else {
            System.out.println("number is greater than 50");
        }

        /* if-else-if ladder
         if(condition)
            statement;
         else if (condition)
            statement
         else if (condition)
            statement
         .
         .
         .
         else
          statement
         */

        int x =1;
        /*
        output:
        x is one
        Finish
         */
        x=3;
        /*
        output:
        x is three
        Finish
         */
        x=6;
        /*
        output:
        x is not between 1 and 4
        Finish
         */

        if(x==1)
        {
            System.out.println("x is one");
        }
        else if(x==2){
            System.out.println("x is two" );
        }
        else if (x==3){
            System.out.println("x is three");
        }
        else if (x==4){
            System.out.println("x is four");
        }
        else {
            System.out.println("x is not between 1 and 4");
        }
        System.out.println("Finish");


        /* Ternary operator
      variable =  Condition ? Expression1 : Expression2
         */
     //   int age = 10;
        int age=19;

  //    boolean isAdult =  age >=18 ? true : false;
      String isAdult;
      if (age>=18) {
          isAdult="can vote";
      }
      else{
          isAdult ="too young";
      }

        System.out.println("isAdult1 for classical if else: "+isAdult);



      String isAdultTernary = age>=18 ? "can vote":"too young";
        System.out.println("isAdultTernary: "+isAdultTernary);

    /*
    output1:
    isAdult1 for classical if else: too young
    isAdultTernary: too young

    output2
    isAdult1 for classical if else: can vote
    isAdultTernary: can vote
     */

    String caseWord =  "uppercase";

    String name =  caseWord.equals("uppercase")?"EVGENY":"evgeny";

    //
/*
        Даны два целых числа.
        Написать программу, выводящую на экран или их сумму
        или если эти числа равны, то двойную сумму.
 */
        int sum1 = a!=b? a+b : (a+b)*2;

        String str = null;
     //   str.toUpperCase();

        String value = str !=null ? str.toLowerCase(): null;
        System.out.println(" value is "+value);

        int value1 = 5;
        int value2 = 8;
        int max = value1 >=value2 ? value1 : value2;
        System.out.println("max is "+max);

        /*
        output:
        value is null
        max is 8
         */

        int value3 = -10;
        int abs = value3>=0? value3: -value3;
        System.out.println("abs value of "+value3+" is "+abs);
        // output: abs value of -10 is 10

        // есть целое положительное число. Нужно вывести на экран количество его цифр если их не
        // больше четырех в следующем виде :
        //   3 ->   "It is a one  digit number
        //   10 -> "It is a two digit number
        //   368 ->  "It is a three digit number
        //  6785 -> "It is a four digit number
       // если же кличество цифр числа больше 4 то вывести надпись "the number is too big for me"

        int number = 2;
        //It is a one  digit number
        number =46;
        //It is a two digit number
        number = 789;
        //It is a three digit number
        number = 4567;
        //It is a four digit number
        number = 23456789;
        //The number is not between 0 and 9999
        number=-34;
        //The number is not between 0 and 9999


        if (number>=0 && number<10){
            System.out.println("It is a one  digit number");
        }
        else if (number>=10 && number<100){
            System.out.println("It is a two digit number");
        }
        else if (number>=100 && number<1000){
            System.out.println("It is a three digit number");
        }
        else if (number>=1000 && number<10000){
            System.out.println("It is a four digit number");
        }
        else {
            System.out.println("The number is not between 0 and 9999");
        }

        // Найти максимальное из трех целых чисел используя какой либо из вариантов еlse if.
        int number1 = 10, number2 = 30, number3 = 1;

        if (number1 >=number2 && number1>=number3)
            System.out.println(number1+" is the largest number");

        else if (number2>=number1 && number2>number3)
            System.out.println(number2+" is the largest number");
        else
            System.out.println(number3 +" is the largest number");

//output 30 is the largest number


        //the same task with nested if

        if(number1>=number2) {

            if (number1 >= number3) {
                System.out.println(number1 + " is the largest");
            } else {
                System.out.println(number3 + " is the largest");
            }
        }
        else {
            if(number2 >= number3){
                System.out.println(number2+" is the largest");
            } else{
                System.out.println(number3+ " is the largest");
            }
        }


        }
    }







