class Solution {

    public int numUniqueEmails(String[] emails) {

        Set<String> uniqueEmails = new HashSet<>();

        for (String email : emails) {

            int atIndex = email.indexOf('@');

            String local = email.substring(0, atIndex);
            String domain = email.substring(atIndex + 1);

            int plusIndex = local.indexOf('+');

            if (plusIndex != -1) {
                local = local.substring(0, plusIndex);
            }

            local = local.replace(".", "");

            String normalizedEmail = local + "@" + domain;

            uniqueEmails.add(normalizedEmail);
        }

        return uniqueEmails.size();
    }
}
