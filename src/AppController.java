import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppController {
  private AppController() {
  }

  public static void appStartPoint() {
    mainMenu();
  }

  private static boolean mainMenu() {
    List<Order> orderList = new ArrayList<>();
    Scanner mainMenuScanner = new Scanner(System.in);
    int mainMenuNumber = 1;
    boolean mainMenuStatus = true;

    while(mainMenuNumber != 0) {
      System.out.println("\n[[メインメニュー]]");
      System.out.println("1. 受注データ読み込み");
      System.out.println("2. 受注件数表示");
      System.out.println("3. 受注情報入力（個別）");
      System.out.println("4. 受注情報表示（全て）");
      System.out.println("5. 発送（個別）");
      System.out.println("6. 発送（全て）");
      System.out.println("0. 終了");
      System.out.print("◆受注プログラム機能を選択 > ");
      mainMenuNumber = mainMenuScanner.nextInt();

      switch(mainMenuNumber) {
        case 1 -> {
          orderList = OrderList.generateOrderList();
          System.out.println("  受注リストを" + orderList.size() + "件よみこみました");
        }
        case 2 -> {
          System.out.println("  受注リストは" + orderList.size() + "件です");
        }
        default -> {
          mainMenuNumber = 0;
        }
      }
    }

    if (mainMenuNumber == 0) mainMenuStatus = true;
    else mainMenuStatus = false;
    return mainMenuStatus;
  }
}
