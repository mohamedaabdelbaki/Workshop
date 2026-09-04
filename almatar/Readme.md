# Almatar Web Application - QA Testing

This repository contains my QA testing work for the Almatar car rental and fleet management web application.

I tested the application mainly through exploratory testing and used Postman to check the APIs and compare what happens on the website with the requests sent to the backend.

## What I Tested

- Login and authentication
- Dashboard and analytics
- Branch management
- Employee management
- Car inventory
- Location and routes
- Supplier registration
- Account and profile management

During testing, I focused on things like:

- Functional testing
- Input validation
- Boundary values
- CRUD operations
- UI behavior
- Dark/Light mode
- RTL/LTR
- Basic security scenarios
- API requests and responses

## API Testing

I used Postman to test the available API endpoints and check the request and response data.

I also used the browser's Network tab to see what requests were being sent when performing actions on the website. This helped me find some issues where the UI was working but the expected API request was not being sent.

## Defects

I found 9 defects during the testing sessions.

Some of the more important ones were:

- **Critical:** Changing one user's profile name could change names across other accounts.
- **High:** Multiple failed login attempts did not appear to have rate limiting.
- **High:** The Bookings filter on the Dashboard did not send the expected API request.
- **Medium:** Leading spaces in the login email were accepted.

## Tools

- Postman
- Chrome DevTools
- Web Browser
- Excel