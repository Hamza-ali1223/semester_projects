# Group Chat Application (Java)

Welcome to the **Group Chat Application**! This project demonstrates a real-time chat application using **Socket Programming** in Java, where multiple users can join, communicate, and receive messages in a GUI environment. This readme provides an overview of the application's structure, key features, and usage.

---

## 📂 Project Overview

This folder contains the **Group Chat Application** project files. The application is developed in Java with a **Graphical User Interface (GUI)**, providing an interactive and visually engaging chat experience for users.

---

## ✨ Key Features

- **Socket Programming**: Enables real-time data transfer between server and clients, ensuring smooth message flow.
- **Multi-User Support**: Allows 2 to 5 users to join the chat session, ensuring a flexible range of participants.
- **Multithreading**: Each user runs on a separate thread, allowing simultaneous message sending and receiving.
- **Date & Time Integration**: Uses Java's DateTime classes to manage and display timestamps for messages.
- **Broadcast Messaging**: Server receives user messages and broadcasts them to all connected users, except the sender.
- **Intuitive GUI**: Built-in GUI makes the chat application user-friendly and visually accessible.

---

## 🛠️ How It Works

1. **User Initialization**: On startup, the application prompts for the number of users (between 2 to 5). Each user is then instantiated as a distinct class object.
2. **Server & Client Communication**: The server acts as the central hub, listening on a designated socket port for incoming messages from any user.
3. **Message Broadcasting**: 
   - When a user sends a message, the server captures it and rebroadcasts it to all connected users.
   - The sender's class discards its own message to avoid duplication.
4. **Multithreading**: Each user operates on its own thread, enabling concurrent message handling and smooth communication without lag.
5. **GUI Message Display**: Received messages appear on each user's chat panel, creating a real-time, synchronized chat experience.

---

## 📁 File Structure

- **Main Server Class**: The core broadcasting class that handles message distribution and client connections.
- **User Classes**: Represent individual users in the chat and manage sending and receiving messages.
- **GUI Components**: Build the visual chat interface for each user.
- **Utility Classes**: Contain methods for handling dates, times, and other application utilities.

---

## 🚀 Getting Started

To run the application:

1. **Clone the repository** and navigate to the project folder.
2. **Compile the files** in your Java IDE or command line.
3. **Run the server** class, followed by the user classes to start the chat application.
4. **Enter the number of users** when prompted, then initiate the chat.

---

## 📅 Dependencies

- **Java DateTime Classes**: Used for timestamps.
- **Socket Programming**: Ensures real-time, reliable communication.
- **Multithreading**: Enables multiple users to operate concurrently.

---

## 🌐 Screenshots

### [Add screenshots of the GUI in action to make the readme more visual and engaging.]

---

## 📝 Additional Notes

- **Thread Management**: Each user runs independently on a thread, minimizing latency and ensuring seamless interaction.
- **Error Handling**: Designed with error handling to manage disconnections and invalid input gracefully.

---

## 👥 Contributors

- **Your Name**
- Additional Contributors

---

Thank you for exploring this project! For any questions or issues, please feel free to reach out.

Happy Coding! 🎉
