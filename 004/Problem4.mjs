import { performance } from "perf_hooks";

function reverse_int(n) {
  var digit,
    result = 0;
  while (n) {
    digit = n % 10;
    result = result * 10 + digit;
    n = (n / 10) | 0;
  }
  return result;
}

function problem() {
  var prod;
  var max = 0;
  for (var i = 100; i < 1000; i++) {
    for (var j = 100; j < 1000; j++) {
      prod = i * j;
      if (prod === reverse_int(prod) && prod > max) {
        max = prod;
      }
    }
  }
  console.log(max);
}

var start = performance.now();
for (var i = 0; i < 1000; i++) {
  problem();
}
var end = performance.now();
console.log("Function took " + (end - start) / 1000);
