from mpi4py import MPI #mpi calls
import sys #command line arguments
import random #random number generator

#Generates n uniform random points inside the interval [0, 1] for X and Y axis
#and counts how many of this points fall inside of a circle of radius 1 and center in (0,0)
#@param n the number of points to generate
#@returns the count of points that fell within the circle
def mccount(n):
  count = 0
  for _ in range(n):
    #generate a random point
    x = random.uniform(0.0, 1.0)
    y = random.uniform(0.0, 1.0)
    #if the point falls inside the circle increase the count
    if (x * x + y * y) < 1:
      count += 1
  return count

#mpi program to compute the value of pi
#using the Monte Carlo method
def main():
  #get the total number of points to generate
  if len(sys.argv) == 2:
    npoints = int(sys.argv[1])
    if (npoints <= 0):
      sys.exit("npoints have to be a number greater than zero (0)")
  else:
    print("Usage:", file=sys.stderr)
    print("mpiexec -np [P]", sys.argv[0], "[npoints]", file=sys.stderr)
    print("Where:", file=sys.stderr)
    print("* P - is the number of processes to run", file=sys.stderr)
    print("* npoints - is the total number of points to generate", file=sys.stderr)
    sys.exit("npoints is missing")

  #initialize the MPI environment
  comm = MPI.COMM_WORLD
  rank = comm.Get_rank()
  size = comm.Get_size()

  #divide the work uniformly between processes
  n = int(npoints / size)
  count = mccount(n)

  #join the counts of all processes
  if rank != 0:
    #workers
    #send count to master
    comm.send(count, dest=0, tag=0)
  else:
    #master
    #receives the count of each worker
    for i in range(1, size):
      data = comm.recv(source=i, tag=0)
      count += data
      #compute pi using the montercarlo formula
    pi = 4.0 * count / npoints;
    print("pi was estimated as:", pi)

  #end the program
  MPI.Finalize()
  return 0

#start the program
if __name__ == "__main__":
  main()

