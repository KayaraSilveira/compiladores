#include<stdio.h>
#include<stdlib.h>
#include <stdbool.h>
int powpow(int n
, int exp
){
int resultado;
resultado=1;
while((exp>0)){
resultado=(resultado*n);
exp=(exp-1);
}
return resultado;}int main(){
int n;
int exp;
int resultado;
n=2;
exp=3;
resultado=powpow(n,exp);
printf("%d", resultado);
}
