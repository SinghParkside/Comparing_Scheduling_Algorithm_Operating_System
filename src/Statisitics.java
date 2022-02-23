/**
 * Name : Ishmeet Singh
 * Professor : Susan Linke
 * Course Name : Operating System
 * Project Name : Statistic class will calculate the following below
 * average service time per job class: time the server actually processes the job,
 * maximum service time per job class,
 * average turnaround (or response) time per job class: job’s end_time – job’s creation_time,
 * maximum turnaround (or response) time per job class,
 * average wait time per job class: job’s turnaround_time – job’s service_time,
 * maximum wait time per job class,
 * processor  (or  CPU)  utilization  =  %  of  time  processor  busy  =  total  consumer  busy  time  /  total
 * time.
 *
 *
 * Known Bugs : NONE!
 *
 */
public class Statisitics {
    // Variables for the calculation for the following stats given in the description
    private long avgSertviceTime;
    private long maxServiceTime;
    private long avgTurnaroundTime;
    private long maxTurnaroundTime;
    private double processCpuUtilization;
    private double avgWaitTime;
    private long maxWaitTime;
    private long randomServiceTime;
    private long randomInterarrivalTime;

    private long sumSt;
    private long sumTa;
    private int count;
    private long sumWT;
    private String appType;
    /**
     * Default constructor which sets the variables to 0 in order to avoid null
     * pointer exception
     */
    public Statisitics() {
        this.avgSertviceTime = 0;
        this.maxServiceTime = 0;
        this.avgTurnaroundTime = 0;
        this.maxTurnaroundTime = 0;
        this.processCpuUtilization = 0;
        this.avgWaitTime = 0;
        this.maxWaitTime = 0;
        this.appType = " ";
    }

    /**
     * Method that sets the app type if appType equals 1 then run the specific app
     * and if appType equals 2 then run the specific job type
     * @param appType Takes the string 1 or 2 for I/O bound and CPU Bound
     */
    public void setAppType(String appType) {
        this.appType = appType;
    }

    /**
     * Method that tracks of jobs .
     * @param j jobs
     */
    public void setCount(Job j ){
        count = j.getCount();
    }

    /**+
     *  Method gets the App Type I/O Bound or CPU Bound
     * @return Gets the App Type
     */
    public String getAppType() {
        return appType;
    }

//    public void setRandomServiceTime(){
//        double j1 = 10 * -Math.log(Math.random());
//    }

    public double getRandomServiceTime() {
        return randomServiceTime = (long) (10 * -Math.log(Math.random()));
    }

    /**
     * Method Calculate the Average wait time
     * sum of all the wait time / count
     * @param avgWaitTime Gets all the average time from the job class
     */
    public void setAvgWaitTime(Job avgWaitTime) {
        sumWT += avgWaitTime.getWaitTime();
        this.avgWaitTime = (double) (sumWT / (double) avgWaitTime.getCount());
    }
    /**
     * Method sets the Max wait time using Math library in java then compare the max value
     * from the set of wait times
     * @param j Job object to get the wait time which is calculated in Job Class
     */

    public void setMaxWaitTime(Job j) {
        maxWaitTime = Math.max(maxWaitTime,j.getWaitTime());
    }
    /**
     * Method Calculate the Average TurnAround time
     * sum of all the TurnAround time / count
     * @param avgTA Job input to get all the turnaround times from job class
     */
    public void setAvgTurnaroundTime(Job avgTA){
        sumTa += avgTA.getTurnAroundTime();
        this.avgTurnaroundTime = sumTa / avgTA.getCount();
    }

    /**+
     * Sets the Average Service Time
     * @param avg Grabs the Service Time from job class
     */

    public void setAvgSertviceTime(Job avg) {
        sumSt += avg.getServiceTime();
        this.avgSertviceTime = sumSt / avg.getCount();
    }

    /**+
     * Sets the MAx TurnAround Time
     * @param j Grabs the TurnAround Time from the Job Class
     */

    public void setMaxTurnaroundTime(Job j) {
        maxTurnaroundTime = Math.max(maxTurnaroundTime, j.getTurnAroundTime());
    }

    /**
     * Sets the Max Service Time
     * @param j Grabs alll the Service Time from the Job Class
     */
    public void setMaxServiceTime(Job j) {
        this.maxServiceTime = Math.max(maxServiceTime, j.getServiceTime());
    }

    /**
     * Sets CPU Utilization for the overall Program
     * @param input takes the input as argument in order to do calculation
     */

    public void setProcessCpuUtilization(long input){
        processCpuUtilization = (double) sumSt / input;
        processCpuUtilization *= 100;
    }
    public void addStats(Job j) {
        setMaxServiceTime(j);
        setMaxTurnaroundTime(j);
        setAvgSertviceTime(j);
        setAvgTurnaroundTime(j);
        setMaxWaitTime(j);
        setAvgWaitTime(j);
        setCount(j);

//        cpu.setAppType();
    }

    /**
     * To String Method To print all the Statistic which are calculated
     * @return Return the String Object
     */
    @Override
    public String toString() {
        return "\n **********########  Statisitics  ############***********" +
                "\n Job type " + getAppType() +
                "\n Average ServiceTime = " + avgSertviceTime +
                "\n Max Service Time = " + maxServiceTime +
                "\n Average Turnaround Time = " + avgTurnaroundTime +
                "\n Max Turnaround Time = " + maxTurnaroundTime +
                "\n Max Wait Time = " + maxWaitTime +
                "\n Avg Wait Time = " + avgWaitTime+
                "\n Total Number of Jobs "  + count +
                "\n CPU Process Utilization : " + processCpuUtilization;
    }
}
