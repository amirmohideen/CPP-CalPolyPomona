
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Document {
    private List<Character> document = new ArrayList<>();

    public void addCharacter(char character, CharacterProperties characterProperties) {
        document.add(new Character(character, characterProperties));
    }

    public void editCharacter(int index, char character, CharacterProperties characterProperties) {
        document.set(index, new Character(character, characterProperties));
        System.out.println("\nCharacter at index " + index + " edited!" );
    }

    public String getDocumentString() {
        StringBuilder documentString = new StringBuilder();
        for (Character character : document) {
            documentString.append(character.getCharacter());
        }
        return documentString.toString();
    }

    public void saveFile(String filePath) {
        try {
            FileWriter writer = new FileWriter(filePath);
            for (Character character : document) {
                CharacterProperties properties = character.getProperties();
                writer.write(character.getCharacter() + ", " + properties.getFont() + ", " + properties.getColor() + ", "
                        + properties.getSize() + "\n");
            }

            writer.close();
        } catch (IOException e) {
            System.out.println("Error occurred in saveFile()!");
            e.printStackTrace();
        }
    }

public void loadFile(String filePath) {
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
        String line;
        document.clear();
        while ((line = reader.readLine()) != null) {
            String[] splitter = line.split(",");
            if (splitter.length == 4) {
                char characterValue = splitter[0].charAt(0);
                String font = splitter[1].trim();
                String color = splitter[2].trim();
                int size = Integer.parseInt(splitter[3].trim());
                addCharacter(characterValue, CharacterPropertiesFactory.getCharacterProperties(font, color, size));
            }
        }
        reader.close();
    } catch (IOException e) {
        System.out.println("Error occurred in loadFile()!");
        e.printStackTrace();
    }
}


}