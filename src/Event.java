public class Event {
    private int eventNum;
    private String name;
    private String place;
    private String organizer;
    private String eventType;
    private long time;

    public Event(String name, String place, String organizer, String eventType, long time, int eventNum) {
    this.name=name;
    this.place=place;
    this.organizer=organizer;
    this.eventType =eventType;
    this.time=time; //yyyymmddhhmm
    this.eventNum=eventNum;
    }

    public String getName(){return name;}

    public String getPlace(){return place;}

    public String getOrganizer(){return organizer;}

    public String getEventType(){return eventType;}

    public long getTime(){return time;}

    public int getEventNum(){return eventNum;}

    public long seeDate(){
        long year = time/100000000;
        long month = (time%100000000)/1000000;
        long date = ((time%100000000)%1000000)/10000;
        return year + month + date;
    }

    public String toString(){
        return getEventType() + ", " + getName() + ", Date: " + seeDate() + ", Location: " + getPlace() + ", organizer: " + getOrganizer() + ", eventnumber: " + getEventNum();}
}
