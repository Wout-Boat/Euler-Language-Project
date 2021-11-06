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
  var a = 1;
  var b = 2;
  var sum = 2;
  var c = a + b;

  while (c < 4000000) {
    c = a + b;
    if (c % 2 == 0) {
      sum += c;
    }
    a = b;
    b = c;
  }

  print(sum);
}