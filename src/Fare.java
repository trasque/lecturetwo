import java.math.BigDecimal;
import java.math.RoundingMode;  //BigDecimal.HALF_UP は @Deprecated となっているためこちらを使う

public class Fare {
  // 配送料 = (配送エリア料金 * 個数 + 品物単価) * 消費税
  private BigDecimal consumptionTax;
  private String deliveryArea;  //将来的に配送エリアクラスから引っ張って farePerLoad を設定するようにする
  private int farePerLoad;      //エリアクラスができるまでは引数を使わず固定値で設定

  public Fare(double consumptionTax, String deliveryArea, int farePerLoad) {
    this.consumptionTax = BigDecimal.valueOf(consumptionTax);
    this.deliveryArea = deliveryArea;
    this.farePerLoad = 201;
  } 

  public Order calculateFare(Order order) {
    if (!validateOrder(order)) {
      order.setLoadFare(BigDecimal.valueOf(0));
      return order;
    }

    BigDecimal result = consumptionTax.multiply(
                        BigDecimal.valueOf(
                        (this.farePerLoad * order.getQuantity() + order.getUnitPrice())));
    order.setLoadFare(result.setScale(0, RoundingMode.HALF_UP));
    return order;
  }

  private boolean validateOrder(Order order) {
    if(!validateInitial(order)) return false;
    if(!validateNegative(order)) return false;
    return true;
  }

  private boolean validateInitial(Order order) {
    if(order.getQuantity() == 0) {
      System.out.println("数量が設定されていません");
      return false;
    }
    if(order.getUnitPrice() == 0) {
      System.out.println("単価が設定されていません");
      return false;
    }
    return true;
  }

  private boolean validateNegative(Order order) {
    if(order.getQuantity() < 0) {
      System.out.println("数量は負の数にできません");
      return false;
    }
    if(order.getUnitPrice() < 0) {
      System.out.println("単価は負の数にできません");
      return false;
    }
    return true;
  }
}
