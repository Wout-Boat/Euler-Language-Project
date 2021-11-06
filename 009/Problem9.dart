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
  var a;
  var b;
  var c = 0;
  var s = 1000;
  var found = false;
  for (a = 1; a < (s / 3).floor(); a++) {
    for (b = a; b < (s / 2).floor(); b++) {
      c = (s - a - b).floor();

      if ((a * a) + (b * b) == c * c) {
        found = true;
        break;
      }
    }
    if (found) {
      break;
    }
  }
  print(a * b * c);
}
