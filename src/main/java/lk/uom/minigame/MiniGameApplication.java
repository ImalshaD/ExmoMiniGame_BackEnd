package lk.uom.minigame;

import lk.uom.minigame.Utility.RandomNumberGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MiniGameApplication {

	public static void main(String[] args) {
		RandomNumberGenerator randomNumberGenerator = RandomNumberGenerator.getInstance();
		randomNumberGenerator.setMax(10);
		randomNumberGenerator.setMin(1);
		SpringApplication.run(MiniGameApplication.class, args);
	}

}
