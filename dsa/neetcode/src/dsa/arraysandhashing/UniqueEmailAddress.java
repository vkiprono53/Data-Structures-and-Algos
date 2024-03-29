package dsa.arraysandhashing;

import java.util.Set;
import java.util.HashSet;

public class UniqueEmailAddress {
    public static void main(String[] args) {
        UniqueEmailAddress address = new UniqueEmailAddress();
        String[] emails = {"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"};
        System.out.println(address.numUniqueEmails(emails));
    }

    /**
     * Time Complexity - O(n)
     * Space Complexity - O(n)
     */
    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();

        for (String email : emails) {
            StringBuilder newEmail = new StringBuilder();
            int splitPos = email.indexOf("@");

            String localName = email.substring(0, splitPos);
            String domainName = email.substring(splitPos);

            if (localName.contains("+")) {
                int plusPos = localName.indexOf("+");
                localName = localName.substring(0, plusPos);
            }
            localName = localName.replaceAll("\\.", "");
            newEmail.append(localName).append(domainName);
            uniqueEmails.add(newEmail.toString());
        }
        return uniqueEmails.size();
    }
}
