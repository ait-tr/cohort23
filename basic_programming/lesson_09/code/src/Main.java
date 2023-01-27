import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        // homework
        String str1 = "Hello";
        String str2 = "There";

        String substr1 = str1.substring(1);
        String substr2 = str2.substring(1);
        String result = substr1+substr2;
        System.out.println(result);

        // length
    //    int length =str1.length();

        //charAt
        str1 = "Hello";
    //    H -0
    //    e -1
    //    l -2
    //    l -3
    //    0 -4

        int length = str1.length();

        System.out.println("First character: "+str1.charAt(0));
        System.out.println("Last character: "+str1.charAt(length-1));


        //substring
        //Hello

        System.out.println(str1.substring(1,4));

        // метод printf

        // Rules start with %

        System.out.printf("Hello %s!%n ","World");

        // в общем виде:
        // %[flags][width][.precision]conversuion-characters
        //основные символы:
        //s - форматирует строки
        //c -форматирует символы
        //d - форматирует целые числа
        //f - форматирует числа с запятой
        //e - научное представление числа
        //t - форматирует дату время

        //форматирование строк с помощью %s
      //  System.out.printf("hello%nworld");

        System.out.printf("'%s'%n","Hello");
        System.out.printf("'%S'%n","Hello");

        // форматирование строк с использованием width
        System.out.printf("'%10s' %n","Hello");

        // flag for strings
        System.out.printf("'%-10s' %n","Hello");

        /*
        output:
        'Hello'
'HELLO'
'     Hello'
'Hello     '
         */

     //   System.out.printf("%-15.2s","Hello");
        // output He

        // %[flags][width][.precision]conversuion-characters
     //   System.out.printf("%-15.3s","Hello");
        //output   Hel


        // Char formatting %c

        System.out.printf("%c%n",'a');
        System.out.printf("%C%n",'a');
        System.out.printf("%c%n",'A');
        /*
        output:
        a
        A
        A
         */

        //Number formatting
        // Integer formatting: %d

        System.out.printf("integer: %d%n",10000);

        System.out.printf(Locale.US,"%,d %n",10000);
        System.out.printf(Locale.GERMANY,"%,d %n",100000);

        /*
        output
        integer: 10000
        10,000
        100.000
         */

        //Float and double formatting %f

        System.out.printf("%f%n",5.9876);

        // with precision ( с округлением)
        System.out.printf("'%5.2f'%n",5.9876);

        /* output:
        5.987600
        ' 5.99'
         */

        //scientific %e

        System.out.printf("'%5.2e'%n",5.9876);

        /* output
        '5.99e+00'

        * */

        //________________________________________________________

        // More Strings methods

        //method equals()

        String name = "Evgeny";
    //    String b = "asdf";
        String name1 = new String("Evgeny");

     boolean equals= name.equals(name1);

        System.out.println("comparison with equals: "+equals);
        System.out.println("comparison with ==: "+(name==name1));
        /*
        output:
        comparison with equals: true
        comparison with ==: false
         */
        String string = "Hello";
        String string1= "hello";

        System.out.println(string.equals(string1));
        System.out.println(string.equalsIgnoreCase(string1));//equals ignore case

        /*
        output
        false
        true
         */


       // a==b;

        //toUpperCase() method

        String string2 = new String("this is a new string");
        System.out.println("we convert all letters in the string to upper case: "+string2.toUpperCase());
        /*
        output:
        we convert all letters in the string to upper case: THIS IS A NEW STRING
         */

        String string3 = new String("ThIs iS a New striNg");
        System.out.println(string3.toUpperCase());
        /*
        THIS IS A NEW STRING
         */

        //to lower case method
        string3 = new String("THIS IS A NEW STRING");
        System.out.println("to lower case: "+string3.toLowerCase());
        /*
        to lower case: this is a new string
         */

        //startsWith() - этот метод проверяет начинается ли строка с указанного префикса
        // и если да возвращает true  если нет false

        String string4 = "Hello";
        boolean startsWith =string4.startsWith("He");
        System.out.println("the word " +string4+" starts with: "+startsWith);

        startsWith =string4.startsWith("Pe");
        System.out.println("the word " +string4+" starts with: "+startsWith);

        /*
        the word Hello starts with: true
        the word Hello starts with: false
         */

        //method valueOf()

        int number = 99;
     //  int test= String.valueOf(number);
        String test = String.valueOf(number);


        // indexOf - находит индекс первого вхождения заданного символа в строке

        String string5 = "tih is is a string";
        System.out.println("Index of h in the string is: "+string5.indexOf('h') );
        System.out.println("Index of s in the string is: "+string5.indexOf('s') );
        System.out.println("Index of z in the string is: "+string5.indexOf('z') );
        System.out.println("Index of 'is' in the string is: "+string5.indexOf("is"));
        System.out.println("Index of 'i' in the string is: "+string5.indexOf("i"));
        System.out.println("Index of 'is' in the string is: "+string5.indexOf(" is "));
        System.out.println("Index of ' ' in the string is: "+string5.indexOf(" "));

        int index = string5.indexOf('s');

        /*
        Index of h in the string is: 2
        Index of s in the string is: 4
        Index of z in the string is: -1
        Index of 'is' in the string is: 3
        Index of 'is' in the string is: 5

         */















    }
}