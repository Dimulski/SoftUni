package app.utilities;

import org.apache.commons.lang.StringUtils;

/**
 * Transforms given tag to a valid one by rules
 */
public final class TagUtilities {
    private static final int DEFAULT_LENGTH = 20;

    private TagUtilities() {
    }

    /**
     * Transforms given wrong tag to a valid one by:
     * 1. removing all white spaces
     * 2. adding pound ('#') sign if needed
     * 3. reduces its length to 20 symbols if it is more
     *
     * @param wrongTag wrong tag to be converted
     * @return converted tag validated by given rules
     */
    public static String validateOrTransform(String wrongTag) {
        if (StringUtils.isBlank(wrongTag)) {
            throw new UnsupportedOperationException("Cannot convert empty string to a valid tag");
        }

        String transformedTag = wrongTag;

        transformedTag = removeAllWhiteSpaces(transformedTag);

        if (wrongTag.charAt(0) != '#') {
            transformedTag = appendPoundSign(transformedTag);
        }

        if (transformedTag.length() > DEFAULT_LENGTH) {
            transformedTag = reduceStringLength(transformedTag, DEFAULT_LENGTH);
        }

        return transformedTag;
    }

    private static String removeAllWhiteSpaces(String tag) {
        String newTag = tag.replace(" ", StringUtils.EMPTY)
                .replace("\t", StringUtils.EMPTY)
                .replace("\n", StringUtils.EMPTY)
                .replace("\r", StringUtils.EMPTY);

        return newTag;
    }

    private static String appendPoundSign(String tag) {
        return "#" + tag;
    }

    private static String reduceStringLength(String tag, int length) {
        String reducedString = tag.substring(0, length - 1);
        return reducedString;
    }
}
