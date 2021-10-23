#include <stdio.h>
#include <time.h>

void problem() {
    int a = 1;
    int b = 2;
    int sum = 2;
    int c = 1;

    while (c < 4000000) {
        c = a + b;
        if (c % 2 == 0) {
            sum += c;
        }

        a = b;
        b = c;
    }

    printf("%d\n", sum);
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
