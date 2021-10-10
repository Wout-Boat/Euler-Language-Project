import time


def isPrime(num: int) -> bool:
    for i in range(2, num):
        if num % i == 0:
            return False
    return True


def problem007():
    count = 2
    i = 4
    while True:
        i += 1
        if (isPrime(i)):
            count += 1
            if count == 10_001:
                break
    print(i)


start = time.time()
problem007()
end = time.time()
print("Function took " + str(end - start))
