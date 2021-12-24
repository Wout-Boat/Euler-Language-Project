#include <iostream>
#include <chrono>

using namespace std;

int sumOfSquares(int num)
{
    int sum = 0;
    while (num > 0)
    {
        sum += num * num;
        num--;
    }
    return sum;
}

int squareOfSum(int num)
{
    int sum = 0;
    while (num > 0)
    {
        sum += num;
        num--;
    }
    return sum * sum;
}

void problem()
{
    int naturalNum = 100;
    cout << squareOfSum(naturalNum) - sumOfSquares(naturalNum) << endl;
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
