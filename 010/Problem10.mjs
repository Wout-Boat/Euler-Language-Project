import { performance } from "perf_hooks";

function Sieve(n) {
  var nums = new Array(n + 1).fill(true);

  for (var p = 2; p * p <= n; p++) {
    if (nums[p]) {
      for (var i = p * 2; i <= n; i += p) {
        nums[i] = false;
      }
    }
  }

  return nums;
}

function problem() {
  var n = 2_000_000;
  var arr = Sieve(n);

  var sum = 0;
  for (var i = 2; i < n; i++) {
    if (arr[i]) {
      sum += i;
    }
  }
  console.log(sum);
}

var start = performance.now();
for (var i = 0; i < 1000; i++) {
  problem();
}
var end = performance.now();
console.log("Function took " + (end - start) / 1000);
