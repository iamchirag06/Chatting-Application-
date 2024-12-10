
# **Java Chatting Application**

A modern, visually appealing chatting application built in **Java** using **Swing** for the user interface and **Socket Programming** for real-time communication. This application facilitates one-on-one communication between a server and a client, showcasing threading and networking concepts.

---

## **Features**

- **Client-Server Communication**: Enables seamless two-way communication between server and client.
- **Custom GUI**: Built with **Swing**, featuring a polished and user-friendly interface.
- **Multi-threaded Server**: The server can handle continuous communication with the client using threads.
- **Real-time Messaging**: Instant message exchange with timestamp display.
- **Scroll and View**: Auto-scroll enabled for efficient conversation navigation.
- **Active Status Display**: Shows live status of users like "Active Now."
- **Iconic UI Elements**: Includes video call, voice call, and more options buttons.

---

## **Technologies Used**

- **Java Swing**: For designing an intuitive and engaging GUI.
- **Socket Programming**: For enabling network communication.
- **Multithreading**: To manage simultaneous message transmission and reception.
- **Event Handling**: For handling user interactions like button clicks.

---

## **Getting Started**

### Prerequisites

- Java Development Kit (JDK) version 8 or higher.
- An IDE like IntelliJ IDEA, Eclipse, or NetBeans (optional).
- Basic understanding of Java and networking concepts.

---

### How to Run

#### **1. Clone the Repository**
```bash
git clone <repository-url>
cd chatting-application
```

#### **2. Compile the Code**
Compile the server and client classes:
```bash
javac Server.java Client.java
```

#### **3. Run the Server**
Start the server on port **6001**:
```bash
java Server
```
The server will wait for a client to connect.

#### **4. Run the Client**
In another terminal or IDE, start the client:
```bash
java Client
```
The client will connect to the server at **127.0.0.1:6001**.

#### **5. Chat!**
You can now exchange messages between the server and client. Multiple instances of the client can be run to simulate additional users (modifications may be needed for multi-client support).

---

## **Class Overview**

### **1. Server Class**
- **Purpose**: Central hub for receiving and sending messages.
- **Key Features**:
  - Uses `ServerSocket` to listen for client connections.
  - Supports continuous communication using threads.
  - Displays received messages with timestamps.

### **2. Client Class**
- **Purpose**: Represents the user interface and communication logic for a chat participant.
- **Key Features**:
  - Connects to the server using `Socket`.
  - Provides a clean, modern GUI for message sending and receiving.
  - Includes icons for video and voice calls (currently placeholders).

---

## **How It Works**

1. **Server** listens for client connections on port **6001**.
2. **Client** connects to the server using `Socket` at the specified IP and port.
3. Messages are exchanged in real-time using **DataInputStream** and **DataOutputStream**.
4. Messages are displayed in a conversational format with timestamps in the GUI.
5. Auto-scroll ensures the latest message is always visible.

---

## **Potential Enhancements**

- **Multi-Client Support**: Extend the server to handle multiple clients simultaneously.
- **Encryption**: Secure communication with end-to-end encryption.
- **File Sharing**: Allow users to exchange files.
- **Improved Status Display**: Real-time user status updates.
- **Group Chat**: Enable group conversations.
- **UI Enhancements**: Add themes and customizations.

---

## **Contributing**

Contributions are welcome! Fork the repository and submit a pull request. For significant changes, please open an issue to discuss your ideas.

---

## **License**

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

## **Contact**

- **Email**: singhchirag494@gmail.
- **GitHub**: [Click Here](https://github.com/iamchirag06)

---
