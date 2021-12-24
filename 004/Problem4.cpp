#include <iostream>
#include <chrono>

using namespace std;

int reverseInt(int n)
{
    int newInt = 0;
    while (n != 0)
    {
        int remainder = n % 10;
        newInt *= 10;
        newInt += remainder;
        n /= 10;
    }
    return newInt;
}

void problem()
{
    int max = 0;
    int prod = 1;
    for (int i = 0; i < 1000; i++)
    {
        for (int j = 0; j < 1000; j++)
        {
            prod = i * j;
            if (prod == reverseInt(prod) && prod > max)
            {
                max = prod;
            }
        }
    }
    cout << max << endl;
}

int main()
{
    auto num_loops = 1000;
    auto start = chrono::high_resolution_clock::now();
    for (int i = 0; i < num_loops; i++)
    {
        problem();
    }
    auto stop = chrono::high_resolution_clock::now();
    auto duration = chrono::duration_cast<chrono::microseconds>(stop - start) / num_loops;
    cout << duration.count() << endl;
    return 0;
}
