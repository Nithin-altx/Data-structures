class CustomStack {
   int maxsize;
   int topidx;
  int stack[];
    public CustomStack(int maxSize) {
        this.maxsize=maxSize;
        this.topidx=-1;
  stack=new int[maxsize];
    }
 
    public void push(int x) {
        if(topidx==-1)
        {
            stack[++topidx]=x;
        }   
        else if(topidx!=maxsize-1) 
        {
            stack[++topidx]=x;

        }    
        
    }
    
    public int pop() {
        int ele=0;
       if(topidx!=-1){
         ele=stack[topidx];
        topidx--;
         return ele;
       }
       return -1;
      

        
    }
    
    public void increment(int k, int val) {
         int limit = Math.min(k, topidx + 1);
        for (int i = 0; i < limit; i++) {
            stack[i] += val;
        }
        
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
