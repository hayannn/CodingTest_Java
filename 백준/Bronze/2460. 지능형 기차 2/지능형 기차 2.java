import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int human = 0;
        int maxPeople = 0;

        for(int i=0; i<10; i++) {
            int outTrain = sc.nextInt();
            int inTrain = sc.nextInt();

            human -= outTrain;
            human += inTrain;

            //human = human - outTrain + inTrain;

            if (human > maxPeople) {
                maxPeople = human;
            }
        }
        System.out.println(maxPeople);
    }
}