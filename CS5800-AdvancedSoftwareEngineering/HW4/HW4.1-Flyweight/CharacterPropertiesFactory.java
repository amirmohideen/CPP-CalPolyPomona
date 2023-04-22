import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CharacterPropertiesFactory {
    private static Map<String, CharacterProperties> propertiesMap = new ConcurrentHashMap<>();

    public static CharacterProperties getCharacterProperties(String font, String color, int size) {
        String key = font + color + size;
        return propertiesMap.computeIfAbsent(key, k -> new CharacterProperties(font, color, size));
    }
}
