/**
 * Scheduler Server works as Consumer which will take the buffer
 * from Client App and removes it from the buffer and process the stats
 */
public class SchedulerServer implements Runnable {
    public static final int quantum = 10;
    // Buffer Object
    private Buffer buffer;
    // Cpu type job
    private Statisitics cpustats;
    // Io type jobs
    private Statisitics iostats;
    // Statistic type object
    private Statisitics s;
    // Boolean variable to stop the program from running infinitly
    boolean stopL = true;
    // Starts the creation time when

    long startProgramTime = System.currentTimeMillis();

    /**
     * +
     * Sets the Starts Program Time
     *
     * @param startProgramTime Takes in argument as start Program Time
     */
    public void setStartProgramTime(long startProgramTime) {
        this.startProgramTime = startProgramTime;
    }

    /**
     * +
     * Constructor for consumer that take the following arguments
     *
     * @param b   Buffer
     * @param cpu Cpu type jobs
     * @param io  io types jobs
     */

    public SchedulerServer(Buffer b, Statisitics cpu, Statisitics io) {
        buffer = b;
        this.cpustats = cpu;
        this.iostats = io;
    }

    /**
     * Run method that
     */

    public void run() {
        Job message;


            while (stopL) {

                message = buffer.remove();

                long startTime = System.currentTimeMillis();
                message.setprocessStartTime(startTime);

                if (message.getAppType().equals("1")) {
                    iostats.setAppType("1");
                    //message.setServiceTime((long) (4 * -Math.log(Math.random())));
                    if (message.getServTime() <= quantum) {
                        SleepUtilities.nap((int) message.getServTime());
                        long endTime = System.currentTimeMillis();
                        message.setCompletionTime(endTime);
                        System.out.println("Process JT" + message.getAppType() + " " + message.getCount() + " " + " " +
                                startTime + " bfr : " + buffer.bufferSize());

                    iostats.addStats(message);
                    } else {
                        SleepUtilities.nap(quantum);
                        message.setServTime(message.getServTime() - quantum);
                        System.out.println("Process JT" + message.getAppType() + " " + message.getCount() + " " + " " +
                                startTime + " bfr : " + buffer.bufferSize());
                        buffer.insert(message);

                    }
                } else if (message.getAppType().equals("2")) {
                            cpustats.setAppType("2");
                 //   message.setServiceTime((long) (55 * -Math.log(Math.random())));

                    if (message.getServiceTime() <= quantum) {

                        SleepUtilities.nap((int) message.getServTime());
                        long endTime = System.currentTimeMillis();
                        message.setCompletionTime(endTime);
                        System.out.println("Process JT" + message.getAppType() + " " + message.getCount() + " " + " " +
                                startTime + " bfr : " + buffer.bufferSize());
                        message.setServiceTime(endTime - startTime);
                        cpustats.addStats(message);


                    } else {
                        try {
                            Thread.sleep(quantum);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        message.setServiceTime(message.getServiceTime() - quantum);
                        System.out.println("Process JT" + message.getAppType() + " " + message.getCount() + " " + " " +
                                startTime + " bfr : " + buffer.bufferSize());
                        buffer.insert(message);

                    }
                }
            }



        }


    // Stop method to stop the program
    public void stop() {
        stopL = false;
    }
}

