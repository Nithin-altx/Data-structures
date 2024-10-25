class Solution {
    //Tc=O(N*L^3)
    //Sc=O(N)
    public List<String> removeSubfolders(String[] folder) {
        Set<String> st=new HashSet<>();
        for(int i=0;i<folder.length;i++)
        {
            String s=folder[i];
            st.add(s);
        }
        List<String> res=new ArrayList<>();
        for(int j=0;j<folder.length;j++)
        {
            String k=folder[j];
            String temp=k;
            boolean issubfolder=false;
            while(!temp.isEmpty())
            {
                int idx=temp.lastIndexOf('/');
                temp=temp.substring(0,idx);
                if(st.contains(temp))
                {
                    issubfolder=true;
                    break;
                }
            
            }
            if(!issubfolder)
            {
                res.add(k);
            }
          
        }
        return res;
        
    }
}
//*********************Using sorting********************

class Solution {
    //Tc=O(NlogN+n*l)
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> res=new ArrayList<>();
        res.add(folder[0]);
        for(int i=1;i<folder.length;i++)
        {
            String curr=folder[i];
            String last=res.get(res.size()-1);
            last+="/";
            if(!curr.startsWith(last))
            {
                res.add(curr);
            }
        }
     
        return res;
        
    }
}
