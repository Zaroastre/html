package io.nirahtech.librairies.html;

import java.io.Serializable;

public final class Html implements Serializable {

    private final Header header;
    private final Body body;

    Html(final Header header, final Body body) {
        this.header = header;
        this.body = body;
    }

    public Header getHeader() {
        return this.header;
    }

    public final Body getBody() {
        return this.body;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder()
            .append("<!DOCTYPE html>\n")
            .append("<html>\n")
            .append(this.header.toString())
            .append(this.body.toString())
            .append("</html>\n");
        return builder.toString();
    }
}
