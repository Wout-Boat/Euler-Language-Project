void main() {
  var numLoops = 1000;
  final stopwatch = Stopwatch()..start();
  for (var i = 0; i < numLoops; i++) {
    problem();
  }
  final elapsedTime = stopwatch.elapsed;
  print(elapsedTime);
}

int reverseInt(n) {
  var newInt = 0;
  while (n != 0) {
    var remainder = (n % 10).floor();
    newInt *= 10;
    newInt += remainder as int;
    n = (n / 10).floor();
  }
  return newInt;
}

void problem() {
  var max = 0;
  var prod;
  for (var i = 100; i < 1000; i++) {
    for (var j = 100; j < 1000; j++) {
      prod = i * j;
      if (prod == reverseInt(prod) && prod > max) {
        max = prod;
      }
    }
  }
  print(max);
}