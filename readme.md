# Multiply Large Numbers (Java CLI Project)

This project is a simple Java command-line tool that multiplies two large numbers using one of two selectable algorithms:

- `--alg1`: Uses Java's built-in `BigInteger`
- `--alg2`: Manual multiplication algorithm (simulating paper-style multiplication)

---

## ✅ Features

- Multiplication of arbitrarily large integers (20+ digits)
- Two interchangeable algorithms (via CLI flag)
- Unit tests comparing both algorithms
- Maven project (clean structure)
- Ready for GitHub

---

## 🧠 Example

```bash
java -jar target/multiply-large-numbers-1.0-SNAPSHOT.jar --alg1 12345678901234567890 98765432109876543210
