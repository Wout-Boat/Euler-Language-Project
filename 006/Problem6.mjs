import { performance } from "perf_hooks";

function SumOfSquares(num) {
  var sum = 0;
  for (var i = 0; i < num + 1; i++) {
    sum += i * i;
  }
  return sum;
}

function SquareOfSum(num) {
  var sum = 0;
  for (var i = 0; i < num + 1; i++) {
    sum += i;
  }
  return sum * sum;
}

function problem() {
  console.log(SquareOfSum(100) - SumOfSquares(100));
}

var start = performance.now();
problem();
var end = performance.now();
console.log("Function took " + (end - start) / 1000);
