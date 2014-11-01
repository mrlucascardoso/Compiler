#include <stdio.h>

int fat(int value);// Função responsavel pelo fatorial

// Função principal
int main(){
    int n, s, RES;                 // declarando as variaveis
    scanf("%d", &n);               // lendo variavel n
    scanf("%d", &s);               // lendo variavel s
    if(  n < 0 || s < 0 ) {        // caso n e/ou s seja menor que zero
        printf("exit(%d)\n", 2);   // emite erro 2
        return 2;
    } if( n == 0 || s == 0) {      // caso n e/ou s seja igual a zero
        printf("exit(%d)\n", 4);   // emite erro 4
        return 4;
    } if( s > n ) {                // caso s  seja maior que n
        printf("exit(%d)\n", 1);   // emite erro 1
        return 1;
    } if( n == s ) {               // caso n for igual a s
        printf("exit(%d)\n", 3);   // emite erro 3
        return 3;
    }


    printf("exit(%d)\n", 0);
    return 0;
}

int fat(int value) {
    if (value < 1) return 0;     // caso value for menor que 1 retornará 0
    int aux = value - 1;

    while(aux > 1) {
        value *= aux--;
    }
    return value;
}
