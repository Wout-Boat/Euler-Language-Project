fn main() {
    let start = std::time::SystemTime::now();
    for _i in 0..1000 {
        problem();
    }
    match start.elapsed() {
        Ok(elapsed) => {
            println!("{}", elapsed.as_nanos())
        }
        Err(e) => {
            println!("Error: {:?}", e)
        }
    }
}

fn problem() {
    let mut sum = 0;
    for n in 1..10000 {
        if n % 3 == 0 || n % 5 == 0 {
            sum += n;
        }
    }
    println!("{}", sum);
}
