#include <stdio.h>
#include <time.h>
#include <stdbool.h>

bool isPrime(int num) {
    for (int i = 2; i < num; i++) {
        if (num % i == 0) {
            return false;
        }
    }
    return true;
}

void problem() {
    int count = 2;
    int i = 4;
    for (;;) {
        i += 1;
        if (isPrime(i)) {
            count += 1;
            if (count == 10001) {
                break;
            }
        }
    }
    printf("%d\n", i);
}

int main() {
    clock_t t;
    t = clock();
    for (int i = 0; i < 100; i++) {
        problem();
    }
    t = clock() - t;
    double time_taken = ((double) t ) / CLOCKS_PER_SEC;
    printf("Function took %f \n", time_taken);
    return 0;
}
