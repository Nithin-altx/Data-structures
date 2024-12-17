class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        //Tc=O(N)
        //sc=O(1)
     int []count=new int[26];
     for(int i=0;i<s.length();i++)
     {
        count[s.charAt(i)-'a']++;
     }
     int i=25;
     StringBuilder res=new StringBuilder() ;
     while(i>=0)
     {
        if(count[i]==0)
        {
            i--;
            continue;
        }
        char ch=(char)('a'+i);
        int freq=Math.min(count[i], repeatLimit);
        for(int k=0;k<freq;k++)
        {
            res.append(ch);
        }
        count[i]-=freq;
        if(count[i]>0)
        {
            int j=i-1;
            while(j>=0&&count[j]==0)
            {
                j--;
            }
            if(j<0)
            break;
            res.append((char)('a'+j));
            count[j]-=1;
        }

     }
     return res.toString();

    }
}
//Using maxheap
class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int []count=new int[26];
     for(int i=0;i<s.length();i++)
     {
        count[s.charAt(i)-'a']++;
     }
     PriorityQueue<Character> pq=new PriorityQueue<>((a,b)->b-a);
     for(int i=0;i<26;i++)
     {
        if(count[i]>0)
        {
            pq.offer((char)('a'+i));
        }
     }
     StringBuilder res=new StringBuilder();
     while(!pq.isEmpty())
     {
        char ch=pq.poll();
        int freq=Math.min(count[ch-'a'],repeatLimit);
        for(int k=0;k<freq;k++)
        {
            res.append(ch);
        }
        count[ch-'a']-=freq;
        if(count[ch-'a']>0&&!pq.isEmpty())
        {
            char next=pq.poll();
            res.append(next);
            count[next-'a']-=1;
            if(count[next-'a']>0)
            {
                pq.offer(next);
            }
            pq.offer(ch);
        }

     }
     return res.toString();

    }
}
