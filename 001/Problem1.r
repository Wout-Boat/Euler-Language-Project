problem <- function() {
    sum <- 0
    for (i in 1:1000) {
        if (i %% 3 == 0 | i %% 5 == 0) {
            sum <- sum + i
        }
    }
    print(sum)
}
num_loops <- 1000
start.time <- Sys.time()
for(i in 1:num_loops) {
    problem()
}
end.time <- Sys.time()
time.taken <- end.time - start.time
print(time.taken / num_loops)