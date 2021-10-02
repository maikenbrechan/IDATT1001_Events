import java.util.ArrayList;
import java.util.Collections;

public class EventRegister {
    private ArrayList<Event> eventList;
    private int amountOfEvents;

    public EventRegister(){
        this.eventList  = new ArrayList<Event>();
        this.amountOfEvents = 0;
    }

    public int getAmountOfEvents(){return amountOfEvents;}

    public boolean addEvent(Event newEvent){
        for(int i=0; i<amountOfEvents; i++){
            if (eventList.get(i).getEventNum()==newEvent.getEventNum()){
                return false;
            }
        }
        eventList.add(newEvent);
        amountOfEvents++;
        return true;
    }

    public int eventsInPlace(String location){
        int a=0;
        for(int i=0;i<amountOfEvents;i++){
            if(eventList.get(i).getPlace().equals(location)){
                a++;
            }
        }
        return a;
    }

    public ArrayList<String> checkDate(long time){
        ArrayList<String> today = new ArrayList<String>();
        for(int i=0; i<amountOfEvents; i++){
            if(time*10000<=eventList.get(i).getTime() && eventList.get(i).getTime()<(time*10000)+100000){
                today.add(eventList.get(i).getEventType() + ": " + eventList.get(i).getName());
            }
        }
        return today;
    }

    public ArrayList<Event> betweenDates( long day1, long day2) {
        ArrayList<Event> between = new ArrayList<Event>();
        for (int i = 0; i < amountOfEvents; i++) {
            if (day1 * 1000 <= eventList.get(i).getTime() && eventList.get(i).getTime() <= day2 * 10000 + 10000) {
                between.add(eventList.get(i));
            }
        }
        return between;
    }
    public String toString(){
        String a = "";
        for(int i=0; i<amountOfEvents;i++){
            a += eventList.get(i).getName() + " \n";
        }
        return a;
        }

    public void sortByTime(){
        Collections.sort(eventList,new SortTime());
    }

    public void sortByType(){
        Collections.sort(eventList, new SortType());
    }

    public void sortByPlace(){
        Collections.sort(eventList, new SortPlace());
    }
}
