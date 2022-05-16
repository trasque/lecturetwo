# 5月度 課題2

「受注情報」を扱うクラスをつくり、必要な情報が揃っているときにのみ「出荷」メソッドを実行できるプログラムとしました。出荷が行われた場合、static変数として用意した伝票番号がひとつずつ加算されます。加算された伝票番号を、インスタンスに保存します。

`checkstyle` を実施しました。 `check.log` はメインメソッドのある `LectureTwo.java` の結果です。 `check2.log` は `Order.java` の結果です。 Java Doc の対応はしていないのでそのままにしています。使用したファイルは `checkstyle-10.2-all.jar` です。

また、 `Order.java` 内の `canShipped()` メソッドにある条件分岐を見やすくしようとしましたが、`checkstyle` には指摘されてしまいました。

## インスタンスの情報

以下のような情報を持ちます

- 品名
- 数量
- 単価
- 送り先住所
- 伝票番号

また、クラスには `static int slip` （伝票）という変数があります。

slip は 0 を初期値とし、ship() が正しく実行されるたびに 1 ずつ加算されます。

## クラスの持つ機能

1. それぞれのインスタンス情報への Getter と Setter があります

https://github.com/trasque/lecturetwo/blob/eb6869b0beb31b01b500ae1651b478204c41f7f7/src/Order.java#L60-L102

2. 生成したインスタンスのメンバ情報を整形して一覧表示します

https://github.com/trasque/lecturetwo/blob/eb6869b0beb31b01b500ae1651b478204c41f7f7/src/Order.java#L105-L135

3. 数量と単価を掛けた値を返し、表示します。どちらかの値が未設定の場合は情報が不足している旨を表示し、0を返します。

https://github.com/trasque/lecturetwo/blob/eb6869b0beb31b01b500ae1651b478204c41f7f7/src/Order.java#L137-L151

4. インスタンスに必要な値が全て設定されているか ＝ 「出荷可能」かを判断します

https://github.com/trasque/lecturetwo/blob/eb6869b0beb31b01b500ae1651b478204c41f7f7/src/Order.java#L153-L163

5. 「出荷」処理をした場合は、伝票番号を付与します

https://github.com/trasque/lecturetwo/blob/eb6869b0beb31b01b500ae1651b478204c41f7f7/src/Order.java#L165-L175

## 実行例

### 例1

引数なしでインスタンス `mikan` を作成し、機能2 `メンバ情報の一覧表示` を実行します。

```
=====[例1]=====
[引数なしで生成→すべて初期値で出力]
品名：設定なし
数量：設定なし
単価：設定なし
住所：設定なし
伝票：未発行
```

https://github.com/trasque/lecturetwo/blob/eb6869b0beb31b01b500ae1651b478204c41f7f7/src/LectureTwo.java#L6-L11

### 例2

品名と数量のみをコンストラクタで設定したインスタンス `suika` を作成し、機能3 `運賃の計算` を実行します。数量はありますが、単価が未設定のため計算ができない旨を表示します。

品名は「すいか」、数量は 5 が入れられています。その後、Setterを使って単価を設定し、改めて運賃計算をします。

```
=====[例2]=====
[一部引数を指定し、運賃メソッドを使う]
[不足した設定値で計算]
単価が設定されていません
[単価を100円にして計算]
運賃は500円です
```

https://github.com/trasque/lecturetwo/blob/eb6869b0beb31b01b500ae1651b478204c41f7f7/src/LectureTwo.java#L13-L24

### 例3

発送先住所以外をコンストラクタで設定したインスタンス `negi` を作成し、一覧表示の後、機能 4 `出荷可否の判定` を実行します。全ての情報が揃っていないため、発送不可と表示されます。

その後、情報を不足させたまま 機能 5 `出荷処理` を実行します。情報が不足しているため、出荷処理はその旨を表示し、現在のインスタンス状況を表示します。

未出荷の状態のまま、Getter で伝票番号 `slipNo` を読み出そうとすると、まだ出荷されていない旨が表示されます。

