class Solution {
public:
    vector<string> validateCoupons(vector<string>& code, vector<string>& businessLine, vector<bool>& isActive) {
        vector<string> result;
        vector<pair<string, string>> validCoupons;

        unordered_set<string> set = {"electronics", "grocery", "pharmacy", "restaurant"};
        vector<string> order = {"electronics", "grocery", "pharmacy", "restaurant"};

        for (int i = 0; i < code.size(); ++i) {
            if (isValid(code[i], isActive[i], businessLine[i], set)) {
                validCoupons.push_back({code[i], businessLine[i]});
            }
        }

        for (const string& cat : order) {
            vector<string> temp;
            for (auto& pair : validCoupons) {
                if (pair.second == cat) {
                    temp.push_back(pair.first);
                }
            }
            sort(temp.begin(), temp.end());
            result.insert(result.end(), temp.begin(), temp.end());
        }

        return result;
    }

private:
    bool isValid(const string& code, bool isActive, const string& businessLine, const unordered_set<string>& set) {
        if (!isActive || code.empty() || set.find(businessLine) == set.end()) {
            return false;
        }
        for (char c : code) {
            if (!isalnum(c) && c != '_') {
                return false;
            }
        }
        return true;
    }
};
