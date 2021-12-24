import { performance } from "perf_hooks";

// This function returns the number of Sundays on the first of the month.
function countSundays(date1, date2) {
  var date = date1;
  var count = 0;
  while (date <= date2) {
    if (date.getDay() === 0 && date.getDate() === 1) {
      count++;
    }
    date.setDate(date.getDate() + 1);
  }
  return count;
}

function problem() {
  const start = new Date(1901, 0, 1);
  const end = new Date(2000, 11, 31);
  console.log(countSundays(start, end));
}

var start = performance.now();
problem();
var end = performance.now();
console.log("Function took " + (end - start) / 1000);
