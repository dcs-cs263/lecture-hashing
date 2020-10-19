
char michaelsDumbHash(char* str) {
    char result = 0;

    // assume a NULL-terminated string; loop through
    // all characters in the string
    while(*str != '\0') {
        // add the numeric value of the character to
        // the result mod 20
        result = (result + *str) % 20;

        // advance pointer
        str++;
    }

    // return a number between 0 and 19
    return result;
}
