class NumberContainers {
Map<Integer,Integer> mp=new HashMap<>();
Map<Integer,TreeSet<Integer>> st=new HashMap<>();
    public NumberContainers() {
        
    }
    
    public void change(int index, int number) {
      if(mp.containsKey(index))
      {
        int oldnum=mp.get(index);
        if(st.containsKey(oldnum)){
        st.get(oldnum).remove(index);
        if(st.get(oldnum).isEmpty())
        {
            st.remove(oldnum);
        } 
        }
      }
        mp.put(index,number);
      st.computeIfAbsent(number, k -> new TreeSet<>()).add(index);
    }
    
    public int find(int number) {
       
return st.containsKey(number) && st.get(number) != null && !st.get(number).isEmpty() 
       ? st.get(number).first() 
       : -1;
               
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */
//Approach 2 using min heap
class NumberContainers {
Map<Integer,Integer> mp=new HashMap<>();
Map<Integer,PriorityQueue<Integer>> st=new HashMap<>();
    public NumberContainers() {
        
    }
    
    public void change(int index, int number) {
        mp.put(index,number);
      st.computeIfAbsent(number, k -> new PriorityQueue<>()).offer(index);
    }
    
    public int find(int number) {
        if(!st.containsKey(number))
        return -1;
        
        PriorityQueue<Integer> pq=st.get(number);
        while(!pq.isEmpty())
        {
            int idx=pq.peek();
            if(mp.get(idx)==number)
            return idx;

            pq.poll();
        }
        return -1;

       

               
    }
}
