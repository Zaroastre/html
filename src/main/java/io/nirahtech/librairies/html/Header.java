package io.nirahtech.librairies.html;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class Header implements Serializable {
    private final String title;
    private final Charset charset; 
    private final List<Metadata> metadatas = new ArrayList<>();

    Header(final String title, final Charset charset, Metadata... metadatas) {
        this.title = title;
        if (charset == null) {
            this.charset = StandardCharsets.UTF_8;
        } else {
            this.charset = charset;
        }
        if (metadatas != null) {
            this.metadatas.addAll(Arrays.asList(metadatas));
        }
    }

    public final String getTitle() {
        return title;
    }
    public final Charset getCharset() {
        return charset;
    }
    public final Collection<Metadata> getMetadatas() {
        return Collections.unmodifiableCollection(this.metadatas);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder()
                .append("\t<head>\n")
                .append(String.format("\t\t<title>%s</title>\n", this.title))
                .append(String.format("\t\t<meta charset='%s'>\n", this.charset.name()));
        this.metadatas.forEach(metadata -> {
            builder.append("\t\t")
                    .append(metadata.toString())
                    .append("\n");
        });
        builder.append("\t</head>\n");
        return builder.toString();
    }

}
