import java.util.Random;

public class Tools {
    public Tools() {

    }

    public int getRandInt(int min, int max){
        return new Random().nextInt((max - min)+1) +min;
    }

}
