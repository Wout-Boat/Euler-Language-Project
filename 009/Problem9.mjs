import { performance } from "perf_hooks";

function problem() {
  var a, b;
  var c = 0;
  var s = 1000;
  var found = false;
  for (a = 1; a < s / 3; a++) {
    for (b = a; b < s / 2; b++) {
      c = s - a - b;
      if (a * a + b * b === c * c) {
        found = true;
        break;
      }
    }
    if (found) {
      break;
    }
  }
  console.log(a * b * c);
}

var start = performance.now();
for (var i = 0; i < 1000; i++) {
  problem();
}
var end = performance.now();
console.log("Function took " + (end - start) / 1000);
