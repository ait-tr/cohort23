public class Main {
    public static void main(String[] args) {
   //     int a,b;

   //     a = 9;
   //     b = 3;

   //     boolean result =( a == 10 || b == 10 || (a+b == 10) );
   //     System.out.println(result);

   //     a = 0;
   //     b = 10;

   //      result =( a == 10 || b == 10 || (a+b == 10) );
   //     System.out.println(result);
   //     System.out.println(a == 10 || b == 10 || (a+b == 10));

        /*
        Написать программу, определяющую является ли год високосным.
        Год является високосным если:
         1.год делится на 4 и год не делится на 100
         2.год делится на 4 и год делится на 100 и год делится на 400




         */
      //  System.out.println("result= "+a+"kjhkbbob");

        int year;
        year = 0;
    //    System.out.println(year);



        boolean a1 = (year%4)==0;//true
        boolean b1 = (year%100) != 0;//true
        boolean c1 = (year%100 == 0) && (year%400 == 0);

    //    System.out.println(year + " year is a leap year: "+(a1 && (b1 || c1)));

        System.out.println(1900%400 == 0);

        /*
        1. a | (b&c) = (a|b)&(a|c)
        2. a & (b|c) = (a&b)|(a&c)
        3. !(a|b) = !a & !b
        4. !(a&b) = !a | !b

        !(a|b) = !a & !b
        a=true
        b=true
        !(true|true)==!true & !true
        a=true
        b=false
       ! (true|false) == false & true
       false ==false

       a=false
       b=false
       true =
         */

        boolean a,b,c;
        a=b=c=true;

        System.out.println(!(a|b) == (!a & !b));

    //    System.out.println(true==true);
    //    System.out.println(false==false);

        int num = 45;
        var num1 = 45;
        var num2 = 49.0;

        int var = 67;












    }
}