final class Solution {
    public final List<String> removeSubfolders(String[] folders) {
        Arrays.sort(folders);
        ArrayList<String> filtered = new ArrayList<>();
        filtered.ensureCapacity(folders.length);
        String parentFolder = "//";
        for (final String folder : folders)
            if (!folder.startsWith(parentFolder)) {
                parentFolder = folder + "/";
                filtered.add(folder);
            }
        return filtered;
    }

}