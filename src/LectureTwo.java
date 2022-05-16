import java.util.ArrayList;
import java.util.List;

public class LectureTwo {
  public static void main(String[] args) {
    // 1) 引数なしでインスタンスを生成
    //    すべて初期値が出力される
    System.out.println("=====[例1]=====");
    System.out.println("[引数なしで生成→すべて初期値で出力]");
    Order mikan = new Order();
    mikan.displayInfo();

    // 2) goods と quantity を生成時に指定する
    //    calcFare() を実行してみる
    //    不足している値をsetterで指定する
    //    改めてcalcFare() を実行してみる
    System.out.println("\n=====[例2]=====");
    System.out.println("[一部引数を指定し、運賃メソッドを使う]");
    System.out.println("[不足した設定値で計算]");
    Order suika = new Order("すいか", 5);
    suika.calcFare();
    System.out.println("[単価を100円にして計算]");
    suika.setUnitPrice(100);
    suika.calcFare();

    // 3) 住所以外を設定して発送可能かを表示する
    System.out.println("\n=====[例3]=====");
    System.out.println("[住所以外を指定し、発送可能かを調べる]");
    Order negi = new Order("ねぎ", 8, 80);
    negi.displayInfo();
    System.out.println("発送可能？：" + negi.canShipped());
    System.out.println("[発送を試みる]");
    negi.ship();

    // 4) 住所などを十分埋めて発送処理をする
    System.out.println("\n=====[例4]=====");
    System.out.println("[ねぎの住所を入れて発送する]");
    negi.setAddress("千葉県");
    negi.ship();
    System.out.println("[ねぎの情報を表示]");
    negi.displayInfo();

    // 5) 複数の品目をリストにし、一気に表示する
    System.out.println("\n=====[例5]=====");
    System.out.println("[複数の品目をリストにする]");
    System.out.println("[みかん、すいか、トマト、かに]");
    System.out.println("[現在の状態を列挙する]");
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

    // 6) 必要な情報を埋めて、一気に発送する
    System.out.println("\n=====[例6]=====");
    System.out.println("[必要な情報を埋めて、一気に発送する]");
    container.get(0).setGoods("みかん");
    container.get(0).setQuantity(25);
    container.get(0).setUnitPrice(30);
    container.get(0).setAddress("沖縄県");
    container.get(1).setAddress("東京都");
    System.out.println("[内容確認]");
    for (Order sinamono : container) {
      System.out.println("◆◆◆◆");
      sinamono.displayInfo();
      System.out.println("発送可能？：" + sinamono.canShipped());
    }
    System.out.println("[全て発送可能なので、一気に発送する]");
    for (Order sinamono : container) {
      sinamono.ship();
    }

  }
}