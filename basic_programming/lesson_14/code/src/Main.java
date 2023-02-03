import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
/*
Задача1

С помощью цикла while написать программу, выводящую на экран куб числа от 1 до заданного числа n
Пример:для числа n=3
1 в кубе 1
2 в кубе 8
3 в кубе 27

Задача2
С помощью цикла while написать программу, выводящую на экран результат умножения данного цисла n на все целые числа от 0 до n
Пример: для числа 3 результат будет 0, 3, 6, 9
 */
//1 task
        int i =1;
        int n =3;
        while(i<=n){
            System.out.println("number is: "+i+" and cube of "+i+"is: "+(i*i*i));
            i++;
        }
        /*output
number is: 1 and cube of 1is: 1
number is: 2 and cube of 2is: 8
number is: 3 and cube of 3is: 27

         */
  //Задача2
        //С помощью цикла while написать программу, выводящую на экран результат умножения
        // данного цисла n на все целые числа от 0 до n
        //Пример: для числа 3 результат будет 0, 3, 6, 9

 /*       i=0;
        n=4;
        while(i<=n){
            System.out.println(n+"*"+i+"="+(n*i));
            i++;
        }

        // Guess Number Game with Do-while loop

        Scanner scanner = new Scanner(System.in);
        int secretNumber = 5;
        int answer;
        int numberOfAttempts = 3;

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
                numberOfAttempts--;
                System.out.println("You have "+numberOfAttempts+" attempts left");
            }

        }while(answer != secretNumber && numberOfAttempts>0);

        System.out.println("Game is over");

  */


        // METHODS IN JAVA
        //ret-type name (parameter list){
        //
        // }

 //   printSmth();
 //   printSmth();


  //  sum();
    int receiveReturn =  sumReturn()+1;

        System.out.println("receiveReturn is "+receiveReturn);

        System.out.println("sumReturn to print: "+sumReturn());

        int receiveReturnPar = sumReturnWithParameters(4,6);
        System.out.println("result for 4+6 is "+receiveReturnPar);
        System.out.println("result for 7+7 is "+sumReturnWithParameters(7,7));

        String wordForMethod = "Hello";
        int numberForMethod = 1;

        System.out.println(returnSmth(wordForMethod,numberForMethod));
    }



    public static void printSmth(){
     //   sum();
        System.out.println("I am printing");
    }
    public static void sum() {
    //    printSmth();
        int a = 1;
        int b = 2;
        int aPlusB = a+b;
        if(aPlusB!=3){
            return;
        }

        System.out.println("a+b = "+aPlusB);
       // return;
    }

    //точка выхода из метода и возврат результатов работы метода в основную программу с помощью return

    public static int sumReturn(){
        int a = 1;
        int b = 2;
        int aPlusB = a+b;

        return aPlusB;
      //  return "ab";
    }

    // передача в метод параметров
    public static int sumReturnWithParameters(int a, int b){
        int aPlusB = a+b;

      //  return aPlusB;
        return a+b;
    }

    public static String returnSmth (String word,int num){

        String result = word+num;

        return result;
    }

    public static String returnStringDigits (int a, int b){
        String res = "Hello"+a+b;

        return res;
    }

    //-----------------------------------Game Guess Number Methods---------------------------------------------------------



}