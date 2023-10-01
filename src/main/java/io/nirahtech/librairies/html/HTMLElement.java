package io.nirahtech.librairies.html;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

final class HTMLElement implements HTMLTag, Serializable {

    private final String id;
    private final Tag tag;
    private String name = null;
    private final Set<String> classNames = new HashSet<>();
    private final Map<String, Object> attributes = new HashMap<>();
    private String innerHtml = null;
    private Object value = null;
    private final List<HTMLTag> children = new ArrayList<>();
    private int depth = 1;

    HTMLElement(final Tag tag, final String id, final Collection<String> classNames, final Map<String, Object> attributes) {
        this.tag = tag;
        this.id = id;
        if (Objects.nonNull(classNames)) {
            this.classNames.addAll(classNames);
        }
        
        if (Objects.nonNull(attributes)) {
            this.attributes.putAll(attributes);
        }
    }

    @Override
    public final String getId() {
        return this.id;
    }
    public final void setInnerHtml(final String innerHtml) {
        this.innerHtml = innerHtml;
    }
    public final void setName(final String name) {
        this.name = name;
    }
    public final void setValue(final Object value) {
        this.value = value;
    }

    @Override
    public final Tag getTag() {
        return this.tag;
    }
    @Override
    public final Optional<String> getName() {
        return Optional.ofNullable(this.name);
    }
    @Override
    public final Collection<String> getClassNames() {
        return Collections.unmodifiableCollection(classNames);
    }
    @Override
    public final Map<String, Object> getAttributes() {
        return Collections.unmodifiableMap(this.attributes);
    }
    @Override
    public final String getInnerHtml() {
        return this.innerHtml;
    }
    @Override
    public final Optional<Object> getValue() {
        return Optional.ofNullable(this.value);
    }
    @Override
    public final Collection<HTMLTag> getChildren() {
        return Collections.unmodifiableCollection(this.children);
    }

    @Override
    public final Optional<HTMLTag> getElementById(final String id) {
        return this.children.stream().filter(node -> node.getId().equalsIgnoreCase(id)).findFirst();
    }

    @Override
    public final Collection<HTMLTag> getElementsByTagName(final Tag tag) {
        return Collections.unmodifiableCollection(this.children.stream().filter(node -> node.getTag().equals(tag)).toList());
    }

    @Override
    public final Collection<HTMLTag> getElementsByClassName(final String className) {
        return Collections.unmodifiableCollection(this.children.stream().filter(node -> node.getClassNames().contains(className)).toList());
    }

    @Override
    public final Collection<HTMLTag> getElementsByName(String name) {
        return Collections.unmodifiableCollection(
            this.children
                    .stream()
                    .filter(node -> {
                        boolean canPass = false;
                        final Optional<String> nodeName = node.getName();
                        if (nodeName.isPresent()) {
                            canPass = nodeName.get().equalsIgnoreCase(name);
                        }
                        return canPass;
                    })
                    .toList());
    }


    @Override
    public final void after(final HTMLTag node) {
        this.children.add(node);
    }

    @Override
    public final void append(final HTMLTag... nodes) {
        this.children.addAll(Arrays.asList(nodes));
    }

    @Override
    public final void appendChild(final HTMLTag node) {
        this.children.add(node);
    }

    @Override
    public final void before(final HTMLTag node) {
        this.children.add(0, node);
    }

    @Override
    public final boolean contains(final HTMLTag node) {
        boolean isFound = this.children.contains(node);
        if (!isFound) {
            isFound = this.children.stream().filter(child -> child.contains(node)).findFirst().isPresent();
        }
        return isFound;
    }

    @Override
    public final Optional<String> getAttribute(final String attributeName) {
        Optional<String> attributeValue = Optional.empty();
        if (this.attributes.containsKey(attributeName)) {
            attributeValue = Optional.ofNullable(attributeName);
        }
        return attributeValue;
    }

    @Override
    public final Optional<HTMLTag> getRootNode() {
        return Optional.empty();
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder()
                .append(String.format("<%s", this.tag.name().toLowerCase()));
        if (this.id != null) {
            builder.append(String.format(" id='%s'", this.id));
        }
        if (!this.classNames.isEmpty()) {
            builder.append(String.format(" class='%s'", this.classNames.stream().collect(Collectors.joining(" "))));
        }
        if (!this.attributes.isEmpty()) {
            this.attributes.entrySet().forEach(attribute -> {
                builder.append(String.format(" %s=%s", attribute.getKey(), attribute.getValue()));
            });
        }

        if (Objects.nonNull(this.name)) {
            builder.append(String.format(" name='%s'", this.name));
        }
        
        if (Objects.nonNull(this.value)) {
            builder.append(String.format(" value='%s'", this.value));
        }
        builder.append(">\n");

        if (Objects.nonNull(this.innerHtml)) {
            builder.append(this.innerHtml);
        } else {
            this.children.forEach(child -> {
                builder.append(child.toString()).append("\n");
            });
        } 

        builder.append(String.format("\n</%s>", this.tag.name().toLowerCase()));
        return builder.toString();
    }
    
}
