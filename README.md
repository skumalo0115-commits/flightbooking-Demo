# ✈️ Flight Booking Demo

A tiny Java Swing app that simulates a **flight booking UI** and resolves airline domain IPs. Perfect for demos, classroom exercises, or quick UI experiments. 💺🌍

## ✨ Highlights
- 🧭 **Domain to IP resolver** using `InetAddress`
- 🪑 **Seat selection** buttons with confirmation prompts
- 🖥️ **Simple Swing UI** (no external dependencies)
- 🧩 **Single-file app** (easy to read and extend)

## ✅ Prerequisites
- ☕ **Java 8+** (JDK installed)
- 🧰 **Command-line tools** (`javac`, `java`) in your PATH

Check your Java version:
```bash
java -version
```

## 🚀 Run the App
From the project root:
```bash
javac src/FlightBookingDemo.java
java -cp src FlightBookingDemo
```

## 🧪 Optional: Build with Ant
If you prefer Ant and have it installed, you can use the provided `build.xml`:
```bash
ant
```
This will compile the project and generate build outputs per the Ant configuration.

## 🧑‍💻 How to Use
1. Enter an airline domain (e.g., `flyair.co.za`).
2. Click **Resolve IP** to see resolved addresses.
3. Choose a seat (1A, 1B, or 1C) and confirm your selection.

## ⚙️ Configuration Tips
- **Domain input:** Any valid domain works; try `example.com` if you want a quick test.
- **Seat behavior:** Once a seat is confirmed, the button is disabled for that session.
- **Networking:** Resolution requires internet access or a resolvable local DNS entry.

## 🧩 Main Entry Point
- `src/FlightBookingDemo.java` contains the Swing UI, event handlers, and `main` method.

## 🗂️ Project Structure
```
.
├── src/
│   └── FlightBookingDemo.java
├── build.xml
└── manifest.mf
```

## 🛠️ Troubleshooting
- **“Could not resolve” error:** Make sure the domain is valid and you have network access.
- **Compilation errors:** Confirm you’re using Java 8+ and compiling from the repository root.
- **App doesn’t open a window:** Ensure you’re running on a machine with a GUI environment.

## 📌 Notes
- This app is a **demo** and stores no data.
- Seat selection disables the chosen seat for the current session.
- The UI is intentionally minimal for learning and extension.

Enjoy flying! ✈️
