import java.util.Comparator;

    public class SortPlace implements Comparator<Event> {
        @Override
        public int compare(Event e1, Event e2){
            String placeEvent1 = e1.getPlace().toLowerCase();
            String placeEvent2 = e2.getPlace().toLowerCase();

            return placeEvent1.compareTo(placeEvent2);
        }
    }
