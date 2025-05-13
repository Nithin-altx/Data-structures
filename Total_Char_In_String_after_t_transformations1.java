class Solution {
    public int lengthAfterTransformations(String s, int t) {
        int[] mp = new int[26];
//Tc=O(N)
//sc=O(1)
        for (int i = 0; i < s.length(); i++) {
            mp[s.charAt(i) - 'a']++;
        }

        int mod = 1000000007;

        while (t-- > 0) {
            int[] next = new int[26];
              // holds changes for the next time 
            for (int i = 0; i < 26; i++) {
                if (mp[i] == 0) continue;

                if (i == 25) {
                    next[0] = (next[0] + mp[i]) % mod;
                    next[1] = (next[1] + mp[i]) % mod;
                } else {
                    next[i + 1] = (next[i + 1] + mp[i]) % mod;
                }
            }

            mp = next;  // move to next state
        }

        int count = 0;
        for (int i = 0; i < 26; i++) {
            count = (count + mp[i]) % mod;
        }

        return count;
    }
}
