package wto.lib.parser;

public enum TypeParser {

    XML("text/xml"),
    JSON("text/json");

    private String type;

    TypeParser(String type) {

        this.type = type;

    }

    @Override
    public String toString() {
        return type;
    }
}
