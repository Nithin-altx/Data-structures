//Optimal 3
class Solution {
    boolean BinarySearch(int start,int end, List<Integer> ls)
    {
        //Tc=(n+m*log(n))
        //sc=O(m)
        int  i=0,j=ls.size()-1;
        while(i<=j)
        {
            int mid=(i+j)/2;
             if(ls.get(mid)<start)
            {
                i=mid+1;
            }
            else if(ls.get(mid)>end){
                j=mid-1;
            }
            else{
                return true;
            }
        }
        return false;

    }
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n=nums.length;
        boolean res[]=new boolean[queries.length];
        List<Integer> ls=new ArrayList<>();
        for(int i=1;i<n;i++)
        {
            if(nums[i]%2==nums[i-1]%2)
            {
                ls.add(i);
            }
        }
        int k=0;
        for(int q[]:queries)
        {
            int a=q[0]+1;
            int b=q[1];
            boolean c=BinarySearch(a,b,ls);
            if(c==false)
            {
                res[k]=true;
            }
           
            k++;
            
        }
        
        return res;
        
    }
}
//Optimal 2
class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n=nums.length;
        boolean res[]=new boolean[queries.length];
        int validend[]=new int[n];
        int i=0,j=0;
        while(i<n)
        {
            if(j<i)
            j=i;
            while(j+1<n&&nums[j]%2!=nums[j+1]%2)
            {
                j++;
            }
            validend[i]=j;
            i++;
        }
        int k=0;
        for(int []q:queries)
        {
            int start=q[0];
            int end=q[1];
            if(end<=validend[start])
            {
                res[k]=true;
            }
            k++;
        }
      
        
        return res;
        
    }
}
//Brute Force
//Brute Force
class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n=nums.length;
        boolean res[]=new boolean[queries.length];
        int j=0;
        for(int q[]:queries)
        {
            int a=q[0];
            int b=q[1];
            if(a==b)
            {
                res[j]=true;
                j++;
            }
            else{
            boolean c=true;
            for(int i=a+1;i<=b;i++)
            {
                if((nums[i]&1)==(nums[i-1]&1))
                {
                    c=false;     
                } 
            }
            res[j]=c;
            j++;
            }
             
        }
        return res;
        
    }
}
//Optimal
class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n=nums.length;
        boolean res[]=new boolean[queries.length];
        int presum[]=new int[n];
        presum[0]=0;
        for(int i=1;i<n;i++)
        {
            presum[i] = presum[i-1] + ((nums[i] % 2 == 0 && nums[i-1] % 2 != 0) || (nums[i] % 2 != 0 && nums[i-1] % 2 == 0) ? 0 : 1);


        }
        for(int i=0;i<queries.length;i++)
        {
            int a=queries[i][0];
            int b=queries[i][1];
            res[i]=(presum[b]-presum[a])==0?true:false;
        }

        
        return res;
        
    }
}
