package aston.Lesson1;

public class test {
    public static void main(String[] args) {
        float radius = 2.0f, height = 10.0f;
// volume инициализируется динамически во время выполнения программы
        float volume = 3.1416f * radius * radius * height;
        System.out.println("Объем цилиндра равен " + volume);
    }
}