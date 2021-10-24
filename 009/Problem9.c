#include <stdio.h>
#include <time.h>
#include <stdbool.h>

void problem() {
    int ans = 0;
    int c = 0;
    int const s = 1000;
    bool found = false;
    for (int a = 1; a < s/3; a++) {
        for (int b = a; b < s/2; b++){
            c = s - a - b;

            if (a * a + b * b == c * c) {
                ans = a * b * c;
                found = true;
                break;
            }
        }
        if (found) {
            break;
        }
    }
    printf("%d\n", ans);
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
