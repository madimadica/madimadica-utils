package com.madimadica.utils.internal.generator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * Generate the source code for Maps utils.
 */
public class MapsGenerator {

    static final int MAX_ENTRIES = 12;

    public static void main(String[] args) throws IOException {
        StringJoiner lines = new StringJoiner("\n");
        lines.add("package com.madimadica.utils;");
        lines.add("");
        lines.add("import java.util.Collections;");
        lines.add("import java.util.HashMap;");
        lines.add("import java.util.LinkedHashMap;");
        lines.add("import java.util.Map;");
        lines.add("");
        lines.add("/**");
        lines.add(" * Static utilities for Maps.");
        lines.add(" */");
        lines.add("public abstract class Maps {");
        lines.add("");

        lines.add(getJavadocJoiner().add("Allow for user extension.").toString());
        lines.add("    public Maps() {}");
        lines.add("");
        lines.add(ofNullable());
        lines.add("");
        lines.add(ofMutable());
        lines.add("");
        lines.add(ofOrdered());
        lines.add("");
        lines.add(ofOrderedNullable());
        lines.add("");
        lines.add(ofOrderedMutable());
        lines.add("");

        lines.add(genCopyOf("copyOfNullable", false, true, false));
        lines.add(genCopyOf("copyOfOrdered", false, false, true));
        lines.add(genCopyOf("copyOfOrderedNullable", false, true, true));

        lines.add("}");
        lines.add("");
        Files.writeString(Paths.get("./src/main/java/com/madimadica/utils/Maps.java"), lines.toString());
    }

    private static String assertNonNullArgs(int keyCount, boolean allowNullValues) {
        String exceptionMessage = allowNullValues ? "Map keys cannot be null" : "Map keys and values cannot be null";
        StringJoiner nonNullIf = new StringJoiner(
                " || ",
                "        if (", ") {\n            throw new NullPointerException(\"" + exceptionMessage + "\");\n        }"
        );
        for (int i = 1; i <= keyCount; ++i) {
            nonNullIf.add("k" + i + " == null");
            if (!allowNullValues) {
                nonNullIf.add("v" + i + " == null");
            }
        }
        return nonNullIf.toString();
    }

    private static StringJoiner getJavadocJoiner() {
        return new StringJoiner("\n     * ", "    /**\n     * ", "\n     */");
    }

    private static String ofNullable() {
        StringJoiner result = new StringJoiner("\n\n");
        for (int i = 1; i <= MAX_ENTRIES; ++i) {
            List<String> javadoc = List.of(
                    "Creates an immutable map with " + i + " " + (i == 1 ? "entry" : "entries") + ".",
                    "<br>",
                    "The values can be {@code null}, but keys must be non-null."
            );
            result.add(generate(i, "ofNullable", "HashMap", "Collections.unmodifiableMap(map)", javadoc, true, "An unordered immutable map with the given entries."));
        }
        return result.toString();
    }

    private static String ofMutable() {
        StringJoiner result = new StringJoiner("\n\n");
        for (int i = 1; i <= MAX_ENTRIES; ++i) {
            List<String> javadoc = List.of(
                    "Creates a mutable map with " + i + " " + (i == 1 ? "entry" : "entries") + ".",
                    "<br>",
                    "The values can be {@code null}, but keys must be non-null."
            );
            result.add(generate(i, "ofMutable", "HashMap", "map", javadoc, true, "An unordered mutable map with the given entries."));
        }
        return result.toString();
    }

    private static String ofOrdered() {
        StringJoiner result = new StringJoiner("\n\n");
        for (int i = 1; i <= MAX_ENTRIES; ++i) {
            List<String> javadoc = List.of(
                    "Creates an ordered, immutable map with " + i + " " + (i == 1 ? "entry" : "entries") + ".",
                    "<br>",
                    "Neither the keys nor values may be {@code null}."
            );
            result.add(generate(i, "ofOrdered", "LinkedHashMap", "Collections.unmodifiableMap(map)", javadoc, false, "An ordered immutable map with the given entries."));
        }
        return result.toString();
    }

    private static String ofOrderedNullable() {
        StringJoiner result = new StringJoiner("\n\n");
        for (int i = 1; i <= MAX_ENTRIES; ++i) {
            List<String> javadoc = List.of(
                    "Creates an ordered, immutable map with " + i + " " + (i == 1 ? "entry" : "entries") + ".",
                    "<br>",
                    "The values can be {@code null}, but keys must be non-null."
            );
            result.add(generate(i, "ofOrderedNullable", "LinkedHashMap", "Collections.unmodifiableMap(map)", javadoc, true, "An ordered immutable map with the given entries."));
        }
        return result.toString();
    }

