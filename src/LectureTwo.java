import java.util.ArrayList;
import java.util.List;

public class LectureTwo {
  public static void main(String[] args) {
    ex1();
    Order mikan = new Order();
    mikan.displayInfo();

    ex2();
    Order suika = new Order("すいか", 5);
    suika.calcFare();
    suika.setUnitPrice(100);
    suika.calcFare();

    ex3();
    Order negi = new Order("ねぎ", 8, 80);
    negi.displayInfo();
    System.out.println("発送可能？：" + negi.canShipped());  // あとで分割したい
    negi.ship();
    negi.getSlipNo();

    ex4();
    negi.setAddress("千葉県");
    negi.ship();
    negi.displayInfo();
    System.out.println("発送した時の伝票番号は" + negi.getSlipNo());  //あとで分割したい

    ex5();
    List<Order> container = new ArrayList<Order>();
    container.add(mikan);
    container.add(suika);
    Order tomato = new Order("トマト", 20, 60, "埼玉県");
    Order kani = new Order("かに", 3, 800, "栃木県");
    container.add(tomato);
    container.add(kani);
    for (Order sinamono : container) {
      System.out.println("◆◆◆◆");
      sinamono.displayInfo();
      System.out.println("発送可能？：" + sinamono.canShipped());
    }

    ex6();
    container.get(0).setGoods("みかん");
    container.get(0).setQuantity(25);
    container.get(0).setUnitPrice(30);
    container.get(0).setAddress("沖縄県");
    container.get(1).setAddress("東京都");
    for (Order sinamono : container) {
      System.out.println("◆◆◆◆");
      sinamono.displayInfo();
      System.out.println("発送可能？：" + sinamono.canShipped());
    }
    for (Order sinamono : container) {
      sinamono.ship();
    }

  }

  private static void ex1() {
    System.out.println("=====[例1]=====");
    System.out.println("= 引数なしで生成");
    System.out.println("= 全て初期値で出力される");
    System.out.println("===============");
  }

  private static void ex2() {
    System.out.println("\n=====[例2]=====");
    System.out.println("= 一部引数を指定し、運賃メソッドを使う");
    System.out.println("= 不足した設定値で計算 → 計算失敗");
    System.out.println("= 単価を設定して再計算");
    System.out.println("===============");
  }

  private static void ex3() {
    System.out.println("\n=====[例3]=====");
    System.out.println("= 住所以外を指定し、発送可能かを調べる");
    System.out.println("= 発送を試みる → 情報が不足で失敗");
    System.out.println("= 未発送の状態で伝票番号を読み取ろうとする → 伝票番号未発行が表示");
    System.out.println("===============");

  }

  private static void ex4() {
    System.out.println("\n=====[例4]=====");
    System.out.println("= ねぎの住所を入れて発送する");
    System.out.println("= ねぎの情報を表示");
    System.out.println("===============");
  }

  private static void ex5() {
    // 5) 複数の品目をリストにし、一気に表示する
    System.out.println("\n=====[例5]=====");
    System.out.println("= 複数の品目をリストにする");
    System.out.println("= みかん、すいか、トマト、かに");
    System.out.println("= 現在の状態を列挙する");
    System.out.println("===============");
  }

  private static void ex6() {
    // 6) 必要な情報を埋めて、一気に発送する
    System.out.println("\n=====[例6]=====");
    System.out.println("= 必要な情報を埋める");
    System.out.println("= すべての内容を確認する");
    System.out.println("= 全て発送可能なので、一気に発送する");
    System.out.println("===============");
  }
}