package neetcode150.greedy;


public class GasStation_134 {

    public static int canCompleteCircuitCircularArray0(int[] gas, int[] cost) {
        int totalGasStation = gas.length;

        for (int i = 0; i < totalGasStation; i++) {
            int totalGas = 0;
            int startingPoint = 0;
            int currentPoint = i;

            while (startingPoint < totalGasStation) {
                totalGas = totalGas + gas[currentPoint % totalGasStation] - cost[currentPoint % totalGasStation];

                if (totalGas < 0) break;

                startingPoint++;
                currentPoint++;
            }

            if (startingPoint == totalGasStation) return i;
        }

        return -1;
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        //determine if we have a solution
        int total = 0;
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
        }
        if (total < 0) {
            return -1;
        }

        // find out where to start
        int tank = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            tank += gas[i] - cost[i];
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }
        return start;
    }

    public static int canCompleteCircuitCircularArray(int[] gas, int[] cost) {
        int startStation = 0, total = 0;

        for (int i = 0; i < gas.length * 2; i++) {
            total += gas[i % gas.length] - cost[i % gas.length];

            // Not enough gas to reach this position, restart from next position
            if (total < 0) {
                total = 0;
                startStation = i + 1;
            }

            if (i - startStation + 1 >= gas.length) return startStation;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        System.out.println(canCompleteCircuit(gas, cost));
    }

}