import java.util.Comparator;

    public class SortType implements Comparator<Event> {
        @Override
        public int compare(Event e1, Event e2) {
            String typeEvent1 = e1.getEventType().toLowerCase();
            String typeEvent2 = e2.getEventType().toLowerCase();

            return typeEvent1.compareTo(typeEvent2);
        }
    }
