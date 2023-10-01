package io.nirahtech.librairies.html;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

public interface HTMLTag extends Root {
    String getId();
    void after(HTMLTag node);
    void append(HTMLTag... nodes);
    void appendChild(HTMLTag node);
    void before(HTMLTag node);
    boolean contains(HTMLTag node);
    Optional<String> getAttribute(final String attributeName);
    Optional<HTMLTag> getRootNode();
    Tag getTag();
    Optional<String> getName();
    Collection<String> getClassNames();
    Map<String, Object> getAttributes();
    String getInnerHtml();
    Optional<Object> getValue();
    Collection<HTMLTag> getChildren();
    Stylesheet getStylesheet();
}
