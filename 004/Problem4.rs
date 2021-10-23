fn main() {
    let start = std::time::SystemTime::now();
    problem();
    match start.elapsed() {
        Ok(elapsed) => {
            println!("Function took: {}", elapsed.as_nanos())
        }
        Err(e) => {
            println!("Error: {:?}", e)
        }
    }
}

fn reverse_int(mut n: i64) -> i64 {
    let mut new_int: i64 = 0;
    let mut remainder: i64;
    while n != 0 {
        remainder = n % 10;
        new_int *= 10;
        new_int += remainder;
        n /= 10;
    }
    return new_int;
}

fn problem() {
    let mut max = 0;
    let mut prod;
    for i in 100..1000 {
        for j in 100..1000 {
            prod = i * j;
            if prod == reverse_int(prod) && prod > max {
                max = prod;
            } // End if
        } // End Inner for
    } // End outer for
    println!("{}", max);
}
