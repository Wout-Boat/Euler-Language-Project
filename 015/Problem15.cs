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

        private static void Problem()
        {
            var gridSize = 20;
            long paths = 1;
            for (var i = 0; i < gridSize; i++)
            {
                paths *= (2 * gridSize) - i;
                paths /= i + 1;
            }
            Console.WriteLine(paths);
        }
    }
}