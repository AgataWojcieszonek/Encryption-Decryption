# Encryption-Decryption

## Description

This is a **command-line tool** for encrypting and decrypting text using simple algorithms, built with **Java**.
The program allows users to encode or decode messages using either a **shift cipher (Caesar cipher)** or a **Unicode cipher**,
depending on their needs.

This project is a great way to practice essential **Java programming concepts**, such as:
- Command-line argument parsing
- Strategy and Factory Method design patterns
- String manipulation
- Algorithm implementation

Working on this project strengthens understanding of **basic cryptography** and improves ability to build flexible,
user-driven Java applications.

---

## Program Flow

1. **Read command-line arguments** to determine:
    - Mode: encryption (`enc`) or decryption (`dec`)
    - Algorithm: `shift` or `unicode`
    - Key: number of positions to shift
    - Input/output: source of data (console or file)

2. **Select the algorithm**:
    - `shift`: shifts letters of the alphabet (a–z, A–Z), wrapping around
    - `unicode`: shifts all characters based on their Unicode value

3. **Apply encryption or decryption** using the selected algorithm and key.

4. **Output the result** to either the console or a specified file.