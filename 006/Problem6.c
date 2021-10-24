#include <stdio.h>
#include <time.h>

int sumOfSquares(int num) {
    int sum = 0;
    while (num > 0) {
        sum += num * num;
        num--;
    }
    return sum;
}

int squareOfSum(int num) {
    int sum = 0;
    while (num > 0) {
        sum += num;
        num--;
    }
    return sum * sum;
}

void problem() {
    static int naturalNum = 100;
    int ans = squareOfSum(naturalNum) - sumOfSquares(naturalNum);
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
