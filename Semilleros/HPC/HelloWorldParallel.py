import threading

def hello(_id):
    a=0
    for i in range(100000000):
        a+=1
    print("Hello world from thread", _id)

def main():
    for _id in range(0,4):
        threading.Thread(target=hello, args=[_id]).start()

if __name__ == "__main__":
    main()
