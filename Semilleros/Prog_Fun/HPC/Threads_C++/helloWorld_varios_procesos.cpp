#include <iostream>
#include <thread>

using namespace std;

// This function will be called from a thread
void helloWorld(int tid){
  //this_thread::sleep_for(20);
  cout << "Hello World from thread "<< tid<< endl;
}


int main(){
  //launch thread
  thread threads[4];

  for(int i=0;i<4;i++){
    threads[i] = thread(helloWorld,i);
  }
  
  for(int i=0;i<4;i++){
    threads[i].join();
  }
  thread t1(helloWorld,1);
  t1.detach();

  //t1.join();
  //this_thread::sleep_for(10);
  cout << " root ends " << endl;
  return 0;
}
