import time


def largest_prime_factor(n: int) -> int:
    i = 2
    while i * i <= n:
        if n % i:
            i += 1
        else:
            n //= i
    return n


def problem():
    print(largest_prime_factor(600851475143))


start = time.time()
for i in range(1000):
    problem()
end = time.time()
print("Function took " + str(end - start))
