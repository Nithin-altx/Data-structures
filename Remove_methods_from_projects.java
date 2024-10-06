class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invoca) {
        Set<Integer>spm=new HashSet<>();
        //Tc=O(m+n)
        //sc=O(n)
        spm.add(k);
        boolean changed=true;
        while(changed)
        {
            changed=false;
            for(int []invoc:invoca)
            {
                int a=invoc[0];
                int b=invoc[1];
                if(spm.contains(a)&&!spm.contains(b))
                {
                    spm.add(b);
                    changed=true;
                }
            }
        }
        
             for(int []invoc:invoca)
             {
                  int a=invoc[0];
                 int b=invoc[1];
                  if(!spm.contains(a)&&spm.contains(b))//If non suspicous node will find and not presnt in set
                {
                    return Arrays.asList(createarray(n));
                    
                }
             }
             List<Integer> remain=new ArrayList<>();
             for(int i=0;i<n;i++)
             {
                if(!spm.contains(i))//non suspicous nodes that are node present in set
                {
                    remain.add(i);
                }

             }
             return remain;
    }
        private static Integer[] createarray(int n)
        {
            Integer[]result=new Integer[n];
            for(int i=0;i<n;i++)
            {
                result[i]=i;
            }
            return result;
        }

}
