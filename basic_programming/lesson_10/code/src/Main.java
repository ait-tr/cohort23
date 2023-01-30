import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        /*
        1-Даны две строки. Написать программу, выводящую в консоль строки, соединенные
        вместе, но без последних букв.Все буквы в получившейся строке должны быть
        заглавными Пример: Hello World -> HELLWORL
         */

        String hello = "Hello";
        String world = "World";

        int lengthHello = hello.length();
        int lengthWorld = world.length();

        String resultHellWorl = hello.substring(0, lengthHello - 1) + world.substring(0, lengthWorld - 1);
        //   System.out.println(resultHellWorl.toUpperCase());

        /*
        2.Написать программу, принимающую с клавиатуры слово, состоящее из не повторяющихся заглавных или прописных
        (больших или маленьких)
        букв и принимающую затем также с клавиатуры одну из букв этого слова.
         Программа заменяет эту букву в строке на звездочку и все буквы на прописные(маленькие)
         и выводит результат на экран
         */

        Scanner scanner = new Scanner(System.in);

        //    System.out.println("Enter a word ");
        //     String str = scanner.nextLine();
        //     System.out.println("you entered "+str);

        //    System.out.println("Enter one of the word letters ");

        //   char change = scanner.nextLine().toLowerCase().charAt(0);
        //     char changeCh = (char)System.in.read(); // еще один вариант чтения символов с клавиатуры

        //    String change =String.valueOf(changeCh).toLowerCase();

        //    int index = str.toLowerCase().indexOf(change);// indexOf() - метод, находящий номер символа,
        // указанного в скобках в строке

        // a b cd

        String abcde = "abcde";
        //    System.out.println(abcde.charAt(8));


        //     String resultReplace = (str.substring(0,index)+'*'+str.substring(index+1)).toLowerCase();
        //     System.out.println(resultReplace);

        // replace method in String class  replace (old char, new char)
        String string = new String("hekko");

        System.out.println(" String after replacement of k with l: ");
        System.out.println(string.replace('k', 'l'));

        /*
        output:
        String after replacement of k with l:
        hello
         */

        System.out.println("original string is " + string);
        /*
        output
        original string is hekko
         */

        //replaceFirst method replaceFirst() replaces the part of a string with a new specified string
        System.out.println("replaces first k with l: ");
        System.out.println(string.replaceFirst("k", "l"));


     /*   IF - ОПЕРАТОР ВЕТВЛЕНИЯ.

        1) if statement
        2) if-else statement
        3) nested if statement

        4) if-else-if statement

        1) if
        В общем виде:
        if(условие) {
          Команды
          }
          Пример:
      */
        int num = 65;
        num = 165;

        if (num < 100) {
            System.out.println("number is less than 100");
        }
        /*
        output:  number is less than 100
         */
        //  Игра "Угадай букву"
     /*   char ch;
        char answer = 'A';

        System.out.println("Guess a letter between A and Z ");

        ch=(char)System.in.read();

        if(ch == answer) {
            System.out.println("You are right!!!");*/
  //  }

        /*
        Guess a letter between A and Z
        A
        You are right!!!
         */

    /*2) if - else statement

        if(condition) {
          Statements
        }
        else {
        Statements
        }
    * */
        num = 100;

        if(num<100)
    {
        System.out.println("num is less than 100");
    } else
    {
        System.out.println("num is greater than or equal 100");
    }
        /* output:
         num is greater than or equal 100*/



        // Guess a letter game - modified   Игра "Угадай букву"-2 вариант
      /*  char ch;
        char answer = 'A';

        System.out.println("Guess a letter between A and Z ");

        ch=(char)System.in.read();

        if(ch == answer) {
            System.out.println("You are right!!!");
          }
        else {
            System.out.println("You are wrong");
        }*/

        /*3) -nested if statement
         */
        num=70;
        num=30;
        if(num<100){
            System.out.println("number is less than 100");
            if(num>50){
                System.out.println("number is greater than 50");
            }
        }
        /*
        output
        number is less than 100
        number is greater than 50
         */
        //3) nested if-else statement
        int i=10;
        int a,b,c,d,j,k;
        a=0;
        j=19;
        b=9;
        k=80;
        d=900;
        c=3;

        if(i == 10){
            if(j<20)a=b;// a=9
            if(k>99)c=d;
            else a=c;//a=3 //этот else относится к if(k>99)
        }
        else a=d;//этот else относится к if(i==10)

        System.out.println("if i==10 a must be 3 . The answer is "+a);

        /* output if i==10 a must be 3 . The answer is 3*/

        //if i !=10
        i=9;

        if(i == 10){
            if(j<20)a=b;// a=9
            if(k>99)c=d;
            else a=c;//a=3 //этот else относится к if(k>99)
        }
        else a=d;//этот else относится к if(i==10)

        System.out.println("if i!=10 'a' must be 900 . The answer is "+a);
        // output: if i!=10 'a' must be 900 . The answer is 900

        // Игра "Угадай букву", третий вариант для вложенного if-else

        char ch;
        char answer = 'K';

        System.out.println("Guess a letter between A and Z ");

        ch=(char)System.in.read();

        if(ch == answer) {
            System.out.println("You are right!!!");
        }
        else {
            System.out.print("Sorry, you  ");

            //вложенный if
            if(ch < answer)
                System.out.println(" entered a letter before the secret letter");

            else
                System.out.println(" entered a letter after the secret letter");

        }
        System.out.println("Game is over");
        /* output:
        *Sorry, you are you entered a letter after the secret letter
        Game is over*/
}

    }
