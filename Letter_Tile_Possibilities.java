class Solution {
    int count;
    void solve(int freq[])
    {
        count++;
        for(int i=0;i<26;i++)
        {
            if(freq[i]==0)
            continue;
            freq[i]=freq[i]-1;
            solve(freq);
            freq[i]=freq[i]+1;
        }

    }
    public int numTilePossibilities(String tiles) {
      count=0;
     int freq[]=new int[26];
      for(int i=0;i<tiles.length();i++)
      {
        freq[tiles.charAt(i)-'A']++;
      }
        solve(freq);
        return count-1;
        
    }
}
//Approach 2
class Solution {
    void solve(String tiles,StringBuilder res, Set<String> st, boolean used[])
    {
        st.add(res.toString());
        for(int i=0;i<tiles.length();i++)
        {
            if(used[i]==true)
            continue;

            used[i]=true;
            res.append(tiles.charAt(i));
            solve(tiles,res,st,used);
            used[i]=false;
            res.deleteCharAt(res.length()-1);
        }


    }
    public int numTilePossibilities(String tiles) {
        StringBuilder res=new StringBuilder();
        Set<String> st=new HashSet<>();
        int n=tiles.length();
        boolean used[]=new boolean[n];
        solve(tiles,res,st,used);
        return st.size()-1;
        
    }
}
