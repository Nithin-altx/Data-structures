//Brute force
class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m=box.length;
        int n=box[0].length;
        char [][]box2=new char[n][m];
        //Transpose
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                box2[i][j]=box[j][i];
            }
        }
        //rotate 90 degree by reversing the row
        for(int i=0;i<n;i++)
        {
            int size=box2[i].length;
            for(int j=0;j<size/2;j++)
            {
                char temp=box2[i][j];
                box2[i][j]=box2[i][size-j-1];
                box2[i][size-j-1]=temp;
            }
        }
        //actual process;
        for(int j=0;j<m;j++)
        {
            for(int i=n-1;i>=0;i--)
            {
                if(box2[i][j]=='.')
                {
                     int stone=-1;
                    for(int k=i-1;k>=0;k--)
                    {
                        if(box2[k][j]=='*')
                        break;
                        else if(box2[k][j]=='#')
                        {
                            stone=k;
                            break;
                        }
                    }
                    if(stone!=-1){
                    box2[stone][j]='.';
                    box2[i][j]='#';
                    }
                }
            }
        }
        return box2;

    }
}
//Optimal
class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m=box.length;
        int n=box[0].length;
        char [][]box2=new char[n][m];
        //Transpose
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                box2[i][j]=box[j][i];
            }
        }
        //rotate 90 degree by reversing the row
        for(int i=0;i<n;i++)
        {
            int size=box2[i].length;
            for(int j=0;j<size/2;j++)
            {
                char temp=box2[i][j];
                box2[i][j]=box2[i][size-j-1];
                box2[i][size-j-1]=temp;
            }
        }
        //actual process;
     for(int j=0;j<m;j++)
     {
        int space=n-1;
        for(int i=n-1;i>=0;i--)
        { 
            if(box2[i][j]=='*')
            {
                space=i-1;
                continue;
            }
             if(box2[i][j]=='#')
             {
               box2[i][j]='.';
                box2[space][j]='#';
                space--;
             }
        }
     }
        return box2;

    }
}
