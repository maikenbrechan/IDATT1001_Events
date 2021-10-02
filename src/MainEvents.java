import javax.swing.*;
import static javax.swing.JOptionPane.*;

public class MainEvents {
    public static void main(String[] args) {
        EventRegister Shows = new EventRegister();

        Event nickiConsert = new Event("Pinkprint", "Oslo", "ticketmaster", "Consert", 201511161900L, 10);
        Event samConsert = new Event("Lonely hour", "Oslo", "Simon Cowell", "Consert", 201406202000L, 17);
        Event guettaConsert = new Event("Beat", "Oslo", "ticketmaster", "Consert", 201105171800L, 11);
        Event bookOfMormons = new Event("Book of Mormones", "London theatre", "actors", "Theatre", 201911211700L, 21);
        Event billieConsert = new Event("Third Man", "Madrid", "Interscope", "Consert", 201911212100L, 15);
        Event gagaConsert = new Event("Bad Romance", "London", "ticketmaster", "Consert", 201511222000L, 13);
        Event camilaConsert = new Event("Havana", "Madrid", "ticketmaster", "Consert", 202006181800L, 16);


        Shows.addEvent(nickiConsert);
        Shows.addEvent(samConsert);
        Shows.addEvent(guettaConsert);
        Shows.addEvent(bookOfMormons);
        Shows.addEvent(billieConsert);
        Shows.addEvent(gagaConsert);
        Shows.addEvent(camilaConsert);

        try {
            boolean running = true;
            while (running) {
                String menu = JOptionPane.showInputDialog("1.See events on one day \n 2.Add an Event \n 3.See events between two dates \n 4. See all events sorted \n 5.Exit program ");
                int choice = Integer.parseInt(menu);
                switch (choice) {
                    case 1:
                        String pickAdate = JOptionPane.showInputDialog("Write a date(yyyymmdd): ");
                        int date = Integer.parseInt(pickAdate);

                        if (date < 0 || date > 20201019) {
                            JOptionPane.showMessageDialog(null, "Unvalid date");
                        } else {
                            JOptionPane.showMessageDialog(null, Shows.checkDate(date));
                        }
                        break;
                    case 2:
                        JTextField eventName = new JTextField();
                        JTextField eventPlace = new JTextField();
                        JTextField eventOrganizer = new JTextField();
                        JTextField eventType = new JTextField();
                        JTextField eventTime = new JTextField();
                        JTextField eventNum = new JTextField();

                        Object[] message = {
                                "Name of the event: ", eventName,
                                "Where is the event? ", eventPlace,
                                "Who organizes it? ", eventOrganizer,
                                "What kind of event is it? ", eventType,
                                "Write the time of the event (yyyymmddklkl 'L') :", eventTime,
                                "Eventnumber: ", eventNum,
                        };

                        showConfirmDialog(null, message, "Input", JOptionPane.OK_CANCEL_OPTION);

                        long whenEvent = Long.parseLong(eventTime.getText());
                        int eventNumb = Integer.parseInt(eventNum.getText());

                        Event newEvent = new Event(eventName.getText(), eventPlace.getText(), eventOrganizer.getText(), eventType.getText(), whenEvent, eventNumb);
                        Shows.addEvent(newEvent);
                        break;
                    case 3:
                        String firstDay = JOptionPane.showInputDialog("Write the first date (yyyymmdd):");
                        long start = Long.parseLong(firstDay);
                        String secondDay = JOptionPane.showInputDialog("Write the second date(yyyymmdd) : ");
                        long end = Long.parseLong(secondDay);

                        Shows.betweenDates(start, end);
                        JOptionPane.showMessageDialog(null, menu);
                        break;
                    case 4:
                        String pickSort = showInputDialog("1.Sort by time \n 2.Sort by type \n 3.Sort by place");
                        int sort = Integer.parseInt(pickSort);
                        if(sort==1){
                            Shows.sortByTime();
                            showMessageDialog(null, Shows.toString());
                        }
                        else if(sort==2){
                            Shows.sortByType();
                            showMessageDialog(null, Shows.toString());
                        }
                        else if(sort==3){
                            Shows.sortByPlace();
                            showMessageDialog(null, Shows.toString());
                        }
                        else{
                            break;
                        }
                        break;
                    case 5:
                        running= false;
                        break;
                }//switch
            }//while-loop
        }catch (IllegalArgumentException e){
            JOptionPane.showMessageDialog(null, "Write a valid number. ");}
    }//main
}//class

