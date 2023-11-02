package com.in28minutes.learnspringframework;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.MarioGame;
import com.in28minutes.learnspringframework.game.PacmanGame;
import com.in28minutes.learnspringframework.game.SuperContraGame;

public class App01GamingBasic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		var game = new MarioGame();
//		var game = new SuperContraGame();
		var game = new PacmanGame(); // 1. 게임 객체 생성
		var gameRunner = new GameRunner(game);
			// 2. gameRunner 객체 생성 + 의존성 연결(Wiring of Dependencies)
			// gameRunner 클래스는 게임을 실행 -> 게임이 의존성(Dependencies)이다.
		gameRunner.run();

	}

}
