from mpi4py import MPI
import math
import numpy as np

def chunkify(l, wp):
  #Yield successive n-sized chunks from l.
  for i in range(0, len(l), wp): 
    yield l[i:i + wp]

def serial_dot_product(a, b):
  dot_product = 0
  for i, j in zip(a, b):
    dot_product += i * j
  return dot_product

def main():
  #initializate mpi common world
  comm = MPI.COMM_WORLD
  rank = comm.Get_rank()
  size = comm.Get_size()
  
  #split the data
  if rank == 0:
    a = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]
    b = [30, 40, 50, 60, 70, 35, 91, 100, 125, 0, 5, 3]
    wp = math.ceil(len(a) / size)#work per processor
    chunks_a = chunkify(a, wp)
    chunks_b = chunkify(b, wp)
  else:
    chunks_a = None
    chunks_b = None

  my_chunk_a = comm.scatter(chunks_a, root=0)
  my_chunk_b = comm.scatter(chunks_b, root=0)

  #process the data
  dot_product_per_chunk = np.array(serial_dot_product(my_chunk_a, my_chunk_b))

  #collect the results
  dot_product = np.array(0, dtype=np.int)
  comm.Reduce([dot_product_per_chunk, MPI.INT],
              [dot_product, MPI.INT],
              op=MPI.SUM,
              root=0)

  #print result
  if rank == 0:
    print("dot product:", dot_product)

if __name__ == "__main__":
  main()
