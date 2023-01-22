public class Main {

    public static void main(String[] args) {

        String name = "Evgeny";
        name = "Maria";
        System.out.println("Hello "+name);

        String a = "Hi";
        String b = "Bye";
      //  HiByeByeHi

     //   System.out.println(a+b+b+a);


    //    System.out.println("Hello world!");
        int x = 424345;
    //    x = Integer.MAX_VALUE+1;
    //    System.out.println(x);
        x = Integer.MIN_VALUE;
    //    System.out.println(x);
        System.out.println(x);
        byte bt =100;
        short sh = 20020;
        long l = 1567567999;
        float f = 1.23f;
        double d = 3.135678990;
        l=bt;
        System.out.println(sh+d);

        //987654.321
        // 0.987654321 *10 power 6
        //90 = 9*10
        //90000 = 0.9*10*10*10*10*10

   /*     int i = 1000;
        float f1 = 108.0f;

        long l1 = i;
        double d1= f1;

        System.out.println("int value: "+i);//prints 1000
        System.out.println("int to long: "+l1);//prints 1000
        System.out.println("float value: "+f1);//108.0
        System.out.println("float to double: "+d1);//108.0

    */

        double d1 = 4.99;
        float f1 = 1.99f;

        int i =(int)d1;
        int i2 =(int) f1;

        System.out.println("Double value: "+d1);//prints 4.55
        System.out.println("Double to int "+i);// prints ?
        System.out.println("Float value: "+f1);//1.45
        System.out.println("Float to int: "+i2);//?

        // ----------------------------Operators-----------------
        //Arithmetic operators
        /*
        +(Addition)  z=x+y
        -(Subtraction) z=x-y
        * (Multiplication) z=x*y
        / (Division) z=x/y
        % (Division with remainder) z=x%y
         */
        int num1 = 10;
        int num2 = 3;

        System.out.println("num1+num2: "+ (num1 + num2));
        System.out.println("num1-num2: "+ (num1 - num2));
        System.out.println("num1*num2: "+ (num1 * num2));
        System.out.println("num1/num2: "+ (num1 / num2));
        System.out.println("num1%num2: "+ (num1 % num2));

     //   double res = num1/num2;
        double res = (double)num1/num2;
        System.out.println("num1/num2= "+res);
        System.out.println(10/3);
        System.out.println(10.0/3);


        //Assignment operators
        /*
        =     num = 5                 num = 5
        +=    num+=3                  num = num + 3
        -=    num-=3                  num = num - 3
        *=    num*=3                  num = num * 3
        /=    num/=3                  num = num / 3
        %=    num%=3                  num = num % 3
         */
        int num3 =5;
        System.out.println("= Output "+num3);
        num3+=3;
        System.out.println("= Output "+num3);
        num3-=3;
        System.out.println("= Output "+num3);
        num3*=3;
        System.out.println("= Output "+num3);
        num3/=3;
        System.out.println("= Output "+num3);
        num3%=3;
        System.out.println("= Output "+num3);

        String str = "abc";
        //5-3
    }
}