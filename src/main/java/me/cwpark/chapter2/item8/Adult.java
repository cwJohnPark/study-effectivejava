package me.cwpark.chapter2.item8;

class Adult {
    public static void main(String[] args) {
        try (Room myRoom = new Room(7)) {
            System.out.println("Goodbye");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Teenager {
    public static void main(String[] args) {
        // It never prints "Cleaning room"
        new Room(99);
        System.out.println("Peace out");
    }
}