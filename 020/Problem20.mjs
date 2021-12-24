import { performance } from "perf_hooks";

function problem() {
  var startNum = 100;

  var prod = BigInt(1);
  for (var i = startNum; i > 1; i--) {
    prod *= BigInt(i);
  }
  const prodStr = prod.toString();
  var sum = 0;
  for (var i = 0; i < prodStr.length; i++) {
    sum += parseInt(prodStr[i]);
  }
  console.log(sum);
}

var start = performance.now();
for (var i = 0; i < 1000; i++) {
  problem();
}
var end = performance.now();
console.log("Function took " + (end - start));
