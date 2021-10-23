import time


def problem001():
    su = 0
    for i in range(1, 1000):
        if i % 3 == 0 or i % 5 == 0:
            su += i
    print(su)


start = time.time()
for i in range(1, 10000):
    problem001()

end = time.time()
print("Function took " + str(end - start))
