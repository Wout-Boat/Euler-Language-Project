import time


def problem001():
    a = 1
    b = 2
    su = 2
    c = 0

    while c < 4_000_000:
        c = a + b
        if c % 2 == 0:
            su += c
        a = b
        b = c
    print(su)


start = time.time()
for i in range(1000):
    problem001()
end = time.time()
print("Function took " + str(end - start))
