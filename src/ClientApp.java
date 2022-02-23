/**
 * Client App works as producer
 * produces a job and puts it into the bounded buffer
 */
public class ClientApp implements Runnable {
    int countJobs = 0;
    // private int nap = 5;
    private Buffer buffer;
    String appType;
    int nap ;
    boolean stopLoop = true;
    int servTime;

    public ClientApp (Buffer b , int interarr ,int serviceTime, String appType){
        buffer = b;
        this.appType = appType;
        this.nap = interarr;
        this.servTime = serviceTime;
    }

    public void run() {
        Job job;
        while (stopLoop) {
            countJobs++;
            job = new Job(countJobs, appType, servTime);
            job.setServTime(servTime);
            buffer.insert(job);
            //Print the print line by the description of program
            System.out.println("Create JT" + job.getAppType() + " " + job.getCount() + " " +
                    job.getCreateTime() + " " +  "bfr : " + buffer.bufferSize());
            SleepUtilities.nap(nap);// this is where the interarrival time goes
        }
    }
    // Method to stop the program for the certain time
    public void stop(){
        stopLoop = false;
    }
}
