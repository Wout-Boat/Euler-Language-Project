#include <iostream>
#include <chrono>

using namespace std;

void problem()
{
    int a = 1;
    int b = 1;
    int sum = 2;
    int c = a + b;
    while (c < 4000000)
    {
        c = a + b;
        if (c % 2 == 0)
        {
            sum += c;
        }
        a = b;
        b = c;
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
