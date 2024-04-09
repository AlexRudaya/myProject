package com.aston.Lesson_4;

/**
 * Расширить задачу про котов и тарелки с едой, выполнив следующие
 * пункты:
 *  Сделать так, чтобы в тарелке с едой не могло получиться
 * отрицательного количества еды (например, в миске 10 еды, а кот
 * пытается покушать 15-20).
 * <p>
 * 22
 *  Каждому коту нужно добавить поле сытость (когда создаем
 * котов, они голодны). Если коту удалось покушать (хватило еды),
 * сытость = true.
 *  Считаем, что если коту мало еды в тарелке, то он её просто не
 * трогает, то есть не может быть наполовину сыт (это сделано для
 * упрощения логики программы).
 *  Создать массив котов и тарелку с едой, попросить всех котов
 * покушать из этой тарелки и потом вывести информацию о
 * сытости котов в консоль.
 *  Добавить в тарелку метод, с помощью которого можно было бы
 * добавлять еду в тарелку.
 */
public class HungryCats {
    public static void main(String[] args) {
        Cat[] cat = new Cat[5];
        cat[0] = new Cat("Murzik", 5);
        cat[1] = new Cat("Barsik", 15);
        cat[2] = new Cat("Tom", 40);
        cat[3] = new Cat("Simba", 15);
        cat[4] = new Cat("Leo", 30);


        Plate plate = new Plate(50);

        for (int i = 0; i < cat.length; i++){
            cat[i].eat(plate);
        }

        for (Cat value : cat) {
            if (value.hungryLevel) {
                System.out.println("Cat " + value.getName() + " had food");
            } else {
                System.out.println("Cat " + value.getName() + " is still hungry");
            }
        }

        System.out.println("Currently " + plate.getAmount() + " is left in the plate");

        //You can add food if you want
        plate.addFood(20);
    }

}

