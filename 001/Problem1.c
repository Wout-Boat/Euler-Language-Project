#include <stdio.h>
#include <time.h>

void problem() {
    int sum = 0;

    for (int i =0; i < 1000; i++) {
        if (i % 3 == 0 || i % 5 == 0) {
            sum += i;
        }
    }

    printf("%d\n", sum);
}

int main() {
    clock_t t;
    t = clock();
    for (int i = 0; i < 10000; i++) {
        problem();
    }
    t = clock() - t;
    double time_taken = ((double) t ) / CLOCKS_PER_SEC;
    printf("Function took %f \n", time_taken);
    return 0;
}
