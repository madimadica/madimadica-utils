package com.madimadica.utils.internal.generator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

import static java.util.Map.entry;

public class MapsTestGenerator {

    static final Map<Integer, String> NUMBER_NAME_MAP = Map.ofEntries(
            entry(1, "one"),
            entry(2, "two"),
            entry(3, "three"),
            entry(4, "four"),
            entry(5, "five"),
            entry(6, "six"),
            entry(7, "seven"),
            entry(8, "eight"),
            entry(9, "nine"),
            entry(10, "ten"),
            entry(11, "eleven"),
            entry(12, "twelve"),
            entry(13, "thirteen")
    );

    private static String genTest(String testMethodName, List<String> bodyLines) {
        StringBuilder sb = new StringBuilder();
        sb.append("    @Test\n    void ").append(testMethodName).append("() {");
        bodyLines.forEach(line -> sb.append("\n        ").append(line));
        sb.append("\n    }");
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        StringJoiner sj = new StringJoiner("\n");
        sj.add("package com.madimadica.utils;");
        sj.add("");
        sj.add("import org.junit.jupiter.api.Test;");
        sj.add("");
        sj.add("import java.util.*;");
        sj.add("");
        sj.add("import static org.junit.jupiter.api.Assertions.*;");
        sj.add("");
        sj.add("/**");
        sj.add(" * Tests autogenerated by {@link com.madimadica.utils.internal.generator.MapsTestGenerator}");
        sj.add(" */");
        sj.add("public class MapsTest {");
        sj.add("");
        sj.add(allTestsFor("ofNullable", false, true, false));
        sj.add(allTestsFor("ofMutable", true, true, false));
        sj.add(allTestsFor("ofOrdered", false, false, true));
        sj.add(allTestsFor("ofOrderedNullable", false, true, true));
        sj.add(allTestsFor("ofOrderedMutable", true, true, true));
        sj.add(allCopyTestsFor("copyOfNullable", false, true, false));
        sj.add(allCopyTestsFor("copyOfOrdered", false, false, true));
        sj.add(allCopyTestsFor("copyOfOrderedNullable", false, true, true));
        sj.add("}");
        sj.add("");
        String testCode = sj.toString();
        Files.writeString(Paths.get("./src/test/java/com/madimadica/utils/MapsTest.java"), testCode);
    }

    private static String allTestsFor(String srcMethodName, boolean mutable, boolean nullable, boolean ordered) {
        StringJoiner sj = new StringJoiner("\n");
        for (int i = 1; i <= 12; ++i) {
            sj.add(normalTestOf(srcMethodName, i));
            sj.add("");
            sj.add(testOfNullKeys(srcMethodName, i));
            sj.add("");
            sj.add(testValueNullability(srcMethodName, i, nullable));
            sj.add("");
            if (ordered) {
                sj.add(testOrdering(srcMethodName, i));
                sj.add("");
            }
        }
        sj.add(testAllMutability(srcMethodName, mutable));
        sj.add("");
        sj.add(testEntries(srcMethodName, mutable, nullable, ordered));
        return sj.toString();
    }

