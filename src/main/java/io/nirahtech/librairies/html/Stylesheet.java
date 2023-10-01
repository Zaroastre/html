package io.nirahtech.librairies.html;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Stylesheet
 */
public class Stylesheet {
    private final Map<String, String> styles = new HashMap<>();

    public Map<String, String> getStyles() {
        return Collections.unmodifiableMap(this.styles);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{\n");
        this.styles.entrySet().forEach(property -> {
            builder.append("\t");
            builder.append(String.format("%s: %s;", property.getKey(), property.getValue()));
            builder.append("\n");
        });
        builder.append("}");
        return builder.toString();
    }
}