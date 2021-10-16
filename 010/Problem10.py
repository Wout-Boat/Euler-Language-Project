import time


def SieveOfEratosthenes(n: int):

    # Create a boolean array "prime[0..n]" and initialize
    # all entries it as true. A value in prime[i] will
    # finally be false if i is Not a prime, else true.
    prime = [True for i in range(n + 1)]
    p = 2
    while (p * p <= n):

        # If prime[p] is not changed, then it is a prime
        if (prime[p] == True):

            # Update all multiples of p
            for i in range(p ** 2, n + 1, p):
                prime[i] = False
        p += 1
    prime[0] = False
    prime[1] = False

    return prime


def problem():
    n = 2_000_000
    # Use print("than or equal to", n) for Python 3s
    arr_of_primes = SieveOfEratosthenes(n)

    su = 0
    for p in range(n + 1):
        if arr_of_primes[p]:
            su += p
    print(su)


start = time.time()
problem()
end = time.time()
print("Function took " + str(end - start))
