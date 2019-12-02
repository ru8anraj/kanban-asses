<h1>KANBAN-SERVICE-API</h1>

This service provides APIs to manage your tickets in the Kanban Board.

<h4>This service exposes 6 endpoints for managing the kanban board</h4>
    <ul>
    <li>POST - /ticket</li>
    <li>GET - /ticket</li>
    <li>GET - /ticket/{ticketId}</li>
    <li>GET - /ticket/findByStatus</li>
    <li>DELETE - /ticket/{ticketId}</li>
    <li>PUT - /ticket/{ticketId}</li>
    </ul>

<h4>Stack used for developement</h4>
    <ul>
    <li>SpringBoot</li>
    <li>Swagger (API Design and Definition)</li>
    <li>H2 (In-Memory DB)</li>
    <li>Docker</li>
    </ul>
    
<h4>Pre-Requisits</h4>
    - Docker should be installed for running the application
    
<h4>Steps to run the service</h4>
    <ol>
    <li>Go to the project directory</li>
    <li>Open terminal</li>
    <li>Command >> mvn clean install</li>
    <li>Command >> docker images (to find the image id)</li>
    <li>Command >> docker run -p 7071:7071 {imageId}</li>
    <li>Now you can access the service through localhost:7071 </li>
