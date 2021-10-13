import { performance } from "perf_hooks";
import * as fs from "fs";
import * as readLine from "readline";

var lines = [];
var start;
var end;

function processLineByLine() {
  var lineReader = readLine.createInterface({
    input: fs.createReadStream("numbers.txt"),
  });

  lineReader.on("line", function (line) {
    lines.push(line);
  });

  lineReader.on("close", function () {
    haveLinesInArr();
  });
}

function haveLinesInArr() {
  var num = 0;
  for (var i = 0; i < lines.length; i++) {
    num += parseInt(lines[i]);
  }
  var numString = num.toString();
  var output = "";
  for (var i = 0; i < 11; i++) {
    output += numString[i];
  }
  output = output.replace(".", "");
  console.log(output);
  lastFunction();
}

function lastFunction() {
  end = performance.now();
  console.log("Function took " + (end - start) / 1000);
}

function problem() {
  performance.mark("start");
  var lines = processLineByLine();
}

start = performance.now();
problem();
