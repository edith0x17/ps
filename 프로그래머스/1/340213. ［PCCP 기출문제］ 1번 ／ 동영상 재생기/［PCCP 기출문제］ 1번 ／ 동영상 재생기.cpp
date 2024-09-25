#include <iostream>
#include <string>
#include <vector>

using namespace std;

int go(string s) {
    int ret = 0;
    string ff = "", ss = "";
    bool flag = false;
    
    for(int i = 0; i < s.size(); i++){
        if(s[i] == ':'){
            flag = true;
            continue;
        }
        
        if(!flag){
            ff += s[i];
        } else {
            ss += s[i];
        }
    }

    // first (분)
    if(ff.size() == 1) ret += (ff[0] - '0') * 60;
    else if(ff.size() == 2) ret += (ff[0] - '0') * 10 * 60 +  (ff[1] - '0') * 60;

    // second (초)
    if(ss.size() == 1) ret += ss[0] - '0';
    else if(ss.size() == 2) ret += (ss[0] - '0') * 10 +  (ss[1] - '0');
    
    return ret;
}

string solution(string video_len, string pos, string op_start, string op_end, vector<string> commands) {
    string answer = "";
    int ans;
    int total = go(video_len);
    int now = go(pos);
    int opStart = go(op_start);
    int opEnd = go(op_end);
    ans = now;
    
    if(opStart <= ans && ans <= opEnd){
        ans = opEnd;
    }
    
    for(auto at: commands){
        if(at == "next"){
            if(total - ans < 10)ans = total;
            else ans = ans + 10;
        }else if(at == "prev"){
            if(ans < 10)ans = 0;
            else ans = ans - 10;
        }
        
        if(opStart <= ans && ans <= opEnd){
            ans = opEnd;
        }
        // cout << ans/ 60 << ":" << ans % 60 << "\n";
    }
    
    // if(opStart <= ans && ans <= opEnd){
    //     ans = opEnd;
    // }
    // cout << ans/ 60 << ":" << ans % 60 << "\n";
    answer = "00:00";// 01:34
    answer[0] = (ans/ 60)/ 10 + '0';
    answer[1] = (ans/ 60)% 10 + '0';
    answer[3] = (ans% 60)/ 10 + '0';
    answer[4] = (ans% 60)% 10 + '0';  
    return answer;
}