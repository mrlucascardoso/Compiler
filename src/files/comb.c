#include <stdio.h>

long int fat(int long value);               // Função responsavel pelo fatorial

// Função principal
int main(){
    long int n, s, RES;                     // declarando as variaveis
    scanf("%ld", &n);                       // lendo variavel n
    scanf("%ld", &s);                       // lendo variavel s
    if(  n < 0 || s < 0 ) {                 // caso n e/ou s seja menor que zero
        printf("exit(%d)\n", 2);            // emite erro 2
        return 2;
    } if( n == 0 || s == 0) {               // caso n e/ou s seja igual a zero
        printf("exit(%d)\n", 4);            // emite erro 4
        return 4;
    } if( s > n ) {                         // caso s  seja maior que n
        printf("exit(%d)\n", 1);            // emite erro 1
        return 1;
    } if( n == s ) {                        // caso n for igual a s
        printf("exit(%d)\n", 3);            // emite erro 3
        return 3;
    }

    RES = fat(n) / fat(s) * fat( n - s);    // calculando combinacao
    printf("RES: %ld\n", RES);              // imprimindo combinacao

    printf("exit(%d)\n", 0);
    return 0;
}

long int fat(long int value) {
    if (value == 0) return 1;               // caso value for 0 por definicao retornara 1
    if (value < 0) return -1;                // caso value for negativo retornara -1 pois nao existe
    long int aux = value - 1;

    while(aux > 1) {
        value *= aux--;
    }
    return value;
}
