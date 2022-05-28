import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ship {
  private Ship() {
  }
  
  private static int serialNo = 0;
  private static String lastUpdate = "";
  private static final int DEFAULT_BASE_SHIP_NO = 0;
  private static final String DATE_FORMAT_PATTERN = "yyyyMMdd";

  public static String genShipNo() {
    DateTimeFormatter shipFormat = DateTimeFormatter.ofPattern(DATE_FORMAT_PATTERN);
    LocalDateTime shipDateTime = LocalDateTime.now();
    String shipDate = shipDateTime.format(shipFormat);

    updateCrossDay(shipDate);
    return assembleShipNo(shipDate);
  }

  private static String assembleShipNo(String shipDate) {
    serialNo += 1;
    return shipDate + "-" + serialNo;
  }

  private static void updateCrossDay(String shipDate) {
    if (!shipDate.equals(lastUpdate)) {
      lastUpdate = shipDate;
      serialNo = DEFAULT_BASE_SHIP_NO;
    }
  }
}
