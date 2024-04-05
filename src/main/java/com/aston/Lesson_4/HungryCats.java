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
        cat[0] = new Cat("Murzik");
        cat[1] = new Cat("Barsik");
        cat[2] = new Cat("Tom");
        cat[3] = new Cat("Simba");
        cat[4] = new Cat("Leo");
        cat[0].canEat = 5;
        cat[1].canEat = 14;
        cat[2].canEat = 20;
        cat[3].canEat = 5;
        cat[4].canEat = 10;

        Plate plate = new Plate(50);

        for (int i = 0; i < cat.length; i++) {
            if (plate.decreaseFood(plate.size, cat[i].canEat) >= 0) {
                cat[i].hungryLevel = true;

                plate.size = plate.decreaseFood(plate.size, cat[i].canEat);
            } else {
                plate.amount = plate.size;
                break;
            }
        }

        for (Cat value : cat) {
            if (value.hungryLevel) {
                System.out.println("Cat " + value.name + " had food");
            } else {
                System.out.println("Cat " + value.name + " is still hungry");
            }
        }

        System.out.println("Currently " + plate.amount + " is left in the plate");

        //You can add food if you want
        plate.addFood(plate.amount, 13, 50);
    }

}

