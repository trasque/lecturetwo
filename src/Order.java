public class Order {
  //::::::::::
  //  受注クラス
  //    メンバ変数（コンストラクタ初期値）
  //      伝票No  : static int slip    : 0 (static)
  //      商品    : String goods       : "none"
  //      数量    : int    quantity    : 0
  //      単価    : int    unitPrice   : 0
  //      発送先  : String address     : "none"
  //      発送伝票: int slipNo         : 0
  //    コンストラクタ
  //      引数なし: 全てのメンバを初期値とする（slip/slipNo 以外）
  //      引数の順は以下の通りとし、足りない分は初期値（slip/slipNo以外）
  //        1) goods
  //        2) quantity
  //        3) unitPrice
  //        4) address
  //    メソッド
  //      getter/setter : それぞれ用意
  //      displayInfo   : 現在設定されている内容をきれいに表示する
  //      calcFare      : 運賃を表示 quantity と unitPrice が初期値でなければ掛け算して返す
  //      canShipped    : slip/slipNo以外のメンバ変数に初期値がなければ true
  //      ship          : canShipped が true なら slip++ し slipNo に記録後「発送しました」と slipNo を出す
  //                      canShipped が false なら「発送情報が足りません」として終わる
  //::::::::::

  private static int slip = 0;
  private String goods;
  private int quantity;
  private int unitPrice;
  private String address;
  private int slipNo;

  public Order() {
    this("none", 0, 0, "none");
  }

  public Order(String goods) {
    this(goods, 0, 0, "none");
  }

  public Order(String goods, int quantity) {
    this(goods, quantity, 0, "none");
  }

  public Order(String goods, int quantity, int unitPrice) {
    this(goods, quantity, unitPrice, "none");
  }

  public Order(String goods, int quantity, int unitPrice, String address) {
    this.goods = goods;
    this.quantity = quantity;
    this.unitPrice = unitPrice;
    this.address = address;
    this.slipNo = 0;
  }

  public String getGoods() {
    return this.goods;
  }

  public int getQuantity() {
    return this.quantity;
  }

  public int getUnitPrice() {
    return this.unitPrice;
  }

  public String getAddress() {
    return this.address;
  }

  public int getSlipNo() {
    if (this.slipNo == 0) {
      System.out.println("発送されていません");
      return 0;
    } else {
      return this.slipNo;
    }
  }

  public void setGoods(String goods) {
    this.goods = goods;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public void setUnitPrice(int unitPrice) {
    this.unitPrice = unitPrice;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  // 設定されている情報を整理して出す
  public void displayInfo() {
    if (this.goods.equals("none")) {
      System.out.println("品名：設定なし");
    } else {
      System.out.println("品名：" + this.goods);
    }

    if (this.quantity == 0) {
      System.out.println("数量：設定なし");
    } else {
      System.out.println("数量：" + this.quantity);
    }

    if (this.unitPrice == 0) {
      System.out.println("単価：設定なし");
    } else {
      System.out.println("単価：" + this.unitPrice);
    }

    if (this.address.equals("none")) {
      System.out.println("住所：設定なし");
    } else {
      System.out.println("住所：" + this.address);
    }

    if (this.slipNo == 0) {
      System.out.println("伝票：未発行");
    } else {
      System.out.println("伝票：No" + this.slipNo);
    }
  }

  // 運賃を表示して返す
  public int calcFare() {
    if (this.quantity == 0) {
      System.out.println("数量が設定されていません");
      return 0;
    }

    if (this.unitPrice == 0) {
      System.out.println("単価が設定されていません");
      return 0;
    }

    System.out.println("運賃は" + (this.quantity * this.unitPrice) + "円です");
    return this.quantity * this.unitPrice;
  }

  // 発送可能な状態かを返す
  public boolean canShipped() {
    if (!this.goods.   equals ("none") &&
        this.quantity  !=       0      &&
        this.unitPrice !=       0      &&
        !this.address. equals ("none")) {
      return true;
    } else {
      return false;
    }
  }

  // 発送が可能な状態なら伝票番号を発行する
  public void ship() {
    if (this.canShipped() == true) {
      Order.slip++;
      this.slipNo = Order.slip;
      System.out.println(this.calcFare() + "円で発送しました!" + this.goods + "の伝票番号は:No" + this.slipNo + "です");
    } else {
      System.out.println("＜＜情報が不足しています：以下を確認してください＞＞");
      this.displayInfo();
    }
  }
}
