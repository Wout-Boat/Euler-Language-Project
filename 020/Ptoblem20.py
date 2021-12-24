import math
import time


# This function will prepend the given number to the given array
def prepend(num: int, array: list) -> list:
    arr = [num]
    return arr + array


def mul_round(top: list, bot: list, round_num: int) -> list:
    # This is the bottom number that used in this round
    # ex round_num 1 means the last digit in bot number
    multiplying_num = len(bot) - round_num

    output = []

    for mul_round_i in range(0, round_num - 1):
        output.append(0)

    carry = 0

    # Go though the number backwards multiplying single digits with a carry
    # digit.
    for mul_round_i in reversed(top):
        mul_num = mul_round_i * bot[multiplying_num] + carry
        num = mul_num % 10
        carry = math.floor(mul_num // 10)
        output = prepend(num, output)
    # This is required when the last multiplication is more than one digit.
    # The above loop will not add the carry if there are no more digits to
    # multiply because it is added when mul_num is calculated.
    if carry != 0:
        output = prepend(carry, output)
    return output


# this function adds two arrays together
def array_add(arr1: list, arr2: list) -> list:
    arr1_len = len(arr1)
    arr2_len = len(arr2)
    while arr1_len > arr2_len:
        arr2 = prepend(0, arr2)
        arr2_len = len(arr2)
    while arr2_len > arr1_len:
        arr1 = prepend(0, arr1)
        arr1_len = len(arr1)

    output = []

    carry = 0

    for array_add_i in reversed(range(arr1_len)):
        sum_num = arr1[array_add_i] + arr2[array_add_i] + carry
        num = sum_num % 10
        carry = math.floor(sum_num // 10)
        output = prepend(num, output)
    # Same carry requirement from the mul_num calculation.
    if carry != 0:
        output = prepend(carry, output)
    return output


def multiply_numbers(num1: list, num2: list) -> list:
    # This is the length of the number
    num1_len = len(num1)
    num2_len = len(num2)

    if num1_len > num2_len:
        output = mul_round(num1, num2, 1)
        for j in range(2, num2_len + 1):
            tmp = mul_round(num1, num2, j)
            output = array_add(output, tmp)
    else:
        output = mul_round(num2, num1, 1)
        for j in range(2, num1_len + 1):
            tmp = mul_round(num2, num1, j)
            output = array_add(output, tmp)

    return output


# This function turns string to int list
def str_to_list(string: str) -> list:
    output = []
    for str_to_list_i in string:
        output.append(int(str_to_list_i))
    return output


def int_to_list(num: int) -> list:
    return str_to_list(str(num))


def list_to_string(num: list) -> str:
    output = ""
    for list_to_string_i in num:
        output += str(list_to_string_i)
    return output


def problem():
    fac_num = 100
    prod = [1]
    for i in range(1, fac_num + 1):
        prod = multiply_numbers(prod, int_to_list(i))

    print(sum(prod))


start = time.time()
for _ in range(1000):
    problem()
end = time.time()
print("Function took " + str(end - start))
