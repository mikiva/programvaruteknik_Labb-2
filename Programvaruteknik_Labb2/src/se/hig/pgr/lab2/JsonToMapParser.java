package se.hig.pgr.lab2;


import com.owlike.genson.Genson;
import java.util.Map;


/**
 *
 * @author thomas
 */
public class JsonToMapParser {

    private final String json;

    public JsonToMapParser(String json) {
        this.json = json;
    }
    
    public Map<String, Object> getResult() {
        return new Genson().deserialize(json, Map.class);
    }
}
