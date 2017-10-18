import threading
import random

counter = 0.0
counter_mt = threading.Lock()
total = 10000

def monte():
    global counter, counter_mt
    for _ in range(total/4):
        x=random.uniform(0,1)
        y=random.uniform(0,1)
        if (x*x + y*y < 1):
            with counter_mt:
                counter +=1

def main():
    threads =[]
    for _id in range(0,4):
        t=threading.Thread(target=monte)
        t.start()
        threads.append(t)

    for t in threads:
        t.join()
    pi = (4*counter)/total
    print "pi is almost: "+str(pi)

main()
