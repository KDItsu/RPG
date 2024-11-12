package humans;

import bases.Human;
import utils.Dice;

public class Fighter extends Human{
	public Fighter(String name, String weapon) {
		super(name, weapon);
	
		//HPや攻撃力は変数で受け取り、Livingクラスの hp, offensiveに保管してく必要がある
		int hp = Dice.get(240, 300);
		this.setHp(hp);// Livingクラスの hpに保管
		
		int offensive = Dice.get(17, 23);
		this.setOffensive(offensive);
	}

}
	//コンストラクタの中で、name, weaponの値を設定するために、Humanクラスに定義したコンストラクタを利用してください。
	//コンストラクタの中で、ヒットポイントの値は乱数を振って決定します。（乱数の具体的は範囲は後述）
	//コンストラクタの中で、攻撃力の値は乱数を振って決定します。（乱数の具体的は範囲は後述）
	//ヒットポイントの乱数範囲、攻撃力の乱数範囲
	//240 ~ 300	17 ~ 23
	