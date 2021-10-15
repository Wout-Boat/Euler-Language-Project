using System;
using System.Numerics;

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

        private static void Problem()
        {
            var two = new BigInteger(2);
            var sum = 0;
            var number = BigInteger.Pow(two, 1000);
            var numStr = number.ToString();
            for (var i = 0; i < numStr.Length; i++)
            {
                sum += int.Parse(Convert.ToString(numStr[i]));
            }
            Console.WriteLine(sum);
        }
    }
}