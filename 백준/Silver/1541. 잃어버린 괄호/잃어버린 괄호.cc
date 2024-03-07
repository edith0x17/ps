#include <iostream>
#include <string>
using namespace std;
string str;
string temp = "";
int ret = 0;

int main() {
	ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

	cin >> str;

	bool flag = false;
	for (auto i = 0; i <= str.size(); i++) {

		if (str[i] == '+' || str[i] == '-' || str[i] == '\0') {
			if (flag)ret -= atoi(temp.c_str());
			else ret += atoi(temp.c_str());

			temp = "";
			if (str[i] == '-')flag = true;
		}
		else temp += str[i];

	}

	cout << ret << '\n';

	return 0;
}