public class Order {
  //::::::::::
  //  受注クラス
  //    メンバ変数（コンストラクタ初期値）
  //      商品    : String goods       : "none"
  //      数量    : int    quantity    : 0
  //      単価    : int    unitPrice   : 0
  //      送料    : int    loadFare    : 0
  //      発送先  : String address     : "none"
  //      発送伝票: String slipNo      : "none"
  //    コンストラクタ
  //      引数なし: 全てのメンバを初期値とする（slipNo 以外）
  //      引数の順は以下の通りとし、足りない分は初期値（slipNo以外）
  //        1) goods
  //        2) quantity
  //        3) unitPrice
  //        4) address
  //    メソッド
  //      getter/setter : それぞれ用意
  //      displayInfo   : 現在設定されている内容をきれいに表示する
  //      calcFare      : 運賃を計算する（数量 x 単価）
  //      canShipped    : 出荷可能かを判定する
  //      ship          : 出荷可能なら伝票番号を発行して記録
  //::::::::::

  private String goods;
  private int quantity;
  private int unitPrice;
  private int loadFare;
  private String address;
  private String slipNo;

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
    this.slipNo = "none";
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

    if (this.slipNo.equals("none")) {
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
    }
    return false;
  }

  // 発送が可能な状態なら伝票番号を発行する
  public void ship() {
    if (this.canShipped() == true) {
      this.slipNo = Slip.genSlipNo();
      System.out.println(this.calcFare() + "円で発送しました!" + this.goods + "の伝票番号は:No" + this.slipNo + "です");
    } else {
      System.out.println("＜＜情報が不足しています：以下を確認してください＞＞");
      this.displayInfo();
    }
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

  public int getLoadFare() {
    return this.loadFare;
  }

  public String getAddress() {
    return this.address;
  }

  public String getSlipNo() {
    if (this.slipNo.equals("none")) {
      System.out.println("発送されていません");
      return "none";
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

  public void setLoadFare(int loadFare) {
    this.loadFare = loadFare;
  }

  public void setAddress(String address) {
    this.address = address;
  }
}
