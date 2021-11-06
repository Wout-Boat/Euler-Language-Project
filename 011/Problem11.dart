import 'dart:io';

void main() {
  var numLoops = 1000;
  final stopwatch = Stopwatch()..start();
  for (var i = 0; i < numLoops; i++) {
    problem();
  }
  final elapsedTime = stopwatch.elapsed;
  print(elapsedTime);
}

List<String> readLines() {
  // Gets the lines of the grid.txt and returns them as a string list.
  var arr = new List.filled(20, "", growable: false);
  final file = File('grid.txt');
  List<String> lines = file.readAsLinesSync();
  lines.asMap().forEach((key, value) { arr[key] = value; });
  return arr;
}

List<int> lineToIntArr(line) {
  // Returns a single line of file as int array.
  var strArr = line.split(" ");
  var arr = new List.filled(20, 1, growable: false);
  strArr.asMap().forEach((key, value) {
    arr[key] = int.parse(strArr[key].toString());
  });
  return arr;
}

int vertMaxProduct(List<List<int>> grid, int L) {
  var max = 0;
  const m = 20;
  for (var i = 0; i < L + 1; i++) {
    for (var j = 0; j < m; j++) {
      var product = 1;
      for (var k = 1; k < L; k++) {
        product *= grid[i + k][j];
      }
      if (product > max) {
        max = product;
      }
    }
  }
  return max;
}

int hozMaxProduct(List<List<int>> grid, int L) {
  var max = 0;
  const n = 20;
  const m = 20;
  var product = 1;
  for (var i = 0; i < n; i++) {
    for (var j = 0; j < m - L + 1; j++) {
      product = 1;
      var subset = grid[i].sublist(j, j + L);
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

int diagAProduct(List<List<int>> grid, int L) {
  var answer = 0;
  const n = 20;
  const m = 20;
  var product = 1;
  for (var i = 0; i < n - L + 1; i++) {
    for (var j = 0; j < m - L + 1; j++) {
      product = 1;
      for (var k = 0; k < L; k++) {
        product *= grid[i + k][j + k];
      }
      if (product > answer) {
        answer = product;
      }
    }
  }
  return answer;
}

int diagBProduct(List<List<int>> grid, int L) {
  var answer = 0;
  const n = 20;
  const m = 20;
  var product = 1;
  for (var i = L - 1; i < n; i++) {
    for (var j = 0; j < m - L + 1; j++) {
      product = 1;
      for (var k = 0; k < L; k++) {
        product *= grid[i - k][j + k];
      }
      if (product > answer) {
        answer = product;
      }
    }
  }
  return answer;
}

void problem() {
  const gridSize = 20;
  const L = 4;
  var grid = List.generate(gridSize, (index) => List.filled(gridSize, 0, growable: false), growable: false);
  var lines = readLines();

  for (var i = 0; i < 20; i++) {
    grid[i] = lineToIntArr(lines[i]);
  }

  var max = hozMaxProduct(grid, L);
  var tmp = vertMaxProduct(grid, L);
  if (tmp > max) {
    max = tmp;
  }
  tmp = diagAProduct(grid, L);
  if (tmp > max) {
    max = tmp;
  }
  tmp = diagBProduct(grid, L);
  if (tmp > max) {
    max = tmp;
  }
  print(max);
}
