import java.util.concurrent.ThreadLocalRandom;

// beberapa cara untuk mendapatkan sebuah nilai random di java, diantaranya : 
// 1. dengan menggunakan class Random 
// 2. dengan menggunakan static class ThreadLocalRandom 

public class Demo {
    
    public static void main(String[] args) {

        //Random rnd = new Random();

        // random 10 buah nilai 
        int i = 1, x;
        while (i <= 10) {
            x = ThreadLocalRandom.current().nextInt(1, 1001);
            System.out.print(x + " ");
            i++;
        }

    }

}




