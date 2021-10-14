using System;

namespace EulerProblems
{
    class Program
    {
        static void Main(string[] args)
        {
            var watch = new System.Diagnostics.Stopwatch();

            watch.Start();
            Problem();
            watch.Stop();

            Console.WriteLine($"Function Took: {watch.Elapsed}");
        }

        private static bool SlowPrime(int num)
        {
            for (var i = 2; i < num; i++)
            {
                if (num % i == 0)
                {
                    return false;
                }
            }
            return true;
        }
        private static void Problem()
        {
            var count = 2;
            var i = 4;
            while (true)
            {
                i++;
                if (SlowPrime(i))
                {
                    count++;
                    if (count == 10_001)
                    {
                        break;
                    }
                }
            }
            Console.WriteLine(i);
        }
    }
}