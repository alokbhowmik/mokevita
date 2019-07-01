// one robort wants to move through a mXn gird 
// 1>it start from (0,0) to (m-1,n-1)
// It can go down or right of the curve 
// Now you have to find that how many possible way of reaching (m-1,n-1)


// -----------------------------------CODE--------------------------

#include<stdio.h>
int total_ways(int i,int j,int m,int n){
    if (i>m-1 || j>n-1)
    {
        return 0;
    }else if (i==m-1 && j== n-1)
    {
        return 1;
    }else
    {
        total_ways(i,j+1,m,n)+ total_ways(i+1,j,m,n);
    }
    
    
    
}
int main()
{
    printf("%d",total_ways(0,0,3,3));
    return 0;
}
