#include "mpi.h"    //mpi calls
#include <random>   //random number generator
#include <iostream> //cout, cerr
#include <stdlib.h> //atol
using namespace std;

/**
 * Generates n uniform random points inside the interval [0, 1] for X and Y axis
 * and counts how many of this points fall inside of a circle of radius 1 and center in (0,0)
 * @param n the number of points to generate
 * @returns the count of points that fell within the circle
 */
unsigned long int mcCount(unsigned long int n) {
  unsigned long int count = 0;
  double x;
  double y;
  //random generator
  random_device rd;
  mt19937 gen(rd());
  uniform_real_distribution<double> dis(0.0, 1.0);
  while (n > 0) {
    //generate a random point
    x = dis(gen);
    y = dis(gen);
    //if the point falls inside the circle increase the count
    if ((x * x + y * y) < 1) count++;
    n--;
  }
  return count;
}

/**
 * Mpi program to compute the value of pi
 * using the Monte Carlo method
 */
int main(int argc, char* argv[]) {
  //get the total number of points to generate
  unsigned long int npoints;
  if (argc == 2) {
    npoints = atol(argv[1]);
    if (npoints <= 0) {
      cerr << "npoints have to be a number greater than zero (0)" << endl;
      exit(-2);
    }
  } else {
    cerr << "Usage:" << endl
	 << "mpiexec -np [P] " << argv[0] << " [npoints]" << endl
	 << "Where:" << endl
	 << "* P - is the number of processes to run" << endl
	 << "* npoints - is the total number of points to generate" << endl;
    exit(-1);
  }

  //initialize the MPI environment
  int size, rank;
  MPI_Init(&argc, &argv);
  MPI_Comm_rank(MPI_COMM_WORLD, &rank);
  MPI_Comm_size(MPI_COMM_WORLD, &size);

  //divide the work uniformly between processes
  unsigned long int n = npoints / size;
  unsigned long int count = mcCount(n);

  //join the counts of all processes
  if (rank != 0) {
    //workers
    //send count to master
    int dest = 0; //rank of destination
    int tag = 0;  //message tag
    int n = 1;    //number of elements in send buffer
    MPI_Send(&count, n, MPI_UNSIGNED_LONG, dest, tag, MPI_COMM_WORLD);
  } else {
    //master
    //receives the count of each worker
    unsigned long int aux; //buffer for incoming messages
    int n = 1;             //number of elements in receive buffer
    int tag = 0;           //message tag
    MPI_Status status;     //mpi status object
    for (int source = 1; source < size; source++) {
      MPI_Recv(&aux, n, MPI_UNSIGNED_LONG, source, tag, MPI_COMM_WORLD, &status);
      count += aux;
    }

    //compute pi using the montercarlo formula
    long double pi = 4.0 * count / npoints;
    cout << "pi was estimated as: " << pi << endl;
  }

  //end program
  MPI_Finalize();
  return 0;
}
