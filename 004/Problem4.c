#include <stdio.h>
#include <time.h>

int reverseInt(int n) {
    int newInt = 0;
    while (n != 0) {
        int remainder = n % 10;
        newInt *= 10;
        newInt += remainder;
        n /= 10;
    }
    return newInt;
}

void problem() {
    int max = 0;
    int prod;
    for (int i = 100; i < 1000; i++) {
        for (int j = 100; j < 1000; j++) {
            prod = i * j;
            if (prod == reverseInt(prod) && prod > max) {
                max = prod;
            }
        }
    }
    printf("%d\n", max);
}

int main() {
    clock_t t;
    t = clock();
    for (int i = 0; i < 1000; i++) {
        problem();
    }
    t = clock() - t;
    double time_taken = ((double) t ) / CLOCKS_PER_SEC;
    printf("Function took %f \n", time_taken);
    return 0;
}
