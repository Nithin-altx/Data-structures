class Solution {
    //Tc=O(m+n*Number of steps)
    //Sc=O(Obstacles.size())
    public int robotSim(int[] commands, int[][] obstacles) {
        HashSet<String> st=new HashSet<>();
        for(int obs[]: obstacles)
        {
            String key=String.valueOf(obs[0])+"_"+String.valueOf(obs[1]);
            st.add(key);
        }
        int []dir={0,1};//Intitially its pointing to North
        int x=0,y=0;
        int maxdistance=0;
        for(int i=0;i<commands.length;i++)
        {
            if(commands[i]==-2)
            {
                dir=new int[]{-dir[1],dir[0]};//Turning left 90 degrees

            }
            else if(commands[i]==-1)
            {
                dir=new int[]{dir[1],-dir[0]};//Turning right 90 degrees

            }
            else{
                for(int steps=0;steps<commands[i];steps++)
                {
                    int newx=x+dir[0];
                    int newy=y+dir[1];
                
                String newkey=String.valueOf(newx)+"_"+String.valueOf(newy);
                //If there is obstacle stop moving in that direction
                if(st.contains(newkey))
                {
                    break;
                }
                //Moving to next Position
                 x=newx;
                 y=newy;
                }
            }
            //Calculating the max distance from origin
            maxdistance=Math.max(maxdistance,x*x+y*y);
           

        }
        return maxdistance;
        
    }
}
