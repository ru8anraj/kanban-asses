KANBAN-SERVICE-API
-
This service provides APIs to manage your tickets in the Kanban Board.

This service exposes 6 endpoints for managing the kanban board
    - POST - /ticket
    - GET - /ticket
    - GET - /ticket/{ticketId}
    - GET - /ticket/findByStatus
    - DELETE - /ticket/{ticketId}
    - PUT - /ticket/{ticketId}


Stack used for developement
    - SpringBoot
    - Swagger (API Design and Definition)
    - H2 (In-Memory DB)
    - Docker
    
Pre-Requisits
    - Docker should be installed for running the application
    
Steps to run the service
1. Go to the project directory
2. Open terminal
3. Command >> mvn clean install
4. Command >> docker images (to find the image id)
5. Command >> docker run -p 7071:7071 {imageId}
6. Now you can access the service through localhost:7071 