    private static String testEntries(String srcMethodName, boolean mutable, boolean nullable, boolean ordered) {
        List<String> lines = new ArrayList<>();
        String fullMethodName = srcMethodName + "Entries";
        lines.add(genTest(fullMethodName + "_whenNullArg_thenThrow", List.of("assertThrows(NullPointerException.class, () -> Maps." + fullMethodName + "(null));")));
        lines.add("");
        lines.add(genTest(fullMethodName + "_whenNullKey_thenThrow", List.of("assertThrows(NullPointerException.class, () -> Maps." + fullMethodName + "(Maps.entry(null, 1)));")));
        lines.add("");
        lines.add(genTest(fullMethodName + "_whenDuplicateKey_thenThrow", List.of("assertThrows(IllegalArgumentException.class, () -> Maps." + fullMethodName + "(Maps.entry(1, \"one\"), Maps.entry(1, \"ONE\")));")));
        lines.add("");
        if (nullable) {
            lines.add(genTest(fullMethodName + "_whenNullValue_thenDontThrow", List.of("assertDoesNotThrow(() -> Maps." + fullMethodName + "(Maps.entry(1, null)));")));
        } else {
            lines.add(genTest(fullMethodName + "_whenNullValue_thenThrow", List.of("assertThrows(NullPointerException.class, () -> Maps." + fullMethodName + "(Maps.entry(1, null)));")));
        }
        lines.add("");
        if (mutable) {
            lines.add(genTest(fullMethodName + "_whenMutate_thenDontThrow", List.of(
                    "Map<Integer, String> map = Maps." + fullMethodName + "(Maps.entry(1, \"one\"));",
                    "assertDoesNotThrow(() -> map.put(2, \"two\"));"
            )));
        } else {
            lines.add(genTest(fullMethodName + "_whenMutate_thenThrow", List.of(
                    "Map<Integer, String> map = Maps." + fullMethodName + "(Maps.entry(1, \"one\"));",
                    "assertThrows(UnsupportedOperationException.class, () -> map.put(2, \"two\"));"
            )));
        }
        if (ordered) {
            lines.add("");
            lines.add(testEntriesOrdering(fullMethodName, 13));
        }
        return String.join("\n", lines);
    }

    private static String allCopyTestsFor(String srcMethodName, boolean mutable, boolean nullable, boolean ordered) {
        StringJoiner sj = new StringJoiner("\n");
        for (int i = 1; i <= 12; ++i) {
            sj.add(testCopyFactoryCopies(srcMethodName, i));
            sj.add("");
        }
        sj.add(testCopyFactoryNullKeys(srcMethodName));
        sj.add("");
        sj.add(testCopyFactoryNullValues(srcMethodName, nullable));
        sj.add("");
        sj.add(testCopyFactoryResultMutability(srcMethodName, mutable));
        sj.add("");
        if (ordered) {
            sj.add(testCopyFactoryResultOrdering(srcMethodName));
            sj.add("");
        }
        return sj.toString();
    }

    private static String getNormalFactoryCall(String srcMethodName, int entrySize) {
        StringJoiner factoryInvocation = new StringJoiner(", ", "Maps." + srcMethodName + "(", ")");
        for (int i = 1; i <= entrySize; ++i) {
            factoryInvocation.add("" + i);
            factoryInvocation.add('"' + NUMBER_NAME_MAP.get(i) + '"');
        }
        return factoryInvocation.toString();
    }

    private static String getEntriesFactoryCall(String srcMethodName, int entrySize) {
        StringJoiner factoryInvocation = new StringJoiner(", ", "Maps." + srcMethodName + "(", ")");
        for (int i = 1; i <= entrySize; ++i) {
            factoryInvocation.add("Maps.entry(" + i + ", \"" + NUMBER_NAME_MAP.get(i) + "\")");
        }
        return factoryInvocation.toString();
    }

    private static String getNormalFactoryInit(String srcMethodName, int entrySize) {
        return "Map<Integer, String> map = " + getNormalFactoryCall(srcMethodName, entrySize) + ";";
    }

    private static String getEntriesFactoryInit(String srcMethodName, int entrySize) {
        return "Map<Integer, String> map = " + getEntriesFactoryCall(srcMethodName, entrySize) + ";";
    }

    /**
     * Generate a test to verify that the method of the given length/name
     * works and the values are properly associated, and sizes match expected.
     */
    private static String normalTestOf(String srcMethodName, int entrySize) {
        List<String> lines = new ArrayList<>();
        lines.add(getNormalFactoryInit(srcMethodName, entrySize));
        lines.add("assertEquals(" + entrySize + ", map.size());");
        for (int i = 1; i <= entrySize; ++i) {
            String expectedValue = "\"" + NUMBER_NAME_MAP.get(i) + "\"";
            int maxWidth = 0;
            for (int j = 1; j <= entrySize; j++) {
                maxWidth = Math.max(maxWidth, NUMBER_NAME_MAP.get(j).length());
            }
            String numberPadding = String.format("%-" + (maxWidth + 3) + "s", expectedValue + ",");
            lines.add("assertEquals(" + numberPadding + " map.get(" + i + "));");
        }
        return genTest(srcMethodName + entrySize, lines);
    }