```
=====[例3]=====
[住所以外を指定し、発送可能かを調べる]
品名：ねぎ
数量：8
単価：80
住所：設定なし
伝票：未発行
発送可能？：false
[発送を試みる]
＜＜情報が不足しています：以下を確認してください＞＞
品名：ねぎ
数量：8
単価：80
住所：設定なし
伝票：未発行
[未発送の状態で伝票番号を読み取ろうとする]
発送されていません
```

https://github.com/trasque/lecturetwo/blob/eb6869b0beb31b01b500ae1651b478204c41f7f7/src/LectureTwo.java#L26-L35

### 例4

例3で不足していた住所を設定し、出荷処理を実行します。

出荷処理では、出荷が可能だと判断されると伝票番号を発行します。

伝票番号は `Order` クラス内にある static変数 `slip` で管理されており、機能 5 によって出荷可能だと判断されると、1つ加算されます。

出荷処理はそのまま、加算した伝票番号をインスタンス内の `slipNo` へ記録します。

出荷後の伝票番号 `slipNo` を Getter で読み出します。

```
=====[例4]=====
[ねぎの住所を入れて発送する]
運賃は640円です
640円で発送しました!ねぎの伝票番号は:No1です
[ねぎの情報を表示]
品名：ねぎ
数量：8
単価：80
住所：千葉県
伝票：No1
発送した時の伝票番号は1
```

https://github.com/trasque/lecturetwo/blob/eb6869b0beb31b01b500ae1651b478204c41f7f7/src/LectureTwo.java#L37-L44

### 例5

これまでで作成された、発送できていない `mikan` `suika` インスタンスに加え `tomato` `kani` も作成し、これをリスト化します。

for と 機能 2 `一覧表示` と 機能 4 `出荷可否` を使って一気に状況を表示します。

```
=====[例5]=====
[複数の品目をリストにする]
[みかん、すいか、トマト、かに]
[現在の状態を列挙する]
◆◆◆◆
品名：設定なし
数量：設定なし
単価：設定なし
住所：設定なし
伝票：未発行
発送可能？：false
◆◆◆◆
品名：すいか
数量：5
単価：100
住所：設定なし
伝票：未発行
発送可能？：false
◆◆◆◆
品名：トマト
数量：20
単価：60
住所：埼玉県
伝票：未発行
発送可能？：true
◆◆◆◆
品名：かに
数量：3
単価：800
住所：栃木県
伝票：未発行
発送可能？：true
```

https://github.com/trasque/lecturetwo/blob/eb6869b0beb31b01b500ae1651b478204c41f7f7/src/LectureTwo.java#L46-L62

### 例6

例5で表示された内容をもとに、Setterで必要な情報を埋めます。

全てのインスタンスが発送可能であることを確認し、一気に ship() メソッドを実行します。

それぞれのインスタンスに連番で伝票番号が割り振られ、出荷完了となります。

```
=====[例6]=====
[必要な情報を埋めて、一気に発送する]
[内容確認]
◆◆◆◆
品名：みかん
数量：25
単価：30
住所：沖縄県
伝票：未発行
発送可能？：true
◆◆◆◆
品名：すいか
数量：5
単価：100
住所：東京都
伝票：未発行
発送可能？：true
◆◆◆◆
品名：トマト
数量：20
単価：60
住所：埼玉県
伝票：未発行
発送可能？：true
◆◆◆◆
品名：かに
数量：3
単価：800
住所：栃木県
伝票：未発行
発送可能？：true
[全て発送可能なので、一気に発送する]
運賃は750円です
750円で発送しました!みかんの伝票番号は:No2です
運賃は500円です
500円で発送しました!すいかの伝票番号は:No3です
運賃は1200円です
1200円で発送しました!トマトの伝票番号は:No4です
運賃は2400円です
2400円で発送しました!かにの伝票番号は:No5です
```

https://github.com/trasque/lecturetwo/blob/eb6869b0beb31b01b500ae1651b478204c41f7f7/src/LectureTwo.java#L64-L84
