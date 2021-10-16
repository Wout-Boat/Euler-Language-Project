using System;

namespace EulerProblems
{
    class Program
    {
        private static void Main(string[] args)
        {
            var watch = new System.Diagnostics.Stopwatch();

            watch.Start();
            Problem();
            watch.Stop();

            Console.WriteLine($"Function Took: {watch.Elapsed}");
        }

        private static bool[] Sieve(int n)
        {
            bool[] nums = new bool[n + 1];
            for (var i = 2; i < n + 1; i++)
            {
                nums[i] = true;
            }

            for (var p = 2; p * p <= n; p++)
            {
                if (nums[p])
                {
                    for (var i = p * 2; i <= n; i += p)
                    {
                        nums[i] = false;
                    }
                }
            }
            return nums;
        }
        private static void Problem()
        {
            var n = 2_000_000;
            var arr = Sieve(n);

            long sum = 0;
            for (var i = 1; i < n; i++)
            {
                if (arr[i])
                {
                    sum += i;
                }
            }
            Console.WriteLine(sum);
        }
    }
}