    /**
     * Generate a test to verify that the method throws when given any null key.
     */
    private static String testOfNullKeys(String srcMethodName, int entrySize) {
        List<String> lines = new ArrayList<>();
        // Test null in every position
        for (int nullPos = 1; nullPos <= entrySize; ++nullPos) {
            StringJoiner factoryInvocation = new StringJoiner(", ", "Maps." + srcMethodName + "(", ")");
            for (int entryPos = 1; entryPos <= entrySize; ++entryPos) {
                factoryInvocation.add(nullPos == entryPos ? "null" : String.valueOf(entryPos));
                factoryInvocation.add('"' + NUMBER_NAME_MAP.get(nullPos) + '"');
            }
            lines.add("assertThrows(NullPointerException.class, () -> " + factoryInvocation + ");");
        }
        return genTest(srcMethodName + entrySize + "_whenNullKeys_thenThrow", lines);
    }

    /**
     * Test that every value can (or cannot) be null based on the given argument.
     */
    private static String testValueNullability(String srcMethodName, int entrySize, boolean nullable) {
        List<String> lines = new ArrayList<>();
        // Test null in every position
        for (int nullPos = 1; nullPos <= entrySize; ++nullPos) {
            StringJoiner factoryInvocation = new StringJoiner(", ", "Maps." + srcMethodName + "(", ")");
            for (int entryPos = 1; entryPos <= entrySize; ++entryPos) {
                factoryInvocation.add(String.valueOf(entryPos));
                factoryInvocation.add(nullPos == entryPos ? "null" : ('"' + NUMBER_NAME_MAP.get(nullPos) + '"'));
            }
            if (nullable) {
                lines.add("assertDoesNotThrow(() -> " + factoryInvocation + ");");
            } else {
                lines.add("assertThrows(NullPointerException.class, () -> " + factoryInvocation + ");");
            }
        }
        return genTest(srcMethodName + entrySize + "_whenNullValues_" + (nullable ? "thenDontThrow" : "thenThrow"), lines);
    }

    /**
     * Test that everything can (or cannot) be mutated based on the given argument.
     */
    private static String testAllMutability(String srcMethodName, boolean mutable) {
        List<String> lines = new ArrayList<>();
        // Test null in every position
        for (int i = 1; i <= 12; ++i) {
            String factoryCall = getNormalFactoryCall(srcMethodName, i);
            factoryCall += ".put(0, \"zero\")";
            if (mutable) {
                lines.add("assertDoesNotThrow(() -> " + factoryCall + ");");
            } else {
                lines.add("assertThrows(UnsupportedOperationException.class, () -> " + factoryCall + ");");
            }
        }
        return genTest(srcMethodName + "_whenMutate_" + (mutable ? "thenDontThrow" : "thenThrow"), lines);
    }


    /**
     * Generate a test to verify the entry ordering matches the argument ordering.
     */
    private static String testOrdering(String srcMethodName, int entrySize) {
        List<String> lines = new ArrayList<>();
        lines.add(getNormalFactoryInit(srcMethodName, entrySize));
        addTestOrderingAsserts(lines, entrySize);
        return genTest(srcMethodName + entrySize + "_thenOrdered", lines);
    }

    private static String testEntriesOrdering(String srcMethodName, int entrySize) {
        List<String> lines = new ArrayList<>();
        lines.add(getEntriesFactoryInit(srcMethodName, entrySize));
        addTestOrderingAsserts(lines, entrySize);
        return genTest(srcMethodName + "_thenOrdered", lines);
    }

