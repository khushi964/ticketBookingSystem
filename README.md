🎟 Ticket Booking Management System(MoviTune)


A simple console-based Java application that allows users to book tickets for movies. Built using pure Java following the MVC design pattern, this project supports both Admin and Customer roles with full CRUD 
operations for movies and ticket management.




🧩 Features


👨‍💼 Admin
	
  •	Login using name and email

  
•	Add new movies

•	View all movies

•	Update movie details

•	Remove movies

•	View all customer bookings

•	Cancel any ticket by Ticket ID

•	Register new admins (via menu)

 👥 Customer
 
•	Login or Signup

•	View available movies

•	Book tickets (with seat tracking)

•	View personal ticket bookings

•	Cancel their own tickets




 🛠 Technologies Used
 
	
 •	Java (no frameworks like Spring used)
 
•	Follows Object-Oriented Programming (OOP)

•	MVC (Model-View-Controller) Design Pattern

•	Lazy Initialization where needed

•	Console-based input/output




📁 Project Structure




ticketBookingSystem/


├── Backend/

│   ├── BookingSystem.java    // Main logic controller

│   ├── Admin.java            // Admin model

│   ├── Customer.java         // Customer model

│   ├── Movie.java            // Movie model

│   ├── Ticket.java           // Ticket model

│   └── Main.java             // Entry point





▶ How to Run  Backend  1. compile all the files        	2.	Run the main class:

  	javac Backend/*.java  
    java Backend.Main


   
⸻

✅ Future Improvements

•	Persistent storage (e.g., file or database)

•	GUI integration using Springboot

•	Support for concerts/events

•	Multiple Admins 









