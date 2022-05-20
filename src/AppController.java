import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppController {
  private static List<Order> orderList = new ArrayList<>();
  private AppController() {
  }

  public static boolean mainMenu() {
    Scanner mainMenuScanner = new Scanner(System.in);
    int mainMenuNumber = 1;
    boolean mainMenuStatus = true;

    while (mainMenuNumber != 0) {
      System.out.println("\n[[メインメニュー]]");
      System.out.println("1. 受注データ読み込み");
      System.out.println("2. 受注件数表示");
      System.out.println("3. 受注情報入力（個別）");
      System.out.println("4. 受注情報表示（全て）");
      System.out.println("5. 発送（個別）");
      System.out.println("6. 発送（全て）");
      System.out.println("0. 終了");
      System.out.print(">> 受注プログラム機能を選択 -> ");
      mainMenuNumber = mainMenuScanner.nextInt();

      switch (mainMenuNumber) {
        case 1 -> {
          orderList = OrderList.generateOrderList();
          System.out.println("  受注リストを" + orderList.size() + "件よみこみました");
        }
        case 2 -> {
          System.out.println("  受注リストは" + orderList.size() + "件です");
        }
        case 3 -> {
          orderInput();
        }
        case 4 -> {
          displayInfoAll();
        }
        case 5 -> {
          shipment();
        }
        case 6 -> {
          for (Order shippingItem: orderList) {
            shippingItem.ship();
          }
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

  private static void orderInput() {
    Scanner orderInputScanner = new Scanner(System.in);
    int itemNo = 0;
    System.out.print(">> 入力したい品物の番号 -> ");
    itemNo = orderInputScanner.nextInt();
    orderList.get(itemNo).setOrderInfo();
  }

  private static void displayInfoAll() {
    int counter = 0;
    for (Order info: orderList) {
      System.out.print(counter + "]");
      info.displayInfo();
      counter++;
    }
  }

  private static void shipment() {
    Scanner shipmentScanner = new Scanner(System.in);
    int itemNo = 0;
    System.out.print(">> 発送したい品物の番号 -> ");
    itemNo = shipmentScanner.nextInt();
    orderList.get(itemNo).ship();
  }
}
