# Multiples of 3 and 5 below 1000
# Venkata Gogineni

total_sum = 0
for i in range(1, 1000):
    if (i % 3 == 0 or i % 5 == 0):
        total_sum = total_sum + i
print(total_sum)
