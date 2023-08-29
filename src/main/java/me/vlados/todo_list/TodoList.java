package me.vlados.todo_list;

import java.util.ArrayList;
import java.util.Scanner;

public class TodoList {

    private final Scanner userInput = new Scanner(System.in);

    public ArrayList<Todo> todos = new ArrayList<>();

    public void displayTodoList() {
        if (todos.isEmpty()) {
            System.out.println("[Nothing here! Add new todos with command '2'.]");
        } else {
            System.out.println("------- Your todos -------");
            for (Todo todo : todos) {
                System.out.println("- " + todo.getName());
            }
        }
    }

    public void addNewTodo() {
        System.out.println("[Please, enter the name of the future todo.]");

        System.out.print("> ");
        String todoName = userInput.nextLine();

        if (todoName.isEmpty()) {
            System.out.println("[Name cannot be empty!]");
            return;
        } else {
            for (Todo todo : todos) {
                if (todo.getName().equals(todoName)) {
                    System.out.println("[Todo with such name already exists!]");
                    return;
                }
            }
        }

        System.out.println("[Please, enter the description of the future todo.]");

        System.out.print("> ");
        String todoDescription = userInput.nextLine();
        todos.add(new Todo(todoName, todoDescription));
    }

    public void deleteTodo() {
        System.out.println("[Please, enter the name of the todo you want to delete.]");

        System.out.print("> ");
        String todoName = userInput.nextLine();

        boolean isDeleted = todos.removeIf(todo -> todo.getName().equals(todoName));

        if (!isDeleted) {
            System.out.println("[Todo with such name was not found.]");
        }
    }

    public void viewTodo() {
        System.out.println("[Please, enter the name of the todo whose description you want to read.]");

        System.out.print("> ");
        String todoName = userInput.nextLine();

        for (Todo todo : todos) {
            if (todo.getName().equals(todoName)) {
                System.out.println("Description of the todo: " + todoName + "\n"
                        + todo.getDescription());
                return;
            }
        }

        System.out.println("[Todo with such name was not found.]");
    }
}
