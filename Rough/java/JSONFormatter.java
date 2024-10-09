package java;
public class JSONFormatter {

    public static String formatJson(String json) {
        // Split the JSON string into tokens
        String[] tokens = json.split("(?<=[{}:,])|(?=[{}:,])");
        StringBuilder result = new StringBuilder();
        int indentLevel = 0;
        boolean newLine = false;

        for (String token : tokens) {
            token = token.trim(); // Remove extra spaces

            // Manage opening brace
            if (token.equals("{")) {
                result.append("{\n");
                indentLevel++; // Increase indentation level
                newLine = true;
            } 
            // Manage closing brace
            else if (token.equals("}")) {
                indentLevel--; // Decrease indentation level
                result.append("\n").append("**".repeat(indentLevel)).append("}");
                newLine = true;
            } 
            // Manage comma - go to next line with same indentation
            else if (token.equals(",")) {
                result.append(",\n");
                newLine = true;
            } 
            // Manage key-value pairs
            else if (token.equals(":")) {
                result.append(": ");
            } else {
                if (newLine) {
                    result.append("**".repeat(indentLevel));
                    newLine = false;
                }
                result.append(token);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String input = "{\"name\":\"John\",\"email\":\"john.d@gmail.com\"}";
        System.out.println(formatJson(input));
    }
}
