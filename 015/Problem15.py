import time


def problem():
    gridSize = 20
    paths = 1
    for i in range(gridSize):
        paths *= (2 * gridSize) - i
        paths /= i + 1
    print(paths)


start = time.time()
problem()
end = time.time()
print("Function took " + str(end - start))
