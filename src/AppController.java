import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppController {
  private static List<Order> orderList = new ArrayList<>();
  private AppController() {
  }

  public static void mainMenu() {
    Scanner mainMenuScanner = new Scanner(System.in);
    boolean isProcessing = true;
    while (isProcessing) {
      System.out.println("\n[[メインメニュー]]");
      System.out.println("1. データ読込 / 2. 件数表示 / 3. 情報入力 / 4. 情報一覧 / 5. 個別発送 / 6. 一括発送 / 0. 終了");
      System.out.print(">> 受注プログラム機能を選択 -> ");
      int mainMenuNumber = mainMenuScanner.nextInt();

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
        case 0 -> {
          isProcessing = false;
        }
        default -> {
          // do nothing. back to menu
        }
      }
    }
  }

  private static void orderInput() {
    Scanner orderInputScanner = new Scanner(System.in);
    System.out.print(">> 入力したい品物の番号 -> ");
    int itemNo = orderInputScanner.nextInt();
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
    System.out.print(">> 発送したい品物の番号 -> ");
    int itemNo  = shipmentScanner.nextInt();
    orderList.get(itemNo).ship();
  }
}
