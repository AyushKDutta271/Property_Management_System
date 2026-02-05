package com.example.PropertyManagementSystem.Exception;

public class InvalidLoginException extends RuntimeException{

   public InvalidLoginException(String message)
   {
       super(message);
   }
}
