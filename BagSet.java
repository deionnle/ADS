import java.util.ArrayList;
import java.util.HashMap;

public class BagSet {
    private  HashMap<String, Integer> elements;

    public BagSet() {
        this.elements = new HashMap<>();
    }

    public void add(String value) {
        elements.put(value, elements.getOrDefault(value, 0) + 1);
    }

    public boolean remove(String value) {
        if (elements.containsKey(value)) {
            int count = elements.get(value);
            if (count > 1) {
                elements.put(value, count - 1);
            } else {
                elements.remove(value);
            }
            return true;
        }
        return false;
    }

    public ArrayList<String> getElements() {
        ArrayList<String> result = new ArrayList<>();
        for (HashMap.Entry<String, Integer> entry : elements.entrySet()) {
            result.add(entry.getKey() + ": " + entry.getValue());
        }
        return result;
    }
}
