public class Main {
  public static void main(String[] args) {
    System.out.println("Welcome!");

    int buttonNumber = 5;
    // Кнопка 1 => "Take your Cola"
    // Кнопка 2 => "Take your Fanta"
    // Кнопка 3 => "Take your SevenUp"
    // Кнопка 4 => "Take your Snickers"
    // Кнопка 5 => "Take your Twix"
    // Кнопка 6 => "Take your Baunty"
    // если другая кнопка  => "Error 806"
    switch (buttonNumber) {
      case 1:
        System.out.println("Take your Cola");
        break;
      case 2:
        System.out.println("Take your Fanta");
        break;
      case 3:
        System.out.println("Take your SevenUp");
        break;
      case 4:
        System.out.println("Take your Snickers");
        break;
      case 5:
        System.out.println("Take your Twix");
        break;
      case 6:
        System.out.println("Take your Baunty");
        break;
      default:
        System.out.println("Error 806");
        break;


    }
    System.out.println("Have a good day!");
  }
}
