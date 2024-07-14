class Solution {
        public String countOfAtoms(String formula) {
                // TreeMap to store atom counts, automatically sorted by atom name
                        TreeMap<String, Integer> map = new TreeMap<>();
                                
                                        // Stack to handle nested parentheses, max size 1000 (could be dynamic)
                                                int[] stack = new int[1000];
                                                        int top = 0; // Top of the stack
                                                                
                                                                        int multiplier = 1; // Current multiplier for atom counts
                                                                                int freq = 0; // Frequency of the current atom
                                                                                        
                                                                                                // Convert formula to char array for easier processing
                                                                                                        char[] c = formula.toCharArray();
                                                                                                                
                                                                                                                        // Process the formula from right to left
                                                                                                                                for(int i = c.length - 1; i >= 0; i--) {
                                                                                                                                            // Case 1: Lowercase letter (part of an atom name)
                                                                                                                                                        if(c[i] >= 'a' && c[i] <= 'z') {
                                                                                                                                                                        int end = i--;
                                                                                                                                                                                        // Find the start of the atom name (uppercase letter)
                                                                                                                                                                                                        while(i >= 0 && c[i] >= 'a' && c[i] <= 'z') i--;
                                                                                                                                                                                                                        // Extract the full atom name
                                                                                                                                                                                                                                        String key = new String(c, i, end - i + 1);
                                                                                                                                                                                                                                                        // Add to map, applying current frequency and multiplier
                                                                                                                                                                                                                                                                        map.put(key, map.getOrDefault(key, 0) + Math.max(freq, 1) * multiplier);
                                                                                                                                                                                                                                                                                        freq = 0; // Reset frequency
                                                                                                                                                                                                                                                                                                    } 
                                                                                                                                                                                                                                                                                                                // Case 2: Uppercase letter (single-letter atom)
                                                                                                                                                                                                                                                                                                                            else if(c[i] >= 'A' && c[i] <= 'Z') {
                                                                                                                                                                                                                                                                                                                                            String key = new String(c, i, 1);
                                                                                                                                                                                                                                                                                                                                                            map.put(key, map.getOrDefault(key, 0) + Math.max(freq, 1) * multiplier);
                                                                                                                                                                                                                                                                                                                                                                            freq = 0;
                                                                                                                                                                                                                                                                                                                                                                                        } 
                                                                                                                                                                                                                                                                                                                                                                                                    // Case 3: Number (frequency of an atom or group)
                                                                                                                                                                                                                                                                                                                                                                                                                else if(c[i] >= '0' && c[i] <= '9') {
                                                                                                                                                                                                                                                                                                                                                                                                                                freq = c[i] - '0';
                                                                                                                                                                                                                                                                                                                                                                                                                                                int p = 10;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                // Parse multi-digit number
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                while(i-1 >= 0 && c[i-1] >= '0' && c[i-1] <= '9') {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    freq += p * (c[--i] - '0');
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        p *= 10;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    } 
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                // Case 4: Closing parenthesis
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            else if(c[i] == ')') {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            stack[top++] = multiplier; // Save current multiplier
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            multiplier *= Math.max(freq, 1); // Update multiplier
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            freq = 0;
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        } 
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    // Case 5: Opening parenthesis
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                else {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                multiplier = stack[--top]; // Restore previous multiplier
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    // Build the result string
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            StringBuilder sb = new StringBuilder();
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    for(Map.Entry<String, Integer> entry : map.entrySet()) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                sb.append(entry.getKey()); // Append atom name
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            if(entry.getValue() > 1) sb.append(entry.getValue()); // Append count if > 1
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            return sb.toString();
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
}