#include<iostream>
using namespace std;

//global matrices
int* a;
int* b;
int* ab;

/**
 * Multiply two square matrices
 * @param a the first matrix
 * @param b the second matrix
 * @param ab the memory region where the resulting matrix will be stored
 * @param n the size of the three matrices
 */
void multiplyMatrices(const int* a, const int* b, int* ab, const unsigned int n) {
  for (unsigned int i = 0; i < n; i++) {
    for (unsigned int j = 0; j < n; j++) {
      int  sum = 0;
      for (unsigned int k = 0; k < n; k++) {
        sum += a[(i*n) + k] * b[(k * n) + j];
      }
      ab[(i*n) + j] = sum;
    }
  }
}

/**
 * Prints a square matrix
 * @param matrix the matrix to print
 * @param n the size of the matrix
 * @param name the name of the matrix (first printed line)
 */
void printMatrix(const int* matrix, const unsigned int n, const string name) {
  cout << name << endl;
  for (unsigned int i = 0; i < n; i++) {
    for (unsigned int j = 0; j < n; j++) {
      cout << matrix[(i*n) + j] << '\t';
    }
    cout << endl;
  }
  cout << endl;
}

/**
 * Simple program to test the speed ups
 * generated from the compiler optimizations
 *
 * Normal: g++ --std=c++11 -o matrixmul Optimization.cpp
 * Debug: g++ -g -DDEBUG --std=c++11 -o matrixmul Optimization.cpp
 * Optimized: g++ -O3 --std=c++11 -o matrixmul Optimization.cpp
 */
int main() {
  //instantiate the matrices
  const unsigned int n = 2500; //35000 -> aproximadamente 9 GB Ram
  a = new int[n*n];
  b = new int[n*n];
  ab = new int[n*n]; //A * B

  //initialize the A & B matrices
  for (unsigned int i = 0; i < n; i++) {
    for (unsigned int j = 0; j < n; j++) {
      a[(i*n) + j] = i + j + 1;
      b[(i*n) + j] = (i * j) + 1;
    }
  }

#ifdef DEBUG
  //print the matrices
  printMatrix(a, n, "First Matrix (A)");
  printMatrix(b, n, "Second Matrix (B)");
#endif

  //multiply the two matrices
  multiplyMatrices(a, b, ab, n);

#ifdef DEBUG
  //print the resulting matrix
  printMatrix(ab, n, "A * B");
#endif

  //exit
  return 0;
}
