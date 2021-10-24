fn main() {
    let start = std::time::SystemTime::now();
    for _ in 0..1000 {
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
    let mut c: usize;
    let s: usize = 1000;
    let mut ans: usize = 10;
    for a in 1..s/3 {
        for b in a..s/2 {
            c = s - a - b;

            if a * a + b * b == c * c {
                ans = a * b * c;
                break;
            }
        }
    }
    println!("{}", ans);
}
