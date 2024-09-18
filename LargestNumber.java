public class Solution {
    //Input: nums = [3,30,34,5,9]
     //Output: "9534330"
     //Tc=O(NLogN)
    public String largestNumber(int[] nums) {
        Integer[] numsAsInteger = Arrays.stream(nums).boxed().toArray(Integer[]::new);

        Arrays.sort(numsAsInteger, (a, b) -> {
            String s1 = Integer.toString(a);
            String s2 = Integer.toString(b);
            return (s2 + s1).compareTo(s1 + s2);
        });

        if (numsAsInteger[0] == 0) {
            return "0";
        }
        StringBuilder result = new StringBuilder();
        for (int num : numsAsInteger) {
            result.append(num);
        }

        return result.toString();
    }
}