    private static String ofOrderedMutable() {
        StringJoiner result = new StringJoiner("\n\n");
        for (int i = 1; i <= MAX_ENTRIES; ++i) {
            List<String> javadoc = List.of(
                    "Creates an ordered, mutable map with " + i + " " + (i == 1 ? "entry" : "entries") + ".",
                    "<br>",
                    "The values can be {@code null}, but keys must be non-null."
            );
            result.add(generate(i, "ofOrderedMutable", "LinkedHashMap", "map", javadoc, true, "An ordered mutable map with the given entries."));
        }
        return result.toString();
    }

    private static String generate(int entryCount, String methodName, String mapClass, String returnValue, List<String> javadocDesc, boolean allowNullValues, String javadocReturn) {
        StringJoiner javadoc = getJavadocJoiner();
        javadocDesc.forEach(javadoc::add);

        for (int i = 1; i <= entryCount; ++i) {
            javadoc.add("@param k" + i + " key for entry " + i);
            javadoc.add("@param v" + i + " value for entry " + i);
        }
        javadoc.add("@return " + javadocReturn);
        javadoc.add("@param <K> key type");
        javadoc.add("@param <V> key type");
        if (allowNullValues) {
            javadoc.add("@throws NullPointerException if any key is {@code null}.");
        } else {
            javadoc.add("@throws NullPointerException if any <em>key or value</em> is {@code null}.");
        }

        StringJoiner signatureSj = new StringJoiner(", ", "public static <K, V> Map<K, V> " + methodName + "(", ")");
        for (int j = 1; j <= entryCount; ++j) {
            String entryPair = String.format("K k%d, V v%<d", j);
            signatureSj.add(entryPair);
        }
        String signature = signatureSj.toString();
        StringJoiner methodSj = new StringJoiner("\n", javadoc + "\n    " + signature + " {\n", "\n    }");
        methodSj.add(assertNonNullArgs(entryCount, allowNullValues));
        methodSj.add("        Map<K, V> map = new " + mapClass + "<>(" + entryCount + ");");
        for (int entryNumber = 1; entryNumber <= entryCount; ++entryNumber) {
            methodSj.add(String.format("        map.put(k%d, v%<d);", entryNumber));
        }
        methodSj.add("        return " + returnValue + ";");
        return methodSj.toString();
    }

    private static String genCopyOf(String methodName, boolean mutable, boolean nullable, boolean ordered) {
        String mapClass = ordered ? "LinkedHashMap" : "HashMap";
        var javadoc = getJavadocJoiner();
        javadoc.add("Creates an " + (ordered ? "ordered" : "unordered") + " " + (mutable ? "mutable" : "immutable") + " copy of the given map.");
        javadoc.add("<br>");
        javadoc.add("The keys must <strong>not</strong> be {@code null}.");
        javadoc.add("<br>");
        if (nullable) {
            javadoc.add("The values may be {@code null}.");
        } else {
            javadoc.add("The values may <strong>not</strong> be {@code null}.");
        }
        javadoc.add("@param mapToCopy a non-null map to deep-copy the entries from.");
        javadoc.add("@throws NullPointerException if any key " + (nullable ? "" : "or value ") + "is null.");
        StringBuilder method = new StringBuilder().append(javadoc).append("\n");
        method.append("    public static <K, V> Map<K, V> ").append(methodName).append("(Map<? extends K, ? extends V> mapToCopy) {")
                .append("\n        if (mapToCopy.containsKey(null)) {")
                .append("\n           throw new NullPointerException(\"Map may not contain null keys\");")
                .append("\n        }");
        if (!nullable) {
            method.append("\n        if (mapToCopy.containsValue(null)) {")
                    .append("\n           throw new NullPointerException(\"Map may not contain null values\");")
                    .append("\n        }");
        }
        method.append("\n        ");
        String mapConstruct = "new " + mapClass + "<>(mapToCopy)";
        if (mutable) {
            method.append("return ").append(mapConstruct).append(';');
        } else {
            method.append("Map<K, V> map = ").append(mapConstruct).append(';').append("\n        return Collections.unmodifiableMap(map);");
        }
        method.append("\n    }\n");
        return method.toString();
    }

}
