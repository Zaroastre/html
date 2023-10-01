package io.nirahtech.librairies.html;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class HtmlBuilder {

    private String title;
    private Charset charset;
    private Set<Metadata> metadatas = new HashSet<>();
    private List<HTMLTag> nodes = new ArrayList<>();

    public final HtmlBuilder title(String title) {
        this.title = title;
        return this;
    }
    
    public final HtmlBuilder charset(Charset charset) {
        this.charset = charset;
        return this;
    }

    public final HtmlBuilder metadata(final String name, final Object value) {
        this.metadatas.add(new Metadata(name, value));
        return this;
    }

    public final HtmlBuilder node(HTMLTag node) {
        this.nodes.add(node);
        return this;
    }

    public final Html build() {
        final Header header = new Header(this.title, this.charset, this.metadatas.toArray(new Metadata[this.metadatas.size()]));
        final Body body = new Body(this.nodes.toArray(new HTMLTag[this.nodes.size()]));
        return new Html(header, body);
    }
}
