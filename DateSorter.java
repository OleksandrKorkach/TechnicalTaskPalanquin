package sample;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Marking will be based upon producing a readable, well engineered solution rather than factors
 * such as speed of processing or other performance-based optimizations, which are less
 * important.
 *
 *
 package sample;

 import java.time.LocalDate;
 import java.util.Collection;
 import java.util.List;

 /**
 * Marking will be based upon producing a readable, well engineered solution rather than factors
 * such as speed of processing or other performance-based optimizations, which are less
 * important.
 *
 * Implement in single class. Don't chane constructor and signature method.
 */
public class DateSorter {

    /**
     * The implementation of this method should sort dates.
     * The output should be in the following order:
     * Dates with an 'r' in the month,
     * sorted ascending (first to last),
     * then dates without an 'r' in the month,
     * sorted descending (last to first).
     * For example, October dates would come before May dates,
     * because October has an 'r' in it.
     * thus: (2004-07-01, 2005-01-02, 2007-01-01, 2032-05-03)
     * would sort to
     * (2005-01-02, 2007-01-01, 2032-05-03, 2004-07-01)
     *
     * @param unsortedDates - an unsorted list of dates
     * @return the collection of dates now sorted as per the spec
     */
    public Collection<LocalDate> sortDates(List<LocalDate> unsortedDates) {
        List<LocalDate> withR = new ArrayList<>();
        List<LocalDate> withoutR = new ArrayList<>();

        for (LocalDate date: unsortedDates){
            distributeDateDependingOnR(date, withR, withoutR);
        }

        Collection<LocalDate> result = new ArrayList<>();
        result.addAll(sortDatesAscending(withR));
        result.addAll(sortDatesDescending(withoutR));
        return result;
    }

    void distributeDateDependingOnR(LocalDate date, List<LocalDate> withR, List<LocalDate> withoutR){
        if (isMonthNameContainsR(date.getMonth())){
            withR.add(date);
        } else {
            withoutR.add(date);
        }
    }

    Boolean isMonthNameContainsR(Month month){
        return month.toString().toLowerCase().contains("r");
    }

    List<LocalDate> sortDatesAscending(List<LocalDate> dates){
        return dates.stream().sorted().collect(Collectors.toList());
    }

    List<LocalDate> sortDatesDescending(List<LocalDate> dates){
        return dates.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }
}