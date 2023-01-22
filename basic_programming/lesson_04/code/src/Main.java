public class Main {
    public static void main(String[] args) {

        int a = 25;
        int b = 3;
        double erg = (double)a/b;
        System.out.println(25.0/3);
        System.out.println(25%3);
        System.out.println(erg);
     //   double double

        int num = 8;
        System.out.println(num*num);

        /*
        Дано трехзначное число.
        1.Вывести на экран все цифры этого числа.
        2. Получить новое число, образованное перестановкой единиц и сотен
        365 -> 3,6,5 ,  365->563
        3*100 +6*10+5*1 = 365
        ones = 365%10 =5
        tens = 365/10%10=6
        hundreds =365/10/10=3

         */
   //     System.out.println(365%10);
        int n = 365;

        int ones,tens,hundreds;

        ones = n % 10;
        tens = n / 10 % 10;
        hundreds = n / 10 /10;

        int reversed = ones*100 + tens*10 + hundreds;

        System.out.println("Digits of "+n+" are:"+hundreds+"-"+tens+"-"+ones);
        System.out.println(n+" reversed is "+reversed);
        //__________________________________________________________
        // Задача 2.  В банкомате есть банкноты 1,5,10 долларов
        // Посчитать минимальное количество банкнот, которое нужно для выдачи суммы n

        int banknotes =49;

        int tens1 = banknotes / 10;
        int fives1 = banknotes % 10 / 5;
        int ones1 = banknotes % 10 % 5;
        // int ones1 = banknotes % 5;

        System.out.println(tens1+fives1+ones1);
        int y;
        int x=10;
    //    x++;
     //   ++x;
      //  y=++x;
      //    y=x++;
      //    y=x--;
        //  y=--x;
          y=x--;
        System.out.println("y="+y);
        System.out.println("x="+x);
    //    x = x+1;
    //    x=x-1;
   //     x++;
    //    x--;
    //    ++x;
    //    --x;

        //Type boolean
        /*
        true, false

        Relational Operators

        Operator                Meaning
        ==                      Equal to
        !=                      Not Equal to
        >                       Greater than
        <                       Less than
        >=                      Greater than or equal to
        <=                      Less than or equal to


        Logical operators

        Operator                Meaning

        &                       AND
        |                       OR
        !                       NOT
        ^                       XOR ( exclusive OR )
        &&
        ||


         */

        System.out.println(11>10);




        boolean b1 = false;
        boolean b2 = false;
        System.out.println("for b1 " +b1+"and b2 "+b2+":");
        System.out.println("b1 & b2: "+(b1&b2));//false
        System.out.println("b1 | b2: "+(b1|b2));//false
        System.out.println("b1 ^ b2: "+(b1^b2));//false
        System.out.println("!b1: "+(!b1));//true

        b1 = true;
        b2 = false;
        System.out.println("for b1 " +b1+" and b2 "+b2+":");
        System.out.println("b1 & b2: "+(b1&b2));//false
        System.out.println("b1 | b2: "+(b1|b2));//true
        System.out.println("b1 ^ b2: "+(b1^b2));//true
        System.out.println("!b1: "+(!b1));//false

        System.out.println();
        b1 = false;
        b2 = true;
        System.out.println("for b1 " +b1+" and b2 "+b2+":");
        System.out.println("b1 & b2: "+(b1&b2));//false
        System.out.println("b1 | b2: "+(b1|b2));//true
        System.out.println("b1 ^ b2: "+(b1^b2));//true
        System.out.println("!b1: "+(!b1));//true

        System.out.println();
        b1 = true;
        b2 = true;
        System.out.println("for b1 " +b1+" and b2 "+b2+":");
        System.out.println("b1 & b2: "+(b1&b2));//true
        System.out.println("b1 | b2: "+(b1|b2));//true
        System.out.println("b1 ^ b2: "+(b1^b2));//false
        System.out.println("!b1: "+(!b1));//false

        int a1 =10;
        int b22 = 2;
        if(a1>b22)
            System.out.println("a1>b22");
     //   System.out.println(2/0);

        int num12 = 10;
        int d = 2;
        d=0;

        if(d != 0 && (num12%d)==0)
            System.out.println("it can be divided without remainder");

        if(d != 0 & (num12%d)==0)
            System.out.println("it can be divided without remainder");

    }
}