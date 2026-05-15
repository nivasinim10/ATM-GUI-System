ATM GUI System – Java Swing Banking Application
A fully functional ATM Simulation System built using Java Swing and AWT with a modern graphical user interface.
This project demonstrates Object-Oriented Programming (OOP) concepts, secure transaction handling, GUI navigation using CardLayout, and real-time banking operations.
The application simulates a real ATM experience with authentication, balance inquiry, withdrawals, deposits, receipt generation, and transaction history management.
 
 Features
 Authentication System
•	4-digit secure PIN verification
•	Password masking using JPasswordField
•	Multiple predefined user accounts
•	Invalid PIN detection and error handling
 Banking Operations
•	Check Account Balance
•	Cash Withdrawal
•	Cash Deposit
•	Transaction Receipt Generation
•	Transaction History Tracking
•	Exit & New Transaction Flow
 GUI Features
•	Built using Java Swing + AWT
•	Multi-screen navigation using CardLayout
•	Numeric keypad interface
•	Background image support
•	Responsive desktop UI
•	User-friendly banking workflow
 Receipt System
•	Auto-generated transaction receipts
•	Timestamped transaction logs
•	Unique transaction IDs
•	Card number masking for security
 
Application Screens
The application contains multiple ATM workflow screens including:
•	Welcome Screen
•	PIN Entry
•	Main Menu
•	Balance Inquiry
•	Withdrawal
•	Deposit
•	Processing Screen
•	Receipt Screen
•	Thank You Screen
The workflow and UI screenshots are documented in the project PDF.
 
 System Architecture
The project uses a CardLayout-based screen navigation architecture.
WELCOME
   ↓
PIN_ENTRY
   ↓
MAIN_MENU
   ↓
[ BALANCE | WITHDRAWAL | DEPOSIT | RECEIPT ]
   ↓
THANK_YOU

 The architecture includes:
•	User Database using HashMap
•	Balance Management
•	Transaction History Storage
•	Real-time Transaction Processing
 
 Technologies Used
1. Technology	Purpose
2. Java	Core Programming Language
3. Swing	GUI Framework
4. AWT	UI Components
5. CardLayout	Multi-screen Navigation
6. HashMap	User & Balance Storage
7. ArrayList	Transaction History
8. OOP Concepts	System Design
 
 Project Structure
ATM-GUI-System/
│
├── SimpleATM_final.java
├── world_map_final.jpg
├── README.md
├── PPT_ATMSystem.pptx
├── Output File_ATMSystem.pdf
 
  How to Run
1. Clone the Repository
git clone https://github.com/your-username/ATM-GUI-System.git
cd ATM-GUI-System
 
 2. Compile the Program
javac SimpleATM_final.java
 
 3. Run the Application
java SimpleATM_final
 
 Demo Credentials
User	PIN
Ananya Verma	1234
Aryan Gupta	4321
Tarun Harish	1111
User credentials are initialized using HashMap storage inside the application source code.
 
 Key OOP Concepts Used
•	Encapsulation
•	Abstraction
•	Modular GUI Design
•	Event-Driven Programming
•	State Management
•	Reusable Components
 
Core Functionalities
PIN Authentication
The system validates the entered PIN against stored user credentials.
if (users.get(cardNumber).equals(enteredPin))
 
Withdrawal Processing
•	Validates sufficient balance
•	Updates account balance
•	Generates transaction receipt
•	Stores transaction history
 
Receipt Generation
The system automatically creates formatted transaction receipts with:
•	Timestamp
•	Transaction type
•	Amount
•	Remaining balance
•	Unique transaction ID
 
Sample Receipt
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
 
 Challenges Solved
Screen State Management
Used ComponentListener with CardLayout to clear/reset fields dynamically.
Background Image Loading
Implemented safe image loading using:
getClass().getResource()
Real-time Balance Synchronization
Balances update instantly after transactions.

Future Enhancements
•	MySQL/PostgreSQL Integration
•	Online Banking API Integration
•	Fund Transfer Implementation
•	PIN Change Functionality
•	Mobile Banking Version
•	Multi-factor Authentication
•	Encryption & Security Improvements

 Academic Purpose
This project was developed as a:
•	3rd Year Object-Oriented Programming Project
•	Java GUI Development Practice
•	Banking System Simulation
•	Desktop Application Engineering Exercise

Included Files
•	Java Source Code → SimpleATM_final.java
•	Project Documentation PDF → Output File_ATMSystem.pdf
•	Presentation Slides → PPT_ATMSystem.pptx
Source files and project documentation are included in this repository.
Java implementation details are available in the source file.

Repository Goals
This project is intended for:
•	Resume Projects
•	GitHub Portfolio
•	Java Swing Learning
•	OOP Demonstration
•	GUI Application Showcase
•	College & Internship Portfolio


