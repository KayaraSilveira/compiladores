#include<stdio.h>
#include<stdlib.h>
#include <stdbool.h>
int fibonacci(int n
){
int a;
int b;
int fibo;
a=0;
b=1;
while((n>1)){
fibo=(a+b);
a=b;
b=fibo;
n=(n-1);
}
printf("%d", fibo);}int main(){
int n;
n=20;
if((n==1)){printf("%d", 1);}
if((n>1)){fibonacci(n);
}

}