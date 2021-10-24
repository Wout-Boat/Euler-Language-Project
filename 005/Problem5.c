#include <stdio.h>
#include <time.h>

void problem() {
    int num = 3000;
    for(; ;) {
        if (num % 2 == 0) {
            if (num % 3 == 0) {
                if (num % 4 == 0) {
                    if (num % 5 == 0) {
                        if (num % 6 == 0) {
                            if (num % 7 == 0) {
                                if (num % 8 == 0) {
                                    if (num % 9 == 0) {
                                        if (num % 10 == 0) {
                                            if (num % 11 == 0) {
                                                if (num % 12 == 0) {
                                                    if (num % 13 == 0) {
                                                        if (num % 14 == 0) {
                                                            if (num % 15 == 0) {
                                                                if (num % 16 == 0) {
                                                                    if (num % 17 == 0) {
                                                                        if (num % 18 == 0) {
                                                                            if (num % 19 == 0) {
                                                                                if (num % 20 == 0) {
                                                                                    break;
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        num += 20;
    }
    printf("%d\n", num);
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
