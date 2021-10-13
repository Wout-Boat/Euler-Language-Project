import { performance } from "perf_hooks";

function problem() {
  var two = BigInt(2n);
  var thousand = BigInt(1000n);
  var number = two ** thousand;
  var numStr = number.toString();
  var sum = 0;
  for (var i = 0; i < numStr.length; i++) {
    sum += parseInt(numStr[i]);
  }
  console.log(sum);
}

var start = performance.now();
problem();
var end = performance.now();
console.log("Function took " + (end - start) / 1000);
