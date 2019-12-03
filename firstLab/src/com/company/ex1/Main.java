package com.company.ex1;// Java program to demonstrate working of Scanner in Java

class Main
{
    public static void main(String args[])
    {
       Monitor monitor_1 = new Monitor();
       Monitor monitor_2 = new Monitor();

       monitor_1.color = "green";
       monitor_1.dimensions = 32.2f;
       monitor_1.resolution = 228;

       monitor_2.color = "red";
       monitor_2.dimensions = 22.8f;
       monitor_2.resolution = 322;

       if (monitor_1.color.equals(monitor_2.color)) {
           System.out.println("Monitors colors are the same");
       } else {
           System.out.println("Monitors colors are the different");
       }

       if (monitor_1.dimensions > monitor_2.dimensions) {
           System.out.println("First monitor's dimensions are bigger");
       } else if (monitor_1.dimensions < monitor_2.dimensions) {
           System.out.println("First monitor's dimensions are smaller");
       } else {
           System.out.println("Monitors' dimensions are the same");
       }

        if (monitor_1.resolution > monitor_2.resolution) {
            System.out.println("First monitor's resolution are bigger");
        } else if (monitor_1.resolution < monitor_2.resolution) {
            System.out.println("First monitor's resolution are smaller");
        } else {
            System.out.println("Monitors' resolution are the same");
        }
    }
}

class Monitor {
    String color;
    float dimensions;
    int resolution;
}