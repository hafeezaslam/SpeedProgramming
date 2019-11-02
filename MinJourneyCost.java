import java.util.Scanner;

public class MinJourneyCost {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("number of simulations");
        int testCases = scanner.nextInt();
        scanner.nextLine();
        for(int i = 0; i < testCases; i++) {
            System.out.println(minCost());
        }
    }

    static int minCost() {
        System.out.println("number of checkpoints");
        int numberOfCheckpoint = scanner.nextInt();
        scanner.nextLine();

        System.out.println("cost per liter at each checkpoint");
        int[] costPerLiter =  inputFormatter(scanner.nextLine().split("\\s"), numberOfCheckpoint);

        System.out.println("liter of fuel needed to reach each checkpoint");
        int[] litPerCheckpoint = inputFormatter(scanner.nextLine().split("\\s"), numberOfCheckpoint);

        int minCost = 0;

        int i =0;
        while(i<numberOfCheckpoint-1) {
            minCost += costPerLiter[i] * litPerCheckpoint[i];

            for(int j= i+1; j < numberOfCheckpoint; j++, i=j) {
                if((costPerLiter[i] < costPerLiter[j])) {
                    minCost += costPerLiter[i]*litPerCheckpoint[j];

                } else {
                    i =j;
                    break;
                }
            }
            if(i == numberOfCheckpoint-1) {
                minCost += costPerLiter[i]*litPerCheckpoint[i];
            }

        }
        return minCost;
    }
    static int[] inputFormatter(String[] input, int inputLength) {
        int[] formattedInput = new int[inputLength];
        for(int i = 0; i<inputLength; i++) {
            formattedInput[i] = Integer.valueOf(input[i]);
        }
        return formattedInput;
    }
}
