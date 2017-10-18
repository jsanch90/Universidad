#include "mpi.h"   //mpi calls
#include <stdio.h> //printf

/**
 * Simple mpi hello world program
 * prints the mpi context of each process
 */
int main(int argc, char *argv[]) {
  //mpi vars
  int  size, rank, len;
  char hostname[MPI_MAX_PROCESSOR_NAME];

  //initialize MPI
  MPI_Init(&argc, &argv);

  //get my rank number
  MPI_Comm_rank(MPI_COMM_WORLD, &rank);

  //get the total number of tasks
  MPI_Comm_size(MPI_COMM_WORLD, &size);

  //get the hostname of this processor
  MPI_Get_processor_name(hostname, &len);

  //print the mpi context of this process
  printf("MPI process on rank %d running on %s of a total number of tasks %d\n", rank, hostname, size);

  //end program
  MPI_Finalize();
  return 0;
}
