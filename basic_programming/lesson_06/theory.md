Для получения ввода с консоли  используют класс Scanner. В качестве иллюстрации напишем  программу, которая осуществляет ввод чисел:

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
           
        Scanner in = new Scanner(System.in);
        System.out.print("Input a number: ");
        int num = in.nextInt();
          
        System.out.print("Your number: "+ num);
        in.close();
    }
}
Так как класс Scanner находится в пакете java.util, то мы вначале его импортируем с помощью инструкции import java.util.Scanner.

Для создания самого объекта Scanner в его конструктор передается объект System.in. После этого мы можем получать вводимые значения. Например, в данном случае вначале выводим приглашение к вводу и затем получаем вводимое число в переменную num.

Чтобы получить введенное число, используется метод in.nextInt();, который возвращает введенное с клавиатуры целочисленное значение.