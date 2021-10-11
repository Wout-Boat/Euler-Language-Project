import { performance } from "perf_hooks";
import * as fs from "fs";
import * as readLine from "readline";

var lines = [];
var start;
var end;

function processLineByLine() {
  var lineReader = readLine.createInterface({
    input: fs.createReadStream("grid.txt"),
  });

  lineReader.on("line", function (line) {
    lines.push(line);
  });

  lineReader.on("close", function () {
    haveLinesInArr();
  });
}

function haveLinesInArr() {
  var nums = [];
  var lineList = [];
  var tmpArr = [];
  for (const line of lines) {
    lineList = line.split(" ");
    for (var i = 0; i < 20; i++) {
      tmpArr.push(parseInt(lineList[i]));
    }
    nums.push(tmpArr);
    tmpArr = [];
  }

  var max = vertMaxProduct(nums, 4);
  var tmp = horzMaxProduct(nums, 4);
  if (tmp > max) {
    max = tmp;
  }
  tmp = diagAProduct(nums, 4);
  if (tmp > max) {
    max = tmp;
  }
  tmp = diagBProduct(nums, 4);
  if (tmp > max) {
    max = tmp;
  }
  console.log(tmp);
  lastFunction();
}

function lastFunction() {
  end = performance.now();
  console.log("Function took " + (end - start) / 1000);
}

function vertMaxProduct(grid, l) {
  var max = 0;
  var m = 20;
  var product = 1;
  for (var i = 0; i < l + 1; i++) {
    for (var j = 0; j < m; j++) {
      product = 1;
      for (var k = 1; k < l; k++) {
        product *= grid[i + k][j];
      }
      if (product > max) {
        max = product;
      }
    }
  }
  return max;
}

function horzMaxProduct(grid, l) {
  var max = 0;
  var n = 20;
  var m = 20;
  var product = 1;
  for (var i = 0; i < n; i++) {
    for (var j = 0; j < m - l + 1; j++) {
      product = 1;
      var subset = grid[i].slice(j, j + l);
      for (var k = 1; k < subset.length; k++) {
        product *= subset[k];
      }
      if (product > max) {
        max = product;
      }
    }
  }
  return max;
}

function diagAProduct(grid, l) {
  var answer = 0;
  var n = 20;
  var m = 20;
  var product = 1;
  for (var i = 0; i < n - l + 1; i++) {
    for (var j = 0; j < m - l + 1; j++) {
      product = 1;
      for (var k = 0; k < l; k++) {
        product *= grid[i + k][j + k];
      }
      if (product > answer) {
        answer = product;
      }
    }
  }
  return answer;
}

function diagBProduct(grid, l) {
  var answer = 0;
  var n = 20;
  var m = 20;
  var product = 1;
  for (var i = l - 1; i < n; i++) {
    for (var j = 0; j < m - l + 1; j++) {
      product = 1;
      for (var k = 0; k < l; k++) {
        product *= grid[i - k][j + k];
      }
      if (product > answer) {
        answer = product;
      }
    }
  }
  return answer;
}

function problem() {
  performance.mark("start");
  var lines = processLineByLine();
}

start = performance.now();
problem();
