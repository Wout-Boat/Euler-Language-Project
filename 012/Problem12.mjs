import { performance } from "perf_hooks";

const countDivisors = (num = 1) => {
  if (num === 1) return num;
  let divArr = [[2, 0]];
  let div = divArr[0][0];
  while (num > 1) {
    if (num % div === 0) {
      for (let i = 0; divArr.length; i++) {
        if (divArr[i][0] === div) {
          divArr[i][1] += 1;
          break;
        } else {
          if (i === divArr.length - 1) {
            divArr.push([div, 1]);
            break;
          }
        }
      }
      num /= div;
    } else {
      div += 1;
    }
  }
  for (let i = 0; i < divArr.length; i++) {
    num *= divArr[i][1] + 1;
  }
  return num;
};

function problem() {
  const numDivisors = 500;
  var i = 3;
  while (true) {
    var key = i;
    var sum = 0;
    while (i > 0) {
      sum += i;
      i--;
    }
    if (countDivisors(sum) > numDivisors) {
      console.log(sum);
      break;
    }
    i = key + 1;
  }
}

var start = performance.now();
problem();
var end = performance.now();
console.log("Function took " + (end - start) / 1000);
