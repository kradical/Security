import statistics

def main():
  with open("urandom.out", "r") as fp:
    counts = [0 for _ in range(256)]
    
    for line in fp:
        counts[int(line)] += 1
    
    for ndx, count in enumerate(counts):
       print(str(ndx) + ", " + str(count))

    print()
    print("random number count:", sum(counts))
    print("max:", max(counts))
    print("min:", min(counts))
    print("median:", statistics.median_low(counts))

if __name__ == "__main__":
  main()
