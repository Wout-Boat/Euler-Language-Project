void main() {
  var numLoops = 1000;
  final stopwatch = Stopwatch()..start();
  for (var i = 0; i < numLoops; i++) {
    problem();
  }
  final elapsedTime = stopwatch.elapsed;
  print(elapsedTime);
}

void problem() {
  var startNum = 100;

  var prod = BigInt.from(1);
  while (startNum > 1) {
    prod *= BigInt.from(startNum);
    startNum--;
  }

  var numString = prod.toString();
  var sum = 0;
  for (var i = 0; i < numString.length; i++) {
    sum += int.parse(numString[i]);
  }
  print(sum);
}
