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

        private static int ReverseInt(int n)
        {
            var newInt = 0;
            while (n != 0)
            {
                var remainder = n % 10;
                newInt *= 10;
                newInt += remainder;
                n /= 10;
            }
            return newInt;
        }


        private static void Problem()
        {
            int max = 0;
            int prod;
            for (int i = 100; i < 1000; i++)
            {
                for (int j = 100; j < 1000; j++)
                {
                    prod = i * j;
                    if (prod == ReverseInt(prod) && prod > max)
                    {
                        max = prod;
                    }
                }
            }
            Console.WriteLine(max);
        }
    }
}