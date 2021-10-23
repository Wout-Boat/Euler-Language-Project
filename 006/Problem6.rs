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

fn sum_of_squares(mut num: i64) -> i64 {
    let mut sum = 0;
    while num > 0 {
        sum += num * num;
        num -= 1;
    }
    return sum;
}

fn square_of_sum(mut num: i64) -> i64 {
    let mut sum = 0;
    while num > 0 {
        sum += num;
        num -= 1;
    }
    return sum * sum;
}

fn problem() {
    let natural_num = 100;
    println!("{}", square_of_sum(natural_num) - sum_of_squares(natural_num))
}
