import java.util.*;

public class quicksort {
    //Time Complexity=O(N*logn)
    //Space Complexity=O(1)
    void swap(int a[],int i,int j)
    {
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
    int partition(int a[],int l,int h)
    {
        int pivot=a[l];
        int i=l,j=h;
        while(i<j)
        {
            while(a[i]<=a[j]&&i<j)//finding element greater than pivot
            {
                i++;
            }
            while(a[j]>a[i]&&j>=i)//finding element less tha pivot
            {
                j--;
            }
            if(i<j)
            swap(a,i,j);//swaping Ith and Jth element if i doesn't excced j

        }
        swap(a,i,j);//swaping Ith and Jth element if i excced j
        return j; //returning the correct position the pivot element
    }
 
    void quickSort(int a[],int l,int h)
    {
        if(l<h)
        {
            int p=partition(a,l,h);//finding the partition element
            quickSort(a, l, p-1);//soting the left half
            quickSort(a, p+1, h);//sorting the right half
        }
        
    }

    
}
class Sorting{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of array:");
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++)
        {
            a[i]=sc.nextInt();//enter the input array
        }
        quicksort qs=new quicksort();
        qs.quickSort(a, 0, n-1);//calling the QUICKSORT function
        //4 6 2 5 7 9 1
//Array after Sorting
//1 2 4 5 6 7 9
        System.out.println("Array after Sorting");
        for(int i=0;i<n;i++)
        {
            System.out.print(a[i]+" ");
        }



    }
}
