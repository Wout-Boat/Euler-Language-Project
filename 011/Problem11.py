import time


def vertMaxProduct(grid, l):
    mx = 0
    m = 20
    product = 1
    for i in range(l + 1):
        for j in range(m):
            product = 1
            for k in range(1, l):
                product *= grid[i+k][j]
            if product > mx:
                mx = product

    return mx


def horzMaxProduct(grid, l):
    mx = 0
    n = 20
    m = 20
    product = 1
    for i in range(n):
        for j in range(n - l + 1):
            product = 1
            subset = grid[i][j: j+l]
            for k in range(1, len(subset)):
                product *= subset[k]
            if product > mx:
                mx = product
    return mx


def diagAProduct(grid, l):
    answer = 0
    n = 20
    m = 20
    product = 1
    for i in range(n - l + 1):
        for j in range(m - l + 1):
            product = 1
            for k in range(l):
                product *= grid[i+k][j+k]
            if product > answer:
                answer = product
    return answer


def diagBProduct(grid, l):
    answer = 0
    n = 20
    m = 20
    product = 1
    for i in range(l - 1, n):
        for j in range(m - l + 1):
            product = 1
            for k in range(l):
                product *= grid[i-k][j+k]
            if product > answer:
                answer = product
    return answer


def problem():
    with open('grid.txt', 'r') as f:
        lines = f.readlines()
    f.close()
    grid = []
    for line in lines:
        small_arr = []
        line_split = line.split()
        for num in line_split:
            small_arr.append(int(num))
        grid.append(small_arr)
    final_answer = max(vertMaxProduct(grid, 4), horzMaxProduct(
        grid, 4), diagAProduct(grid, 4), diagBProduct(grid, 4))
    print(final_answer)


start = time.time()
problem()
end = time.time()
print("Function took " + str(end - start))
