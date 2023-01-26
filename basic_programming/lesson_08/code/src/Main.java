import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)throws IOException {

        int a = 5;
        String str = "";
        Scanner sc = new Scanner(System.in);

    //    Car mercedes = new Car("red","GLS",2020);
    //    Car volvo =new Car ("blue","XC90",2022);
        //volvo="red","GLS"
        // mercedes1 = mercedes
        //mersedes = null





        // Ввод символа с экрана
        // сканнер не умеет обрабатывать отдельные символы.
        // Он воспринимает их как строки
        // 'Z'-символ
        // "Z"-строка
        char ch;
      //  System.out.println("Press a key followed by ENTER: ");
   //     ch = (char)System.in.read();

    //    System.out.println("Press a key followed by ENTER:" );
    //    int code =System.in.read();



     //   System.out.println("you entered "+ch);
    //    System.out.println("you entered char with ASCII code "+code);

        //  Классы, обьекты, литералы

      long num =  100L;
      String str1 = "String";

      int x = 5;
      int y = x;

      x=8;

      String str13 = "new string";
      String usingNew = new String("new string");

      String newStr1;

      String emptyLiteral = "";
      String emptyNewString =  new String("");

        System.out.println("empty string is "+emptyLiteral);
        System.out.println("empty new string is"+ emptyNewString);

        String nullValue = null;
        System.out.println("nullValue value is "+nullValue);


        String str2 = "Evgeny";
        String str3 = "Evgeny";
        System.out.println("str2=str3? "+(str2==str3));

        String str4 = "Evgeny";

        System.out.println("str2=str4? "+(str2==str4));

        String str5 = new String("Evgeny");
        System.out.println("str2=str5? "+(str2==str5));

        String str6 = new String("Evgeny");
        System.out.println(str5==str6);

        String s1 = "Cat";
        String s2 = "Cat";
        String s3 = new String("Cat");
        s3 = "Dog";

        s1 = s1 +" Dog";
        String s5 =s3;

        //Методы строк

      String cat = "Cat";
    //  String cat = " good Cat";

        // Cat
        // C -0
        // a -1
        // t -2

      //1.метод length()
      int catLength = cat.length();
      System.out.println("cat length is "+ catLength);


      //метод charAt
      char charAtCatIndex = cat.charAt(0);
      System.out.println("char at position 0 is "+charAtCatIndex);

      char charAtCatIndex1 = cat.charAt(1);
      System.out.println("char at position 1 is "+charAtCatIndex1);

      char charAtCatIndex2 = cat.charAt(2);
      System.out.println("char at position 2 is "+charAtCatIndex2);

   //   char charAtCatIndex3 = cat.charAt(3);
   //   System.out.println("char at position 3 is "+charAtCatIndex3);

      //метод substring
      String goodCat = "good Cat";
      //g 0
      //o 1
      //o 2
      //d 3
      //  4
      //C 5
      //a 6
      //t 7
     String substrCat= goodCat.substring(5);
      System.out.println("substring cat from 5 index is "+substrCat);
      System.out.println("goodCat is "+goodCat);

      String substrGood = goodCat.substring(0,4);
      System.out.println("substring good is "+substrGood);

      /*
      cat length is 3
char at position 0 is C
char at position 1 is a
char at position 2 is t
substring cat from 5 index is Cat
goodCat is good Cat
substring good is good
       */









    }
}