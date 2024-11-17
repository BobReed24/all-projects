package com.thealgorithms.strings;

public final class CharactersSame {
    private CharactersSame() {
    }

    public static boolean isAllCharactersSame(String s) {
        if (s.isEmpty()) {
            return true; 
        }

        char firstChar = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != firstChar) {
                return false;
            }
        }
        return true;
    }
}
