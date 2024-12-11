class Solution {
//O(N^2)
    public int maximumLength(String s) {
        Map<Map.Entry<Character, Integer>, Integer> mp = new HashMap<>();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            int length = 0;

            for (int j = i; j < n; j++) {
                if (ch == s.charAt(j)) {
                    length++;
                    Map.Entry<Character, Integer> key = new AbstractMap.SimpleEntry<>(ch, length);
                    mp.put(key, mp.getOrDefault(key, 0) + 1);
                } else {
                    break;
                }
            }
        }

        int result = 0;
        for (Map.Entry<Map.Entry<Character, Integer>, Integer> entry : mp.entrySet()) {
            int count = entry.getValue();
            int length = entry.getKey().getValue();

            if (count >= 3 && length > result) {
                result = length;
            }
        }

        return result == 0 ? -1 : result;
    }
}
//Approach 2
//O(N^3)
class Solution {
    public int maximumLength(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            StringBuilder curr = new StringBuilder();
            
            for (int j = i; j < s.length(); j++) {
                if (curr.length() == 0 || curr.charAt(curr.length() - 1) == s.charAt(j)) {
                    curr.append(s.charAt(j));
                    map.put(curr.toString(), map.getOrDefault(curr.toString(), 0) + 1);
                } else {
                    break;
                }
            }
        }
        
        int maxLength = 0;
        for (String key : map.keySet()) {
            int count = map.get(key);
            if (count >= 3 && key.length() > maxLength) {
                maxLength = key.length();
            }
        }
        
        return maxLength == 0 ? -1 : maxLength;
    }
}
//Approach 3
//O(N)
class Solution {
    public int maximumLength(String s) {
        int n=s.length();
        int matrix[][]=new int[26][n+1];
        char prev=s.charAt(0);
        int length=0;
        for(int i=0;i<n;i++)
        {
            char ch=s.charAt(i);
            if(ch==prev)
            {
                length++;
                matrix[ch-'a'][length]++;
                prev=ch;
            }
            else{
                length=1;
                matrix[ch-'a'][length]++;
                prev=ch;
            }
        }
        int result=0;
        for(int i=0;i<26;i++)
        {
            int cumsum=0;
            for(int j=n;j>=1;j--)
            {
                cumsum+=matrix[i][j];
                if(cumsum>=3)
                {
                    result=Math.max(result,j);
                    break;
                }
            }
        }
        return result==0?-1:result;
    }
}
