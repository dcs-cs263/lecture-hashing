#include <stdio.h>

char michaelsDumbHash(char* str) {
    char result = 0;

    // assume a NULL-terminated string; loop through
    // all characters in the string
    while(*str++ != '\0') {
        // add the numeric value of the character to
        // the result mod 20
        result = (result + *str) % 20;
    }

    // return a number between 0 and 19
    return result;
}

int main() {
    char* str = "I hate Thursdays";

    // print the hash of a string
    printf("michaelsDumbHash(%s)=%d\n",
        str, michaelsDumbHash(str));

    // success
    return 0;
}
