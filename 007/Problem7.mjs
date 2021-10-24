import { performance } from "perf_hooks";

function SlowPrime(num) {
  for (var i = 2; i < num; i++) {
    if (num % i == 0) {
      return false;
    }
  }
  return true;
}

function problem() {
  var count = 2;
  var i = 4;
  while (true) {
    i++;
    if (SlowPrime(i)) {
      count++;
      if (count == 10_001) {
        break;
      }
    }
  }
  console.log(i);
}

var start = performance.now();
for (var i = 0; i < 100; i++) {
  problem();
}
var end = performance.now();
console.log("Function took " + (end - start) / 1000);
