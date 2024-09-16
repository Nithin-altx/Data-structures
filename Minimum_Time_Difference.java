class Solution {
//     Input: timePoints = ["23:59","00:00"]
// Output: 1 EDGE CASE. Tc=O(NLOGN)
    public int findMinDifference(List<String> timePoints) {
    int n=timePoints.size();
    List<Integer> min=new ArrayList<>();
    for(int i=0;i<n;i++)
    {
        String s=timePoints.get(i);
        String []parts=s.split(":");
        int h=Integer.valueOf(parts[0]);
        int m=Integer.valueOf(parts[1]);
        min.add(h*60+m);
    }
    Collections.sort(min);
    int result=Integer.MAX_VALUE;
    for(int i=0;i<min.size()-1;i++)
    {
        result=Math.min(result,min.get(i+1)-min.get(i));
    }
    return Math.min(result,24*60-min.get(min.size()-1)+min.get(0));
        
    }
}
