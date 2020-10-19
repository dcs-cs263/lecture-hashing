#include <stdio.h>
#include <stdlib.h>
#include "hash.h"

typedef struct DatabaseEntry {
    int hash;
} DatabaseEntry;

DatabaseEntry entry;

void init_user(const char* password) {
    entry.hash = michaelsDumbHash(password);
}

int main() {
    char* str = "9ams are the worst";

    init_user(str);

    while(1) {
        char *line = NULL;
        size_t size = 0;
        ssize_t len = 0;

        printf("Password: ");

        len = getline(&line, &size, stdin);
        line[len-1] = '\0';

        if(michaelsDumbHash(line) == entry.hash) {
            printf("Authentication successful!\n");
            exit(0);
        }
        else {
            printf("Authentication failed :(\n");
        }

        free(line);
    }

    // success
    return 0;
}