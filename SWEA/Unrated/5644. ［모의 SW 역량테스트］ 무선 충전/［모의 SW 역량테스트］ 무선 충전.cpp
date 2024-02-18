#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
// const int dx[] = {0, -1, 0, 1, 0};
// const int dy[] = {0, 0, 1, 0, -1};

int dx[] = {0, 0, 1, 0, -1}; // x랑 y로 사용
int dy[] = {0, -1, 0, 1, 0}; // 상우하좌
int totalSum = 0;
int nxA = 1, nyA = 1;
int nxB = 10, nyB = 10;

struct batteryCharger
{
   int x;
   int y;
   int c;
   int p;
};
vector<batteryCharger> batteryChargerList;

int t, m, a; // m: 이동량, a: 개수
vector<int> aTrace, bTrace;

void init()
{
   totalSum = 0;

   nxA = nyA = 1;
   nxB = nyB = 10;

   batteryChargerList.clear();

   aTrace.clear();
   bTrace.clear();
}

int check(int i, int j, int number)
{
   return abs(batteryChargerList[number].x - i) + abs(batteryChargerList[number].y - j) <= batteryChargerList[number].c ? batteryChargerList[number].p : 0;
}

int getMaxCharge()
{
   int mx = 0;
   for (int i = 0; i < batteryChargerList.size(); i++)
   { // 플레이어 A가 선택한 BC
      for (int j = 0; j < batteryChargerList.size(); j++)
      { // 플레이어 B가 선택한 BC
         int sum = 0;
         int amountA = check(nxA, nyA, i);
         int amountB = check(nxB, nyB, j);

         // 두 충전소가 다르면 충전량 나누지 않아도 됨
         if (i != j) // 어차피 함수에서 충전 불가능하면 0 보내주니까 그냥 더하면 됨
            sum = amountA + amountB;
         else // 충전소가 같다면 둘 중에 큰 값 가져오면 됨
            sum = max(amountA, amountB);

         mx = max(mx, sum);
      }
   }

   //   cout << "mx : " << mx << '\n';

   return mx;
}

int main()
{
   ios_base::sync_with_stdio(false);
   cin.tie(NULL);
   cout.tie(NULL);

   cin >> t;
   for (int tc = 1; tc <= t; tc++)
   {
      // 실행

      init(); // 초기화

      cin >> m >> a;

      aTrace.push_back(0);
      for (int i = 0; i < m; i++)
      {
         int temp;
         cin >> temp;
         aTrace.push_back(temp);
      }
      bTrace.push_back(0);
      for (int i = 0; i < m; i++)
      {
         int temp;
         cin >> temp;
         bTrace.push_back(temp);
      }

      for (int i = 0; i < a; i++)
      {
         batteryCharger temp;
         cin >> temp.x >> temp.y >> temp.c >> temp.p;
         batteryChargerList.push_back(temp);
      }

      for (int i = 0; i < m + 1; i++)
      {
         nxA += dx[aTrace[i]];
         nyA += dy[aTrace[i]];

         nxB += dx[bTrace[i]];
         nyB += dy[bTrace[i]];

         totalSum += getMaxCharge();
      }
      cout << "#" << tc << ' ' << totalSum << '\n';
   }
   return 0;
}