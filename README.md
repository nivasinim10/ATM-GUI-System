# ATM GUI System

A fully functional ATM Simulation System built using Java Swing and AWT with a modern graphical user interface.

This project demonstrates:

- Object-Oriented Programming (OOP)
- Secure transaction handling
- GUI navigation using CardLayout
- Real-time banking operations
- Event-driven programming

The application simulates a real ATM experience with authentication, balance inquiry, withdrawals, deposits, receipt generation, and transaction history management.

---

# Table of Contents

- [Project Overview](#project-overview)
- [Features](#features)
- [Application Screens](#application-screens)
- [System Architecture](#system-architecture)
- [Technologies Used](#technologies-used)
- [Project Structure](#project-structure)
- [Application Workflow](#application-workflow)
- [How to Run the Project](#how-to-run-the-project)
- [Demo Credentials](#demo-credentials)
- [Key OOP Concepts Used](#key-oop-concepts-used)
- [Core Functionalities](#core-functionalities)
- [Sample Receipt](#sample-receipt)
- [Challenges Solved](#challenges-solved)
- [Future Enhancements](#future-enhancements)
- [Academic Purpose](#academic-purpose)
- [Included Files](#included-files)
- [Repository Goals](#repository-goals)
- [License](#license)
- [Author](#author)

---

# Project Overview

This project implements a complete ATM Banking Simulation System using Java Swing.

The application provides a realistic banking workflow where users can:

- Login using secure PIN authentication
- Check account balance
- Withdraw money
- Deposit money
- Generate transaction receipts
- Track transaction history

The system is designed using a multi-screen CardLayout architecture to simulate real-world ATM behavior.

---

# Features

## Authentication System

- 4-digit secure PIN verification
- Password masking using `JPasswordField`
- Multiple predefined user accounts
- Invalid PIN detection and validation

---

## Banking Operations

- Check Account Balance
- Cash Withdrawal
- Cash Deposit
- Transaction Receipt Generation
- Transaction History Tracking
- Exit & New Transaction Workflow

---

## GUI Features

- Built using Java Swing + AWT
- Multi-screen navigation using `CardLayout`
- Numeric keypad interface
- Background image support
- Responsive desktop UI
- User-friendly banking workflow

---

## Receipt System

- Auto-generated transaction receipts
- Timestamped transaction logs
- Unique transaction IDs
- Card number masking for security

---

# Application Screens

The application contains multiple ATM workflow screens including:

- Welcome Screen
- PIN Entry Screen
- Main Menu
- Balance Inquiry
- Withdrawal Screen
- Deposit Screen
- Processing Screen
- Receipt Screen
- Thank You Screen

The workflow and UI screenshots are documented in the project PDF.

---

# System Architecture

The project uses a `CardLayout`-based screen navigation architecture.

```text
WELCOME
   ↓
PIN_ENTRY
   ↓
MAIN_MENU
   ↓
[ BALANCE | WITHDRAWAL | DEPOSIT | RECEIPT ]
   ↓
THANK_YOU
```

---

## Architecture Includes

- User Database using `HashMap`
- Balance Management
- Transaction History Storage
- Real-time Transaction Processing

---

# Technologies Used

| Technology | Purpose |
|---|---|
| Java | Core Programming Language |
| Swing | GUI Framework |
| AWT | UI Components |
| CardLayout | Multi-screen Navigation |
| HashMap | User & Balance Storage |
| ArrayList | Transaction History |
| OOP Concepts | System Design |
| JPasswordField | Secure PIN Masking |
| Event Listeners | User Interaction Handling |

---

# Project Structure

```text
ATM-GUI-System/
│
├── SimpleATM_final.java
├── world_map_final.jpg
├── README.md
├── PPT_ATMSystem.pptx
└── Output File_ATMSystem.pdf
```

---

# Application Workflow

```text
WELCOME SCREEN
       ↓
PIN AUTHENTICATION
       ↓
MAIN MENU
       ↓
[ BALANCE | WITHDRAW | DEPOSIT ]
       ↓
TRANSACTION PROCESSING
       ↓
RECEIPT GENERATION
       ↓
THANK YOU SCREEN
```

---

# How to Run the Project

## 1. Clone the Repository

```bash
git clone https://github.com/your-username/ATM-GUI-System.git
cd ATM-GUI-System
```

---

## 2. Compile the Program

```bash
javac SimpleATM_final.java
```

---

## 3. Run the Application

```bash
java SimpleATM_final
```

---

# Demo Credentials

| User Name | PIN |
|---|---|
| Ananya Verma | 1234 |
| Aryan Gupta | 4321 |
| Tarun Harish | 1111 |

User credentials are initialized using `HashMap` storage inside the application source code.

---

# Key OOP Concepts Used

| Concept | Usage in Project |
|---|---|
| Encapsulation | Managing user data and balances |
| Abstraction | Simplified banking operations |
| Modular GUI Design | Multiple reusable screens |
| Event-Driven Programming | Button click handling |
| State Management | Maintaining ATM workflow |
| Reusable Components | Shared GUI elements |

---

# Core Functionalities

## PIN Authentication

The system validates the entered PIN against stored user credentials.

```java
if (users.get(cardNumber).equals(enteredPin))
```

---

## Withdrawal Processing

- Validates sufficient balance
- Updates account balance
- Generates transaction receipt
- Stores transaction history

---

## Deposit Processing

- Accepts deposit amount
- Updates account balance
- Maintains transaction records
- Synchronizes balance in real-time

---

## Receipt Generation

The system automatically creates formatted transaction receipts with:

- Timestamp
- Transaction type
- Amount
- Remaining balance
- Unique transaction ID

---

# Sample Receipt

```text
GLOBAL BANK ATM
====================
Date: 2025-11-29 17:14:25
Card: ---3456
Transaction: WITHDRAWAL
Amount: ₹1000.00
Available Balance: ₹65000.00
Transaction ID: TXN1764416665925
====================
Thank you for banking with us!
```

---

# Challenges Solved

| Challenge | Solution |
|---|---|
| Screen State Management | Used `ComponentListener` with `CardLayout` |
| Background Image Loading | Implemented safe image loading using `getClass().getResource()` |
| Real-time Balance Synchronization | Dynamic balance updates after transactions |
| Transaction Tracking | Stored logs using `ArrayList` |

---

# Future Enhancements

- MySQL/PostgreSQL Integration
- Online Banking API Integration
- Fund Transfer Functionality
- PIN Change System
- Mobile Banking Version
- Multi-factor Authentication
- Encryption & Security Improvements
- ATM Analytics Dashboard

---

# Academic Purpose

This project was developed as a:

- 3rd Year Object-Oriented Programming Project
- Java GUI Development Practice
- Banking System Simulation
- Desktop Application Engineering Exercise

---

# Included Files

| File Name | Description |
|---|---|
| `SimpleATM_final.java` | Java Source Code |
| `Output File_ATMSystem.pdf` | Project Documentation |
| `PPT_ATMSystem.pptx` | Presentation Slides |
| `README.md` | Project Documentation |

Source files and project documentation are included in this repository.

---

# Repository Goals

This project is intended for:

- Resume Projects
- GitHub Portfolio
- Java Swing Learning
- OOP Demonstration
- GUI Application Showcase
- College & Internship Portfolio

---


## Focus Areas

- Java Programming
- GUI Development
- Banking System Simulation
- Object-Oriented Programming
- Desktop Application Development
