import java.util.*;

public class Main {
    public static String[] task = new String[10];
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        mainMenuTodoList();
//        testshow();
//        testAddTodoList();
//        testRemoveTodoList();
//        testInputData();
//        testMainMenuTodoList();
//        testMenuAddTodoList();
//        testMenuRemoveTodoList();
    }


    /**
     * Menampilkan data
     */
    public static void showToDoList() {

        System.out.println("TODOLIST");

        for (int index = 0; index < task.length; index++) {
            String newTask = task[index];
            Integer nomor = index + 1;

            if (newTask != null) {
                System.out.println(nomor + ". " + newTask);
            }
        }

    }


    /**
     * Menambah data
     */
    public static void addToDoList(String data) {

        //cek task penuh atau tidak
        boolean isFull = true;
        for (int index = 0; index < task.length; index++) {
            if (task[index] == null) {
                //task masih ada yang kosong
                isFull = false;
                break;
            }
        }

        //jika penuh, akan resize ukuran array 2x lipat
        if (isFull) {
            String[] temp = task;
            task = new String[task.length * 2];

            for (int index = 0; index < temp.length; index++) {
                task[index] = temp[index];
            }
        }

        // menambahkan data ke posisi array null
        for (int index = 0; index < task.length; index++) {
            if (task[index] == null) {
                task[index] = data;
                break;
            }
        }

    }

    /**
     * Menghapus data
     */
    public static boolean removeToDoList(Integer number) {

        if ((number - 1) >= task.length) {
            return false;
        } else if (task[number - 1] == null) {
            return false;
        } else {
            for (int index = (number - 1); index < task.length; index++) {
                if (index == (task.length - 1)) {
                    task[index] = null;
                } else {
                    task[index] = task[index + 1];
                }
            }
            return true;
        }
    }

    public static String input(String info) {
        System.out.print(info + " : ");
        String inputData = scanner.nextLine();
        return inputData;
    }

    /**
     * Tampilan menu todolist
     */
    public static void mainMenuTodoList() {
        while (true) {
            showToDoList();

            System.out.println("Menu");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");

            String input = input("Pilih");

            if (input.equals("1")) {
                menuAddTodoList();
            } else if (input.equals("2")) {
                menuRemoveTodoList();
            } else if (input.equals("x")) {
                break;
            } else {
                System.out.println("Pilihan salah, coba lagi");
            }
        }
    }

    /**
     * Tampilan add todolist
     */
    public static void menuAddTodoList() {

        System.out.println("MENAMBAH TASK");

        String addTask = input("Task (x Untuk Batal)");

        if (addTask.equals("x")) {
            //batal
            mainMenuTodoList();
        } else {
            addToDoList(addTask);
        }

    }

    /**
     * menu remove todolist
     */
    public static void menuRemoveTodoList() {

        System.out.println("MENGHAPUS TASK");
        String number = input("Nomor yang Dihapus (x Untuk Batal)");

        if (number.equals("x")) {
            //batal
            mainMenuTodoList();
        } else {
            boolean success = removeToDoList(Integer.valueOf(number));

            if (!success) {
                System.out.println("Gagal menghapus Task : " + number);
            }
        }

    }


    public static void testshow() {

        task[0] = "Java Dasar";
        task[1] = "Test TodoList";
        showToDoList();

    }

    public static void testAddTodoList() {
        for (int index = 1; index <= 25; index++) {
            addToDoList("Contoh ke - " + index);
        }
        showToDoList();
    }

    public static void testRemoveTodoList() {
        addToDoList("Satu");
        addToDoList("Dua");
        addToDoList("Tiga");

        boolean result = removeToDoList(20);
        System.out.println(result);

        result = removeToDoList(4);
        System.out.println(result);

        result = removeToDoList(2);
        System.out.println(result);

        showToDoList();
    }

    public static void testInputData() {
        String name = input("Nama");
        System.out.println("Hi " + name);

        String channel = input("Channel");
        System.out.println(channel);
    }

    public static void testMainMenuTodoList() {
        addToDoList("satu");
        addToDoList("dua");
        addToDoList("tiga");
        addToDoList("empat");
        addToDoList("lima");
        mainMenuTodoList();
    }

    public static void testMenuAddTodoList() {
        addToDoList("satu");
        addToDoList("dua");
        addToDoList("tiga");

        menuAddTodoList();

        showToDoList();
    }

    public static void testMenuRemoveTodoList() {
        addToDoList("Satu");
        addToDoList("Dua");
        addToDoList("Tiga");

        showToDoList();

        menuRemoveTodoList();

        showToDoList();
    }
}