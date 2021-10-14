using System;
using System.ComponentModel.DataAnnotations;

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

        private static long CollatzCount(int n)
        {
            long count = 0;
            while (n > 1)
            {
                count++;
                if (n % 2 != 0)
                {
                    n = 3 * n + 1;
                }
                else
                {
                    n = n / 2;
                }
            }

            count++;
            return count;
        }
        private static void Problem()
        {
            var num = 0;
            long max = 0;
            for (var i = 2; i < 1_000_000; i++)
            {
                var tmp = CollatzCount(i);
                if (tmp > max)
                {
                    max = tmp;
                    num = i;
                }
            }
            Console.WriteLine(num);
        }
    }
}