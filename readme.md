####the project uses h2 in memory db  

 - run the project  
 - from postman POST http://localhost:8080/users/record with   
   {   
   "username": "asd",  
   "password": "123"  
   }  
to create an user in db 


 - POST http://localhost:8080/login with  
   {  
   "username": "asd",  
   "password": "123"  
   }  
to login and get the token from the response header, copy the token  


 - GET http://localhost:8080/api/secure with  
   Authorization header and its value the copied token to get the secured endpoint