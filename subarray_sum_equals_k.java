class Solution {
    public int subarraySum(int[] nums, int k) {
Map<Integer,Integer> mp=new HashMap<>();
int n=nums.length;
mp.put(0,1);
int result=0;
int curr=0;
for(int i=0;i<n;i++)
{
    curr+=nums[i];
    if(mp.containsKey(curr-k))
    {
        result+=mp.get(curr-k);
    }
    mp.put(curr,mp.getOrDefault(curr, 0) + 1);

}
return result;
        
    }
}
