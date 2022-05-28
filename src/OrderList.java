import java.util.ArrayList;
import java.util.List;

public class OrderList {
  private static List<Order> tabemonoOrderList = new ArrayList<>();

  private OrderList() {
  }

  public static List<Order> generateOrderList() {
    tabemonoOrderList.add(Order.newOrderWithDefaultValue());          //"みかん", 30, 80, "和歌山"
    tabemonoOrderList.add(new Order("すいか"));                 //7, 400, "熊本"
    tabemonoOrderList.add(new Order("ねぎ", 15));               //130, "千葉"
    tabemonoOrderList.add(new Order("かに", 3, 890, "北海道"));
    return tabemonoOrderList;
  }
}
