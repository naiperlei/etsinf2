#include <stdio.h> 
#define TAM_CADENA 200

main() {
    // Puntero a caracter para copiar las cadenas
    char *p1, *p2;

    // A) Definir las variables cadena y cadena2
    char cadena[TAM_CADENA], cadena2[TAM_CADENA]; 
    // B) Leer cadena de consola 
    scanf("%[^\n]s",cadena);
    // C) Convertir a mayúsculas
    p1 = cadena;
    p2 = cadena2;
    while (*p1 != '\0') {
        //  Copiar p1 a p2 restando 32
        if(*p1 >= 'a' && *p1 <= 'z'){
            *p2 = (*p1)-32;
        } else {
            *p2 = *p1;
        }
        p2++;
        p1++;
    }
    *p2 = '\0';
    // Acordarse de poner el cero final en cadena2
    // D) Sacar por consola la cadena2.
    printf("%s",cadena2);
}

