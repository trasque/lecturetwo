import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Slip {
  private static int serialNo = 0;
  private static String lastUpdate = "";
  private static final int DEFAULT_BASE_SLIP_NO = 0;
  private static final String DATE_FORMAT_PATTERN = "yyyyMMdd";

  public static String genSlipNo() {
    DateTimeFormatter slipFormatt = DateTimeFormatter.ofPattern(DATE_FORMAT_PATTERN);
    LocalDateTime slipDateTime = LocalDateTime.now();
    String slipDate = slipDateTime.format(slipFormatt);

    updateCrossDay(slipDate);
    return assembleSlipNo(slipDate);
  }

  private static String assembleSlipNo(String slipDate) {
    serialNo += 1;
    return slipDate + "-" + serialNo;
  }

  private static void updateCrossDay(String slipDate) {
    if (!slipDate.equals(lastUpdate)) {
      lastUpdate = slipDate;
      serialNo = DEFAULT_BASE_SLIP_NO;
    }
  }

  // デフォルトコンストラクタを無効化し、インスタンス生成を禁止する。
  private Slip() {
  }
}
