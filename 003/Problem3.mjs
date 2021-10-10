import { performance } from "perf_hooks";

function primeFactors(n) {
  var numbers = [];

  // Print the number of 2s that divide n
  while (n % 2 == 0) {
    numbers.push(2);
    n = Math.floor(n / 2);
  }

  // n must be odd at this point.
  // So we can skip one element
  // (Note i = i +2)
  for (let i = 3; i <= Math.floor(Math.sqrt(n)); i = i + 2) {
    // While i divides n, print i
    // and divide n
    while (n % i == 0) {
      numbers.push(i);
      n = Math.floor(n / i);
    }
  }

  // This condition is to handle the
  // case when n is a prime number
  // greater than 2
  if (n > 2) numbers.push(n);

  return numbers[numbers.length - 1];
}

function problem() {
  console.log(primeFactors(600851475143));
}

var start = performance.now();
problem();
var end = performance.now();
console.log("Function took " + (end - start) / 1000);
