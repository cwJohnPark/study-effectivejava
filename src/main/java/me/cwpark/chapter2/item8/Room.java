package me.cwpark.chapter2.item8;


import java.lang.ref.Cleaner;

/*
 * An autocloseable class using a cleaner as a safety net
 */
public class Room implements AutoCloseable {

    private static final Cleaner cleaner = Cleaner.create();

    // resource that requires cleaning. must not refer to Room!
    private static class State implements Runnable {
        int numJunkPiles; // Number of junk piles in this room.

        State(int numJunkPiles) {
            this.numJunkPiles = numJunkPiles;
        }

        // Invoked by close method or cleaner
        @Override
        public void run() {
            System.out.println("Cleaning room");
            numJunkPiles = 0;
        }
    }

    // The state of this room, shared with our cleanable
    private final State state;

    // Out cleanable. Cleans the room when it's eligible for gc
    private final Cleaner.Cleanable cleanable;

    public Room(int numJunkPiles) {
        this.state = new State(numJunkPiles);
        this.cleanable = cleaner.register(this, state);
    }

    @Override
    public void close() throws Exception {
        cleanable.clean();

    }

}
