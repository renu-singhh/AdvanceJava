

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.File;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends JFrame {
    ServerSocket server;
    Socket socket;
    BufferedReader br;
    PrintWriter out;

    JLabel heading = new JLabel("Server Chat ");
    WatermarkTextPane messagePane = new WatermarkTextPane("Server");
    JTextField messageInput = new JTextField();
    JButton sendButton = new JButton("Send");
    JButton imgselect = new JButton("Attach");
    File[] fileToSend = new File[1];
    Font font = new Font("Arial", Font.PLAIN, 16);

    public Server() {
        try {
            server = new ServerSocket(7776);
            System.out.println("Server is ready to accept connection");
            System.out.println("Waiting...");
            socket = server.accept();

            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream());

            createGUI();
            handleEvents();

            startReading();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createGUI() {
        this.setTitle("Server Messenger");
        this.setSize(600, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(240, 240, 240)); // Set background color

        heading.setFont(new Font("Arial", Font.BOLD, 40)); // Change font and size
        heading.setForeground(new Color(70, 130, 180)); // Change text color
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        heading.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        messagePane.setEditable(false);
        messagePane.setFont(font);
        messagePane.setBackground(new Color(255, 255, 255)); // Change background color of text pane
        messagePane.setBorder(BorderFactory.createLineBorder(new Color(70, 130, 180))); // Add border
        messagePane.setMargin(new Insets(10, 10, 10, 10)); // Add some padding
        JScrollPane jScrollPane = new JScrollPane(messagePane);
        jScrollPane.setBorder(BorderFactory.createEmptyBorder()); // Remove border from scroll pane

        messageInput.setFont(font);
        messageInput.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createLineBorder(new Color(70, 130, 180)), // Add border
        BorderFactory.createEmptyBorder(5, 5, 5, 5))); // Add padding
        messageInput.setBackground(new Color(240, 240, 240)); // Change background color of text field

        sendButton.setFont(new Font("Arial", Font.BOLD, 16)); // Change font and size
        sendButton.setBackground(new Color(70, 130, 180)); // Change background color
        sendButton.setForeground(Color.WHITE); // Change text color
        sendButton.setFocusPainted(false); // Remove focus border
        sendButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Add padding
        sendButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Change cursor on hover

        imgselect.setFont(new Font("Arial", Font.BOLD, 16)); // Change font and size
        imgselect.setBackground(new Color(70, 130, 180)); // Change background color
        imgselect.setForeground(Color.WHITE); // Change text color
        imgselect.setFocusPainted(false); // Remove focus border
        imgselect.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Add padding
        imgselect.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Change cursor on hover


        imgselect.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                // Create a file chooser to open the dialog to choose a file.
                JFileChooser jFileChooser = new JFileChooser();
                // Set the title of the dialog.
                jFileChooser.setDialogTitle("Choose a file to send.");
                // Show the dialog and if a file is chosen from the file chooser execute the following statements.
                if (jFileChooser.showOpenDialog(null)  == JFileChooser.APPROVE_OPTION) {
                    // Get the selected file.
                    fileToSend[0] = jFileChooser.getSelectedFile();
                    // Change the text of the java swing label to have the file name.
                  
                }
            }
        });
        
        JPanel btns = new JPanel(new BorderLayout());
        btns.setBackground(new Color(240, 240, 240)); // Change background color of input panel
        btns.add(sendButton,BorderLayout.EAST);
        btns.add(imgselect,BorderLayout.WEST);

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.setBackground(new Color(240, 240, 240)); // Change background color of input panel
        inputPanel.add(messageInput, BorderLayout.CENTER);
        inputPanel.add(btns,BorderLayout.EAST);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(255, 255, 255)); // Change background color of main panel
        mainPanel.add(heading, BorderLayout.NORTH);
        mainPanel.add(jScrollPane, BorderLayout.CENTER);
        mainPanel.add(inputPanel, BorderLayout.SOUTH);

        this.add(mainPanel);

        this.setVisible(true);
    }

    private void handleEvents() {
        messageInput.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    sendMessage();
                }
            }
        });

        sendButton.addActionListener(e -> sendMessage());
    }

    private void sendMessage() {
        String contentToSend = messageInput.getText().trim();
        if (!contentToSend.equals("")) {
            appendToPane(messagePane, "You: " + contentToSend + "\n", Color.BLACK, true);
            out.println(contentToSend);
            out.flush();
            messageInput.setText("");
            messageInput.requestFocus();
        }
    }

    private void appendToPane(JTextPane tp, String msg, Color c, boolean isRight) {
        StyledDocument doc = tp.getStyledDocument();

        SimpleAttributeSet right = new SimpleAttributeSet();
        StyleConstants.setAlignment(right, isRight ? StyleConstants.ALIGN_RIGHT : StyleConstants.ALIGN_LEFT);
        StyleConstants.setForeground(right, c);
        StyleConstants.setFontSize(right, 20);
        StyleConstants.setSpaceAbove(right, 4);
        StyleConstants.setSpaceBelow(right, 4);
       

        try {
            doc.insertString(doc.getLength(), msg, null);
            doc.setParagraphAttributes(doc.getLength() - 1, 1, right, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startReading() {
        Runnable r1 = () -> {
            System.out.println("Reader started...");
            try {
                while (true) {
                    String msg = br.readLine();
                    if (msg.equals("exit")) {
                        System.out.println("Client terminated the chat");
                        socket.close();
                        break;
                    }
                    appendToPane(messagePane, "Client: " + msg + "\n", Color.BLACK, false);
                }
            } catch (Exception e) {
                System.out.println("Connection closed");
            }
        };
        new Thread(r1).start();
    }

    class WatermarkTextPane extends JTextPane {
        private String watermarkText;

        public WatermarkTextPane(String watermarkText) {
            this.watermarkText = watermarkText;
            this.setOpaque(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(new Color(220, 220, 220, 128));
            g.setFont(new Font("Arial", Font.BOLD, 100));
            FontMetrics fm = g.getFontMetrics();
            int x = (getWidth() - fm.stringWidth(watermarkText)) / 2;
            int y = (getHeight() - fm.getHeight()) / 2 + fm.getAscent();
            g.drawString(watermarkText, x, y);
        }
    }

    public static void main(String[] args) {
        System.out.println("This is the server. Going to start server");
        new Server();
    }
}
