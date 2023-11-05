package iv.michail;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < 10000000; i++)
        {
            int val = MyRandom.randInt(10);
            if(map.containsKey(val))
            {
                map.replace(val, map.get(val) + 1);
            }
            else
            {
                map.put(val, 1);
            }
        }
        System.out.println(map);

        // Determine the maximum frequency in the map
        int maxFrequency = 0;
        for (int value : map.values()) {
            if (value > maxFrequency) {
                maxFrequency = value;
            }
        }

        // Define the scale for the chart
        int scale = 5;

        // Create a text-based bar chart
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int value = entry.getKey();
            int frequency = entry.getValue();
            int barLength = (int) (frequency * scale / (double) maxFrequency);

            System.out.printf("%d |", value);

            for (int j = 0; j < barLength; j++) {
                System.out.print("█");
            }

            System.out.printf(" %d%n", frequency);
        }
    }
}