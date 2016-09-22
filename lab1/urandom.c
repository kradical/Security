/* 

   Simple skeleton of a program that does "something" until user presses ctrl-C or the program gets a SIGINT or SIGKILL

*/

#include <fcntl.h>
#include <stdio.h>
#include <signal.h>
#include <unistd.h>
#include <stdlib.h>

int i = 0;

void report_results(void)
{
  // Output to stderr to separete results from report
  fprintf(stderr, "Here is where your report goes\n");
  fprintf(stderr, "Value of %i\n", i);
}



void signal_handler(int signo)
{
  // Output to stderr to separete results from report
  if (signo == SIGINT || signo == SIGKILL) {
    fprintf(stderr, "received SIGINT\n");
    report_results();
    exit(0);
  } else {
    fprintf(stderr, "received signal %d\n", signo);
  }
}

void do_something(FILE *handle)
{
  unsigned char rand_num;
  fread(&rand_num, sizeof(char), 1, handle);
  printf("%u\n", rand_num);
}


int main(void)
{
  // Set signal handler
  if (signal(SIGINT, signal_handler) == SIG_ERR) {
    printf("\ncan't catch SIGINT\n");
    exit(1);
  }

  // just do it
  FILE *handle = fopen("/dev/urandom", "r");
  while (1) {
    // what you do forever
    do_something(handle);
  }
  fclose(handle);
}

