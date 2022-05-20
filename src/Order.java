import java.math.BigDecimal;

public class Order {
  //::::::::::
  //  受注クラス
  //    メンバ変数（コンストラクタ初期値）
  //      商品    : String      goods       : "none"
  //      数量    : int         quantity    : 0
  //      単価    : int         unitPrice   : 0
  //      送料    : BigDecimal  loadFare    : 0
  //      発送先  : String      address     : "none"
  //      発送伝票: String      slipNo      : "none"
  //    コンストラクタ
  //      引数なし: 全てのメンバを初期値とする
  //      引数の順は以下の通りとし、足りない分は初期値（slipNo以外）
  //        1) goods
  //        2) quantity
  //        3) unitPrice
  //        4) address
  //    メソッド
  //      public boolean  isAveilableShipped    : 出荷可能かを判定する
  //      public void     ship          : 出荷可能なら伝票番号を発行して記録
  //      public void     displayInfo   : オーダー情報をきれいに表示する
  //      public getter/setter          : それぞれ用意
  //::::::::::

  private String goods;
  private int quantity;
  private int unitPrice;
  private BigDecimal loadFare;
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
    this.loadFare = BigDecimal.valueOf(0);
    this.address = address;
    this.slipNo = "none";
  }

  // 発送可能な状態かを返す
  public boolean isAveilableShipped() {
    if (!this.goods.   equals ("none")                      &&
        this.quantity  !=       0                           &&
        this.unitPrice !=       0                           &&
        this.loadFare.compareTo(BigDecimal.valueOf(0)) != 0 &&
        !this.address. equals ("none")) {
      return true;
    }
    return false;
  }

  // 発送が可能な状態なら伝票番号を発行する
  public void ship() {
    if (this.isAveilableShipped() == true) {
      this.slipNo = Slip.genSlipNo();
      System.out.println(this.loadFare + "円で発送しました!" + this.goods + "の伝票番号は:No" + this.slipNo + "です");
    } else {
      System.out.println("＜＜情報が不足しています：以下を確認してください＞＞");
      this.displayInfo();
    }
  }

  // 設定されている情報を整理して出す
  public void displayInfo() {
    String[] display = {"設定なし", "設定無し", "設定無し", "未計算", "設定無し", "未発行"};

    if (!this.goods.equals("none"))                           display[0] = this.goods;
    if (this.quantity != 0)                                   display[1] = String.valueOf(this.quantity);
    if (this.unitPrice != 0)                                  display[2] = String.valueOf(this.unitPrice);
    if (this.loadFare.compareTo(BigDecimal.valueOf(0)) != 0)  display[3] = String.valueOf(this.loadFare);
    if (!this.address.equals("none"))                         display[4] = this.address;
    if (!this.slipNo.equals("none"))                          display[5] = this.slipNo;

    System.out.println("品名: " + display[0]);
    System.out.println("数量: " + display[1]);
    System.out.println("単価: " + display[2]);
    System.out.println("運賃: " + display[3]);
    System.out.println("発送: " + display[4]);
    System.out.println("伝票: " + display[5]);
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

  public BigDecimal getLoadFare() {
    return this.loadFare;
  }

  public String getAddress() {
    return this.address;
  }

  public String getSlipNo() {
    return this.slipNo;
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

  public void setLoadFare(BigDecimal loadFare) {
    this.loadFare = loadFare;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public void setSlipNo(String slipNo) {
    this.slipNo = slipNo;
  }
}
