#include <stdio.h>

int fat(int value);// Função responsavel pelo fatorial

// Função principal
int main(){

   Int n,s,aux,Res; //declarando as variaveis

   printf("numero n"); // aqui é para digitar o numero de n

   printf("numero s"); // aqui para digitar o numero de s

   aux = n!/s!(n-s)! // aqui ta  fazendo o fatorial de n e s

   Res=aux; // aqui pegou o resultado do aux e jogou na variavel res

   if(s>n){         // aparti daqui foi feito as comparações necessarias para cada if

   printf("Erro 1 ");

   }else if(n<0 || s<0){

   printf("Erro 2");

   } else if(n==s){

   printf("Erro 3");

   }else if(n==0 & s==0){

   printf("Erro 4");

   }

}

int fat(int value) {
    if (value < 1) return 0; // Caso value for menor que 1 retornará 0
    int aux = value - 1;

    while(aux > 1) {
        value *= aux--;
    }
    return value;
}
