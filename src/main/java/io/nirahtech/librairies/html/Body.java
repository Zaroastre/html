package io.nirahtech.librairies.html;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public final class Body implements Root, Serializable {

    private final List<HTMLTag> children = new ArrayList<>();

    Body(HTMLTag... nodes) {
        this.children.addAll(Arrays.asList(nodes));
    }

    @Override
    public Optional<HTMLTag> getElementById(String id) {
        return this.children.stream().filter(node -> node.getId().equalsIgnoreCase(id)).findFirst();
    }

    @Override
    public List<HTMLTag> getElementsByTagName(Tag tag) {
        throw new UnsupportedOperationException("Unimplemented method 'getElementsByClassName'");
    }

    @Override
    public List<HTMLTag> getElementsByClassName(String className) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getElementsByClassName'");
    }

    @Override
    public List<HTMLTag> getElementsByName(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getElementsByName'");
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder()
                .append("\t<body>\n");
        this.children.forEach(child -> {
            builder.append("\t\t")
                    .append(child.toString())
                    .append("\n");
        });
        builder.append("\t</body>\n");
        return builder.toString();
    }

}
