//③Human.java
/*1. basesパッケージ内に作成します。
2. 引数をname, weapon の 2つとするコンストラクタを作成します。その際、Livingクラスで定義したコンストラクタを利用してください。
3. attackメソッドをオーバーライドします。その際、コメント文の内容を実装します。
  3-1. 引数でもらった Living型のtargetインスタンスを攻撃する相手のインスタンスとします。
  3-2. Diceクラスを利用して1から10までのサイコロを振り、自分の攻撃力とかけ合わせた値を相手に与えるダメージ値（整数）とします。
  3-3. 攻撃されたtargetの持つHPをダメージ分だけ減らします
  3-4. 人間の場合は、攻撃を仕掛けた際に　自分の攻撃力も1だけ減るとします
  3-5. コンソールに、以下のようにステータス文字列（〇〇は人間の名前、✕✕は人間の武器の名前、△△はtargetの名前、▲▲はダメージ値）を表示します
　　　　「〇〇」が「✕✕」で攻撃！「△△」に▲▲のダメージを与えた。
　　　　　しかし自分の攻撃力も1減少した。*/
package bases;

import utils.Dice;  // ★

public abstract class Human extends Living {

    // コンストラクタ
    public Human(String name, String weapon) {//mainで使う部品を用意している
        super(name, weapon);  // ★superをつかって、スーパークラス（この場合 Living）のコンストラクタを実行
    }

    // attackメソッドのオーバーライド
    @Override
    public void attack(Living target) {//attackメソッドが実行されるときにLivingクラスのデータが呼び出される/サブクラスのデータも渡せる
        // 1から10までのサイコロを振り、自分の攻撃力とかけ合わせが値を相手に与えるダメージとする
        int damage = Dice.get(1, 10) * this.getOffensive();  // ★Diceの結果と自分の攻撃力をかけ合わせる

        // 相手のHPをダメージ値だけ減らす
        int hp = target.getHp();  // ★ターゲットのHPを取得
        hp = hp - damage;  // ★ターゲットのHPからダメージをマイナス
        target.setHp(hp);  // ★マイナスしたHPを、ターゲットのHPとしてセット

        // 自分の攻撃力を1だけ減らす
        hp = this.getHp();  // ★自分のHPを取得
        hp = hp - 1;  // ★HPを1だけ減らす
        this.setHp(hp);  // ★マイナスしたHPを、自分のHPとしてセット

        // コンソールにステータスを表示
        System.out.println(this.getName() + "が" + this.getWeapon() + "で攻撃！" + target.getName() + "に" + damage + "のダメージを与えた。");
    }
}