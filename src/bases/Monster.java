//④Monster.java
/*1. basesパッケージ内に作成します。
2. 引数をname, weapon の 2つとするコンストラクタを作成します。その際、Livingクラスで定義したコンストラクタを利用してください。
3. attackメソッドをオーバーライドします。その際、コメント文の内容を実装します。
  3-1. 引数でもらった Living型のtargetインスタンスを攻撃する相手のインスタンスとします。
  3-2. Diceクラスを利用して1から10までのサイコロを振り、自分の攻撃力とかけ合わせた値を相手に与えるダメージ値（整数）とします。
  3-3. 攻撃されたtargetの持つHPをダメージ分だけ減らします
  3-4. コンソールに、以下のようにステータス文字列（〇〇はモンスターの名前、✕✕はモンスターの武器の名前、△△はtargetの名前、▲▲はダメージ値）を表示します
　　　　「〇〇」が「✕✕」で攻撃！「△△」に▲▲のダメージを与えた。*/
package bases;

import utils.Dice;

// モンスターを表現する抽象クラス
public abstract class Monster extends Living {
	// コンストラクタ
    public Monster(String name, String weapon) {//mainで使う部品を用意している
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

        // コンソールにステータスを表示
        System.out.println(this.getName() + "が" + this.getWeapon() + "で攻撃！" + target.getName() + "に" + damage + "のダメージを与えた。");
    }
}