    private static void addTestOrderingAsserts(List<String> lines, int entrySize) {
        lines.add("var entryList = new ArrayList<>(map.entrySet());");
        for (int i = 1; i <= entrySize; ++i) {
            lines.add("assertEquals(" + i + ", entryList.get(" + (i - 1) + ").getKey());");
        }
        for (int i = 1; i <= entrySize; ++i) {
            int maxWidth = 0;
            for (int j = 1; j <= entrySize; j++) {
                maxWidth = Math.max(maxWidth, NUMBER_NAME_MAP.get(j).length());
            }
            String numberPadding = String.format("%-" + (maxWidth + 3) + "s", '"' + NUMBER_NAME_MAP.get(i) + "\",");
            lines.add("assertEquals(" + numberPadding + " entryList.get(" + (i - 1) + ").getValue());");
        }
    }

    private static String testCopyFactoryCopies(String srcMethodName, int i) {
        List<String> lines = new ArrayList<>();
        String factoryCall = getNormalFactoryCall("ofNullable", i);
        lines.add("Map<Integer, String> map" + i + " = " + factoryCall + ";");
        lines.add("Map<Integer, String> copy" + i + " = Maps." + srcMethodName + "(map" + i + ");");
        lines.add("assertEquals(" + i + ", copy" + i + ".size());");
        lines.add("assertEquals(map" + i + ", copy" + i + ");");
        lines.add("assertNotSame(map" + i + ", copy" + i + ");");

        return genTest(srcMethodName + i + "_whenCopy_thenEqualAndNotSame", lines);
    }

    private static String testCopyFactoryNullKeys(String srcMethodName) {
        return genTest(
                srcMethodName + "_whenNullKeys_thenThrow",
                List.of("assertThrows(NullPointerException.class, () -> Maps." + srcMethodName + "(Maps.ofNullable(0, \"zero\", null, \"one\")));")
        );
    }

    private static String testCopyFactoryNullValues(String srcMethodName, boolean nullable) {
        if (nullable) {
            return genTest(
                    srcMethodName + "_whenNullValues_thenDontThrow",
                    List.of("assertDoesNotThrow(() -> Maps." + srcMethodName + "(Maps.ofNullable(0, \"zero\", 1, null)));")
            );
        } else {
            return genTest(
                    srcMethodName + "_whenNullValues_thenThrow",
                    List.of("assertThrows(NullPointerException.class, () -> Maps." + srcMethodName + "(Maps.ofNullable(0, \"zero\", 1, null)));")
            );
        }
    }

    private static String testCopyFactoryResultMutability(String srcMethodName, boolean mutable) {
        if (mutable) {
            return genTest(
                    srcMethodName + "_whenMutate_thenDontThrow",
                    List.of(
                            "assertDoesNotThrow(() -> Maps." + srcMethodName + "(Maps.ofNullable(0, \"zero\", 1, \"one\")).put(2, \"two\"));",
                            "assertDoesNotThrow(() -> Maps." + srcMethodName + "(Maps.ofNullable(0, \"zero\", 1, \"one\")).put(3, null));" // Should allow nulls
                    )
            );
        } else {
            return genTest(
                    srcMethodName + "_whenMutate_thenThrow",
                    List.of("assertThrows(UnsupportedOperationException.class, () -> Maps." + srcMethodName + "(Maps.ofNullable(0, \"zero\", 1, \"one\")).put(2, \"two\"));")
            );
        }
    }

    private static String testCopyFactoryResultOrdering(String srcMethodName) {
        List<String> lines = new ArrayList<>();
        lines.add("var mapToCopy = " + getNormalFactoryCall("ofOrdered", 10) + ";");
        lines.add(String.format("var result = Maps.%s(mapToCopy);", srcMethodName));
        lines.add("assertNotSame(mapToCopy, result);");
        lines.add("assertEquals(mapToCopy, result);");
        lines.add("var entryList = new ArrayList<>(mapToCopy.entrySet());");
        for (int i = 1; i <= 10; ++i) {
            lines.add("assertEquals(" + i + ", entryList.get(" + (i-1) + ").getKey());");
            lines.add("assertEquals(\"" + NUMBER_NAME_MAP.get(i) + "\", entryList.get(" + (i-1) + ").getValue());");
        }
        return genTest(
                srcMethodName + "_whenCopy_thenIsOrdered",
                lines
        );
    }


}
