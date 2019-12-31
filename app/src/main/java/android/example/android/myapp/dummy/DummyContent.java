package android.example.android.myapp.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    private static final int COUNT = 25;

    static {
        addItem(new DummyItem("1","Department of Applied Geology","http://www.nitrr.ac.in/aboutgeology.php"));
        addItem(new DummyItem("2","Department of Architecture","http://www.nitrr.ac.in/aboutarchi.php"));
        addItem(new DummyItem("3","Department of Bio-Medical","http://www.nitrr.ac.in/aboutbiomed.php"));
        addItem(new DummyItem("4","Department of Bio-Technology","http://www.nitrr.ac.in/aboutbiotech.php"));
        addItem(new DummyItem("5","Department of Chemical Engineering","http://www.nitrr.ac.in/aboutchemical.php"));
        addItem(new DummyItem("6","Department of Civil Engineering","http://www.nitrr.ac.in/aboutcivil.php"));
        addItem(new DummyItem("7","Department of Computer Science and Engineering","http://www.nitrr.ac.in/aboutcse.php"));
        addItem(new DummyItem("8","Department of Chemistry","http://www.nitrr.ac.in/aboutchemistry.php"));
        addItem(new DummyItem("9","Department of Mathematics","http://www.nitrr.ac.in/aboutmaths.php"));
        addItem(new DummyItem("10","Department of Physics","http://www.nitrr.ac.in/aboutphysics.php"));
        addItem(new DummyItem("11","Department of Humanities aand Social Sciences","http://www.nitrr.ac.in/aboutenglish.php"));
        addItem(new DummyItem("12","Department of Electrical","http://www.nitrr.ac.in/aboutelectrical.php"));
        addItem(new DummyItem("13","Department of Electronics and Communication Engineering","http://www.nitrr.ac.in/aboutelectronics.php"));
        addItem(new DummyItem("14","Department of Information Technology","http://www.nitrr.ac.in/it.php"));
        addItem(new DummyItem("15","Department of Master in Computer Applications","http://www.nitrr.ac.in/mca.php"));
        addItem(new DummyItem("16","Department of Mechanical Engineering","http://www.nitrr.ac.in/aboutmechanical.php"));
        addItem(new DummyItem("17","Department of Mining Engineering","http://www.nitrr.ac.in/aboutmining.php"));
        addItem(new DummyItem("18","Department of Metallurgical and Materials Engineering","http://www.nitrr.ac.in/aboutmeta.php"));
        addItem(new DummyItem("19","Department of Workshop","http://www.nitrr.ac.in/aboutworkshop.php"));
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static DummyItem createDummyItem(int position) {
        return new DummyItem(String.valueOf(position), "Item " + position, makeDetails(position));
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public final String id;
        public final String department;
        public final String url;

        public DummyItem(String id, String department, String url) {
            this.id = id;
            this.department = department;
            this.url = url;
        }

        @Override
        public String toString() {
            return department;
        }
    }
}
