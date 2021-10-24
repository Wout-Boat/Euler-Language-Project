import time


def SumOfSquares(num: int) -> int:
    su = 0
    for i in range(0, num + 1):
        su += i * i
    return su


def SquareOfSum(num: int) -> int:
    su = 0
    for i in range(0, num + 1):
        su += i
    return su * su


def problem():
    print(SquareOfSum(100) - SumOfSquares(100))


start = time.time()
for i in range(1000):
    problem()
end = time.time()
print("Function took " + str(end - start))
