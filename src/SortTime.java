import java.util.Comparator;

public class SortTime implements Comparator<Event> {
    @Override
    public int compare(Event o1, Event o2) {
        long time1 = o1.getTime();
        long time2 = o2.getTime();

        return (int) (time2 - time1);
    }
}
