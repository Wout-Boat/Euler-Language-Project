using System;
using System.Linq;
using System.Reflection.Metadata.Ecma335;

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

        private static int VertMaxProduct(int[,] grid, int l)
        {
            var max = 0;
            var m = 20;
            var product = 1;
            for (var i = 0; i < l + 1; i++)
            {
                for (var j = 0; j < m; j++)
                {
                    product = 1;
                    for (var k = 1; k < l; k++)
                    {
                        product *= grid[i + k, j];
                    }

                    if (product > max)
                    {
                        max = product;
                    }
                }
            }

            return max;
        }

        private static int HorzMaxProduct(int[,] grid, int l)
        {
            var max = 0;
            var m = 20;
            var product = 1;
            for (var i = 0; i < l + 1; i++)
            {
                for (var j = 0; j < m; j++)
                {
                    product = 1;
                    for (var k = 1; k < l; k++)
                    {
                        product *= grid[j, i + k];
                    }

                    if (product > max)
                    {
                        max = product;
                    }
                }
            }

            return max;
        }

        private static int DiagAProduct(int[,] grid, int l)
        {
            var answer = 0;
            var n = 20;
            var m = 20;
            var product = 1;
            for (var i = 0; i < n - l + 1; i++)
            {
                for (var j = 0; j < m - l + 1; j++)
                {
                    product = 1;
                    for (var k = 0; k < l; k++)
                    {
                        product *= grid[i + k, j + k];
                    }

                    if (product > answer)
                    {
                        answer = product;
                    }
                }
            }
            return answer;
        }

        private static int DiagBProduct(int[,] grid, int l)
        {
            var answer = 0;
            var n = 20;
            var m = 20;
            var product = 1;
            for (var i = l - 1; i < n; i++)
            {
                for (var j = 0; j < m - l + 1; j++)
                {
                    product = 1;
                    for (var k = 0; k < l; k++)
                    {
                        product *= grid[i - k, j + k];
                    }

                    if (product > answer)
                    {
                        answer = product;
                    }
                }
            }

            return answer;
        }
        private static int[,] ReadLines(string path)
        {
            var grid = new int[20, 20];
            var i = 0;
            foreach (var line in System.IO.File.ReadLines(path))
            {
                var j = 0;
                string[] lineSplit = line.Split(" ");
                int[] lineInt = new int[20];
                foreach (var numStr in lineSplit)
                {
                    grid[i, j] = Int32.Parse(numStr);
                    j++;
                }

                i++;
            }

            return grid;
        }
        private static void Problem()
        {
            var grid = ReadLines(@"C:\Users\woutb\RiderProjects\EulerProblems\EulerProblems\grid.txt");
            var max = VertMaxProduct(grid, 4);
            var tmp = HorzMaxProduct(grid, 4);
            if (tmp > max)
            {
                max = tmp;
            }

            tmp = DiagAProduct(grid, 4);
            if (tmp > max)
            {
                max = tmp;
            }
            tmp = DiagBProduct(grid, 4);
            if (tmp > max)
            {
                max = tmp;
            }
            Console.WriteLine(tmp);
        }
    }
}