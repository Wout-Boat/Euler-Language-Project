import { performance } from "perf_hooks";

function problem() {
  var sum = 0;
  for (let i = 1; i < 1000; i++) {
    if (i % 3 == 0 || i % 5 == 0) {
      sum += i;
    }
  }
  console.log(sum);
}

var start = performance.now();
problem();
var end = performance.now();
console.log("Function took " + (end - start) / 1000);
