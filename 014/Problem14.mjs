import { performance } from "perf_hooks";

function collatzCount(n) {
  var count = 0;
  while (n > 1) {
    count++;
    if (n % 2 != 0) {
      n = 3 * n + 1;
    } else {
      n = n / 2;
    }
  }
  count++;
  return count;
}

function problem() {
  var num = 0;
  var max = 0;
  for (var i = 2; i < 1_000_000; i++) {
    var tmp = collatzCount(i);
    if (tmp > max) {
      max = tmp;
      num = i;
    }
  }
  console.log(num);
}

var start = performance.now();
problem();
var end = performance.now();
console.log("Function took " + (end - start) / 1000);
