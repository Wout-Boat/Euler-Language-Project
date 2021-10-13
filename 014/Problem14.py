import time


def collatzCount(n: int) -> int:
    count = 0
    while n > 1:
        count += 1
        if n % 2 != 0:
            n = 3 * n + 1
        else:
            n = n / 2
    count += 1
    return count


def problem():
    num = 0
    mx = 0
    for i in range(1_000_000):
        tmp = collatzCount(i)
        if tmp > mx:
            mx = tmp
            num = i
    print(num)


start = time.time()
problem()
end = time.time()
print("Function took " + str(end - start))
