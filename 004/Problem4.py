import time


def reverse_int(n: int) -> int:
    new_int = 0
    while n != 0:
        remainder = n % 10
        new_int = (new_int * 10) + remainder
        n = n // 10
    return new_int


def problem():
    mx = 0

    for i in range(100, 1000):
        for j in range(100, 1000):
            prod = i * j
            if prod == reverse_int(prod) and prod > mx:
                mx = prod
    print(mx)


start = time.time()
for i in range(1000):
    problem()
end = time.time()
print("Function took " + str(end - start))
