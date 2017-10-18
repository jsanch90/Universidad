#include <iostream>
#include <thread>
#include <mutex>
#include <random>

#define NUM_THREADS 4

using namespace std;

long total = 100000000;
long count = 0;
mutex countLock;

void mcCount(long iterations){
  random_device r ;
  default_random_engine random(r());
  uniform_real_distribution<double> uniform_dist(0.0,1.0);
  for(int i=0;i<iterations;i++){
    double x=uniform_dist(random);
    double y=uniform_dist(random);
    if(x*x+y*y<1){
      countLock.lock();
      count ++;
      countLock.unlock();
    }
  }
}


int main(){
  thread threads[NUM_THREADS];

  for(int i=0;i<NUM_THREADS;i++){
    threads[i]=thread(mcCount,total/NUM_THREADS);
  }

  for(int i=0;i<NUM_THREADS;i++){
    threads[i].join();
  }

  double pi = 4.0*(count/(double)total);
  cout << "pi was estimated as " << pi << endl;
}
