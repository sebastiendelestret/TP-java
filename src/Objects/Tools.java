package Objects;

import java.util.Random;

public interface Tools {
    public static int getRandInt(int min, int max){
        return new Random().nextInt((max - min)+1) +min;
    }

}
