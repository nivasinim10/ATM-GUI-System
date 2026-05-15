ATM GUI System using Java Swing
A complete ATM Simulation System built using Java Swing and AWT that replicates real-world banking operations through a modern desktop graphical user interface.
This project demonstrates Object-Oriented Programming (OOP), event-driven programming, secure transaction workflows, multi-screen navigation using CardLayout, and banking transaction management.
The application simulates a realistic ATM environment with:
•	PIN Authentication
•	Balance Inquiry
•	Cash Withdrawal
•	Cash Deposit
•	Transaction Receipt Generation
•	Transaction History Tracking
•	Interactive GUI Navigation
 
Features
Banking Operations
•	Secure PIN-based login system
•	Account balance inquiry
•	Cash withdrawal functionality
•	Cash deposit functionality
•	Transaction receipt generation
•	Transaction history management
•	Exit and new transaction workflow
 
Authentication System
•	4-digit secure PIN verification
•	Password masking using JPasswordField
•	Multiple predefined user accounts
•	Invalid PIN detection and validation
•	Secure account access flow
 
GUI Features
•	Developed using Java Swing and AWT
•	Multi-screen navigation using CardLayout
•	Numeric keypad interface
•	Background image support
•	User-friendly banking workflow
•	Desktop application interface
•	Responsive screen transitions
 
Receipt & Transaction System
•	Auto-generated transaction receipts
•	Timestamped transaction logs
•	Unique transaction tracking
•	Card number masking for security
•	Transaction processing workflow
 
Application Workflow
The ATM application follows a real-world banking interaction flow.
WELCOME SCREEN
       ↓
PIN AUTHENTICATION
       ↓
MAIN MENU
       ↓
[ BALANCE | WITHDRAW | DEPOSIT ]
       ↓
RECEIPT GENERATION
       ↓
THANK YOU SCREEN
 
Application Screens
The project contains multiple interactive ATM screens including:
•	Welcome Screen
•	PIN Entry Screen
•	Main Menu
•	Balance Inquiry Screen
•	Withdrawal Screen
•	Deposit Screen
•	Processing Screen
•	Receipt Screen
•	Thank You Screen
The UI workflow and screenshots are included in the project documentation PDF.
 
Technologies Used
Technology	Purpose
Java	Core Programming Language
Swing	GUI Framework
AWT	User Interface Components
CardLayout	Multi-screen Navigation
HashMap	User & Balance Storage
ArrayList	Transaction History Storage
OOP Concepts	Application Design
 
System Architecture
The project uses a CardLayout-based navigation architecture for switching between multiple ATM screens.
USER INPUT
     ↓
AUTHENTICATION MODULE
     ↓
BANKING OPERATIONS
     ↓
TRANSACTION PROCESSING
     ↓
RECEIPT GENERATION
     ↓
TRANSACTION STORAGE
 
Project Structure
ATM-GUI-System/
│
├── SimpleATM_final.java
├── world_map_final.jpg
├── README.md
├── PPT_ATMSystem.pptx
├── Output File_ATMSystem.pdf
 
How to Run the Project
1. Clone the Repository
git clone https://github.com/your-username/ATM-GUI-System.git
cd ATM-GUI-System
 
2. Compile the Java Program
javac SimpleATM_final.java
 
3. Run the Application
java SimpleATM_final
 
Demo Credentials
User	PIN
Ananya Verma	1234
Aryan Gupta	4321
Tarun Harish	1111
The credentials are initialized using HashMap storage inside the Java source code.
 
Core Functionalities
PIN Authentication
The application validates user credentials before granting ATM access.
if (users.get(cardNumber).equals(enteredPin))
 
Balance Inquiry
Users can securely check their current account balance.
 
Cash Withdrawal
The withdrawal module:
•	Validates sufficient balance
•	Updates account balance
•	Records transaction history
•	Generates receipt details
 
Cash Deposit
The deposit system:
•	Adds deposited amount to account balance
•	Updates transaction logs
•	Stores transaction records
 
Transaction History Management
The application stores transaction activities using:
ArrayList<String>
This enables tracking of:
•	Deposits
•	Withdrawals
•	Balance inquiries
•	Receipt generation
 
Key Java Concepts Demonstrated
•	Object-Oriented Programming (OOP)
•	Event-Driven Programming
•	GUI Application Development
•	Java Swing Components
•	State Management
•	Data Structures in Java
•	Exception Handling
•	Multi-screen UI Navigation
 
Challenges Solved
Multi-Screen Navigation
Implemented smooth screen switching using CardLayout.
 
Banking Transaction Handling
Developed secure transaction workflows for deposits and withdrawals.
 
GUI State Management
Managed transitions between ATM workflow screens while preserving transaction data.
 
Example Use Cases
Banking System Simulation
Demonstrates how ATM systems process customer transactions.
 
Java GUI Learning Project
Helps understand Java Swing, AWT, and desktop application development.
 
OOP Demonstration
Shows practical implementation of core Object-Oriented Programming concepts.
 
Educational Mini Project
Suitable for:
•	College Projects
•	Java Learning
•	GUI Programming Practice
•	Resume Projects
•	Internship Demonstrations
 
Future Enhancements
•	Database Integration using MySQL/PostgreSQL
•	User Registration System
•	OTP-based Authentication
•	Online Banking Features
•	Card Swipe Simulation
•	ATM Cash Management System
•	Admin Dashboard
•	Transaction Analytics
•	Cloud Deployment Support
•	Mobile Banking Integration

