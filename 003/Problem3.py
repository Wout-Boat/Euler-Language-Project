import time


def largest_prime_factor(n: int) -> int:
    i = 2
    while i * i <= n:
        if n % i:
            i += 1
        else:
            n //= i
    return n


def problem003():
    print(largest_prime_factor(600851475143))


start = time.time()
problem003()
end = time.time()
print("Function took " + str(end - start))
