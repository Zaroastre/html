package io.nirahtech.librairies.html;

public record Metadata(String name, Object value) {
    
    @Override
    public String toString() {
        return String.format("<meta name='%s' content='%s' />", this.name, this.value);
    }
}
