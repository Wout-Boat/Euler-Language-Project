fn main() {
    let start = std::time::SystemTime::now();
    for _i in 0..1000 {
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

fn problem() {
    let num = 600851475143;
    let factors = primes::factors(num);

    println!("{:?}", factors.last().unwrap());
}
