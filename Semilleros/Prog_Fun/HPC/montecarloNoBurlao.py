import threading
import random
from concurrent.futures import *
total = 10000
def monte():
    c=0
    for _ in range(total//4):
        x=random.uniform(0,1)
        y=random.uniform(0,1)
        if (x*x + y*y < 1):
            c+=1
    return c
        
def main():
    with ThreadPoolExecutor(max_workers=4) as executor:
        futures =[]
        for _ in range(0,4):
            f= executor.submit(monte)
            futures.append(f)
    c=0

    for f in futures:
        c += int(f.result())
    pi = (4*c)/total
    print ("pi is almost: ",pi)

main()
