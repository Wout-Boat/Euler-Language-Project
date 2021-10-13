import time


def problem():
    num = 2 ** 1000
    sum = 0
    for digit in str(num):
        sum += int(digit)
    print(sum)


start = time.time()
problem()
end = time.time()
print("Function took " + str(end - start))
