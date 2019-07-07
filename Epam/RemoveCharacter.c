#include<stdio.h>
#include<string.h>
#include<stdlib.h>

void removechar(char *s,char c){
    int j, n = strlen(s); 
    for (int i=j=0; i<n; i++) 
       if (s[i] != c) 
          s[j++] = s[i]; 
      
    s[j] = '\0'; 
    
}
int main(){
    char s[50],ch[50];
    gets(s);
    gets(ch);
    for (int i = 0; i < strlen(ch); i++)
    {
        /* code */
   removechar(s, ch[i]); 
    }
    
   printf("%s ",s);
   
    
    return 0;
}