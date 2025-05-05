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






🎬 Movie Ticket Booking System (UI Sample)





It is a  sample front-end UI for a movie ticket booking system named MoviTune, developed using HTML, CSS, and basic JavaScript principles, following OOP concepts where applicable.





🔧 This is a front-end-only implementation — meant as a design and layout prototype.





🗂️ Project Structure





frontend/
├── index.html                # Landing/Home Page



├── movies.html              # Movies listing


├── ticket-booking.html      # Seat selection & booking


├── e-ticket.html            # Electronic ticket view


├── sign_in.html             # Sign-in page


├── Contact_Us.html          # Contact form


├── about.html               # About the project


├── assets/
│   └── css/                 # Stylesheets (UI, seat charts, progress bars, etc.)


├── screenshots/             # Light and dark theme previews


├── LICENSE.md               # License information





⸻

💡 Features



•	🎥 Browse available movies



•	🎟️ Seat selection interface


•	📄 E-ticket sample page



•	🌙 Light and Dark UI themes


•	🔐 Sign-in page mockup


•	📞 Contact Us page




🛠️ Tech Stack



•	HTML5


•	CSS3


•	JavaScript (basic DOM/OOP usage)


•	UI Elements styled using custom CSS and templates














🚀 Getting Started




To preview the UI locally:



1.	Download or clone the repo.

 
2.	Open index.html in your browser.

    
3.	Navigate between the pages via links or manually.





