#include <stdio.h>
#include <time.h>

long long largestPrimeFactor(long long n) {
    long long i = 2;
    while (i * i <= n) {
        if (n % i) {
            i += 1;
        } else {
            n /= i;
        }
    }
    return n;
}

void problem() {
    long long ans = largestPrimeFactor(600851475143);
    printf("%lld\n", ans);
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
