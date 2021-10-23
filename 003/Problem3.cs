using System;

namespace EulerProblems
{
    class Program
    {
        static void Main(string[] args)
        {
            var watch = new System.Diagnostics.Stopwatch();

            watch.Start();
            for (var i = 0; i < 1000; i++)
            {
                Problem();
            }
            watch.Stop();

            Console.WriteLine($"Function Took: {watch.Elapsed}");
        }

        static private long MaxFactor(long n)
        {
            long k = 2;
            while (k * k <= n)
            {
                if (n % k == 0)
                {
                    n /= k;
                }
                else
                {
                    ++k;
                }
            }

            return n;
        }

        static void Problem()
        {
            Console.WriteLine(MaxFactor(600851475143));
        }
    }
}