import time


ones = ["one", "two", "three", "four", "five", "six", "seven", "eight", "nine"]
teens = ["ten", "eleven", "twelve", "thirteen", "fourteen",
         "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"]
tens = ["", "twenty", "thirty", "forty", "fifty",
        "sixty", "seventy", "eighty", "ninety"]

# There is an issue with out this program handels 10s. Such as 480, 470
# TODO: See above


def numToString(num: int) -> str:
    if num == 1000:
        return "OneThousand"
    if num < 10:
        return ones[num-1]

    output = ""

    if num >= 100:
        hundredsSpot = int(num / 100)
        remainder = num % 100
        output += ones[hundredsSpot - 1] + "Hundred"
        if remainder == 0:
            return output
        output += "And"
        num = remainder

    if num >= 10:
        if num < 20:
            output += teens[num - 10]
            return output
        tensSpot = int(num / 10)
        remainder = num % 10
        output += tens[tensSpot - 1]
        if remainder == 0:
            return output
        num = remainder

    output += ones[num - 1]
    return output


def NumLength(n: int) -> int:
    return len(numToString(n))


def problem():
    su = 0
    for i in range(1, 1001):
        su += NumLength(i)
    print(su)


start = time.time()
problem()
end = time.time()
print("Function took " + str(end - start))
