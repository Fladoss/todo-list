package me.vlados.todo_list;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        TodoList todoList = new TodoList();
        Scanner userInput = new Scanner(System.in);

        System.out.println("Welcome to Todo List :)\n" +
                "1. Show the list\n" +
                "2. Add a new todo\n" +
                "3. Delete the todo\n" +
                "4. View the todo\n\n" +
                "Please, enter the command:");

        while (true) {
            System.out.print("> ");

            int choice;

            try {
                choice = userInput.nextInt();

                switch (choice) {
                    case 1:
                        todoList.displayTodoList();
                        break;
                    case 2:
                        todoList.addNewTodo();
                        break;
                    case 3:
                        todoList.deleteTodo();
                        break;
                    case 4:
                        todoList.viewTodo();
                        break;
                    default:
                        System.out.println("[Only numbers 1 - 4 allowed.]");
                }
            } catch (InputMismatchException e) {
                System.out.println("[No words allowed! Use numbers 1 - 4.]");
                userInput.next();
            }
        }
    }
}
