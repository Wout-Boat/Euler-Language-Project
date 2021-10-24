fn main() {
    let start = std::time::SystemTime::now();
    for _ in 0..10 {
        problem();
    }
    match start.elapsed() {
        Ok(elapsed) => {
            println!("Function took: {}", elapsed.as_nanos())
        }
        Err(e) => {
            println!("Error: {:?}", e)
        }
    }
}

fn prime(num: i64) -> bool {
    for i in 2..num {
        if num % i == 0 {
            return false;
        }
    }
    return true;
}

fn problem() {
    let mut count = 2;
    let mut i = 4;
    loop {
        i += 1;
        if prime(i) {
            count += 1;
            if count == 10_001 {
                break;
            }
        }
    }
    println!("{}", i);
}
