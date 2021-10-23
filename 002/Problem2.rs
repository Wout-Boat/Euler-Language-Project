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
    let mut a = 1;
    let mut b = 2;
    let mut c = 1;
    let mut sum = 0;
    while c < 4_000_000 {
        c = a + b;

        if c % 2 == 0 {
            sum += c;
        }

        a = b;
        b = c;
    }

    println!("{}", sum);
}
