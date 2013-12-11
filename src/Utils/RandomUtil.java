package Utils;
import java.util.Random;



public class RandomUtil {
	Random rand = new Random();
	int posRandInt = rand.nextInt( Integer.MAX_VALUE );

	public String getRandomNumber(){
		return String.valueOf(posRandInt);
	}
}
