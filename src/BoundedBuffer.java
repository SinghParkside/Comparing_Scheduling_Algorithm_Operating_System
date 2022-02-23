//package Semaphores.boundedbuffer;

import java.util.concurrent.Semaphore;

/**
 * BoundedBuffer.java
 *
 * This program implements the bounded buffer with semaphores.
 * Note that the use of count only serves to output whether
 * the buffer is empty of full.
 *
 * Bounded buffer is the ready queue just have
 * there is one condition where is the
 */
public class BoundedBuffer implements Buffer {

        protected static final int BUFFER_SIZE = 5;
        protected Semaphore mutex;
        protected Semaphore empty;
        protected Semaphore full;

        protected static int count;

        protected int in, out;

        protected Job[] buffer;

     //   Statisitics stats = new Statisitics();

        public BoundedBuffer() {
                // buffer is initially empty
                count = 0;
                in = 0;
                out = 0;

                buffer = new Job[BUFFER_SIZE];

                mutex = new Semaphore(1);
                empty = new Semaphore(BUFFER_SIZE);
                full = new Semaphore(0);
        }

        // producer calls this method
        public void insert(Job item) {
                try {

                        empty.acquire();
                        mutex.acquire();

                } catch (Exception e) {
                }
                // add an item to the buffer


                        ++count;
                        buffer[in] = item;
                        in = (in + 1) % BUFFER_SIZE;



                mutex.release();
                full.release();
        }

        // consumer calls this method
        public Job remove() {
                try {
                        full.acquire();
                        mutex.acquire();
                } catch (Exception e) {
                }

                // remove an item from the buffer
             //   if ()
               // --count;
                Job item = buffer[out];
                out = (out + 1) % BUFFER_SIZE;

                //System.out.println("Removed the Job : " + count);


                mutex.release();
                empty.release();

                return item;
        }

        @Override
        public int bufferSize() {
                return count;
        }
}
