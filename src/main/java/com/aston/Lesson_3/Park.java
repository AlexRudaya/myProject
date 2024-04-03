package com.aston.Lesson_3;

/** *
 * Создать класс Park с внутренним классом, с помощью объектов
 * которого можно хранить информацию об аттракционах, времени их
 * работы и стоимости.
 */


public class Park {

    public class Attractions {
        private String name;
        private double startHour;
        private double finishHour;
        private double cost;
        public Attractions(String name, double startHour, double finishHour, double cost){
            this.name=name;
            this.startHour=startHour;
            this.finishHour=finishHour;
            this.cost=cost;
        }
        @Override
        public String toString() {
            return "Attractions: " + name +" "+ startHour +" "+ finishHour +" "+ cost ;
        }
    }
}





