import { performance } from "perf_hooks";

function problem() {
  var gridSize = 20;
  var paths = 1;
  for (var i = 0; i < gridSize; i++) {
    paths *= 2 * gridSize - i;
    paths /= i + 1;
  }
  console.log(paths);
}

var start = performance.now();
problem();
var end = performance.now();
console.log("Function took " + (end - start) / 1000);
