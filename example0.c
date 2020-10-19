#include <stdio.h>
#include "hash.h"

int main() {
    char* str = "9ams are the worst";

    // print the hash of a string
    printf("michaelsDumbHash(%s)=%d\n",
        str, michaelsDumbHash(str));

    // success
    return 0;
}
