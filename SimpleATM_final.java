

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.swing.*;

public class SimpleATM_final extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private String currentUser;
    private double balance;
    private String currentTransactionType;
    private double transactionAmount;

    private final Image worldMapImage;

    private final HashMap<String, String> users = new HashMap<>();
    private final HashMap<String, Double> balances = new HashMap<>();
    private final HashMap<String, String> userNames = new HashMap<>();
    private final HashMap<String, ArrayList<String>> transactionHistory = new HashMap<>();

  
    private JPasswordField pinField;
    private JTextField amountField;
    private JLabel balanceLabel;
    private JTextArea receiptArea;

    public SimpleATM_final() {
        java.net.URL imgUrl = getClass().getResource("/world_map_final.jpg");
        if (imgUrl != null) {
            worldMapImage = new ImageIcon(imgUrl).getImage();
        } else {
            System.err.println("ERROR: background image not found in classpath: /world_map_final.jpg");
            worldMapImage = null; 
        }
        initializeDB();
        setupGUI();
    }

    private void initializeDB() {
        users.put("1234567890123456", "1234");
        users.put("6543210987654321", "4321");
        users.put("6543210987654222", "1111");

        balances.put("1234567890123456", 65000.00);
        balances.put("6543210987654321", 80000.00);
        balances.put("6543210987654222", 90000.00);

        userNames.put("1234567890123456", "Ananya Verma");
        userNames.put("6543210987654321", "Aryan Gupta");
        userNames.put("6543210987654222", "Tarun Harish");

        initializeTranHis();
    }

    private void initializeTranHis() {
        transactionHistory.put("1234567890123456", new ArrayList<>());
        transactionHistory.put("6543210987654321", new ArrayList<>());
        transactionHistory.put("6543210987654222", new ArrayList<>());

        addTransaction("1234567890123456", "2024-01-15 10:30", "DEPOSIT", 5000.00, 65000.00);
        addTransaction("6543210987654321", "2024-01-14 14:22", "WITHDRAWAL", 2000.00, 80000.00);
        addTransaction("6543210987654222", "2024-01-14 16:35", "DEPOSIT", 5000.00, 90000.00);
    }

    private void setupGUI() {
        setTitle("ATM Machine - Secure Banking");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(560, 480);
        setLocationRelativeTo(null);
        setResizable(true);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        mainPanel.add(WelcomeScreen(), "WELCOME");
        mainPanel.add(PinScreen(), "PIN_ENTRY");
        mainPanel.add(MainMenu(), "MAIN_MENU");
        mainPanel.add(BalScreen(), "BALANCE");
        mainPanel.add(WithdrawalScreen(), "WITHDRAWAL");
        mainPanel.add(AmtSelectScreen(), "AMOUNT_SELECT");
        mainPanel.add(ProcessingScreen(), "PROCESSING");
        mainPanel.add(DepositScreen(), "DEPOSIT");
        mainPanel.add(ReceiptScreen(), "RECEIPT");
        mainPanel.add(ThankYouScreen(), "THANK_YOU");
       

        add(mainPanel);
        showScreen("WELCOME");
    }

    private JPanel WelcomeScreen() {
        JPanel panel = new BackgroundPanel(worldMapImage, new BorderLayout());
        panel.setBackground(new Color(0, 10, 10));

        JLabel titleLabel = new JLabel("Hello! Welcome to Global Bank.", JLabel.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 32));
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(100, 0, 20, 0));
        titleLabel.setOpaque(false);

        JLabel instructionLabel = new JLabel("Please insert your card to begin.", JLabel.CENTER);
        instructionLabel.setFont(new Font("SansSerif", Font.ITALIC, 19));
        instructionLabel.setForeground(Color.BLACK);
        instructionLabel.setBorder(BorderFactory.createEmptyBorder(25, 0, 0, 0));
        instructionLabel.setOpaque(false);

        JButton inCardBtn = new JButton("INSERT CARD");
        inCardBtn.setFont(new Font("SansSerif", Font.BOLD, 20));
        inCardBtn.setForeground(Color.BLACK);
        inCardBtn.setOpaque(false);
        inCardBtn.setContentAreaFilled(false);
        inCardBtn.setBorderPainted(true);
        inCardBtn.setFocusPainted(false);
        inCardBtn.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK, 3),
                BorderFactory.createEmptyBorder(10, 24, 11, 24)));

        inCardBtn.addActionListener(e -> showScreen("PIN_ENTRY"));

        panel.add(titleLabel, BorderLayout.NORTH);
        panel.add(instructionLabel, BorderLayout.CENTER);
        panel.add(inCardBtn, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel PinScreen() {
        JPanel panel = new BackgroundPanel(worldMapImage, new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

       
        panel.addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentShown(java.awt.event.ComponentEvent e) {
                if (pinField != null)
                    pinField.setText("");
            }
        });
        JLabel titleLabel = new JLabel("Please enter your 4-digit PIN to continue.", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 25));
        titleLabel.setOpaque(false);

        JPanel centerPanel = new JPanel(new GridLayout(0, 1, 10, 10));
        centerPanel.setOpaque(false);

        pinField = new JPasswordField(20); 
        pinField.setFont(new Font("Arial", Font.BOLD, 24));
        pinField.setHorizontalAlignment(JTextField.CENTER);
        pinField.setEchoChar('*'); 
        pinField.setPreferredSize(new Dimension(600, 40));
        JPanel keypadPanel = Keypad(pinField);
        keypadPanel.setOpaque(false);

        JButton submitBtn = new JButton("SUBMIT");
        JButton cancelBtn = new JButton("CANCEL");
        JLabel pinLabel = new JLabel("PIN:");
        pinLabel.setFont(new Font("Arial", Font.BOLD, 22));
        pinLabel.setHorizontalAlignment(SwingConstants.LEFT);
    
        centerPanel.setLayout(new GridLayout(0, 1, 5, 5));
        centerPanel.add(pinLabel); 
        centerPanel.add(pinField); 
        centerPanel.add(keypadPanel); 

        JPanel pinBox = new JPanel();
        pinBox.setOpaque(false);
        pinBox.setPreferredSize(new Dimension(100, 40));
        pinBox.setBorder(BorderFactory.createCompoundBorder(
                pinBox.getBorder(),
                BorderFactory.createEmptyBorder(20, 0, 10, 0) 
        ));
        pinBox.add(pinField);

        centerPanel.add(pinBox);

        centerPanel.add(keypadPanel);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        buttonPanel.setOpaque(false);
        buttonPanel.add(cancelBtn);
        buttonPanel.add(submitBtn);

        panel.add(titleLabel, BorderLayout.NORTH);
        panel.add(centerPanel, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        submitBtn.addActionListener(e -> authenticateUser());
        cancelBtn.addActionListener(e -> showScreen("WELCOME"));

        return panel;
    }

    private JPanel Keypad(JTextField targetField) {
        JPanel panel = new JPanel(new GridLayout(4, 3, 7, 7));
        panel.setOpaque(false);

        for (int i = 1; i <= 9; i++) {
            JButton btn = new JButton(String.valueOf(i));
            btn.setFont(new Font("Arial", Font.BOLD, 15));
            final int number = i;
            btn.addActionListener(e -> targetField.setText(targetField.getText() + number));
            panel.add(btn);
        }

        JButton clearBtn = new JButton("CLR");
        clearBtn.addActionListener(e -> targetField.setText(""));
        panel.add(clearBtn);

        JButton zeroBtn = new JButton("0");
        zeroBtn.addActionListener(e -> targetField.setText(targetField.getText() + "0"));
        zeroBtn.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(zeroBtn);

        JButton backBtn = new JButton("←");
        backBtn.addActionListener(e -> {
            String text = targetField.getText();
            if (text.length() > 0) {
                targetField.setText(text.substring(0, text.length() - 1));
            }
        });
        panel.add(backBtn);

        return panel;
    }
 
    private JPanel MainMenu() {
        JPanel panel = new BackgroundPanel(worldMapImage, new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
        JLabel welcomeLabel = new JLabel("", JLabel.CENTER);
        welcomeLabel.setFont(new Font("Roboto", Font.BOLD, 26));
        panel.addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentShown(java.awt.event.ComponentEvent e) {
                String name = (currentUser != null && userNames.get(currentUser) != null)
                        ? userNames.get(currentUser)
                        : "Customer";
                welcomeLabel.setText("Welcome " + name);
            }
        });
        /* 
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.setOpaque(false);
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
        topPanel.add(welcomeLabel);*/
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setOpaque(false);
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
        topPanel.add(welcomeLabel, BorderLayout.CENTER);

        panel.add(topPanel, BorderLayout.NORTH);
       
        JPanel centerWrapper = new JPanel(new GridBagLayout());
        centerWrapper.setOpaque(false);
      
        JPanel gridPanel = new JPanel(new GridLayout(3, 2, 40, 20));
        gridPanel.setOpaque(false);
        //gridPanel.setPreferredSize(new Dimension(600, 240));  

        String[] buttons = {
                "Check Balance", "Cash Deposit",
                "Cash Withdrawal", "Change PIN",
                "Fund Transfer", "Exit"
        };

        Dimension btnSize = new Dimension(190, 55);
        for (String b : buttons) {
            JButton btn = new JButton(b);
            btn.setPreferredSize(btnSize);
            btn.setFont(new Font("SansSerif", Font.BOLD, 18));
            btn.setBackground(Color.BLACK);       // Button background color
            btn.setForeground(Color.LIGHT_GRAY);
            btn.addActionListener(e -> MenuSelect(b));
            gridPanel.add(btn);
        }

        centerWrapper.add(gridPanel, new GridBagConstraints());

  
        panel.add(centerWrapper, BorderLayout.CENTER);

        return panel;
    }

    private void MenuSelect(String menuItem) {
        switch (menuItem) {
            case "Check Balance" -> {
                boolean userExists = users.containsKey(currentUser);
                if (userExists) {
                    balance = balances.getOrDefault(currentUser, 0.0);
                    if (balanceLabel != null) {
                        balanceLabel.setText("Current Balance: ₹" + String.format("%.2f", balance));
                    }
                    showScreen("BALANCE");
                } else {
                    showError("User not found!");
                }
            }
            case "Cash Withdrawal" -> {
                currentTransactionType = "WITHDRAWAL";
                showScreen("WITHDRAWAL");
            }
            case "Cash Deposit" -> {
                currentTransactionType = "DEPOSIT";
                showScreen("DEPOSIT");
            }
            case "Fund Transfer" -> JOptionPane.showMessageDialog(this,
                    "Oops! We encountered a technical difficulty. Please come back later...");
            case "Change PIN" -> JOptionPane.showMessageDialog(this, "PIN change feature coming soon!");
            case "Exit" -> showScreen("THANK_YOU");
        }
    }

    private JPanel BalScreen() {
        JPanel panel = new BackgroundPanel(worldMapImage, new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        balanceLabel = new JLabel("Your current account balance is: ₹" + String.format("%.2f", balance), JLabel.CENTER);
        balanceLabel.setFont(new Font("Arial", Font.BOLD, 24));
        balanceLabel.setForeground(new Color(34, 139, 34));
        balanceLabel.setOpaque(false);

        JButton receiptBtn = new JButton("Print Receipt");
        JButton anotherBtn = new JButton("Back");
        JButton exitBtn = new JButton("Exit");

        JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 10, 10));
        buttonPanel.setOpaque(false);
        buttonPanel.add(receiptBtn);
        buttonPanel.add(anotherBtn);
        buttonPanel.add(exitBtn);

        panel.add(balanceLabel, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        receiptBtn.addActionListener(e -> generateReceipt("BALANCE_INQUIRY", 0));
        anotherBtn.addActionListener(e -> showScreen("MAIN_MENU"));
        exitBtn.addActionListener(e -> showScreen("THANK_YOU"));

        return panel;
    }

    private JPanel WithdrawalScreen() {
        JPanel panel = new BackgroundPanel(worldMapImage, new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titleLabel = new JLabel(" How much would you like to withdraw? ", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setOpaque(false);

        JTextField customAmountField = new JTextField();
        customAmountField.setFont(new Font("Arial", Font.BOLD, 20));
        customAmountField.setHorizontalAlignment(JTextField.CENTER);
        customAmountField.setPreferredSize(new Dimension(200, 40));
        customAmountField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));

        JPanel buttonGridPanel = new JPanel(new GridBagLayout());
        buttonGridPanel.setOpaque(false);

        Dimension btnSize = new Dimension(160, 40);
        double[] quickAmounts = { 500, 1000, 2000, 5000 };

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        for (int i = 0; i < quickAmounts.length; i++) {
            JButton btn = new JButton("₹" + (int) quickAmounts[i]);
            btn.setPreferredSize(btnSize);
            btn.setFont(new Font("Arial", Font.BOLD, 16));
            double amount = quickAmounts[i];
            btn.addActionListener(e -> customAmountField.setText(String.valueOf((int) amount)));

            gbc.gridx = i % 2;
            gbc.gridy = i / 2;
            buttonGridPanel.add(btn, gbc);
        }

        JButton otherAmtBtn = new JButton("Other Amount");
        otherAmtBtn.setPreferredSize(btnSize);
        otherAmtBtn.setFont(new Font("Arial", Font.BOLD, 16));
        otherAmtBtn.addActionListener(e -> {
            customAmountField.setText("");
            customAmountField.requestFocus();
        });

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        buttonGridPanel.add(otherAmtBtn, gbc);

        JPanel controlPanel = new JPanel(new GridLayout(1, 3, 15, 15));
        controlPanel.setOpaque(false);

        JButton enterBtn = new JButton("ENTER");
        JButton clearBtn = new JButton("CLEAR");
        JButton backBtn = new JButton("BACK");

        enterBtn.setFont(new Font("Arial", Font.BOLD, 16));
        clearBtn.setFont(new Font("Arial", Font.BOLD, 16));
        backBtn.setFont(new Font("Arial", Font.BOLD, 16));

        controlPanel.add(backBtn);
        controlPanel.add(clearBtn);
        controlPanel.add(enterBtn);

        enterBtn.addActionListener(e -> {
            try {
                double amount = Double.parseDouble(customAmountField.getText());
                if (amount <= 0) {
                    showError("Please enter a positive amount!");
                } else {
                    processWithdrawal(amount);
                }
            } catch (NumberFormatException ex) {
                showError("Invalid amount entered!");
            }
        });

        clearBtn.addActionListener(e -> customAmountField.setText(""));
        backBtn.addActionListener(e -> showScreen("MAIN_MENU"));

        JPanel centerPanel = new JPanel();
        centerPanel.setOpaque(false);
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.add(titleLabel);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        centerPanel.add(customAmountField);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        centerPanel.add(buttonGridPanel);

        panel.add(centerPanel, BorderLayout.CENTER);
        panel.add(controlPanel, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel AmtSelectScreen() {
        JPanel panel = new BackgroundPanel(worldMapImage, new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titleLabel = new JLabel("ENTER AMOUNT", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setOpaque(false);

        amountField = new JTextField();
        amountField.setFont(new Font("Arial", Font.BOLD, 20));
        amountField.setHorizontalAlignment(JTextField.RIGHT);

        JPanel keypadPanel = Keypad(amountField);
        keypadPanel.setOpaque(false);

        JButton enterBtn = new JButton("ENTER");
        JButton clearBtn = new JButton("CLEAR");
        JButton backBtn = new JButton("BACK");

        JPanel controlPanel = new JPanel(new GridLayout(1, 3, 10, 10));
        controlPanel.setOpaque(false);
        controlPanel.add(backBtn);
        controlPanel.add(clearBtn);
        controlPanel.add(enterBtn);

        JPanel centerBox = new JPanel();
        centerBox.setLayout(new BoxLayout(centerBox, BoxLayout.Y_AXIS));
        centerBox.setOpaque(false);
        centerBox.add(amountField);
        centerBox.add(keypadPanel);

        panel.add(titleLabel, BorderLayout.NORTH);
        panel.add(centerBox, BorderLayout.CENTER);
        panel.add(controlPanel, BorderLayout.SOUTH);

        enterBtn.addActionListener(e -> {
            try {
                double amount = Double.parseDouble(amountField.getText());
                if ("WITHDRAWAL".equals(currentTransactionType)) {
                    processWithdrawal(amount);
                } else if ("DEPOSIT".equals(currentTransactionType)) {
                    transactionAmount = amount;
                    currentTransactionType = "DEPOSIT";
                    completeDeposit();
                }
            } catch (NumberFormatException ex) {
                showError("Invalid amount entered!");
            }
        });

        clearBtn.addActionListener(e -> amountField.setText(""));
        backBtn.addActionListener(e -> showScreen("WITHDRAWAL"));

        return panel;
    }

    private JPanel ProcessingScreen() {
        JPanel panel = new BackgroundPanel(worldMapImage, new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(50, 20, 20, 20));

        JLabel processingLabel = new JLabel("PROCESSING TRANSACTION...", JLabel.CENTER);
        processingLabel.setFont(new Font("Arial", Font.BOLD, 20));
        processingLabel.setOpaque(false);

        JProgressBar progressBar = new JProgressBar();
        progressBar.setIndeterminate(true);

        panel.add(processingLabel, BorderLayout.CENTER);
        panel.add(progressBar, BorderLayout.SOUTH);

        panel.addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentShown(java.awt.event.ComponentEvent e) {
                Timer timer = new Timer(2000, ev -> completeTransaction());
                timer.setRepeats(false);
                timer.start();
            }
        });

        return panel;
    }

    private JPanel DepositScreen() {
        JPanel panel = new BackgroundPanel(worldMapImage, new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel title = new JLabel("Enter the amount to deposit:", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setOpaque(false);

        JTextField depositField = new JTextField();
        depositField.setFont(new Font("Arial", Font.BOLD, 18));
        depositField.setHorizontalAlignment(JTextField.RIGHT);

        depositField.setPreferredSize(new Dimension(400, 60));
        depositField.setMaximumSize(new Dimension(600, 100));

        JPanel keypad = Keypad(depositField);
        keypad.setOpaque(false);

        JButton enter = new JButton("ENTER");
        JButton back = new JButton("BACK");

        enter.addActionListener(e -> {
            try {
                double amt = Double.parseDouble(depositField.getText());
                if (amt > 0) {
                    transactionAmount = amt;
                    currentTransactionType = "DEPOSIT";
                    showScreen("PROCESSING");
                } else {
                    showError("Enter a positive amount!");
                }
            } catch (NumberFormatException ex) {
                showError("Invalid amount!");
            }
        });

        back.addActionListener(e -> showScreen("MAIN_MENU"));

        panel.add(title, BorderLayout.NORTH);
        JPanel centerBox = new JPanel();
        centerBox.setLayout(new BoxLayout(centerBox, BoxLayout.Y_AXIS));
        centerBox.setOpaque(false);
        centerBox.add(depositField);
        centerBox.add(keypad);
        panel.add(centerBox, BorderLayout.CENTER);

        JPanel bottom = new JPanel(new GridLayout(1, 2, 10, 10));
        bottom.setOpaque(false);
        bottom.add(back);
        bottom.add(enter);
        panel.add(bottom, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel ReceiptScreen() {
        JPanel panel = new BackgroundPanel(worldMapImage, new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titleLabel = new JLabel("TRANSACTION RECEIPT", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setOpaque(false);

        receiptArea = new JTextArea(10, 30);
        receiptArea.setEditable(false);
        receiptArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        receiptArea.setOpaque(false);

        JScrollPane scrollPane = new JScrollPane(receiptArea);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);

        JButton printBtn = new JButton("Print Receipt");
        JButton doneBtn = new JButton("Done");

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        buttonPanel.setOpaque(false);
        buttonPanel.add(printBtn);
        buttonPanel.add(doneBtn);

        panel.add(titleLabel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        printBtn.addActionListener(e -> JOptionPane.showMessageDialog(this, "Receipt printed!"));
        doneBtn.addActionListener(e -> showScreen("MAIN_MENU"));

        return panel;
    }

    private JPanel ThankYouScreen() {
        JPanel panel = new BackgroundPanel(worldMapImage, new BorderLayout());
        panel.setBackground(new Color(0, 102, 204));
        panel.setBorder(BorderFactory.createEmptyBorder(50, 20, 20, 20));

      
        JPanel textPanel = new JPanel();
        textPanel.setOpaque(false);
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));

        JLabel line1 = new JLabel("Thanks for banking with us!", JLabel.CENTER);
        line1.setFont(new Font("Serif", Font.BOLD, 32));
        line1.setForeground(Color.BLACK);
        line1.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel line2 = new JLabel("Don't forget your card.", JLabel.CENTER);
        line2.setFont(new Font("Serif", Font.BOLD, 32));
        line2.setForeground(Color.BLACK);
        line2.setAlignmentX(Component.CENTER_ALIGNMENT);

        textPanel.add(line1);
        textPanel.add(Box.createVerticalStrut(10)); 
        textPanel.add(line2);

        JLabel securityLabel = new JLabel("Have a great day :)", JLabel.CENTER);
        securityLabel.setFont(new Font("SansSerif", Font.ITALIC, 19));
        securityLabel.setForeground(Color.BLACK);
        securityLabel.setOpaque(false);

        JButton newTransactionBtn = new JButton("New Transaction");

        newTransactionBtn.setFont(new Font("SansSerif", Font.BOLD, 20));
        newTransactionBtn.setForeground(Color.BLACK);
        newTransactionBtn.setOpaque(false);
        newTransactionBtn.setContentAreaFilled(false);
        newTransactionBtn.setBorderPainted(true);
        newTransactionBtn.setFocusPainted(false);
        newTransactionBtn.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK, 3),
                BorderFactory.createEmptyBorder(10, 24, 11, 24)));

        newTransactionBtn.addActionListener(e -> {
            currentUser = null;
            showScreen("WELCOME");
        });

        panel.add(textPanel, BorderLayout.NORTH);  
        panel.add(securityLabel, BorderLayout.CENTER);
        panel.add(newTransactionBtn, BorderLayout.SOUTH);

        return panel;
    }

    private void authenticateUser() {
        String enteredPin = new String(pinField.getPassword());
        boolean foundUser = false;
        for (String cardNumber : users.keySet()) {
            if (users.get(cardNumber).equals(enteredPin)) {
                currentUser = cardNumber;
                balance = balances.getOrDefault(currentUser, 0.0);
                foundUser = true;
                break;
            }
        }
        if (foundUser) {
            showScreen("MAIN_MENU");
        } else {
            JOptionPane.showMessageDialog(this, "Oops! That PIN doesn't seem right. Want to try again?");
            pinField.setText("");
        }
    }

    private void processWithdrawal(double amount) {
        if (amount > balance) {
            showError("Insufficient funds!");
            return;
        }
        if (amount <= 0) {
            showError("Invalid amount!");
            return;
        }
        transactionAmount = amount;
        currentTransactionType = "WITHDRAWAL";
        showScreen("PROCESSING");
    }

    private void completeTransaction() {
        if ("WITHDRAWAL".equals(currentTransactionType)) {
            balance -= transactionAmount;
            balances.put(currentUser, balance);
            addTransaction(currentUser, new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()),
                    "WITHDRAWAL", transactionAmount, balance);
            generateReceipt("WITHDRAWAL", transactionAmount);
        } else if ("DEPOSIT".equals(currentTransactionType)) {
            balance += transactionAmount;
            balances.put(currentUser, balance);
            addTransaction(currentUser, new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()),
                    "DEPOSIT", transactionAmount, balance);
            generateReceipt("DEPOSIT", transactionAmount);
        }
    }

    private void completeDeposit() {
        balance += transactionAmount;
        balances.put(currentUser, balance);
        addTransaction(currentUser, new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()),
                "DEPOSIT", transactionAmount, balance);
        generateReceipt("DEPOSIT", transactionAmount);
    }

    private void generateReceipt(String transactionType, double amount) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String receipt = "GLOBAL BANK ATM\n";
        receipt += "====================\n";
        receipt += "Date: " + sdf.format(new Date()) + "\n";
        receipt += "Card: " + (currentUser != null ? maskCardNumber(currentUser) : "N/A") + "\n";
        receipt += "Transaction: " + transactionType + "\n";

        if (amount > 0) {
            receipt += "Amount: ₹" + String.format("%.2f", amount) + "\n";
        }

        receipt += "Available Balance: ₹" + String.format("%.2f", balance) + "\n";
        receipt += "Transaction ID: " + generateTransactionId() + "\n";
        receipt += "====================\n";
        receipt += "Thank you for banking with us!";

        if (receiptArea != null) {
            receiptArea.setText(receipt);
        }
        showScreen("RECEIPT");
    }

    private void addTransaction(String user, String date, String type, double amount, double newBalance) {
        String transaction = String.format("%s %-10s ₹%-8.2f ₹%.2f",
                date, type, amount, newBalance);
        ArrayList<String> list = transactionHistory.get(user);
        if (list == null) {
            list = new ArrayList<>();
            transactionHistory.put(user, list);
        }
        list.add(0, transaction);
        if (list.size() > 10) {
            list.remove(10);
        }
    }

    private String maskCardNumber(String cardNumber) {
        if (cardNumber == null || cardNumber.length() < 4)
            return "";
        return "---" + cardNumber.substring(Math.max(0, cardNumber.length() - 4));
    }

    private String generateTransactionId() {
        return "TXN" + System.currentTimeMillis();
    }

    private void showScreen(String screenName) {
        cardLayout.show(mainPanel, screenName);
    }

    private void showError(String message) {
    JOptionPane.showMessageDialog(this,
        "Uh oh! " + message + "\nIf you need help, press 'Retry' or talk to our support desk.",
        "Oops!", JOptionPane.ERROR_MESSAGE);
}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SimpleATM_final().setVisible(true);
        });
    }
}

class BackgroundPanel extends JPanel {
    private final Image backgroundImage;

    public BackgroundPanel(Image img, LayoutManager layout) {
        super(layout);
        this.backgroundImage = img;
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}