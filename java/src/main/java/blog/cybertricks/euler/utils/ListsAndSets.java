package blog.cybertricks.euler.utils;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ListsAndSets {
    private final Logger logger;

    @Autowired
    public ListsAndSets(Logger logger) {
        this.logger = logger;
    }

    public Map<Integer, Integer> getNumberOfOccurrencesMap(List<Integer> list) {
        HashMap<Integer, Integer> occurrenceMap = new HashMap<>();
        for (Integer element : list) {
            if (occurrenceMap.getOrDefault(element, -1) == -1) {
                occurrenceMap.put(element, 1);
            } else {
                occurrenceMap.put(element, occurrenceMap.get(element) + 1);
            }
        }
        return occurrenceMap;
    }

    // TODO: don't return Integer but an instance of a custom class
    public List<Integer> getMaximumOccurrence(List<Integer> list) {
        Map<Integer, Integer> map = getNumberOfOccurrencesMap(list);
        ArrayList<Integer> maximumOccurrence = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (maximumOccurrence.isEmpty()) {
                maximumOccurrence.add(entry.getKey());
                maximumOccurrence.add(entry.getValue());
            } else if (entry.getValue() > maximumOccurrence.get(1)) {
                maximumOccurrence.clear();
                maximumOccurrence.add(entry.getKey());
                maximumOccurrence.add(entry.getValue());
            }
        }
        return maximumOccurrence;
    }


    public Map<Integer, Integer> getNumberOfConsecutiveOccurrencesMap(List<Integer> list) {
        HashMap<Integer, Integer> occurrenceMap = new HashMap<>();
        int consecutiveAppearancesForCurrentValue = 1;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).equals(list.get(i - 1))) {
                consecutiveAppearancesForCurrentValue += 1;
                Integer element = list.get(i);
                if (occurrenceMap.getOrDefault(element, -1) == -1) {
                    occurrenceMap.put(element, consecutiveAppearancesForCurrentValue);
                } else if (occurrenceMap.get(element) < consecutiveAppearancesForCurrentValue) {
                    occurrenceMap.put(element, consecutiveAppearancesForCurrentValue);
                }
            } else {
                consecutiveAppearancesForCurrentValue = 1;
            }
        }
        return occurrenceMap;
    }

    public List<Integer> getMaximumConsecutiveOccurrence(List<Integer> list) {
        Map<Integer, Integer> map = getNumberOfConsecutiveOccurrencesMap(list);
        ArrayList<Integer> maximumOccurrence = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (maximumOccurrence.isEmpty()) {
                maximumOccurrence.add(entry.getKey());
                maximumOccurrence.add(entry.getValue());
            } else if (entry.getValue() > maximumOccurrence.get(1)) {
                maximumOccurrence.clear();
                maximumOccurrence.add(entry.getKey());
                maximumOccurrence.add(entry.getValue());
            }
        }
        return maximumOccurrence;
    }
}
