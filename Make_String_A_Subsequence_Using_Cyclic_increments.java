class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int i = 0, j = 0;
        int n = str1.length(), n1 = str2.length();
        //Tc=O(Min(N,N1))
        while (i < n && j < n1) {
            char currentChar = str1.charAt(i);
            // Handle wrap-around from 'z' to 'a'
            char nextChar = (currentChar == 'z') ? 'a' : (char)(currentChar + 1);
            
            // Check if characters match directly or after increment
            if (currentChar == str2.charAt(j) || nextChar == str2.charAt(j)) {
                j++; // Move pointer in str2 if there's a match
            }
            i++; // Always move pointer in str1
        }
        
        // If all characters in str2 are matched, return true
        return j == n1;
    }
}
