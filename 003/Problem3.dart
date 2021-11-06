void main() {
  var numLoops = 1000;
  final stopwatch = Stopwatch()..start();
  for (var i = 0; i < numLoops; i++) {
    problem();
  }
  final elapsedTime = stopwatch.elapsed;
  print(elapsedTime);
}

List<int> PrimeFactors(n) {
  List<int> factors = [];
  while (n % 2 == 0) {
    factors.add(2);
    n /= 2;
  }

  for (var i = 3; i * i <= n; i = i + 2) {
    while (n % i == 0) {
      factors.add(i);
      n = (n / i).floor();
    }
  }

  if (n > 2) {
    factors.add(n);
  }
  return factors;
}

int largestFactor(n) {
  List<int> factors = PrimeFactors(n);
  return factors[factors.length - 1];
}

void problem() {
  print(largestFactor(600851475143));
}