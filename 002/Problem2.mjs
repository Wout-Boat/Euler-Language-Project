import { performance } from "perf_hooks";

function problem() {
  let a = 1;
  let b = 2;
  let sum = 2;
  let c = 0;

  while (c < 4_000_000) {
    c = a + b;
    if (c % 2 == 0) {
      sum += c;
    }
    a = b;
    b = c;
  }
  console.log(sum);
}

var start = performance.now();
problem();
var end = performance.now();
console.log("Function took " + (end - start) / 1000);
