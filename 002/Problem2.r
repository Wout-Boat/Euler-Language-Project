problem <- function() {
    a <- 1
    b <- 2
    sum <- 2
    c <- a + b
    while(c < 4000000) {
        c <- a + b
        if(c %% 2 == 0) {
            sum <- sum + c
        }
        a <- b
        b <- c
    }
    print(sum)
}
num_loops <- 10000
start.time <- Sys.time()
for(i in 1:num_loops) {
    problem()
}
end.time <- Sys.time()
time.taken <- end.time - start.time
print(time.taken / num_loops)