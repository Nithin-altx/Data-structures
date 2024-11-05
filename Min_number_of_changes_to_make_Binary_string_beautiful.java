class Solution {
    public int minChanges(String s) {
        int n=s.length();
        int count=0;
        int change=0;
        //Tc=O(n)
        //sc=O(1)
        char ch=s.charAt(0);
        for(int i=0;i<n;i++)
        {
            if(s.charAt(i)==ch)
            {
                count++;
                continue;
            }
            if(count%2==0)
            {
                count=1;
            }
            else{
                change++;
                count=0;
            }
            ch=s.charAt(i);
        }
        return change;
    }
}
