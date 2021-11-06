void main() {
  var numLoops = 100000;
  final stopwatch = Stopwatch()..start();
  for (var i = 0; i < numLoops; i++) {
    problem();
  }
  final elapsedTime = stopwatch.elapsed;
  print(elapsedTime);
}

int sumOfSquares(n) {
  var sum = 0;
  for (var num = 1; num <= n; num++) {
    sum += num * num;
  }
  return sum;
}

int squareOfSum(n) {
  var sum = 0;
  for (var num = 1; num <= n; num++) {
    sum += num;
  }
  return sum * sum;
}

void problem() {
  var naturalNum = 100;
  print(squareOfSum(naturalNum) - sumOfSquares(naturalNum));
}