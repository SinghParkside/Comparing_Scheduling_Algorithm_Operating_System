/**+
 * Name : Ishmeet Singh
 * Professor : Susan Linke
 * Course Name : Job Class prints stats used in stats class
 * Class Name : Job Class calculates the following
 *  Create Time : when Client produces a job
 *  Completion Time : when scheduler server completes the process the job
 *  Service Time : End time - Start time of comsumer (scheduler Server)
 *  TurnAround Time : completion time - create time
 *  ProcessStart TIme : When the schedular server starts the processing
 *  Wait Time

 */

public class Job {
  //Variable for the stats
  long createTime;
  long completionTime;
  long serviceTime;
  long turnAroundTime;
  long processsStartTime;
  long waitTime;
  long jobInfo;
  long servTime = 4;

  public long getRemainingTime() {
    return remainingTime;
  }

  public void setRemainingTime(long remainingTime) {
    this.remainingTime = remainingTime;
  }

  long remainingTime;


//  public void setRemainingTime(long remainingTime) {
//    this.remainingTime = remainingTime;
//  }

  private long randominterArrivalTime;
  private int count;
  private String appType;

  //default constuctor
  public Job() {
  }


  /**
   * +
   * Job class constructor
   *
   * @param a takes in a count of jobs
   * @param b takes in a types of jobs
   */
  public Job(int a, String b, int serviceTime) {
    count = a;
    appType = b;
    this.serviceTime = serviceTime;
    //Setting the create time right away
    createTime = System.currentTimeMillis();
  }

  /**
   * Getter for the completion time
   *
   * @return completion time
   */
  public long getCompletionTime() {
    return completionTime;
  }

  /**
   * Getter for the create time
   *
   * @return create time
   */
  public long getCreateTime() {
    return createTime;
  }

  public long getServTime()
  {
    return servTime;
  }

  public long setServTime(long l){
    return serviceTime = l;

  }

  /**
   * Sets the completion time from scheduler server
   *
   * @param completionTime Returns the completion time
   * @return the object
   */
  public Job setCompletionTime(long completionTime) {
    this.completionTime = completionTime;
    return this;
  }

  public long getProcesssStartTime() {
    return processsStartTime;
  }


  public void setServiceTime(long sleep) {
    this.serviceTime = sleep;
  }

  public long getServiceTime() {
    return serviceTime;
  }

  /**
   * +
   * Gets the turnaround time to calculate the max and average
   *
   * @return The turnAround time
   */
  public long getTurnAroundTime() {
    turnAroundTime = (completionTime - createTime);
    return turnAroundTime;
  }

  /**
   * Gets the app Type I/O bound or cpu bounds
   *
   * @return gets the app type
   */
  public String getAppType() {
    return this.appType;
  }

  /**
   * +
   * Gets the number of jobs
   *
   * @return Number of jobs
   */

  public int getCount() {
    return this.count;
  }

  /**
   * +
   * Sets the process start time for schedular server
   *
   * @param start input that sets the start time
   * @return process start time
   */
  public Job setprocessStartTime(long start) {
    this.processsStartTime = start;
    return this;
  }

  /**
   * Gets the wait time
   *
   * @return wait time
   */
  public long getWaitTime() {
    return processsStartTime - createTime;
  }





  /**
   * To string to print the object
   *
   * @return print object data
   */
  @Override
  public String toString() {
    return "\njob track : " + this.count + "\nCreateTime = " + this.createTime +
            "\nCompletion Time = " + this.completionTime +
            " \nServiceTime = " + getServiceTime() +
            "\nTurnAroundTime = " + getTurnAroundTime() +
            " \nprocesssStartTime = " + this.processsStartTime;
  }
}







