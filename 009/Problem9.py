import time


def problem():
    c, s, found = 0, 1000, False

    for a in range(1, int(s / 3)):
        for b in range(a, int(s / 2)):
            c = s - a - b
            if a * a + b * b == c * c:
                found = True
                break
        if found:
            break
    print(a * b * c)


start = time.time()
for i in range(1000):
    problem()
end = time.time()
print("Function took " + str(end - start))
