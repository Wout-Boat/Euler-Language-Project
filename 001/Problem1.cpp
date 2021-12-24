#include <iostream>
#include <chrono>

using namespace std;

void problem()
{
    int sum = 0;
    for (int i = 0; i < 1000; i++)
    {
        if (i % 3 == 0 || i % 5 == 0)
        {
            sum += i;
        }
    }
    cout << sum << endl;
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
