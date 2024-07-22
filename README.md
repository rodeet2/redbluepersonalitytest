
## Red Blue Personality Test

A fun simple personality test, choosing from Red or Blue. It then shows other users of similar results, and the link to their Instagram accounts. 

#### Features

Provides the user Personality result from questions. 
Allows saving the details by entering Instagram.
Shows other similar users and their Instagram.
Allows user to replace a existing test.

### Made with and Structure

This is a basic springboot web app. It uses a MySql database to store all questions, answers and user details. There are some Javascript componets, that control opening modals and calling Ajax. The users inputs are taken and stored on the client side, until the result page is reached. Where a information is sent to the server, and the user object is made. This is stored in the database and returns other random users. There are exeption handling, such as replacing a existing user, empty fields, no user found, invalid inputs etc. Some of them are handled using modals.

### Setup and Requirements 

The project will need login details to MySql in the application.properties, along with the dependancies mainly of springboot. 

### Status

Currenlty the project plans to add features that show the percentage of how much of a match there was with other users, and rank/show users like wise. Changes in the UI, and design elements that better show the users. Adding the profie picture alongside the Instagram links (taken from instagram.com if possible).
