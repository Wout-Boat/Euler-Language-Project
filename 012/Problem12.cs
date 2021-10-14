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

        private static int CountDivisors(int n)
        {
            int count = 0;
            for (int i = 1; i <= Math.Sqrt(n); i++)
            {
                if (n % i == 0)
                {
                    if (n / i == i)
                        count++;

                    else
                        count = count + 2;
                }
            }
            return count;
        }
        private static void Problem()
        {
            var NumDivisors = 500;
            var i = 3;
            while (true)
            {
                var key = i;
                var sum = 0;
                while (i > 0)
                {
                    sum += i;
                    i--;
                }
                if (CountDivisors(sum) > NumDivisors)
                {
                    Console.WriteLine(sum);
                    break;
                }

                i = key + 1;
            }
        }
    }
}