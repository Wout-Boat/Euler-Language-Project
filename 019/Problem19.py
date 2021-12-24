import time
from datetime import date, datetime


# This method will count the number of Sundays that fell on the first of the month between two days.
def countSundays(start: datetime, end: datetime) -> int:
    date1_ord = start.toordinal()
    date2_ord = end.toordinal()
    sundays = 0

    for d_ord in range(date1_ord, date2_ord + 1):
        d = date.fromordinal(d_ord)
        if d.weekday() == 6 and d.day == 1:
            sundays += 1
    return sundays


def problem():
    date1 = date(1901, 1, 1)
    date2 = date(2000, 12, 31)
    print(countSundays(date1, date2))


start = time.time()
problem()
end = time.time()
print("Function took " + str(end - start))
