package io.nirahtech.librairies.html;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public final class HTMLTagBuilder {
    
    private final Tag tag;
    private String id = null;
    private String name = null;
    private Set<String> classNames = new HashSet<>();
    private Map<String, Object> attributes = new HashMap<>();
    private String innerHtml = null;
    private Object value = null;
    private List<HTMLTag> children = new ArrayList<>();

    public HTMLTagBuilder(final Tag tag) {
        this.tag = tag;
    }

    public final HTMLTagBuilder id(final String id) {
        this.id = id;
        return this;
    }
    public final HTMLTagBuilder name(final String name) {
        this.name = name;
        return this;
    }
    public final HTMLTagBuilder className(final String className) {
        if (Objects.nonNull(className)) {
            this.classNames.add(className); 
        }
        return this;
    }
    public final HTMLTagBuilder attribute(final String name, final Object value) {
        this.attributes.put(name, value);
        return this;
    }
    public final HTMLTagBuilder innerHtml(final String innerHtml) {
        this.innerHtml = innerHtml;
        return this;
    }
    public final HTMLTagBuilder value(final Object value) {
        this.value = value;
        return this;
    }

    public final HTMLTagBuilder child(final HTMLTag child) {
        this.children.add(child);
        return this;
    }

    public final HTMLTag build() {
        final HTMLElement htmlTag =  new HTMLElement(this.tag, this.id, this.classNames, this.attributes);
        htmlTag.setInnerHtml(this.innerHtml);
        htmlTag.setName(this.name);
        htmlTag.setValue(this.value);
        htmlTag.append(this.children.toArray(new HTMLTag[this.children.size()]));
        return htmlTag;
    }

}
