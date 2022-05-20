import java.util.ArrayList;
import java.util.List;

public class LectureTwo {
  public static void main(String[] args) {
    Order mikan = new Order();
    Order saba = new Order("さば", 10, 120, "千葉");

    Fare tokyo = new Fare(1.1, "東京", 200);
    Fare hokkaido = new Fare(1.1, "北海道", 800);

    System.out.println("◆◆みかん◆◆");
    mikan.ship();
    tokyo.calcFare(mikan);

    System.out.println("◆◆さば◆◆");
    saba.ship();
    hokkaido.calcFare(saba);
    saba.ship();
  }
}