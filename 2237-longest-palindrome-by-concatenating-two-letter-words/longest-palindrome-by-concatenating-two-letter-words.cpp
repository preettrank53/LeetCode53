class Solution {
public:
    string reverse(string s) {
        string rev = "";
        for (int i = s.size() - 1; i >= 0; i--) {
            rev += s[i];
        }
        return rev;
    }

    int longestPalindrome(vector<string>& words) {
        unordered_map<string, int> map;
        int pairs = 0;
        bool hasMiddle = false;

        for (int i = 0; i < words.size(); i++) {
            string word = words[i];
            string rev = reverse(word);

            if (map.count(rev) && map[rev] > 0) {
                pairs++;
                map[rev]--;
                if (map[rev] == 0) {
                    map.erase(rev);
                }
            } else {
                if (map.count(word)) {
                    map[word]++;
                } else {
                    map[word] = 1;
                }
            }
        }

        // Check if any palindromic word (like "gg") exists to place in the middle
        for (auto it = map.begin(); it != map.end(); it++) {
            string key = it->first;
            int value = it->second;

            if (key[0] == key[1] && value > 0) {
                hasMiddle = true;
                break;
            }
        }

        int result = pairs * 4;
        if (hasMiddle) result += 2;

        return result;
    }
};
