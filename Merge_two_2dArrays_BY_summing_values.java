//Appraoch 1 using map
class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Map<Integer, Integer> map = new TreeMap<>();

        // Add elements from nums1 to the map
        for (int[] a : nums1) {
            map.put(a[0], map.getOrDefault(a[0], 0) + a[1]);
        }

        // Add elements from nums2 to the map
        for (int[] b : nums2) {
            map.put(b[0], map.getOrDefault(b[0], 0) + b[1]);
        }

        // Convert map entries into a 2D array
        int[][] res = new int[map.size()][2];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            res[i][0] = entry.getKey();
            res[i][1] = entry.getValue();
            i++;
        }

        return res;
    }
}

//Approach 2 Using two Pointer
class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
         int equalcount=0;
         //Tc=O(M+N)
         //Sc=O(M+N)
        for(int a[]:nums1)
        {
            int id=a[0];
            boolean k=false;
           for(int b[]:nums2)
           {
            int id1=b[0];
            if(id==id1)
            {
                k=true;
                equalcount++;
                break;
            }
        }
        }
        int m=0,n=0;
        int size=nums1.length+nums2.length-equalcount;
        int res[][]=new int[size][2];
        int i=0;
        while(m<nums1.length&&n<nums2.length)
        {
            int j=0;
                int id1=nums1[m][0];
                int id2=nums2[n][0];
                int val1=nums1[m][1];
                int val2=nums2[n][1];
                if(id1==id2)
                {
                    res[i][j]=id1;
                    j++;
                    res[i][j]=val1+val2;
                    m++;
                    n++;
                    i++;
                }
                else if(id1<id2)
                {
                    res[i][j]=id1;
                    j++;
                    res[i][j]=val1;
                    m++;
                    i++;
                }
                else{
                    res[i][j]=id2;
                    j++;
                    res[i][j]=val2;
                    n++;
                    i++;
                }
        }
        while(m<nums1.length)
        {
            int j=0;
            int id=nums1[m][0];
            int val=nums1[m][1];
            res[i][j]=id;
            j++;
            res[i][j]=val;
            i++;
            m++;
        }
        while(n<nums2.length)
        {
            int j=0;
            int id=nums2[n][0];
            int val=nums2[n][1];
            res[i][j]=id;
            j++;
            res[i][j]=val;
            i++;
            n++;
        }
        return res;

        
    }
}
