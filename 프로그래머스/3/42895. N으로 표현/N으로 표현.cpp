#include <string>
#include <vector>
#include <set>
using namespace std;

void unionSet(set<int>& union_set, const set<int>& a, const set<int>& b) {
    for (int n1 : a) {
        for (int n2 : b) {
            union_set.insert(n1 + n2);
            union_set.insert(n1 - n2);
            union_set.insert(n1 * n2);

            if (n2 != 0) {
                union_set.insert(n1 / n2);
            }
        }
    }
}

int solution(int N, int number) {
    vector<set<int>> setList(9);

    setList[1].insert(N); // Initialize for one digit number
    if (number == N) {
        return 1;
    }

    for (int i = 2; i < 9; i++) {
        for (int j = 1; j <= i / 2; j++) {
            unionSet(setList[i], setList[i - j], setList[j]);
            unionSet(setList[i], setList[j], setList[i - j]);
        }

        // Add the concatenated number
        string n_str = to_string(N);
        int concatenated_number = stoi(string(i, n_str[0]));
        setList[i].insert(concatenated_number);

        // Check if the target number is in the current set
        if (setList[i].find(number) != setList[i].end()) {
            return i;
        }
    }
    
    return -1;
}