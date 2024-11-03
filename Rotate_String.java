class Solution {
    //Tc=O(N)
    public boolean rotateString(String s, String goal) {
        int n=s.length();
     if(s.length()!=goal.length())
     return false;
     String ds=s+s;
     return ds.contains(goal);
    }
}
