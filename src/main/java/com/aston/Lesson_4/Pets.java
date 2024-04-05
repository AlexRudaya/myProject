package com.aston.Lesson_4;

/**
 * 1. Создать классы Собака и Кот с наследованием от класса Животное.
 * 2. Все животные могут бежать и плыть. В качестве параметра каждому
 * методу передается длина препятствия. Результатом выполнения
 * действия будет печать в консоль. (Например, dogBobik.run(150); -&gt;
 * &#39;Бобик пробежал 150 м.&#39;);
 * 3. У каждого животного есть ограничения на действия (бег: кот 200 м.,
 * собака 500 м.; плавание: кот не умеет плавать, собака 10 м.).
 * 4. Добавить подсчет созданных котов, собак и животных.
 */
public class Pets {
    public static void main(String[] args) {
        //Animals animals = new Animals("Cat"); //- почему обязательно создавать, можно без них?
        Cat cat1 = new Cat("Tom");
        Cat cat2 = new Cat("Leo");
        Dog dog1 = new Dog("Bobik");
        Dog dog2 = new Dog("Sam");
        Cat cat3 = new Cat("Simba");
        cat1.run(200);
        cat1.run(100);
        cat2.run(150);
        cat3.run(201);
        dog2.run(500);
        dog1.run(510);
        cat1.swim(1);
        dog1.swim(10);
        dog2.swim(12);
        System.out.println("All amount of animals- " + Animals.getAmountAnimals());
        System.out.println("All amount of cats- " + Cat.getAmountCats());
        System.out.println("All amount of dogs- " + Dog.getAmountDogs());

    }
}
