package com.aston.Lesson_3;

public class ParkAttractions {
    public static void main(String[] args) {
      Park park = new Park();
      Park.Attractions[] attractions = new Park.Attractions[2];
      attractions[0] = park.new Attractions("carousel", 9.00, 16.00, 5);
      attractions[1] = park.new Attractions("carousel 2", 9.00, 16.00, 5);
      System.out.println(attractions[0]);
    }
}




