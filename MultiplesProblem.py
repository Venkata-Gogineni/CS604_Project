# Multiples of 3 and 5 below 1000
# Venkata Gogineni

total = 0
for numbers in range(1, 1000):
    if (numbers % 3 == 0 or numbers % 5 == 0):
        total = total + numbers
print(total)
