import java.util.Scanner;

public class Main {
    public static String[] todos =  new String[10];
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        addTodoList("Belajar");
        addTodoList("Menggambar");
        addTodoList("Menulis");
        addTodoList("Menyetir");
    }

    public static void showTodoList(){
        System.out.println("TODO LIST");
        for(int i = 0; i < todos.length; i++){
            String todo = todos[i];
            if(todo != null){
                System.out.println((i + 1) + ". " + todo);
            }
        }
    }

    public static void addTodoList(String todo){
        resizeIfFull();

        //add todo to array that has null element
        for(int i = 0; i < todos.length; i++){
            if(todos[i] == null){
                todos[i] = todo;
                break;
            }
        }
    }

    private static void resizeIfFull() {
        //check is full
        Boolean isFull = true;
        for(int i = 0; i < todos.length; i++){
            if(todos[i] == null){
                isFull = false;
                break;
            }
        }

        //resize array to two times bigger if full
        if(isFull){
            resizeArrayToTwoTimesBigger();
        }
    }

    private static void resizeArrayToTwoTimesBigger() {
        String[] temp = todos;
        todos = new String[todos.length * 2];
        for(int i = 0; i < temp.length; i++){
            todos[i] = temp[i];
        }
    }

    public static boolean removeTodoList(Integer number){
        if (isSelectedTodoNotValid(number)) return false;

        for(int i = number - 1; i < todos.length; i++){
            //if todo is the last element
            if(i == (todos.length - 1)){
                todos[i] = null;
            }
            else{
                //replace with the element on the right
                todos[i] = todos[i + 1];
            }
        }
        return true;
    }

    private static boolean isSelectedTodoNotValid(Integer number) {
        //check if the number is less then equal zero
        if(number <= 0){
            return true;
        }
        //check if the number is greater than the todos size/length
        if(number - 1 > todos.length - 1){
            return true;
        }
        //check whether the element is already null
        if(todos[number - 1] == null){
            return true;
        }
        return false;
    }

    public static boolean editTodoList(int number, String newTodo){
        if(isSelectedTodoNotValid(number)){
            return false;
        }
        todos[number - 1] = newTodo;
        return true;
    }
}
