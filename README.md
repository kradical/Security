# Security

## Lab1
Random numbers! Generating some random numbers and doing a little bit of stats.

To run:
* navigate to lab1 folder `$ cd lab1`
* build both executables `$ make`
* get random numbers from `/dev/random` with `$ ./random > random.out`
* get random numbers from `/dev/urandom` with `$ ./urandom > urandom.out`
* get some analysis with `$ python3 random_stats.py` and `$ python3 urandom_stats.py`
* get some plots with `$ Rscript random.r` and `$ Rscript urandom.r` 
