/**
 * Factory runs the producer and consumer and starts the factory
 */
class Factory {

    public static void main(String args[]) {
        Buffer server = new BoundedBuffer();
        Statisitics cpu = new Statisitics();
        Statisitics io = new Statisitics();
        // now create the producer and consumer threads
        Thread producerThread = new Thread(new ClientApp(server, 10, 4,"1"));
        Thread producerThread2 = new Thread(new ClientApp(server, 100,55,"2"));
        Thread consumerThread0 = new Thread(new SchedulerServer(server,io,cpu));
        // Thread consumerThread1 = new Thread(new SchedulerServer(server));
        //Thread consumerThread2 = new Thread(new SchedulerServer(server));
        long startStimulationTime = System.currentTimeMillis();
        producerThread.start();
         producerThread2.start();
        consumerThread0.start();
        long currentSystemTime = System.currentTimeMillis();
        // Loop iof the time equals the current time then interrupt the program
        while (System.currentTimeMillis() < currentSystemTime + 80000){}
        long endStimulationTime = System.currentTimeMillis();
        long totalTime = endStimulationTime - startStimulationTime;
        // Sets the CPU utilization for io bound job
        io.setProcessCpuUtilization(totalTime);
        // Sets the CPU utilization for cpu bound job
        cpu.setProcessCpuUtilization(totalTime);
        producerThread.stop();
        //producerThread2.stop();
        consumerThread0.stop();
        System.out.println("Client App Exiting");
        System.out.println("Schedule App ");
        System.out.println();
        //To string to print all the stats
        System.out.println(cpu.toString() + io.toString());

    }

}
