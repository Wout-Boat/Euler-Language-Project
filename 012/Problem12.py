import time
import math


def countDivisors(n):
    count = 0
    for i in range(1, int(math.sqrt(n))):
        if n % i == 0:
            if n / i == i:
                count += 1
            else:
                count = count + 2
    return count


def problem():
    numDivisors = 500
    i = 3
    while True:
        key = i
        su = 0
        while i > 0:
            su += i
            i -= 1
        if countDivisors(su) > numDivisors:
            print(su)
            break
        i = key + 1


start = time.time()
problem()
end = time.time()
print("Function took " + str(end - start))
