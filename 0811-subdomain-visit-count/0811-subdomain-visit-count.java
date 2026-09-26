class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {

        Map<String, Integer> mp = new HashMap<>();
        for (String d : cpdomains) {
            String[] cpDomain = d.split(" ");
            int count = Integer.parseInt(cpDomain[0]);
            String domain = cpDomain[1];
            while (!domain.isEmpty()) {
                mp.put(domain, mp.getOrDefault(domain, 0) + count);
                int idx = domain.indexOf(".");
                if (idx == -1)
                    break;
                domain = domain.substring(idx + 1);
            }
        }

        List<String> ans = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : mp.entrySet()) {
            ans.add(entry.getValue() + " " + entry.getKey());
        }
        return ans;
    }
}