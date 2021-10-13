import time


def problem():
    with open('numbers.txt', 'r') as f:
        lines = f.readlines()
    f.close()
    num = 0
    for line in lines:
        num += int(line)

    num_str = str(num)
    output = ""
    for i in range(10):
        output += num_str[i]

    print(output)


start = time.time()
problem()
end = time.time()
print("Function took " + str(end - start))
