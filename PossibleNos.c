#include<stdio.h>
int possible(int num,int i,int n){
    int rem ;
    rem = num%10;
    if (i%n==0)
    {
        printf("%d\n",num);
    }
    // printf("%d\n",num);
    else
    {
        possible(rem*10+num/10,i+1,n);
        possible(num,i+1,n);
        /* code */
    }
    
}
int main(){
    possible(123,0,2);
}