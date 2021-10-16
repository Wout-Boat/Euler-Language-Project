import { performance } from "perf_hooks";

var ones = [
  "one",
  "two",
  "three",
  "four",
  "five",
  "six",
  "seven",
  "eight",
  "nine",
];

var teens = [
  "ten",
  "eleven",
  "twelve",
  "thirteen",
  "fourteen",
  "fifteen",
  "sixteen",
  "seventeen",
  "eighteen",
  "nineteen",
];

var tens = [
  "",
  "twenty",
  "thirty",
  "forty",
  "fifty",
  "sixty",
  "seventy",
  "eighty",
  "ninety",
];

function NumToString(num) {
  if (num === 1000) {
    return "OneThousand";
  }

  if (num < 10) {
    return ones[num - 1];
  }

  var output = "";

  if (num >= 100) {
    var hundredsSpot = Math.floor(num / 100);
    var remainder = num % 100;
    output += ones[hundredsSpot - 1] + "Hundred";
    if (remainder === 0) {
      return output;
    }
    output += "And";
    num = remainder;
  } // End Hundreds

  if (num >= 10) {
    if (num < 20) {
      output += teens[num - 10];
      return output;
    }
    var tensSpot = Math.floor(num / 10);
    var remainder = num % 10;
    output += tens[tensSpot - 1];
    if (remainder === 0) {
      return output;
    }
    num = remainder;
  }

  output += ones[num - 1];
  return output;
}

function numberLength(i) {
  return NumToString(i).length;
}

function problem() {
  var sum = 0;
  for (var i = 1; i < 1001; i++) {
    sum += numberLength(i);
  }
  console.log(sum);
}

var start = performance.now();
problem();
var end = performance.now();
console.log("Function took " + (end - start) / 1000);
