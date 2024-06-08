package com.andersenlab.lesson2;
import java.util.ArrayList;

public class TicketService {
    static final String ID = "5Gsr";
    static final String VEGA_ARENA = "Vega Arena";
    static final String EVENT_CODE = "005";
    static final long EVENT_DATE_TIMESTAMP = 1723240800;
    static final double MAX_BACKPACK_WEIGHT = 5.5;
    static final int PRICE_IN_CENTS = 20000;
    private static final ArrayList<Ticket> storage = new ArrayList<>();

    public static void main(String[] args) {
        Ticket empty = Ticket.createTicket();
        Ticket full = Ticket.createTicket(ID, VEGA_ARENA, EVENT_CODE,
                EVENT_DATE_TIMESTAMP, false,
                StadiumSector.B, MAX_BACKPACK_WEIGHT, PRICE_IN_CENTS);
        Ticket limited = Ticket.createTicket(VEGA_ARENA, EVENT_CODE, EVENT_DATE_TIMESTAMP);

        System.out.println(empty);
        System.out.println(full);
        System.out.println(limited);

        storage.add(empty);
        storage.add(full);
        storage.add(limited);

        System.out.println(getTicketBySector(StadiumSector.B));
    }

    private static Ticket getTicketBySector (StadiumSector sector){
        for (Ticket ticket : storage) {
            if (ticket.getStadiumSector() == sector){
                return ticket;
            }
        }
        return null;
    }
}
