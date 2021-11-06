void main() {
  var numLoops = 10;
  final stopwatch = Stopwatch()..start();
  for (var i = 0; i < numLoops; i++) {
    problem();
  }
  final elapsedTime = stopwatch.elapsed;
  print(elapsedTime);
}

bool isPrime(num) {
  for (var i = 2; i < num; i++) {
    if (num % i == 0) {
      return false;
    }
  }
  return true;
}

void problem() {
  var count = 2;
  var i = 4;
  while (true) {
    i++;
    if (isPrime(i)) {
      count++;
      if (count == 10001) {
        break;
      }
    }
  }
  print(i);
}