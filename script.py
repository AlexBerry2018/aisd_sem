import numpy as np


for num in range(150):
    n, m = 0, 0
    if 0 <= num <= 49:
        n = 10  # vertex
        m = 25  # edges
    elif 50 <= num <= 99:
        n = 100  # vertex
        m = 250  # edges
    elif 100 <= num <= 149:
        n = 1000  # vertex
        m = 2500 # edges
    data = open("data/data"+str(num)+".txt", "w")
    matrix = [[0] * n for i in range(n)]
    all_edges = np.array([(i, j) for i in range(n) for j in range(i + 1, n)])
    edges = all_edges[np.random.choice(len(all_edges), size=m, replace=False)]
    for i, j in edges:
        w = np.random.randint(1, 9)
        matrix[i][j] = w
        matrix[j][i] = w
    for line in matrix:
        data.write(str(line).replace("[", "").replace("]", "").replace(",","")+'\n')