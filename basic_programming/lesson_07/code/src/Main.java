import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char ch;
        ch = 'X';
        System.out.println("This is ch "+ch);

        ch = 'A';
        System.out.println("ch now contains "+ch);

        ch++;

        System.out.println("ch is now "+ch);

        ch = 90;
        System.out.println("90 in Unicode is "+ch);

        int letter = 'Z';
        System.out.println("letter is now "+letter);
        String z =" this word \\ is in quotes ";
        System.out.println(z);
        System.out.print("this is a line\n\n");
        System.out.print("this is another line\n");
     //   System.out.print("this is \nanother line");
    //    System.out.print("this\tis\tanother\tline");

        /*
        Вывод специальных символов

        \' -  одиночная кавычка
        \" - двойная кавычка
        \\ - обратный слеш
        \n - новая строка
        \t -табуляция
        \ uxxxx - символ юникода
         */
        char symbol ='\"';
        char newLine = '\n';
        System.out.print("this is a line"+newLine);
        System.out.print("this is another line"+newLine);

        System.out.println('\u1234');

        String str = "string1";
        System.out.println(str);

        str="string2";
        System.out.println(str);

        str = "sqwertz";
        System.out.println(str);

        int x=1;
        System.out.println(x);

        x = 3;
        System.out.println(x);

        System.out.println("\"Hello World\"");

        char unicode ='\u5555';
        System.out.println('\u5555');

        int int1 = 45;
        Scanner sc = new Scanner(System.in);

        String string = "String";

        int a = 2;
        System.out.println(a);

        a=a+5;

        String str1="In Java Strings are objects";

        int b =0;
        String space =" ";

        space="";
        space=null;

        String space1;





        /*
abstract
assert
boolean
break
byte
case
catch
char
class
const
continue
default
do
double
else
enum
extends
final
finally
float
for
goto
if
implements
import
instanceof
int
interface
long
native
new
package
private
protected
public
return
short
static
strictfp
super
switch
synchronized
this
throw
throws
transient
try
void
volatile
while
var
true
null
false*/





    }
}