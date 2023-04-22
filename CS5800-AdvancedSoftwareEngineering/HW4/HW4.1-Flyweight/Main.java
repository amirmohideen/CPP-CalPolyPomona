public class Main {
    public static void main(String[] args) {
        Document document = new Document();
        
        document.addCharacter('Y', CharacterPropertiesFactory.getCharacterProperties("Arial", "Red", 12));
        document.addCharacter('e', CharacterPropertiesFactory.getCharacterProperties("Arial", "Red", 14));
        document.addCharacter('l', CharacterPropertiesFactory.getCharacterProperties("Arial", "Red", 16));
        document.addCharacter('l', CharacterPropertiesFactory.getCharacterProperties("Calibri", "Red", 12));
        document.addCharacter('o', CharacterPropertiesFactory.getCharacterProperties("Calibri", "Blue", 12));
        document.addCharacter('W', CharacterPropertiesFactory.getCharacterProperties("Calibri", "Black", 12));
        document.addCharacter('o', CharacterPropertiesFactory.getCharacterProperties("Verdana", "Black", 16));
        document.addCharacter('r', CharacterPropertiesFactory.getCharacterProperties("Verdana", "Black", 14));
        document.addCharacter('l', CharacterPropertiesFactory.getCharacterProperties("Verdana", "Black", 12));
        document.addCharacter('d', CharacterPropertiesFactory.getCharacterProperties("Arial", "Red", 12));
        document.addCharacter('C', CharacterPropertiesFactory.getCharacterProperties("Calibri", "Blue", 14));
        document.addCharacter('S', CharacterPropertiesFactory.getCharacterProperties("Verdana", "Black", 16));
        document.addCharacter('7', CharacterPropertiesFactory.getCharacterProperties("Arial", "Blue", 12));
        document.addCharacter('8', CharacterPropertiesFactory.getCharacterProperties("Verdana", "Red", 16));
        document.addCharacter('0', CharacterPropertiesFactory.getCharacterProperties("Arial", "Red", 14));
        document.addCharacter('0', CharacterPropertiesFactory.getCharacterProperties("Arial", "Black", 16));
        
        System.out.println("Initial Line of Characters:");
        System.out.println(document.getDocumentString());
        
        document.editCharacter(0, 'H', CharacterPropertiesFactory.getCharacterProperties("Calibri", "Red", 16));
        System.out.println("Line of characters after 1st edit:");
        System.out.println(document.getDocumentString());
        document.saveFile("document.txt");
        
        System.out.println("\nLine of characters loaded from document.txt:");
        document.loadFile("document.txt");
        System.out.println(document.getDocumentString());

        document.editCharacter(12, '5', CharacterPropertiesFactory.getCharacterProperties("Arial", "Red", 22));
        System.out.println("Line of characters after 2nd edit:");
        System.out.println(document.getDocumentString());

        document.saveFile("document.txt");
    }
}
