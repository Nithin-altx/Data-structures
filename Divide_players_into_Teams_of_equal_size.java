 //approach 1 Tc=O(nlogn)
        //Two pointer approach
        // int n=skill.length;
        // Arrays.sort(skill);
        // int i=0,j=n-1;
        // int s=skill[i]+skill[j];
        // long chem=0;
        // while(i<j)
        // {
        //     int cs=skill[i]+skill[j];
        //     if(cs!=s)
        //     return -1;
        //     chem+=((long)skill[i]*(long)skill[j]);
        //     i++;
        //     j--;

        // }
        // return chem;
class Solution {
    public long dividePlayers(int[] skill) {
        //Tc=O(N)
        //Sc=O(1)
        int n=skill.length;
        int teams=n/2;
        int sum=0;
        for(int x:skill)
        {
            sum+=x;
        }
        if(sum%teams!=0)
        return -1;
        int s=sum/teams;
        int a[]=new int[10001];
        for(int i=0;i<n;i++)
        {
            a[skill[i]]++;
        }
        long chem=0;
        for(int i=0;i<n;i++)
        {
            int rem=s-skill[i];
            chem+=(long)rem*skill[i];
            if(a[rem]<=0)
            return -1;
            a[rem]--;
        }
        return chem/2;

       
        
    }
}
