package Amazon;

import java.util.ArrayList;
import java.util.List;

public class TotalStrengthWizard {

    // Not with modulo
    public static int totalStrength(int[] strength) {
        List<Integer> result = new ArrayList<>();
        for (int j=0; j<strength.length; j++) {
            for (int k=1; k<=strength.length; k++) {
                int currSum = 0;
                int i=j;
                int minStrength = strength[i];
                while (i<k && i<strength.length) {
                    currSum = currSum + strength[i];
                    minStrength = Math.min(minStrength, strength[i]);
                    i++;
                }
                result.add(currSum*minStrength);
            }
        }
        return result.stream().mapToInt(Integer::intValue).sum();
    }

    public static void main(String[] args) {
        int[] strength = new int[] {5,4,6};
        System.out.println(totalStrength(strength));
    }
}
