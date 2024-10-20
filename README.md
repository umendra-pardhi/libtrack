# Library Management Android App

This project is an Android App which aims to provide a solution to manage a Book Library. Designed for both Users/Students and Library Admins, various operations such as adding/removing/updating books, searching books, issuing/re-issuing/returning books, seeing issued books with due dates, collecting fines, etc. can be performed. The App uses Cloud Firestore as the back-end database for storing details of the Books and Users. Firebase Cloud Messaging is used to send realtime notifications to Users if a return deadline is approaching, his/her fine is increased, or when a new book is added to the Library. Cloud Functions are used to monitor the database in order to update fines and trigger notifications. The App has a user-friendly and interactive interface.

A detailed description of this project 

## Usage
This App is not live at the moment and won't work off the shelf.
* Create a new Firebase Project (with Firestore Database) on Firebase Console and configure it with the App.
* Setup a Node.js and Firebase CLI environment to deploy the Cloud Functions.
* Setup a cron job to trigger the "updateFine" Function once every day through a HTTPS request.

I would recommend following YouTube Tutorials, Online Guides, and Official Documentation to get help in setting up the Project.<br>


## Tools Used
* [Android Studio](https://developer.android.com/studio) : Primary IDE for Android App Development using Java.
* [Cloud Firestore](https://firebase.google.com/products/firestore) : The Database used for storing data in the form of Collections and Documents.
* [Firebase Cloud Messaging](https://firebase.google.com/products/cloud-messaging) : Used for sending Push Notifications to specified users using FCM Tokens.
* [Cloud Functions](https://firebase.google.com/products/functions) : Used for real-time monitoring on the database and listening to certain triggers for taking required actions.
* [Firebase Authentication](https://firebase.google.com/products/auth) : Used to maintain Accounts and perform Login and Signup Actions.
* [cron-job.org](https://cron-job.org/en/): Used for scheduling Cloud Functions through HTTPS Requests.



## Future Work
* UI Improvement and Optimization
* New Features/Functionalities
* Generalization for Flexible Usage. This App was implemented specifically for my College's Library System:
    * Books and Users are identified through unique Book IDs and Card No. respectively.
    * While issuing/re-issuing/returning a Book, 2 digits need to be added at end of its Book ID (to specify the unit number). For example, copies of a Book with ID 14532 having 25 units would have the IDs 1453201, 1453202, 1453203 ... 1453225. Book IDs are displayed in the same way in User Account's end.
    * Email ID for registration needs to be of the domain @iiitnr.edu.in.
    * Books are issued for a duration of 14 days, after which a fine of Rs.1 per day is incurred (if the book is not re-issued or returned).
    * A book can be re-issued only 1 time from the User's end.


## Project Description 
### Features
* Simple and minimal Layout Designs.
* Interlinked Activities for different functions.
* Text Views and Toasts for displaying info.
* Interaction with the User with the help of Edit Text Views, Buttons, Checkboxes, Alert Dialogs, Card Views, etc.
* Updates using Push Notifications.
* Real-time Synchronization with Online Database.
* Auto Login on App launch if the user/admin is logged in.
* Security Rules to protect the database from malicious activities.

### Functionalities
* Admin Account :

  * Add new Book to the Library.
  * Update details of an existing Book.
  * Remove a Book from the Library.
  * Issue a Book to a User.
  * Return a Book from User.
  * Re-Issue a Book to a User.
  * Collect Fine from a User.
  * Search for a particular Book.
  
* User Account :

  * See Issued Books with Due Dates.
  * Re-issue a Book one time.
  * Search for a particular Book.
  
* Push Notifications to Users when :

  * New Book added to the Library.
  * Fine of the User increases.
  * Deadline for a particular Book is nearby (3 days).
  
* Cloud Functions to :

  * Increase Fine of the user if the deadline is crossed, once in a day.
  * Trigger Notifications based on events.

