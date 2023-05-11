import numpy

with open("array.txt", "w") as f:
    arr = numpy.random.random_integers(1, 10000, 10000)
    f.write(str(list(arr)))
