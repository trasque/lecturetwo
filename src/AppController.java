import java.util.Scanner;

public class AppController {
  private AppController() {
  }

  public static void appStartPoint() {
    mainMenu();
  }

  private static int mainMenu() {
    Scanner mainMenuScanner = new Scanner(System.in);
    int mainMenuNumber;

    System.out.println("[[メインメニュー]]");
    System.out.println("1. 受注データ読み込み");
    System.out.println("2. 受注件数表示");
    System.out.println("3. 受注情報入力（個別）");
    System.out.println("4. 受注情報表示（全て）");
    System.out.println("5. 発送（個別）");
    System.out.println("6. 発送（全て）");
    System.out.print("◆受注プログラム機能を選択 > ");
    mainMenuNumber = mainMenuScanner.nextInt();

    return mainMenuNumber;
  }
}
