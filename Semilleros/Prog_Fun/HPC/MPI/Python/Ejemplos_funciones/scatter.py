from mpi4py import MPI
import numpy as np

def main():
    comm = MPI.COMM_WORLD
    rank = comm.Get_rank()
    size = comm.Get_size()

    if rank == 0:
        data =  np.array([1,2,3,4])
    else:
        data = None

    datos = comm.scatter(data,root=0)

    print("proc",rank,datos)

    MPI.Finalize()

    return 0

if __name__=="__main__":
    main()
