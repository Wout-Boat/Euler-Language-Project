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

        private static int SumOfSquares(int num)
        {
            var sum = 0;
            while (num > 0)
            {
                sum += num * num;
                num--;
            }
            return sum;
        }

        private static int SquareOfSum(int num)
        {
            var sum = 0;
            while (num > 0)
            {
                sum += num;
                num--;
            }

            return sum * sum;
        }
        private static void Problem()
        {
            const int naturalNum = 100;
            Console.WriteLine(SquareOfSum(naturalNum) - SumOfSquares(naturalNum));
        }
    }
}